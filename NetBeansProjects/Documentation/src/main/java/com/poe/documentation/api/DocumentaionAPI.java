/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.documentation.api;

import com.poe.documentation.dao.DocumentationDAO;
import com.poe.documentation.entity.Documentation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Anouar-Sao
 */
@Path("docs")
public class DocumentaionAPI {

 

    @POST()
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Documentation docToCreate) {

        DocumentationDAO.createDoc(docToCreate);
    }

    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    public List<Documentation> findAll() {

        return DocumentationDAO.findAllDocs();
    }

    @Path("/{id}")
    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    public Response findById(@PathParam("id") Long docId) {
        Documentation d = DocumentationDAO.findDocById(docId);
        if (d != null) {
            return Response.ok(d).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Documentation Not Found").build();
        }
    }
    
    @Path("/{id}")
    @DELETE()
    public void delete(@PathParam("id") Long docId) {

        DocumentationDAO.deleteDoc(docId);
    }

    @Path("/{id}")
    @PUT()
    public void update(@PathParam("id") Long docId, Documentation docData) {

        DocumentationDAO.updateDoc(docId, docData);
    }
}
