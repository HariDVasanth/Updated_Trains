import java.util.HashMap;
import java.util.InputMismatchException;

public class Login {
    private String username;
    private String password;

    private final  HashMap<String,String>Admin=new HashMap<>();
    private  HashMap<String,String>User=new HashMap<>();

    public Login(){
        setAdmin();
    }
    public void setAdmin(){
        Admin.put("admin","admin");
    }

    public Boolean setUser(String username,String password){
        this.username=username;
        if(User.containsKey(username)){
            System.out.println("Choose another username");
            return false;
        }
        this.password=password;
        User.put(username,password);
        System.out.println("Account Created Successfully");
        return true;
    }
    public Boolean LoginAccount(int Function,String username,String password){
        if(Function==1) {
            try{
            return Admin.containsKey(username) && Admin.get(username).equals(password);
        }catch (InputMismatchException exception){
                System.out.println("Username or Password inncorrect.");
            }
        }
        else if(Function==2){
            return User.containsKey(username) && User.get(username).equals(password);
        }
        return false;
    }

}
