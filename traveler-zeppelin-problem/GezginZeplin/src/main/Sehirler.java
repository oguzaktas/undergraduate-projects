
package main;

/**
 * Programlama Laboratuvari II Proje 1
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Sehirler {

    public double latitude;
    public double longitude;
    public int plaka;
    public int rakim;
    public int[] komsuluklar;
    //ArrayList<Integer> komsuluklar = new ArrayList<Integer>(); // komsuluklar Integer ArrayList seklinde olusturulursa
    //ArrayList<Node> komsuluklar = new ArrayList<Node>(); // komsuluklar Node ArrayList seklinde olusturulursa
    public int koordinatx;
    public int koordinaty;
    
    public Sehirler() { // Default constructor Node classi icin lazim
        
    }

    public Sehirler(double latitude, double longitude, int plaka, int rakim, int[] komsuluklar, int koordinatx, int koordinaty) { // dosya okumada lazim olabilir
        this.latitude = latitude;
        this.longitude = longitude;
        this.plaka = plaka;
        this.rakim = rakim;
        this.komsuluklar = komsuluklar;
        this.koordinatx = koordinatx;
        this.koordinaty = koordinaty;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getPlaka() {
        return plaka;
    }

    public int getRakim() {
        return rakim;
    }
    
    public int[] getKomsuluklar() {
        return komsuluklar;
    }
    
    public int getKoordinatx() {
        return koordinatx;
    }
    
    public int getKoordinaty() {
        return koordinaty;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public void setPlaka(int plaka) {
        this.plaka = plaka;
    }
    
    public void setRakim(int rakim) {
        this.rakim = rakim;
    }
    
    public void setKomsuluklar(int[] komsuluklar) {
        this.komsuluklar = komsuluklar;
    }
    
    public void setKoordinatx(int koordinatx) {
        this.koordinatx = koordinatx;
    }
    
    public void setKoordinaty(int koordinaty) {
        this.koordinaty = koordinaty;
    }

}
