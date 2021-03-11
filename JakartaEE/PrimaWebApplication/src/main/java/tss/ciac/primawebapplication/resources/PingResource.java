/*
 * per accedere a questo web service http://localhost:8080/PrimaWebApplication-1.0-SNAPSHOT/resources/ping
 */
package tss.ciac.primawebapplication.resources;

import java.time.LocalDateTime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Paolo
 */

@Path("ping")
public class PingResource {
        @GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping(){
		return "ping ok at "+LocalDateTime.now();
	}
}
