/*
 * ogni volta che entro in UserResource WildFly crea un'istanza della classe 
 * quindi non il controllo delle istanze non è lasciato al programmatore
 * NB non si devono usare variabili statiche perchè vanno contro il principio 
 *    di un application server STATELESS
 */
package tss.ciac.primawebapplication.resources;

import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tss.ciac.primawebapplication.User;
import tss.ciac.primawebapplication.UserStore;

/**
 *
 * @author Paolo
 */
@Path("users")
public class UserResource {

    private UserStore store;
    
    @PostConstruct
    public void init() {
        /* 
        store = new UserStore();
        non posso creare un'istanza in questo modo perchè non sono io a gestire la creazione delle istanze di UserResource
        perchè verrebbero creat
        */
        store = UserStore.getInstance();
        System.out.println("init UserResource...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("end UsersResource");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> all() {
        return store.all();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("id") Integer id) {
        //return Arrays.asList(new User("Mario", "Rossi"), new User("Luca", "Verdi"), new User("Francesca","Rossi"));
        return store.find(id).get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) // viene creata un'istanza di user a partire dai dati .json
    public void create(User u) { 
        store.add(u);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id){
        store.remove(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, User u){
        u.setId(id);
        store.update(u);
    }
    
}
