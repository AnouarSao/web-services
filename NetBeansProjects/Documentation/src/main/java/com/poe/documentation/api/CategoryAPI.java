/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.documentation.api;

import com.poe.documentation.dao.CategoryDAO;
import com.poe.documentation.entity.Category;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Anouar-Sao
 */
@Path("cats")
public class CategoryAPI {

    @POST()
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Category catToCreate) {

        CategoryDAO.createCat(catToCreate);
    }

    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    public List<Category> findAll() {

        return CategoryDAO.findAllCats();
    }

    @Path("/{id}")
    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    public Response findById(@PathParam("id") Long catId) {
        Category c = CategoryDAO.findCatById(catId);
        if (c != null) {
            return Response.ok(c).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Category Not Found").build();
        }
    }

    @Path("/{id}")
    @DELETE()
    public void delete(@PathParam("id") Long catId) {

        CategoryDAO.deleteCat(catId);
    }

    @Path("/{id}")
    @PUT()
    public void update(@PathParam("id") Long catId, Category catData) {

        CategoryDAO.updateCat(catId, catData);
    }
}
