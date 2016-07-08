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

//Sets the path to base URL + /hello
@Path("/")
public class Hello {	

//	// This method is called if TEXT_PLAIN is request
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String sayPlainTextHello() throws IOException {
//		Query query = new Query();
//		return query.printResults();
//	}
//
//	// This method is called if XML is request
//	@GET
//	@Produces(MediaType.TEXT_XML)
//	public String sayXMLHello() throws IOException {
//		Query query = new Query();
//		return "<?xml version=\"1.0\"?>" + "<result> " + query.printResults() + "</result>";
//	}
//
//	// This method is called if HTML is request
//	@GET
//	@Produces(MediaType.TEXT_HTML)
//	public String sayHtmlHello() throws IOException {
//		Query query = new Query();
//		return "<html> " + "<title>" + "Query Result" + "</title>" + "<body>" + query.printResults() + "</body>"
//				+ "</html> ";
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TableCell> sayJSONHello() throws IOException {
		Query query = new Query();
		return query.printResults();
	}

}