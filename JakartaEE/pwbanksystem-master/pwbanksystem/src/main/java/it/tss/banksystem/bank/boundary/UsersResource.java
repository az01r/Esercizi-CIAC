/*
 * ordine risorse: users/user/accounts/account/transactions
 * oppure          accounts/account/transactios (per amministratori)
 */
package it.tss.banksystem.bank.boundary;

import it.tss.banksystem.bank.boundary.dto.UserCreate;
import it.tss.banksystem.bank.boundary.dto.UserList;
import it.tss.banksystem.bank.boundary.dto.UserViewLink;
import it.tss.banksystem.bank.boundary.dto.UserViewFull;
import it.tss.banksystem.bank.control.UserStore;
import it.tss.banksystem.bank.entity.User;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.Valid;
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
 * @author Paolo
 */
@Path("/users")
public class UsersResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    private UserStore store;

    @Context
    private ResourceContext resource;

    @PostConstruct
    public void init() {
        System.out.println(uriInfo.getPath());
        System.out.println(uriInfo.getBaseUri());
        System.out.println(uriInfo.getAbsolutePath());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserList search(@QueryParam("start") int start, @QueryParam("maxResult") int maxResult) {
        return store.searchFullView(start, maxResult);
    }

    /**
     * non mettendo il metodo HTTP posso intercettare i parametri nel
     * Path e mandarli a una sottorisorsa. Sarà questa a intercettare 
     * e gestire i metodi HTTP relativi alla singola risorsa
     * 
     * @param id
     * @return 
     */
    @Path("{userId}")
    public UserResource find(@PathParam("userId") Long id) {
        UserResource sub = resource.getResource(UserResource.class);
        sub.setUserId(id);
        return sub;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid UserCreate u) {
        User saved = store.create(new User(u));
        return Response.status(Response.Status.CREATED)
                .entity(new UserViewFull(saved))
                .build();
    }

}
