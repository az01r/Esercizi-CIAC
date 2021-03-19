/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.bank.boundary;

import it.tss.banksystem.bank.control.AccountStore;
import it.tss.banksystem.bank.control.UserStore;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Paolo
 */

@Path("/bank")
public class BankResource {
    
    UserStore userStore;
    AccountStore accountStore;
/*
    @Override
    public String toString() {
        return "BankResource{" + "totAccont=" + userStore.count() + ", totDeposit=" + accountStore.totalDeposit() + '}';
    }
    
    @GET
    @Path("/stats")
    public String stats() {
        return this.toString();
    } 
*/  
    
    @GET
    @Path("/stats")
    public JsonObject stats() {
        return Json.createObjectBuilder().add("naccounts", userStore.count()).add("totDeposit", accountStore.totalDeposit()).build();
    } 
    
}
