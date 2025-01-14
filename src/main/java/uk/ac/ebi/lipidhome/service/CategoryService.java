package uk.ac.ebi.lipidhome.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Joe Foster <jfoster@ebi.ac.uk>
 *
 * The CategoryService interface defines the avilable category related services and the paths that they map to.
 *
 */
@Path( "/" )
public abstract interface CategoryService {
	
    @GET
    @Path( "/summary" )
    Response getCategorySummary( @QueryParam("id") Long id);

    /*
    @GET
    @Path( "/summary/{id}" )
    Response getCategorySummary( @PathParam("id") final Long id);
    */
    
    @GET
    @Path( "/list" )
    Response getCategoryList( );
    
    @GET
    @Path( "/mainclasses" )
    Response getMainClassSimpleList( @QueryParam("id") Long id);
}
