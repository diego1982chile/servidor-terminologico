package cl.minsal.semantikos;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * @author Andrés Farías on 27-12-16.
 */
@Path(value = "/termSearch/{term}")
public class TermSearcherWS {

    @GET
    @Produces("text/plain")
    //@Consumes(TEXT_PLAIN)
    public String findTerm(@PathParam("term") String term) {
        return "Buscando término " + term + "... Paciencia por favor...";
    }

}
