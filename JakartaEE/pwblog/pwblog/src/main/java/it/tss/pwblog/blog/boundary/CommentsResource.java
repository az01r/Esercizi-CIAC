/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.boundary;

import it.tss.pwblog.blog.control.CommentStore;
import javax.annotation.PostConstruct;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author tss
 */
@DenyAll
@Path("/comments")
public class CommentsResource {

    @Context
    private ResourceContext resource;

    @Context
    private UriInfo uriInfo;

    @Context
    SecurityContext securityCtx;

    @Inject
    JsonWebToken jwt;
    @Inject
    private CommentStore store;

    @PostConstruct
    public void init() {
        System.out.println(uriInfo.getPath());
        System.out.println(uriInfo.getBaseUri());
        System.out.println(uriInfo.getAbsolutePath());
    }

    //FINIRE COMMENTSRESOURCE E COMMENTRESOURCE

    /**
     * Non mettendo il metodo HTTP posso intercettare i parametri nel
     * Path e mandarli a una sottorisorsa. Sarà questa a intercettare 
     * e gestire i metodi HTTP relativi alla singola risorsa.
     * 
     * Possono eseguire il find solo gli admin o un user il cui id(nel token) == all'id passato nel path
     * 
     * In Postman:
     * - passare token in Authorization
     * - aggiungere /id_account all' url
     * 
     * @param id dell'account da visualizzare
     * @return 
     */
    @RolesAllowed({"ADMIN", "USER"})
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountResource find(@PathParam("accountId") Long id) {
        Account account = store.find(id).orElseThrow(() -> new NotFoundException());
        boolean isUserRole = securityCtx.isUserInRole(User.Role.USER.name()); // ritorna vero se il ruolo contenuto nel token è USER
        if (isUserRole && (jwt == null || jwt.getSubject() == null || Long.parseLong(jwt.getSubject()) != account.getUser().getId())) { // jwt.getSubject ritorna l'id dello user proprietario dell'account
            throw new ForbiddenException(Response.status(Response.Status.FORBIDDEN).entity("Access forbidden: role not allowed").build());
        }
        AccountResource sub = resource.getResource(AccountResource.class);
        sub.setAccountId(id);
        return sub;
    }

}
