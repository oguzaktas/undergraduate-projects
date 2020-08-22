
package main;

/**
 * Programlama Laboratuvari II Proje 4
 * @author Oguz Aktas
 */
public class Sehir {
    
    private int id;
    private String sehir;
    
    public Sehir(int id, String sehir) {
        this.id = id;
        this.sehir = sehir;
    }

    public int getId() {
        return id;
    }

    public String getSehir() {
        return sehir;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    
}
