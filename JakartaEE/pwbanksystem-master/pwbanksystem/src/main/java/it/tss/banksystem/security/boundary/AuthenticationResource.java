/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.security.boundary;

import it.tss.banksystem.bank.control.UserStore;
import it.tss.banksystem.bank.entity.User;
import it.tss.banksystem.security.control.JWTManager;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Paolo
 */
@Path("/auth")
public class AuthenticationResource {
    
    @Inject
    UserStore store;
    
    @Inject
    JWTManager jwtManager;
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) //riceve l'url
    public Response login (@FormParam("usr") String usr,@FormParam("pwd") String pwd) {
        User found = store.findByUserAndPwd(usr,pwd)
                .orElseThrow(
                () -> new NotAuthorizedException("Invalid user or password", Response.status(Response.Status.UNAUTHORIZED)
                .build()));
        return Response.ok().entity(getToken(found)).build();
    }
    
    private String getToken(User usr) {
        String result = jwtManager.generate(usr);
        System.out.println("------------ generated token -------------------");
        System.out.println(result);
        System.out.println("------------ curl command for test -------------");
        System.out.println("curl -v -i -H'Authorization: Bearer " + result + "' http://localhost:8080/projectwork/resources/users");
        return result;
    }
}
