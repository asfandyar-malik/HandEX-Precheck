package com.handex.resources;

import com.handex.persistence.ExportDao;
import com.handex.representations.Export;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Transactional
public class ExportResource {
    private final ExportDao exportDao;


    @Inject
    public ExportResource(ExportDao exportDao) {
        this.exportDao = exportDao;
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

    /**
     * Create new Export
     * @param export
     * @return new export
     */
    @POST
    @Path("public/exports")
    public Export save(@Valid Export export) {
        return exportDao.save(export);
    }

}