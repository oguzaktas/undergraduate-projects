
package main;

/**
 * Programlama Laboratuvari II Proje 4
 * @author Oguz Aktas
 */
public class Renk {
    
    private int id;
    private String renk;
    
    public Renk(int id, String renk) {
        this.id = id;
        this.renk = renk;
    }

    public int getId() {
        return id;
    }

    public String getRenk() {
        return renk;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }
    
}
