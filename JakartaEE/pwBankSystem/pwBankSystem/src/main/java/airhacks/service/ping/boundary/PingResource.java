package airhacks.service.ping.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @Inject
    /* 
    annotazione derivata dalla specifica MicroProfile Config, non ancora 
    implementata in Jackarta EE
    configura un file in /Other_Sources/METAINF/
    nel pom si vede la dipendenza
    <dependency>
            <groupId>org.eclipse.microprofile</groupId>
            <artifactId>microprofile</artifactId>
            <version>3.3</version>
            <type>pom</type>
            <scope>provided</scope>
    </dependency>
    */      
    @ConfigProperty(name = "message") 
    String message;    

    @GET
    public String ping() {
        return this.message + " Jakarta EE 8 with MicroProfile 3+!";
    }

}
