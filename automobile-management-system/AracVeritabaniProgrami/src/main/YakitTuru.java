
package main;

/**
 * Programlama Laboratuvari II Proje 4
 * @author Oguz Aktas
 */
public class YakitTuru {
    
    private int id;
    private String yakitturu;

    public YakitTuru(int id, String yakitturu) {
        this.id = id;
        this.yakitturu = yakitturu;
    }

    public int getId() {
        return id;
    }

    public String getYakitturu() {
        return yakitturu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYakitturu(String yakitturu) {
        this.yakitturu = yakitturu;
    }
    
}
