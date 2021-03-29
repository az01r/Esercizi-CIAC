/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.security.boundary;

import javax.annotation.PostConstruct;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author alfonso
 */
@Path("/test")
@DenyAll
public class Test {
    
    @Inject
    @Claim(standard = Claims.sub)
    private String userId;
    
    @Inject
    JsonWebToken jwt;
    
    @Context
    SecurityContext securityContext;
    
    @PostConstruct
    public void init(){
        System.out.println(jwt);
    }
    
    /*
     * NB prima di testare registrarsi e loggarsi, con postman:
     *
     *  SIGN IN http://localhost:8080/resources/users
     *  passare nel body raw / json
     *  {
     *      "email": "a",
     *      "fname": "a",
     *      "lname": "a",
     *      "pwd": "a",
     *      "tel": "a",
     *      "usr": "a"
     *  }
     *  
     *  LOGIN http://localhost:8080/resources/auth
     *  passare nel body x-www-form-urlencoded
     *  @param usr
     *  @param pwd
     *  copiare il token ritornato, servirà per il test
     * 
     */
    
    /**
     * per testare con postman: http://localhost:8080/resources/test/all
     *
     * @return
     */
    @GET
    @Path("all")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String testAll(){
        return "all ok..";
    }
    
    /**
     * per testare con postman: http://localhost:8080/resources/test/admin
     * passare in authorization il token (tipo Barer Token)
     *
     * @return
     */
    @GET
    @Path("admin")
    @RolesAllowed({"ADMIN"})
    @Produces(MediaType.TEXT_PLAIN)
    public String testAdmin(){
        return "all admin ok..";
    }
    
    /**
     * per testare con postman: http://localhost:8080/resources/test/user
     * passare in authorization il token (tipo Barer Token)
     *
     * @return
     */
    @GET
    @Path("user")
    @RolesAllowed({"USER","ADMIN"})
    @Produces(MediaType.TEXT_PLAIN)
    public String testUser(){
        System.out.println("L'utente ha ruolo USER ? " + securityContext.isUserInRole("USER"));
        System.out.println("User ID: " + userId );
        return "all users ok..";
    }
    
}
