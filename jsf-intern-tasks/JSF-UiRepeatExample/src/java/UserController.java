
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserCtrl")
@SessionScoped
public class UserController {
    
    private List<Employee> employees = null;
    
    @PostConstruct
    public void init() {
        employees = new ArrayList<Employee>();
        employees.add(new Employee("asdasd", "dsadsa", 21));
        employees.add(new Employee("Musa", "Ozudogru", 22));
        employees.add(new Employee("Murat", "aa", 20));
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }
    
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
}
