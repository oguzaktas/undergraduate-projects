
package aracyonetimsistemi;

/**
 * Programlama Laboratuvari II Proje 2
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Otomobil extends MotorluTasitlar {
    
    private static int id = 0;
    private String serino;

    public Otomobil() { // default constructor
        id++;
    }

    public Otomobil(String serino, String marka, int hiz, int yolcusayisi, int tekerleksayisi, int fiyat, int uretimyili, String renk, String yakitturu) { // tum ozelliklerin bulundugu constructor
        this.serino = serino;
        this.marka = marka;
        this.hiz = hiz;
        this.yolcusayisi = yolcusayisi;
        this.tekerleksayisi = tekerleksayisi;
        this.fiyat = fiyat;
        this.uretimyili = uretimyili;
        this.renk = renk;
        this.yakitturu = yakitturu;
        id++;
    }
    
    public Otomobil(String serino, int hiz, int yolcusayisi, String renk) { // nesne olusturulurken kullanilacak ozel constructor
        this.serino = serino;
        this.hiz = hiz;
        this.yolcusayisi = yolcusayisi;
        this.renk = renk;
        tekerleksayisi = 4;
        fiyat = 135000;
        marka = "Mercedes";
        uretimyili = 2016;
        id++;
    }

    @Override
    public void hizlan(int hiz) {
        this.hiz += hiz;
    }

    @Override
    public void yavasla(int hiz) {
        this.hiz -= hiz;
    }

    @Override
    public void dur() {
        hiz = 0;
    }
    
    public static int getId() {
        return id;
    }

    @Override
    public String getSerino() {
        return serino;
    }

    @Override
    public String getMarka() {
        return marka;
    }

    @Override
    public int getHiz() {
        return hiz;
    }

    @Override
    public int getYolcusayisi() {
        return yolcusayisi;
    }

    public int getTekerleksayisi() {
        return tekerleksayisi;
    }

    @Override
    public int getFiyat() {
        return fiyat;
    }

    @Override
    public int getUretimyili() {
        return uretimyili;
    }

    @Override
    public String getRenk() {
        return renk;
    }
    
    public String getYakitturu() {
        return yakitturu;
    }
    
    @Override
    public void setSerino(String serino) {
        this.serino = serino;
    }

    @Override
    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    @Override
    public void setYolcusayisi(int yolcusayisi) {
        this.yolcusayisi = yolcusayisi;
    }

    public void setTekerleksayisi(int tekerleksayisi) {
        this.tekerleksayisi = tekerleksayisi;
    }

    @Override
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public void setUretimyili(int uretimyili) {
        this.uretimyili = uretimyili;
    }

    @Override
    public void setRenk(String renk) {
        this.renk = renk;
    }
    
    public void setYakitturu(String yakitturu) {
        this.yakitturu = yakitturu;
    }
    
}
