

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class BookTicket {
    private final TrainSearch display;
    private final Trains trains;
    private int seatNumber=0;
    Scanner scanner=new Scanner(System.in);

    public BookTicket(TrainSearch display, Trains trains){
        this.display=display;
        this.trains=trains;
    }


    public String bookTickets(int TrainNumber,String SeatType,String Departure,String Destination,int Seats) {
        for (Map.Entry<Integer, Trains> entry : trains.getTrain().entrySet()) {
            int key = entry.getKey();
            Trains values = entry.getValue();

            if ((key == TrainNumber) && (SeatType.equals("Ac") || SeatType.equals("General"))) {
                double fare = 0;
                String berthType = null;

                if (SeatType.equals("Ac")) {
                    if (values.getAcSleeperBerth().size() > Seats) {
                        berthType = "AcSleeperBerth";
                        fare = display.CalculateFare(Departure, Destination, values.getTrainType(), "Ac");
                    } else if (values.getAcMiddleBerth().size() > Seats) {
                        berthType = "AcMiddleBerth";
                        fare = display.CalculateFare(Departure, Destination, values.getTrainType(),"Ac");
                    }
                    else if(values.getAcUpperBerth().size()>Seats){
                        berthType = "AcUpperBerth";
                        fare = display.CalculateFare(Departure, Destination, values.getTrainType(), "Ac");

                    }
                } else {
                    if (values.getGeneralSleeperBerth().size() > Seats) {
                        berthType = "GeneralSleeperBerth";
                        fare = display.CalculateFare(Departure, Destination, values.getTrainType(), "General");
                    } else if (values.getGeneralMiddleBerth().size() > Seats) {
                        berthType = "GeneralMiddleBerth";
                        fare = display.CalculateFare(Departure, Destination, values.getTrainType(), "General");
                    } else if (values.getGeneralUpperBerth().size() > Seats) {
                        berthType = "GeneralUpperBerth";
                        fare =display.CalculateFare(Departure, Destination, values.getTrainType(), "General");
                    }
                }

                if (fare > 0) {
                    try {
                        double FareToPay = fare * Seats;
                        System.out.println("Amount to pay: " + FareToPay);
                        System.out.print("Enter Amount: ");
                        double Amount = scanner.nextDouble();
                        if (Amount == FareToPay) {
                            return berthType;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Amount not enough.");
                    }
                }
            }


        }


    return null;
    }
    public int confirmTicket(String berthType){
            switch (berthType) {
                case "AcSleeperBerth":
                    seatNumber = AcSleeper();
                    break;
                case "AcMiddleBerth":
                    seatNumber = AcMiddle();
                    break;
                case "AcUpperBerth":
                    seatNumber = AcUpper();
                    break;
                case "GeneralSleeperBerth":
                    seatNumber = GeneralSleeper();
                    break;
                case "GeneralMiddleBerth":
                    seatNumber = GeneralMiddle();
                    break;
                case "GeneralUpperBerth":
                    seatNumber = GeneralUpper();
                    break;
                default:
                    System.out.println("Invalid Berth Type.");


            }

        return seatNumber;
    }

    public int AcSleeper() {
        return trains.bookAcSleeper();
    }

    public int AcMiddle() {
        return trains.bookAcMiddle();
    }

    public int AcUpper() {
        return trains.bookAcUpper();
    }
    public int GeneralSleeper(){
        return trains.bookGeneralSleeper();
    }
    public int GeneralMiddle(){
        return trains.bookGeneralMiddle();
    }
    public int GeneralUpper(){
        return trains.bookGeneralUpper();
    }

}
