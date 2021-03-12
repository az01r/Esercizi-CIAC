/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.gestusers.resources;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tss.ciac.gestusers.User;
import tss.ciac.gestusers.UserStore;


/**
 *
 * @author Paolo
 */
@Path("users")
public class UserResource {

    @Inject
    private UserStore store;
    
    @PostConstruct
    public void init() {
        System.out.println("init UserResource...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("end UsersResource");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) // viene creata un'istanza di user a partire dai dati .json
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User u) { 
        store.add(u);
        return Response.status(Response.Status.CREATED).entity(u).build();
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id){
        store.find(id).orElseThrow(() -> new NotFoundException());
        store.remove(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, User u){
        u.setId(id);
        store.find(id).orElseThrow(() -> new NotFoundException());
        store.update(u);
    }
    
    /**
     * per passare i parametri aggiungere all'url --> ?nome=Paolo&cognome=Grosso
     * @param nome
     * @param cognome
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> find(@QueryParam("nome") String nome, @QueryParam("cognome") String cognome) {
        if(nome==null && cognome==null){
            return store.all();
        }
        return store.find(nome, cognome);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("id") Integer id) {
        return store.find(id).orElseThrow(() -> new NotFoundException()); // .get(); //.orElseThrow()
    }
    
    //url per passare i parametri --> ?nome=Paolo&cognome=Grosso
    @PATCH
    @Path("{id}")
    public void partialUpdate(@PathParam("id") Integer id, JsonObject json){
        store.find(id).orElseThrow(() -> new NotFoundException());
        store.partialUpdate(id, json);
    }
    
}