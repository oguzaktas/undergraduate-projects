
package main;

/**
 * Programlama Laboratuvari II Proje 4
 * @author Oguz Aktas
 */
public class SQL {
    
    private int id;
    private String ilanadi;
    private float fiyat;
    private float km;
    private String tarih;
    private String marka;
    private String model;
    private String yakitturu;
    private String vitesturu;
    private String renk;
    private String sehir;

    public SQL(int id, String ilanadi, float fiyat, float km, String tarih, String marka, String model, String yakitturu, String vitesturu, String renk, String sehir) {
        this.id = id;
        this.ilanadi = ilanadi;
        this.fiyat = fiyat;
        this.km = km;
        this.tarih = tarih;
        this.marka = marka;
        this.model = model;
        this.yakitturu = yakitturu;
        this.vitesturu = vitesturu;
        this.renk = renk;
        this.sehir = sehir;
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

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getYakitturu() {
        return yakitturu;
    }

    public String getVitesturu() {
        return vitesturu;
    }

    public String getRenk() {
        return renk;
    }

    public String getSehir() {
        return sehir;
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

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYakitturu(String yakitturu) {
        this.yakitturu = yakitturu;
    }

    public void setVitesturu(String vitesturu) {
        this.vitesturu = vitesturu;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    
}
