
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "UserCtrl")
@SessionScoped
public class UserController {
    
    private String firstname;
    private String lastname;
    private String country;
    private List<String> items;
    
    @PostConstruct
    public void init() {
        items = new ArrayList<String>();
        items.add("Brazil");
        items.add("France");
        items.add("Germany");
        items.add("India");
        items.add("Turkey");
        items.add("United Kingdom");
        items.add("United States");
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
