
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserCtrl")
@SessionScoped
public class UserController {
    
    private String address;
    
    public void sendAddress() {
        System.out.println("Your address is :" + address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
