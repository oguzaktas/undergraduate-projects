
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserCtrl")
@SessionScoped
public class UserController {
    private String pass;

    public void sendPassword() {
        System.out.println("Your password is" + pass);
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
