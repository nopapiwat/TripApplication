package TripApplication;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.api.services.bigquery.model.TableCell;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

@Path("/")
public class Route {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TableCell> returnJSON() throws IOException {
		Query query = new Query();
		return query.printResults();
	}

}