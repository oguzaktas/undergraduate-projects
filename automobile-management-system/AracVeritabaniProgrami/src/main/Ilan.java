
package main;

/**
 * Programlama Laboratuvari II Proje 4
 * @author Oguz Aktas
 */
public class Ilan {

    private int id;
    private String ilanadi;
    private float fiyat;
    private float km;
    private String tarih;
    private int arabaid;
    private int sehirid;
    
    public Ilan(int id, String ilanadi, float fiyat, float km, String tarih, int arabaid, int sehirid) {
        this.id = id;
        this.ilanadi = ilanadi;
        this.fiyat = fiyat;
        this.km = km;
        this.tarih = tarih;
        this.arabaid = arabaid;
        this.sehirid = sehirid;
    }

    public int getId() {
        return id;
    }

    public String getIlanadi() {
        return ilanadi;
    }

    public float getFiyat() {
        return fiyat;
    }

    public float getKm() {
        return km;
    }

    public String getTarih() {
        return tarih;
    }

    public int getArabaid() {
        return arabaid;
    }

    public int getSehirid() {
        return sehirid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIlanadi(String ilanadi) {
        this.ilanadi = ilanadi;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public void setArabaid(int arabaid) {
        this.arabaid = arabaid;
    }

    public void setSehirid(int sehirid) {
        this.sehirid = sehirid;
    }
    
}
