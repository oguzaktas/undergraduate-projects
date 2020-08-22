
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author oguz
 */
@ManagedBean(name = "UserController")
@SessionScoped
public class UserController {
    public void clickMe() {
        System.out.println("Clicked me!");
    }
}
