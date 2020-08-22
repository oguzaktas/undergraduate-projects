
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserCtrl")
@SessionScoped
public class UserController {
    
    private String pageNumber;

    public String forwardPage() {
        if("2".equals(pageNumber)) {
            return "second.xhtml";
        } else {
            return "third.xhtml";
        }
    }
    
    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

}
