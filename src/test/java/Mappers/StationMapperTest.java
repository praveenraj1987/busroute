package Mappers;

import Model.BusRoute;
import Model.Station;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class StationMapperTest {

    @Test
    public void applyShouldAddAllStationToStationList() throws Exception {
        BusRoute route = new BusRoute(0);
        String[] staions = {"1", "2", "3", "4"};
        HashMap<Integer, Station> stationList = new HashMap<>();

        final BusRoute route1 = route;
        final HashMap<Integer, Station> stationList1 = stationList;
        Arrays.asList(staions).stream()
                .map(new Function<String, Station>() {
                    private final BusRoute route = route1;
                    private final HashMap<Integer, Station> stationList = stationList1;

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
                })
                .toArray(size -> new Station[size]);

        assertEquals(4,stationList.size());
    }

    @Test
    public void applyShouldAddStationOnlyIfItDoesntExistInStationList() throws Exception {
        BusRoute route = new BusRoute(0);
        String[] staions = {"1", "2", "3", "4"};
        Station stationExpected = new Station(6);
        HashMap<Integer, Station> stationList = mock(HashMap.class);
        when(stationList.get(anyInt())).thenReturn(stationExpected);
        when(stationList.get(3)).thenReturn(null);
        ArgumentCaptor<Integer> argument1 = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Station> argument2 = ArgumentCaptor.forClass(Station.class);

        final BusRoute route1 = route;
        final HashMap<Integer, Station> stationList1 = stationList;
        Arrays.asList(staions).stream()
                .map(new Function<String, Station>() {
                    private final BusRoute route = route1;
                    private final HashMap<Integer, Station> stationList = stationList1;

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
                })
                .toArray(size -> new Station[size]);

        verify(stationList, times(1)).put(argument1.capture(),argument2.capture());
        assertEquals(3, (long)argument1.getValue());
        assertEquals(3, argument2.getValue().getStationId());
    }

    @Test
    public void applyShouldNotAddStationIfItExistInStationList() throws Exception {
        BusRoute route = new BusRoute(0);
        String[] staions = {"1", "2", "3", "4"};
        Station stationExpected = new Station(6);
        HashMap<Integer, Station> stationList = mock(HashMap.class);
        when(stationList.get(anyInt())).thenReturn(stationExpected);

        final BusRoute route1 = route;
        final HashMap<Integer, Station> stationList1 = stationList;
        Arrays.asList(staions).stream()
                .map(new Function<String, Station>() {
                    private final BusRoute route = route1;
                    private final HashMap<Integer, Station> stationList = stationList1;

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
                })
                .toArray(size -> new Station[size]);

        verify(stationList, times(0)).put(any(Integer.class), any(Station.class));
    }

}