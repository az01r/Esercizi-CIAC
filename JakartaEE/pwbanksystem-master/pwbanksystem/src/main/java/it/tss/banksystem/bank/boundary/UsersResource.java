/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.bank.boundary;

import it.tss.banksystem.bank.control.UserStore;
import it.tss.banksystem.bank.entity.User;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author alfonso
 */
@Path("/users")
public class UsersResource {

    @Context
    UriInfo uriInfo;

    @Inject
    UserStore store;

    @Context
    ResourceContext resource;

    @PostConstruct
    public void init() {
        System.out.println(uriInfo.getPath());
        System.out.println(uriInfo.getBaseUri());
        System.out.println(uriInfo.getAbsolutePath());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> search(@QueryParam("start") int start, @QueryParam("maxResult") int maxResult) {
        return store.search(start, maxResult);
    }

    /**
     * non mettendo il metodo HTTP posso intercettare i parametri nel
     * Path e mandarli a una sottorisorsa. Sarà questa a intercettare 
     * e gestire i metodi HTTP relativi alla singola risorsa
     * 
     * @param id
     * @return 
     */
    @Path("{id}")
    public UserResource find(@PathParam("id") Long id) {
        UserResource sub = resource.getResource(UserResource.class);
        sub.setId(id);
        return sub;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User u) {
        User saved = store.create(u);
        return Response.status(Response.Status.CREATED)
                .entity(saved)
                .build();
    }

}
