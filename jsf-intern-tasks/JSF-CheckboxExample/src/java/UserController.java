
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserCtrl")
@SessionScoped
public class UserController {
    
    private boolean married;

    public void show() {
        System.out.println("Married: " + married);
    }
    
    public boolean isMarried() {
        return married;
    }
    
    public void setMarried(boolean married) {
        this.married = married;
    }
    
}
