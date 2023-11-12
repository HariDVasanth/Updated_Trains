

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Trains {

    private String trainName;
    private String trainType;
    private final String acSleeperBerth="AcSleeperBerth";
    private final String acMiddleBerth="AcMiddleBerth";
    private final String acUpperBerth="AcUpperBerth";
    private final String generalSleeperBerth="GeneralSleeperBerth";
    private final String generalMiddleBerth="GeneralMiddleBerth";
    private final String generalUpperBerth="GeneralUpperBerth";
    private final String Ac="Ac";
    private final String General="General";
    private ArrayList<Integer> AcSleeperBerth = new ArrayList<>();
    private ArrayList<Integer> AcMiddleBerth = new ArrayList<>();
    private ArrayList<Integer> AcUpperBerth = new ArrayList<>();
    private ArrayList<Integer> GeneralSleeperBerth = new ArrayList<>();
    private ArrayList<Integer> GeneralMiddleBerth = new ArrayList<>();
    private ArrayList<Integer> GeneralUpperberth = new ArrayList<>();
    private int AcSeatsAvailable;
    private int GeneralSeatsAvailable;
    private int Distance1;
    protected ArrayList<Integer> DateArrival = new ArrayList<>();
    private HashMap<Integer, Trains> Train = new HashMap<>();
    private ArrayList<String> Stops = new ArrayList<>();
    private ArrayList<Integer> Distance = new ArrayList<>();
    private ArrayList<Integer> DateDeparture = new ArrayList<>();


    public HashMap<Integer, Trains> getTrain() {
        return Train;
    }

    public void setTrain(int TrainNUmber, Trains Value) {
        Train.put(TrainNUmber, Value);
    }


    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }


    public void setDateArrival(int Date_Arrival) {
        DateArrival.add(Date_Arrival);
    }

    public void setDateDeparture(int Date_Departure) {
        DateDeparture.add(Date_Departure);
    }

    public ArrayList getDateDeparture() {
        return DateDeparture;
    }


    public String getTrainType() {
        return trainType;
    }

    public ArrayList<Integer> getAcSleeperBerth() {
        return AcSleeperBerth;
    }


    public ArrayList<Integer> getAcMiddleBerth() {
        return AcMiddleBerth;
    }


    public ArrayList<Integer> getAcUpperBerth() {
        return AcUpperBerth;
    }






    public void setAcSleeperSeats() {
        int seats=FareCalculation.Seats(getTrainType(),Ac);
        SetSeats(seats,acSleeperBerth);
    }
    public void setAcMiddleBerth(){
        int seats=FareCalculation.Seats(getTrainType(),Ac);
        SetSeats(seats,acMiddleBerth);
    }
    public void setAcUpperBerth(){
        int seats=FareCalculation.Seats(getTrainType(),Ac);
        SetSeats(seats,acUpperBerth);
    }
    public void setGeneralSleeperBerth(){
        int seats=FareCalculation.Seats(getTrainType(),General);
        SetSeats(seats,generalSleeperBerth);
    }
    public void setGeneralMiddleBerth(){
        int seats=FareCalculation.Seats(getTrainType(),General);
        SetSeats(seats,generalMiddleBerth);
    }
    public void setGeneralUpperberth(){
        int seats=FareCalculation.Seats(getTrainType(),General);
        SetSeats(seats,generalUpperBerth);
    }




    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }
    public void setStops(String stops){
        Stops.add(stops);
    }

    public ArrayList<String> getStops() {
        return Stops;
    }

    public void setDistance(int distance){
        Distance1+=distance;
        Distance.add(Distance1);
    }

    public ArrayList<Integer> getDistance() {
        return Distance;
    }

    public ArrayList<Integer> getGeneralSleeperBerth() {
        return GeneralSleeperBerth;
    }

    public ArrayList<Integer> getGeneralMiddleBerth() {
        return GeneralMiddleBerth;
    }

    public ArrayList<Integer> getGeneralUpperBerth() {
        return GeneralUpperberth;
    }

    public int getAcSeatsAvailable() {
        return AcSeatsAvailable;
    }
    public int getGeneralSeatsAvailable(){
        return GeneralSeatsAvailable;
    }


    public void setAcSeatsAvailable() {
        AcSeatsAvailable = getAcSleeperBerth().size()+getAcMiddleBerth().size()+getAcUpperBerth().size();
    }
    public void setGeneralSeatsAvailable(){
        GeneralSeatsAvailable=getGeneralSleeperBerth().size()+getGeneralMiddleBerth().size()+getGeneralUpperBerth().size();
    }

    public void viewTrains(){
        for(Map.Entry<Integer,Trains>entry:Train.entrySet()){
            int trainNumber=entry.getKey();
            Trains details= entry.getValue();
            System.out.println("Train number: "+trainNumber);
            System.out.println(details);
        }
    }

    @Override public String toString() {
                return
                    "Train Name: " + getTrainName() + "\n" +
                    "AC Seats Available: " + getAcSeatsAvailable() + "\n" +
                    "General Seats Available: " + getGeneralSeatsAvailable() + "\n" +
                    "Departure Date: " + DateDeparture.get(0) + "-" + DateDeparture.get(1) + "-" + DateDeparture.get(2) + "\n" +

                    "Arrival Date: " + DateArrival.get(0) + "-" + DateArrival.get(1) + "-" + DateArrival.get(2);
        }
        public void SetSeats(int seats,String SeatType){
            int k=(seats/8);
            int adder=0;
            for(int i=1;i<=k;i++){
                for(int j=1;j<=8;j++){
                   if((j==1 || j==2 || j==7 || j==8) && SeatType.equals(acSleeperBerth)){
                       AcSleeperBerth.add(j+adder);
                   }
                   else if((j==3 || j==4) && SeatType.equals(acMiddleBerth)){
                       AcMiddleBerth.add(j+adder);
                   }
                   else if((j==5 || j==6) && SeatType.equals(acUpperBerth)){
                       AcUpperBerth.add(j+adder);
                   }
                   else if((j==1 || j==2 || j==7 || j==8) && SeatType.equals(generalSleeperBerth)){
                       GeneralSleeperBerth.add(j+adder);
                   }
                   else if((j==3 || j==4) && SeatType.equals(generalMiddleBerth)){
                       GeneralMiddleBerth.add(j+adder);
                   }
                   else if((j==5 || j==6) && SeatType.equals(generalMiddleBerth)){
                        GeneralUpperberth.add(j+adder);
                    }

                }
                adder+=8;
            }
        }
        public int size(){
            int s= Train.size();
            System.out.println("Trains added size: "+s);
            return s;
        }

        public int booking(String seat,ArrayList<Integer>seatType) {
                int seatNumber = seatType.get(0);
                seatType.remove(0);
                if(seat.equals("Ac")) {
                    AcSeatsAvailable -= 1;
                }
                if(seat.equals("General")){
                    GeneralSeatsAvailable-=1;
                }
                return seatNumber;
        }
        public int bookAcSleeper(){
            System.out.println(AcSleeperBerth);
            int seatNumber=booking("Ac",AcSleeperBerth);
            return seatNumber;
        }

        public int bookAcMiddle(){
            int seatNumber=booking("Ac",AcMiddleBerth);
            return seatNumber;
        }
        public int bookAcUpper(){
            int SeatNumber=booking("Ac",AcUpperBerth);
            return SeatNumber;
        }
        public int bookGeneralSleeper(){
            int SeatNumber=booking("General",GeneralSleeperBerth);
            return SeatNumber;
        }
        public int bookGeneralMiddle(){
            int SeatNumber=booking("General",GeneralMiddleBerth);
            return SeatNumber;
        }
        public int bookGeneralUpper(){
            int SeatNumber=booking("General",GeneralUpperberth);
            return SeatNumber;
        }
        public void cancel(String seatType){
            if(seatType.equals("Ac")) {
                AcSeatsAvailable += 1;
            } else if (seatType.equals("General")) {
                GeneralSeatsAvailable+=1;
            }
        }
        public void cancelAcSLeeper(int Cancelled){
            AcSleeperBerth.add(Cancelled);
            cancel("Ac");
        }
        public void cancelAcMiddle(int Cancelled){
            AcMiddleBerth.add(Cancelled);
            cancel("Ac");
        }
        public void cancelAcUpper(int Cancelled){
            AcUpperBerth.add(Cancelled);
            cancel("Ac");
        }
        public void cancelGeneralSleeper(int Cancelled){
            GeneralSleeperBerth.add(Cancelled);
            cancel("General");
        }
        public void cancelGeneralMiddle(int Cancelled){
            GeneralMiddleBerth.add(Cancelled);
            cancel("General");
        }
        public void cancelGeneralUpper(int Cancelled){
            GeneralUpperberth.add(Cancelled);
            cancel("General");
        }
    }

