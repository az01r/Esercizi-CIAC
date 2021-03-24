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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Paolo
 */
@Path("/accounts")
public class AccountsResource {

    @Context
    private ResourceContext resource;

    @Context
    private UriInfo uriInfo;

    @Inject
    private AccountStore store;

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

    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountResource find(@PathParam("accountId") Long id) {
        AccountResource sub = resource.getResource(AccountResource.class);
        sub.setAccountId(id);
        return sub;
    }

}
