package response;

import org.codehaus.jackson.annotate.JsonProperty;

public class RouteResponse {
    @JsonProperty("dep_sid")
    private int departure;
    @JsonProperty("arr_sid")
    private int arrival;
    @JsonProperty("direct_bus_route")
    private boolean directRoute;

    public RouteResponse(int dep, int arr, boolean routeExist) {
        departure = dep;
        arrival = arr;
        directRoute = routeExist;
    }

    public int getDeparture() {
        return departure;
    }


    public int getArrival() {
        return arrival;
    }

    public boolean getDirectRoute() {
        return directRoute;
    }
}
