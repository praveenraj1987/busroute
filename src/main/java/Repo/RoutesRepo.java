package Repo;

import Mappers.StationMapper;
import Model.BusRoute;
import Model.Station;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class RoutesRepo {

    private final String dataFilePath;
    private String DELIMITER = " ";
    ;

    public RoutesRepo(String dataFilePath) throws FileNotFoundException {
        this.dataFilePath = dataFilePath;
    }

    public HashMap<Integer, Station> readStationMap() throws FileNotFoundException {
        File file;
        Scanner scanner;
        HashMap<Integer, Station> stationList = null;
        if (!dataFilePath.isEmpty()) {
            ClassLoader classLoader = getClass().getClassLoader();
            file = new File(dataFilePath);
            scanner = new Scanner(file);
            stationList = readStationListFromFile(scanner);
            scanner.close();
        }
        return stationList;
    }

    private HashMap<Integer, Station> readStationListFromFile(Scanner scanner) {
        HashMap<Integer, Station> stationList = new HashMap<>();
        if (scanner.hasNextLine()) {
            int totalNumberOfRoute = Integer.parseInt(scanner.nextLine());
            while (totalNumberOfRoute-- > 0) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(DELIMITER);
                int routeNumber = Integer.parseInt(lineSplit[0]);
                BusRoute route = new BusRoute(routeNumber);

                Arrays.asList(lineSplit).stream().skip(1)
                        .map(new StationMapper(route, stationList))
                        .toArray(size -> new Station[size]);
            }
        }
        return stationList;
    }
}
