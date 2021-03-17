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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    
}
