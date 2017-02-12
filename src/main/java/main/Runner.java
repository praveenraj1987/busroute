package main;

import EmbeddedServer.EmbeddedServerRunner;
import RouteData.BusRoutesFinder;

public class Runner
{
    public static void main(String[] args ) throws Exception
    {
        BusRoutesFinder.init(args[0]);

        EmbeddedServerRunner server = new EmbeddedServerRunner(8088);
        server.run();
    }
}