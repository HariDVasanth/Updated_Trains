import java.util.*;

public class TrainSearch {

    private Trains trains;
    private double AcberthFare;
    private double GeneralBerthFare;
    private double distance;

    public TrainSearch(Trains trains) {
        this.trains = trains;
    }

    public boolean SearchDisplay(String Departure, String Destination, ArrayList<Integer> Dates) {
        boolean trainFound = false;
        for (Map.Entry<Integer, Trains> entry : trains.getTrain().entrySet()) {
            int TrainNumber = entry.getKey();
            Trains trainDetails = entry.getValue();

            if (isSuitableTrain(trainDetails, Departure, Destination, Dates)) {
                String TrainType = trainDetails.getTrainType();
                distance = Distance(Departure, Destination);
                AcberthFare = CalculateFare(Departure, Destination, TrainType, "Ac");
                GeneralBerthFare = CalculateFare(Departure, Destination, TrainType, "General");

                System.out.println("Train Number: " + TrainNumber + "\n");
                System.out.println(trainDetails);
                System.out.println("Ac Berth Fare: " + AcberthFare);
                System.out.println("Departure: " + Departure);
                System.out.println("Destination: " + Destination);
                System.out.println("General Berth Fare: " + GeneralBerthFare);
                System.out.println("Distance: " + distance);
                trainFound = true;
                break;
            }
        }
        if (!trainFound) {
            System.out.println("Trains not available");
        }
        return trainFound;
    }

    private boolean isSuitableTrain(Trains train, String Departure, String Destination, ArrayList<Integer> Dates) {
        return train.getStops().contains(Departure) &&
                train.getStops().contains(Destination) &&
                train.getDateDeparture().size() == Dates.size() &&
                train.getDateDeparture().containsAll(Dates);
    }

    public double Distance(String Departure, String Destination) {
        for (Map.Entry<Integer, Trains> entry : trains.getTrain().entrySet()) {
            Trains sub = entry.getValue();
            int Startindex = sub.getStops().indexOf(Departure);
            int Stopindex = sub.getStops().indexOf(Destination);
            if (Startindex < Stopindex) {
                distance = sub.getDistance().get(Stopindex) - sub.getDistance().get(Startindex);
                return distance;
            }
        }
        return 0;
    }

    public double CalculateFare(String Departure, String Destination, String TrainType, String SeatType) {
        for (Map.Entry<Integer, Trains> entry : trains.getTrain().entrySet()) {
            distance = Distance(Departure, Destination);
            if (SeatType.equals("Ac")) {
                AcberthFare = FareCalculation.calculate(TrainType, "Ac", distance);
                return AcberthFare;
            } else if (SeatType.equals("General")) {
                GeneralBerthFare = FareCalculation.calculate(TrainType, "General", distance);
                return GeneralBerthFare;
            }
        }
        return 0;
    }
}