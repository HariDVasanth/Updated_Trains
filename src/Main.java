import java.util.ArrayList;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Trains trains = new Trains();
        TrainSearch display = new TrainSearch(trains);
        BookTicket bookTicket=new BookTicket(display,trains);
        Login login = new Login();
        User user=new User(login);
        CancelTickets cancelTickets=new CancelTickets(user,trains);
        WaitingList waitingList=new WaitingList(user,bookTicket);

        Scanner scanner = new Scanner(System.in);
        int PNR=1000;
        while (true) {
            System.out.println("***** Welcome to Online Train Reservation *****");
            System.out.println("1.Admin Login");
            System.out.println("2.User Login");
            System.out.println("3.Exit");
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:

                        System.out.print("Enter your username: ");
                        String username = scanner.next();
                        System.out.print("Enter your password: ");
                        String password = scanner.next();
                        System.out.println("What do you want to do? ");
                        System.out.println("1.Details");
                        System.out.println("2.Add Trains");
                        int option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                System.out.println("1.Passengers tickets booked list");
                                System.out.println("2.Passengers waiting list ");
                                System.out.println("3.View all trains seats status");
                                int choice1 = scanner.nextInt();
                                if (choice1 == 1) {
                                    user.adminLogin(username, password);
                                }
                                if(choice1==2){
                                   System.out.println(user.getWaitinglist());
                                }
                                if(choice1==3){
                                    trains.viewTrains();
                                }
                                break;

                            case 2:
                                System.out.println("***** Trains Addition  *****");
                                if (login.LoginAccount(choice, username, password)) {
                                    System.out.println("Enter number of trains to add: ");
                                    int trainNumbers = scanner.nextInt();

                                    for (int i = 0; i < trainNumbers; i++) {

                                        System.out.print("Enter Train Name: ");
                                        String TrainName = scanner.next();
                                        trains.setTrainName(TrainName);

                                        System.out.print("Enter train number: ");
                                        int TrainNumber = scanner.nextInt();


                                        System.out.print("Enter Train Type: ");
                                        String TrainType = scanner.next();
                                        trains.setTrainType(TrainType);


                                        System.out.println("How many Stops you want to add?");
                                        int stops = scanner.nextInt();
                                        for (int j = 0; j < stops; j++) {

                                            System.out.print("Enter your Stop Name: ");
                                            String Stop = scanner.next();
                                            trains.setStops(Stop);
                                            System.out.print("Enter distance from previous stops: ");
                                            int distance = scanner.nextInt();
                                            trains.setDistance(distance);

                                        }

                                        trains.setAcSleeperSeats();
                                        trains.setAcMiddleBerth();
                                        trains.setAcUpperBerth();
                                        trains.setGeneralSleeperBerth();
                                        trains.setGeneralMiddleBerth();
                                        trains.setGeneralUpperberth();
                                        trains.setAcSeatsAvailable();
                                        trains.setGeneralSeatsAvailable();

                                        System.out.print("Enter Travel Date ");
                                        System.out.print("Enter Dates: ");
                                        int date = scanner.nextInt();
                                        trains.setDateDeparture(date);

                                        System.out.print("Enter Month: ");
                                        int month = scanner.nextInt();
                                        trains.setDateDeparture(month);

                                        System.out.print("Enter Year: ");
                                        int Year = scanner.nextInt();
                                        trains.setDateDeparture(Year);


                                        System.out.print("Enter Date Arrival: ");
                                        int arrivalDate = scanner.nextInt();
                                        trains.setDateArrival(arrivalDate);
                                        System.out.print("Enter Month Arrival: ");
                                        int arrivalMonth = scanner.nextInt();
                                        trains.setDateArrival(arrivalMonth);
                                        System.out.println("Enter Year Arrival: ");
                                        int yearArrival = scanner.nextInt();
                                        trains.setDateArrival(yearArrival);


                                        trains.setTrain(TrainNumber, trains);
                                        System.out.println(trains.getTrain());
                                        System.out.println("Trains added Successfully");
                                    }
                                }
                        }
                        break;
                    case 2:
                        System.out.println("1.Book Ticket");
                        System.out.println("2.Cancel Ticket");
                        System.out.println("3.View Booked Ticket");
                        int userChoice = scanner.nextInt();
                        switch (userChoice) {
                            case 1:
                                ArrayList<Integer> userDates = new ArrayList<>();
                                System.out.print("From: ");
                                String departure = scanner.next();
                                System.out.print("To: ");
                                String destination = scanner.next();

                                System.out.println("Select Date(DD/MM/YYYY)");
                                System.out.print("Enter Date");
                                int Date = scanner.nextInt();
                                System.out.print("Enter Month");
                                int Month = scanner.nextInt();
                                System.out.print("Enter Year");
                                int Year = scanner.nextInt();
                                userDates.add(Date);
                                userDates.add(Month);
                                userDates.add(Year);


                                if (display.SearchDisplay(departure, destination, userDates)) {

                                    System.out.println("Do you want to book Tickets?");
                                    System.out.println("1.Login");
                                    System.out.println("2.Register");
                                    int Choice = scanner.nextInt();
                                    if (Choice == 1) {
                                        System.out.print("Enter Username: ");
                                        String Username = scanner.next();
                                        System.out.print("Enter Password: ");
                                        String Password = scanner.next();


                                        if (login.LoginAccount(choice, Username, Password)) {
                                            if(user.checkUserAlready(Username)){
                                                System.out.println("Ticket already booked using this username.");
                                                break;
                                            }
                                            System.out.print("Enter Train Number: ");
                                            int TrainNumber = scanner.nextInt();

                                            System.out.print("Number of Seats you want to Book: ");
                                            int Seats = scanner.nextInt();

                                            System.out.println("Enter Seat Type(1/2)");
                                            System.out.println("1.Ac");
                                            System.out.println("2.General");
                                            String SeatType = null;

                                            int userOption=scanner.nextInt();
                                            if (userOption==1) {
                                                SeatType="Ac";
                                            } else if (userOption==2) {
                                                SeatType="General";
                                            }


                                            System.out.print("Enter train name: ");
                                            String trainName = scanner.next();

                                            String BerthType = bookTicket.bookTickets(TrainNumber, SeatType, departure, destination, Seats);
                                            HashMap<Integer,User>passengerDetails=new HashMap<>();
                                            if (BerthType != null) {
                                                for (int i = 0; i <Seats; i++) {
                                                    User user1=new User(login);

                                                    System.out.println("Enter Passenger Name");
                                                    String PassengerName = scanner.next();
                                                    user1.setPassengerName(PassengerName);

                                                    System.out.println("Enter Passenger Age: ");
                                                    int Age = scanner.nextInt();
                                                    user1.setAge(Age);

                                                    System.out.println("Enter Passenger Gender");
                                                    String Gender = scanner.next();
                                                    user1.setGender(Gender);
                                                    int seatNumber = bookTicket.confirmTicket(BerthType);

                                                    user1.setSeatNumber(seatNumber);
                                                    user1.setSeatType(BerthType);
                                                    user1.setDestination(destination);
                                                    user1.setDeparture(departure);
                                                    user1.setTrainName(trainName);
                                                    PNR += 1;
                                                    passengerDetails.put(PNR,user1);
                                                    System.out.println(user1.getUserDetails());
                                                }
                                                user.setUserDetails(Username,passengerDetails);
                                            } else {
                                                System.out.println("Do you want to be added in Waiting List?");
                                                System.out.println("1.Yes");
                                                System.out.println("2.No");
                                                int option1 = scanner.nextInt();
                                                if (option1 == 1) {
                                                    User user2=new User(login);
                                                    System.out.println("Enter username");
                                                    String userName=scanner.next();
                                                    user2.setUsername(userName);
                                                    user2.setDeparture(departure);
                                                    user2.setDestination(destination);
                                                    user2.setSeatType(SeatType);
                                                    user2.setTrainNumber(TrainNumber);
                                                    user2.setTrainName(trainName);

                                                    System.out.println("Enter Passenger Name: ");
                                                    String passengerName = scanner.next();
                                                    user2.setPassengerName(passengerName);

                                                    System.out.println("Enter Passenger age: ");
                                                    int passengerAge = scanner.nextInt();
                                                    user2.setAge(passengerAge);

                                                    System.out.print("Enter Passenger Gender: ");
                                                    String passengerGender = scanner.next();
                                                    user2.setGender(passengerGender);
                                                    user.setWaitinglist(Username,user2);


                                                }
                                                System.out.println(user.getUserDetails());
                                            }

                                        }
                                    } else if (Choice == 2) {
                                        System.out.println("Enter UserName");
                                        String UserName = scanner.next();
                                        System.out.println("Set Password");
                                        String PassWord = scanner.next();
                                        login.setUser(UserName, PassWord);
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Ticket Cancellation");
                                System.out.println("Enter username: ");
                                String username1= scanner.next();
                                System.out.print("Enter your Pnr number: ");
                                int userPnr = scanner.nextInt();

                                int cancel = cancelTickets.cancelTicket(username1,userPnr);

                                String berthType = cancelTickets.getSeatType();
                                String destination1 = cancelTickets.getDestination();
                                String departure1 = cancelTickets.getDeparture();
                                try {
                                    switch (berthType) {
                                        case "AcSleeperBerth":
                                            cancelTickets.CancelAcSleeper(cancel);
                                            break;
                                        case "AcMiddleBerth":
                                            cancelTickets.CancelAcMiddle(cancel);
                                            break;
                                        case "AcUpperBerth":
                                            cancelTickets.CancelAcUpper(cancel);
                                            break;
                                        case "GeneralSleeperBerth":
                                            cancelTickets.CancelGeneralSleeper(cancel);
                                            break;
                                        case "GeneralMiddleBerth":
                                            cancelTickets.CancelGeneralMiddle(cancel);
                                            break;
                                        case "GeneralUpperBerth":
                                            cancelTickets.CancelGeneralUpper(cancel);
                                    }
                                }catch (NullPointerException exception){
                                    System.out.println("Please enter correct Pnr number");
                                }

                                waitingList.checkWaitingList(userPnr,departure1,destination1);


                                break;


                            case 3:
                                System.out.println("Enter your username: ");
                                String username2 = scanner.next();
                                user.userLogin(username2);
                                break;

                        }
                        break;

                    case 3:
                        return;

                }
            } catch (InputMismatchException exception){
                System.out.println("Invalid input.Enter integer.");
                break;
            }


        }
    }

}