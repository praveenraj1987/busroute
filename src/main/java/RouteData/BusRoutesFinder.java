package RouteData;

import Model.BusRoute;
import Model.Station;
import Repo.RoutesRepo;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class BusRoutesFinder {
    private static HashMap<Integer, Station> stationMap;

    public static void init(String dataFile) throws FileNotFoundException {
        process(dataFile);
    }

    private static void process(String dataFilePath) throws FileNotFoundException {
        RoutesRepo repo = new RoutesRepo(dataFilePath);
        stationMap = repo.readStationMap();
    }

    public boolean doesRouteExist(int srcId, int depId){
        Station source = stationMap.get(srcId);
        Station destination = stationMap.get(depId);
        return doesRouteExist(source, destination);
    }

    private boolean doesRouteExist(Station source, Station destination) {
        if(source != null && destination != null){
            HashSet<BusRoute> sourceRoutes = source.getRouteSet();
            HashSet<BusRoute> destinationRoutes = destination.getRouteSet();
            return !Collections.disjoint(sourceRoutes, destinationRoutes);
        }
        return false;
    }
}
