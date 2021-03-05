/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodotti;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alfonso
 */
@Path("/prodotti")
public class ProdottiResource {
    
    @Inject
    ProdottoStore store;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prodotto> all(){
        return store.allProdotti();
    }
}
