
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserCtrl")
@SessionScoped
public class UserController {
    
    private List<String> values;
    
    @PostConstruct
    public void init() {
        values = new ArrayList<String>();
    }
    
    public void show() {
        System.out.println(values);
    }
    
    public List<String> getValues() {
        return values;
    }
    
    public void setValues(List<String> values) {
        this.values = values;
    }
    
}
