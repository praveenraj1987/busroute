package Model;

public class BusRoute {
    private int routeId;

    public BusRoute(int routeNumber) {
        routeId = routeNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BusRoute person = (BusRoute) obj;
        return person.routeId == routeId;
    }

    @Override
    public int hashCode() {
        return routeId;
    }
}
