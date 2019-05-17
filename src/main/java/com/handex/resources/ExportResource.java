package com.handex.resources;

import com.handex.persistence.CompanyRiskPremiumDao;
import com.handex.persistence.ExportDao;
import com.handex.persistence.IndustryBetaDao;
import com.handex.representations.Export;
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
    public Export getExport(@PathParam("id")long id) {
        Export export = exportDao.findOne(id);
        if (export == null) {
            throw new WebApplicationException((Response.Status.NOT_FOUND));
        }
        return export;
    }

    @GET
    @Path("public/exports/computeOffer")
    public String letsCompute(){

        String beta1 = String.valueOf(industryBetaDao.getOne(Long.valueOf(1)));
//        String beta2 = String.valueOf(industryBetasDao.findByIndustryName("Auto & Truck parts"));

//        ArrayList<IndustryBetas> beta3 = industryBetasDao.findByEhNace(22);
//        beta3.forEach((k) -> System.out.println("beta3 : " + k));

        System.out.println("beta1: "+ beta1);
//        System.out.println("beta2: "+ beta2);

        return beta1;

    }
}