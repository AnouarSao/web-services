/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurant.api;

import com.mycompany.restaurant.business.Menu;
import com.mycompany.restaurant.business.Plat;
import java.util.List;
import java.util.Optional;
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
@Path("menus")
public class MenuApi {

    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    public List<Menu> getAllMenus(@Context HttpServletRequest request) {

        Plat plat = (Plat) request.getSession().getAttribute("plat");
        if (plat == null) {
            plat = new Plat();
            request.getSession().setAttribute("plat", plat);
        }
        return plat.getAllMenus();
    }

    @POST()
    @Consumes({MediaType.APPLICATION_JSON})
    public void postMenu(Menu menu, @Context HttpServletRequest request) {

        Plat plat = (Plat) request.getSession().getAttribute("plat");
        if (plat == null) {
            plat = new Plat();
        }
        plat.addMenu(menu);
        request.getSession().setAttribute("plat", plat);
    }

    @Path("/{id}")
    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMenuById(@PathParam("id") Long menuId, @Context HttpServletRequest request) {
        Plat plat = (Plat) request.getSession().getAttribute("plat");
        if (plat == null) {
            plat = new Plat();
        }
        Optional<Menu> menuOptional = plat.findMenuById(menuId);

        if (menuOptional.isPresent()) {
            return Response.ok(menuOptional.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Menu Not Found").build();
        }
    }

    @Path("/{id}")
    @DELETE()
    public void deleteMenu(@PathParam("id") Long menuId, @Context HttpServletRequest request) {
        Plat plat = (Plat) request.getSession().getAttribute("plat");
        if (plat == null) {
            plat = new Plat();
        }

        Optional<Menu> menuToDelete = plat.findMenuById(menuId);

        if (menuToDelete.isPresent()) {
            plat.deleteMenu(menuToDelete.get());
        } 
    }

    @Path("/{id}")
    @PUT()
    public void updateMenu(Menu menuToUpdate, @Context HttpServletRequest request) {
        Plat plat = (Plat) request.getSession().getAttribute("plat");
        if (plat == null) {
            plat = new Plat();
        }
        plat.updateMenu(menuToUpdate);
    }
}
