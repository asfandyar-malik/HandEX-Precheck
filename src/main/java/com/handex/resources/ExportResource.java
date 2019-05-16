package com.handex.resources;

import com.handex.persistence.CompanyRiskPremiumsDao;
import com.handex.persistence.ExportDao;
import com.handex.persistence.IndustryBetasDao;
import com.handex.representations.Export;
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

    private final ExportDao exportDao;

    @Autowired
    private IndustryBetasDao industryBetasDao;

    @Autowired
    private CompanyRiskPremiumsDao companyRiskPremiumsDao;

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

        String output = String.valueOf(industryBetasDao.getOne(Long.valueOf(1)));

        return output;

    }

}