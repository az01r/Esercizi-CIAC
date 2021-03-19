/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bankSystem.boundary;

import it.tss.bankSystem.control.UserStore;
import it.tss.bankSystem.entity.User;
import java.util.List;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.models.OpenAPI;

/**
 *
 * @author Paolo
 */

@Path("/users")
public class UserResource {
    
    @Inject
    UserStore store;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> search(){
        return store.search();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User u){ // creazione di un'entity
        User saved = store.create(u);
        return Response.status(Response.Status.CREATED)
                .entity(saved)
                .build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Long id){
        User user = store.find(id).orElseThrow((() -> 
            new NotFoundException()
        ));
        return Response.ok().entity(user).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        store.find(id).orElseThrow(() -> new NotFoundException());
        store.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @PATCH
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, JsonObject json){
        User user = store.find(id).orElseThrow(() -> new NotFoundException()); 
        store.update(user,json); // ritorna l'User aggiornato
        return Response.ok().entity(user).build();
    }
}
