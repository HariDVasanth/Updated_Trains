import java.util.HashMap;
import java.util.Map;

public class User  {
    private Login login;
    public User(Login login){
        this.login=login;
    }

    private int age;

    private String gender;
    private String passengerName;
    private String seatType;
    private String destination;
    private String departure;
    private String trainName;
    private int seatNumber;
    private String username;
    private int trainNumber;

    private HashMap<String,HashMap<Integer,User>>details=new HashMap<>();

    private HashMap<String,User>waitinglist=new HashMap<>();
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  HashMap <String,HashMap<Integer, User>> getUserDetails() {
        return details;
    }

    public void setUserDetails(String username,HashMap<Integer,User>passengerDetails) {
        details.put(username,passengerDetails);

    }

    public boolean checkUserAlready(String username){
        return details.containsKey(username);
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public HashMap<String, HashMap<Integer, User>> getDetails() {

        return details;
    }
    public void setWaitinglist(String username,User waitingList){
        waitinglist.put(username,waitingList);
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public HashMap<String, User> getWaitinglist() {
        return waitinglist;
    }

    public void adminLogin(String username, String password) {
        if (login.LoginAccount(1, username, password)) {
            if (!details.isEmpty()) {
                for (Map.Entry<String,HashMap<Integer,User>> entry : details.entrySet()) {
                    String user = entry.getKey();
                    HashMap<Integer,User>passengers=entry.getValue();
                    System.out.println("Username" + user);
                    for(Map.Entry<Integer,User>entry1: passengers.entrySet()) {
                        int pnr= entry1.getKey();
                        User details= entry1.getValue();
                        System.out.println("Pnr: "+pnr);
                        System.out.println(details);
                    }
                }
            } else {
                System.out.println("No passenger details available.");
            }
        } else {
            System.out.println("Invalid login credentials for admin.");
        }
    }

    public void userLogin(String username){
        for(Map.Entry<String,HashMap<Integer,User>>entry: details.entrySet()){
            String userName=entry.getKey();
            HashMap<Integer,User>details=entry.getValue();
            if(username.equals(userName)){
                for(Map.Entry<Integer,User>entry1:details.entrySet()){
                    int pnr=entry1.getKey();
                    User user=entry1.getValue();
                    System.out.println("PNR: "+pnr);
                    System.out.println(user);
                }
            }
        }
    }




    public String toString(){
        return
                "Train Name: "+getTrainName()+"\n"+
                "Passenger Name: "+getPassengerName()+"\n"+
                "Age: "+getAge()+"\n"+
                "Gender: "+getGender()+"\n"+
                "Seat type: "+getSeatType()+"\n"+
                "Seat Number: "+getSeatNumber();
    }
}