package cl.minsal.semantikos.ws.service;

import javax.ws.rs.*;

/**
 * @author Andrés Farías on 27-12-16.
 */
@Path(value = "/termSearch")
public class TermSearcherWS {

    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    public String findTerm() {
        return "{Hello World}";
    }

    @POST
    @Produces("text/plain")
    @Consumes("text/plain")
    public String findTerms() {
        return "{Hello World}";
    }
}
