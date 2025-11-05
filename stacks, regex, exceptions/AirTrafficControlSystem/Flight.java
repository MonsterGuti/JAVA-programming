package SU3.AirTrafficControlSystem;

public class Flight {
    private String flightNumber;
    private String departureTime;
    private String destination;
    private FlightStatus status;

    public Flight(String flightNumber, String departureTime, String destination, FlightStatus status) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.destination = destination;
        this.status = status;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s",
                flightNumber,
                departureTime,
                destination,
                status == null ? "UNKNOWN" : status.name());
    }
}


