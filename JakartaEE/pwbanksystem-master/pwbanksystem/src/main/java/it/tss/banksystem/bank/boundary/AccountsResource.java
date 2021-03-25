/*
 * risorsa usata dagli amministratori
 * ordine: accounts/account/transactions
 * 
 * https://eclipse-ee4j.github.io/jakartaee-tutorial/jaxrs002.html
 * 
 */
package it.tss.banksystem.bank.boundary;

import it.tss.banksystem.bank.boundary.dto.AccountList;
import it.tss.banksystem.bank.boundary.dto.AccountView;
import it.tss.banksystem.bank.control.AccountStore;
import it.tss.banksystem.bank.entity.Account;
import it.tss.banksystem.bank.entity.User;
import java.util.List;
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
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author Paolo
 */
@Path("/accounts")
@DenyAll
public class AccountsResource {

    @Context
    private ResourceContext resource;

    @Context
    private UriInfo uriInfo;

    @Inject
    private AccountStore store;
    
    @Context
    SecurityContext securityCtx;
    
    @Inject
    JsonWebToken jwt;

    @PostConstruct
    public void init() {
        System.out.println(uriInfo.getPath());
        System.out.println(uriInfo.getBaseUri());
        System.out.println(uriInfo.getAbsolutePath());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AccountList search() {
        return store.searchView();
    }

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
    @RolesAllowed({"ADMIN","USER"})
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountResource find(@PathParam("accountId") Long id) {
        Account account = store.find(id).orElseThrow(() -> new NotFoundException());
        boolean isUser = securityCtx.isUserInRole(User.Role.USER.name()); // ritorna vero se il ruolo contenuto nel token è USER
        if (isUser && (jwt == null || jwt.getSubject() == null || Long.parseLong(jwt.getSubject()) != account.getUser().getId())) { // jwt.getSubject ritorna l'id dello user proprietario dell'account
            throw new ForbiddenException(Response.status(Response.Status.FORBIDDEN).entity("Access forbidden: role not allowed").build());
        }
        AccountResource sub = resource.getResource(AccountResource.class);
        sub.setAccountId(id);
        return sub;
    }
    
}
