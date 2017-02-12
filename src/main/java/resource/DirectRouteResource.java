package resource;


import response.RouteResponse;
import RouteData.BusRoutesFinder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("api")
public class DirectRouteResource {
    @Path("direct")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RouteResponse routeExist(@QueryParam("dep_sid") int departure, @QueryParam("arr_sid") int arrival) {
        BusRoutesFinder busRoutesFinder = new BusRoutesFinder();
        boolean isDirectRoutePresent = busRoutesFinder.doesRouteExist(departure, arrival);
        RouteResponse route = new RouteResponse(departure, arrival, isDirectRoutePresent);
        return route;
    }
}