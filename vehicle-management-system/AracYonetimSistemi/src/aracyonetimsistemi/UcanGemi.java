
package aracyonetimsistemi;

/**
 * Programlama Laboratuvari II Proje 2
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class UcanGemi extends DenizTasitlari implements HavaTasitlari { // Multiple inheritance bu sekilde saglandi.
    
    private static int id = 0;
    private String serino;
    private boolean indimi = false;

    public UcanGemi() { // default constructor
        id++;
    }

    public UcanGemi(String serino, boolean indimi, String marka, int hiz, int yolcusayisi, int fiyat, int uretimyili, String renk) { // tum ozelliklerin bulundugu constructor
        this.serino = serino;
        this.indimi = indimi;
        this.marka = marka;
        this.hiz = hiz;
        this.yolcusayisi = yolcusayisi;
        this.fiyat = fiyat;
        this.uretimyili = uretimyili;
        this.renk = renk;
        id++;
    }
    
    public UcanGemi(String serino, int hiz, int yolcusayisi, String renk) { // nesne olusturulurken kullanilacak ozel constructor
        this.serino = serino;
        this.hiz = hiz;
        this.yolcusayisi = yolcusayisi;
        this.renk = renk;
        fiyat = 156000000;
        marka = "USS Enterprise";
        uretimyili = 2125;
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
    public void dur() { // dur() metodu Otomobil, Bisiklet ve Gemi siniflarindan farkli olarak inis yapip yapilmadigina gore calisir.
        if (this.indimi == true) {
            hiz = 0;
        } else {
            System.out.println("Ucan gemi inis yapmadan duramiyor.");
        }
    }
    
    public static int getId() {
        return id;
    }

    @Override
    public String getSerino() {
        return serino;
    }

    public boolean isIndimi() {
        return indimi;
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
    
    @Override
    public void setSerino(String serino) {
        this.serino = serino;
    }

    public void setIndimi(boolean indimi) {
        this.indimi = indimi;
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

}
