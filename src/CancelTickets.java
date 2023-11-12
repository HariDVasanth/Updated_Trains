import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CancelTickets {
    private final User user;
    private final Trains trains;
    private String seatType;
    private String departure;
    private String destination;
    public CancelTickets(User user, Trains trains){
        this.user = user;
        this.trains=trains;
    }

    public int cancelTicket(String username,int pnr) {
        int canceledSeatNumber = -1;

        Iterator<Map.Entry<String, HashMap<Integer, User>>> iterator = user.getUserDetails().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, HashMap<Integer, User>> entry = iterator.next();
            String user = entry.getKey();
            if (user.equals(username)) {
                HashMap<Integer, User> userDetails = entry.getValue();


                Iterator<Map.Entry<Integer, User>> innerIterator = userDetails.entrySet().iterator();
                while (innerIterator.hasNext()) {
                    Map.Entry<Integer, User> innerEntry = innerIterator.next();
                    User passenger = innerEntry.getValue();

                    try {
                        if (innerEntry.getKey() == pnr) {
                            destination = passenger.getDestination();
                            departure = passenger.getDeparture();
                            seatType = passenger.getSeatType();

                            canceledSeatNumber = passenger.getSeatNumber();


                            innerIterator.remove();

                            if (userDetails.isEmpty()) {
                                iterator.remove();
                            }

                            break;
                        }
                    } catch (NullPointerException exception) {
                        System.out.println("No Train Found. Enter the correct PNR number.");
                    }
                }
            }
        }
        return canceledSeatNumber;
}

    public String getSeatType(){
       return seatType;
    }
    public void CancelAcSleeper(int ticket){
        trains.cancelAcSLeeper(ticket);
    }
    public void CancelAcMiddle(int ticket){
        trains.cancelAcMiddle(ticket);
    }
    public void CancelAcUpper(int ticket){
        trains.cancelAcUpper(ticket);
    }
    public void CancelGeneralSleeper(int ticket){
        trains.cancelGeneralSleeper(ticket);
    }
    public void CancelGeneralMiddle(int ticket){
        trains.cancelGeneralMiddle(ticket);
    }
    public void CancelGeneralUpper(int ticket){
        trains.cancelGeneralUpper(ticket);
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }
}
