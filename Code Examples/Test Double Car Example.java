//four classes and two collaborators

public class Car {
    private Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }
    public void start() {
        engine.start();
    }
    public void drive(Route route) {
        for (Directions directions: route.directions()) {
            directions.follow();
        }
    }
    public void stop() {
        engine.stop();
    }
}


====================================
//this thing uses a clock class to feed the algorithm if we want to test the car we would have to deal with this
public class Route {
    private Clock clock = new Clock();
    private ShortestPath algorithm = new ShortestPath();
    public Collection < Directions > directions() {
        if (clock.isRushHour()) {
            return algorithm.avoidBusyIntersections();
        }
        return algorithm.calculateRouteBetween(...);
    }
}