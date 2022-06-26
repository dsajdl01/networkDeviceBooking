package org.booking.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.response.json.RestResponseHandler;


@Path("/user")
public class RestApiUser
{

    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@Context HttpServletRequest request) {
        // auth.getLogonUser(request)
        return RestResponseHandler.success();
    }
}
