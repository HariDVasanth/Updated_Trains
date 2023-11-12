import java.util.HashMap;
import java.util.Map;


public class WaitingList {

    private BookTicket bookTicket;
    private String username;
    private User user;

    private String departure;
    private String destination;

    private String seatType;
    private int trainNumber;
    private int seatNumber;

    private HashMap<Integer,User>waitingPassengers=new HashMap<>();


    public WaitingList(User user,BookTicket bookTicket){
        this.user=user;
        this.bookTicket=bookTicket;
    }
    public void setPassenger(int pnr,User values){
        waitingPassengers.put(pnr,values);
    }

    public void checkWaitingList(int pnr,String departure1,String destination1){
        for(Map.Entry<String,User>entry:user.getWaitinglist().entrySet()){

            User values= entry.getValue();
            departure= values.getDeparture();
            destination= values.getDestination();
            if(departure1.equals(departure)&&destination1.equals(destination)){
                trainNumber= values.getTrainNumber();
                seatType= values.getSeatType();
                username=user.getUsername();
                if(user.checkUserAlready(username)){
                    System.out.println("tickets have already been booked using this username");
                }
                String berthType=bookTicket.bookTickets(trainNumber,seatType,departure1,destination1,1);
                seatNumber=bookTicket.confirmTicket(berthType);
                if(berthType!=null){
                    user.setSeatNumber(seatNumber);
                    user.setSeatType(berthType);
                    user.setDestination(destination);
                    user.setDeparture(departure);
                    user.setTrainName(values.getTrainName());
                    user.setAge(values.getAge());
                    user.setPassengerName(values.getPassengerName());
                    username=values.getUsername();
                }
                setPassenger(pnr,user);
            }
            user.getWaitinglist().remove(entry);
            user.setUserDetails(username,waitingPassengers);
        }
    }


}