package SU3.AirTrafficControlSystem;

public enum FlightStatus {
    PARKED,
    TAXING,
    RUNWAY,
    DEPARTED;

    public static FlightStatus fromString(String s) {
        if (s == null) return null;
        try {
            return FlightStatus.valueOf(s.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}

