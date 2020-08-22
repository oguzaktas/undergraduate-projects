
package main;

/**
 * Programlama Laboratuvari II Proje 4
 * @author Oguz Aktas
 */
public class VitesTuru {
    
    private int id;
    private String vitesturu;

    public VitesTuru(int id, String vitesturu) {
        this.id = id;
        this.vitesturu = vitesturu;
    }

    public int getId() {
        return id;
    }

    public String getVitesturu() {
        return vitesturu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVitesturu(String vitesturu) {
        this.vitesturu = vitesturu;
    }
    
}
