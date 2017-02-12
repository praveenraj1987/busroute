package Mappers;

import Model.BusRoute;
import Model.Station;

import java.util.HashMap;

public class StationMapper implements java.util.function.Function<String, Station> {

    private final BusRoute route;
    private final HashMap<Integer, Station> stationList;

    public StationMapper(BusRoute route, HashMap<Integer, Station> stationList) {
        this.route = route;
        this.stationList = stationList;
    }

    @Override
    public Station apply(String id) {
        int stationId = Integer.parseInt(id);
        Station station = stationList.get(stationId);

        if (station == null) {
            station = new Station(stationId);
            stationList.put(stationId, station);
        }
        station.addRoute(route);
        return station;
    }
}