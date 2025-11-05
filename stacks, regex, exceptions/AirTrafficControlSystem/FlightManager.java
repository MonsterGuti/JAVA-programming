package SU3.AirTrafficControlSystem;
import java.util.*;

public class FlightManager {
    private final Queue<Flight> queue;
    private final Map<String, Flight> indexByNumber;

    public FlightManager() {
        this.queue = new ArrayDeque<>();
        this.indexByNumber = new HashMap<>();
    }

    public boolean addFlight(Flight flight) {
        if (flight == null || flight.getFlightNumber() == null) return false;
        String key = flight.getFlightNumber().trim().toUpperCase();
        if (indexByNumber.containsKey(key)) {
            return false;
        }
        queue.offer(flight);
        indexByNumber.put(key, flight);
        return true;
    }

    public Flight pollNextFlight() {
        Flight f = queue.poll();
        if (f != null) {
            indexByNumber.remove(f.getFlightNumber().trim().toUpperCase());
        }
        return f;
    }

    public boolean changeStatus(String flightNumber, FlightStatus newStatus) {
        if (flightNumber == null || newStatus == null) return false;
        Flight f = indexByNumber.get(flightNumber.trim().toUpperCase());
        if (f == null) return false;
        f.setStatus(newStatus);
        return true;
    }

    public List<Flight> listAllFlights() {
        return new ArrayList<>(queue);
    }

    public boolean hasFlights() {
        return !queue.isEmpty();
    }
}

