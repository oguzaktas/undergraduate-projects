
package main;

/**
 * Programlama Laboratuvari II Proje 4
 * @author Oguz Aktas
 */
public class Araba {
    
    private int id;
    private String marka;
    private String model;
    private int vitesturuid;
    private int yakitturuid;
    private int renkid;
    
    public Araba(int id, String marka, String model, int vitesturuid, int yakitturuid, int renkid) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.vitesturuid = vitesturuid;
        this.yakitturuid = yakitturuid;
        this.renkid = renkid;
    }

    public int getId() {
        return id;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getVitesturuid() {
        return vitesturuid;
    }

    public int getYakitturuid() {
        return yakitturuid;
    }

    public int getRenkid() {
        return renkid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVitesturuid(int vitesturuid) {
        this.vitesturuid = vitesturuid;
    }

    public void setYakitturuid(int yakitturuid) {
        this.yakitturuid = yakitturuid;
    }

    public void setRenkid(int renkid) {
        this.renkid = renkid;
    }
    
}
