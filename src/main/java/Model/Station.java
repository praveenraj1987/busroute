package Model;

import java.util.HashSet;

public class Station {
    private int stationId;
    private HashSet<BusRoute> routes;

    public Station(int stationId) {
        this.stationId = stationId;
        routes = new HashSet<BusRoute>();
    }

    public HashSet<BusRoute> getRouteSet() {
        return routes;
    }

    public void addRoute(BusRoute route) {
        routes.add(route);
    }

    public int getStationId() {
        return stationId;
    }
}
