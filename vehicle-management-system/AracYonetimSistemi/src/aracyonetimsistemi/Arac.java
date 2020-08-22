
package aracyonetimsistemi;

/**
 * Programlama Laboratuvari II Proje 2
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public interface Arac {

    void hizlan(int hiz);
    void yavasla(int hiz);
    void dur();
    String getSerino();
    String getMarka();
    int getHiz();
    int getYolcusayisi();
    int getFiyat();
    int getUretimyili();
    String getRenk();
    void setSerino(String serino);
    void setMarka(String marka);
    void setHiz(int hiz);
    void setYolcusayisi(int yolcusayisi);
    void setFiyat(int fiyat);
    void setUretimyili(int uretimyili);
    void setRenk(String renk);
    
}
