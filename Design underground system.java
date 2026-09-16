import java.util.*;

class UndergroundSystem {

    // customerId -> [stationName, checkInTime]
    private Map<Integer, CheckInData> checkIns;

    // "start,end" -> [totalTime, tripCount]
    private Map<String, TripData> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkIns.get(id);

        String route = data.stationName + "," + stationName;
        int travelTime = t - data.time;

        if (!trips.containsKey(route)) {
            trips.put(route, new TripData(0, 0));
        }

        TripData trip = trips.get(route);
        trip.totalTime += travelTime;
        trip.tripCount++;

        // Customer is no longer checked in
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "," + endStation;

        TripData trip = trips.get(route);

        return (double) trip.totalTime / trip.tripCount;
    }

    // Stores customer's check-in information
    private static class CheckInData {
        String stationName;
        int time;

        CheckInData(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Stores route statistics
    private static class TripData {
        int totalTime;
        int tripCount;

        TripData(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
}
