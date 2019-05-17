package com.handex.resources;

import com.handex.persistence.CompanyRiskPremiumDao;
import com.handex.persistence.ExportDao;
import com.handex.persistence.IndustryBetaDao;
import com.handex.representations.CompanyRiskPremium;
import com.handex.representations.Export;
import com.handex.representations.Result;
import com.handex.representations.StateResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Transactional
public class ExportResource {

    private static final Logger log = LogManager.getLogger(ExportResource.class);

    private ExportDao exportDao;

    @Autowired
    private IndustryBetaDao industryBetaDao;

    @Autowired
    private CompanyRiskPremiumDao companyRiskPremiumsDao;

    @Inject
    public ExportResource(ExportDao exportDao) {
        this.exportDao = exportDao;
    }

    @POST
    @Path("public/exports")
    public Export save(@Valid Export export) {
        return exportDao.save(export);
    }

    @GET
    @Path("public/exports/{id}")
    public Export getExport(@PathParam("id") long id) {
        Export export = exportDao.findOne(id);
        if (export == null) {
            throw new WebApplicationException((Response.Status.NOT_FOUND));
        }
        return export;
    }

    @POST
    @Path("public/exports/computeVorabOffer")
    public String computeVorabCheck(@Valid Export export) throws Exception {

        StateResponse stateResponse ;
        String companyNameForm = export.companyName;
        String emailForm = export.email;
        String importerCountryForm = export.importerCountry;
        String paymentTermForm = export.paymentTerm;
        Integer contractValueForm = export.contractValue;
        String industryTypeForm = export.industryType;

        CompanyRiskPremium crp = companyRiskPremiumsDao.findByCountry(importerCountryForm.toLowerCase());
        String country_risk_premium = crp.getCountryRiskPremium();
        String total_equity_risk_premium = crp.getTotalEquityRiskPremium();


        Double leveredBeta = industryBetaDao.findByIndustryName(industryTypeForm.toLowerCase()).getLeveredBeta();
        Double debt_beta_min = 0.296;
        Double debt_beta_max = 0.41;

        Double industry_risk_interest_min = ((Double.parseDouble(total_equity_risk_premium) - Double.parseDouble(country_risk_premium)) * leveredBeta * debt_beta_min) * 0.15;
        Double industry_risk_interest_max = ((Double.parseDouble(total_equity_risk_premium) - Double.parseDouble(country_risk_premium)) * leveredBeta * debt_beta_max) * 0.15;
        Double country_risk_interest = Double.parseDouble(country_risk_premium) * 0.15;

        //calculating 30% country and industry interest rate
        Double interest_per_factor_min = country_risk_interest + industry_risk_interest_min;
        Double interest_per_factor_max = country_risk_interest + industry_risk_interest_max;

        Double best_rating = 0.05 * 0.7; //five percent rating for 70% weightage
        Double worst_rating = 0.1 * 0.7; //10 percent rating for 70% weightage

        Double min_interest_rate =  best_rating + interest_per_factor_min;
        Double max_interest_rate = worst_rating + interest_per_factor_max;

        DecimalFormat df = new DecimalFormat("###.###");
        DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
        sym.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(sym);

        String min_interest_rate_string =  df.format(min_interest_rate);
        String max_interest_rate_string = df.format(max_interest_rate);

        System.out.println("min_interest_rate_string: " + min_interest_rate_string);
        System.out.println("max_interest_rate_string: " + max_interest_rate_string);

        if (((contractValueForm < 100000) || (contractValueForm > 5000000))
                || ((Integer.parseInt(paymentTermForm) < 6) || (Integer.parseInt(paymentTermForm) > 36))){

            makeHubspotRequest(emailForm, -1.0, -1.0, Result.REJECTED);
            stateResponse = new StateResponse(-1.0, -1.0, Result.REJECTED);
        }
        else {
            makeHubspotRequest(emailForm, Double.parseDouble(min_interest_rate_string), Double.parseDouble(max_interest_rate_string), Result.ACCEPTED);
            stateResponse = new StateResponse(Double.parseDouble(min_interest_rate_string), Double.parseDouble(max_interest_rate_string), Result.ACCEPTED);
        }

        return stateResponse.toString();
    }

    public void makeHubspotRequest(String emailForm, Double minimum_offer, Double maximum_offer, Result preliminary_check_status) throws IOException {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://api.hubapi.com/contacts/v1/contact/email/" + emailForm + "/profile?hapikey=a6cbf9fb-3341-4fb3-a741-262eda57199a");
        String payload = "{ \"properties\": [ { \"property\": \"preliminary_check_status\", \"value\": \" " + preliminary_check_status + "\" }, { \"property\": \"minimum_offer\", \"value\": \" " + minimum_offer + "\" }, { \"property\": \"maximum_offer\", \"value\": \" " + maximum_offer + " \" } ] }";
        StringEntity params =new StringEntity(payload);
        httppost.addHeader("content-type", "application/x-www-form-urlencoded");
        httppost.setEntity(params);

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                System.out.println(instream);
            }
        }

        System.out.println("StatusCode: " + response.getStatusLine().getStatusCode());

    }
}