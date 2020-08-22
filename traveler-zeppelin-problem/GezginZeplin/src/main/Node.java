
package main;

/**
 * Programlama Laboratuvari II Proje 1
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Node extends Sehirler {
    
    public HashMap<Integer, Double> komsulukdegerleri = new HashMap<Integer, Double>(); // sirasiz bir sekilde komsuluklar ve uzakliklarini tutan key-value ozelligi

    public HashMap<Integer, Double> getKomsulukdegerleri() {
        return komsulukdegerleri;
    }

    public void setKomsulukdegerleri(ArrayList<Node> dugumler, int yolcusayisi) {
        for (int i=0; i<komsuluklar.length; i++) {
            if (Zeplin.getYeni().gidebilirmi(this, dugumler.get(komsuluklar[i]-1), yolcusayisi)) {
                komsulukdegerleri.put(komsuluklar[i], Zeplin.getYeni().distanceBetweenTwoCities(this, dugumler.get(komsuluklar[i]-1)));
            } else {
                komsulukdegerleri.put(komsuluklar[i], null); // Egim sorunundan dolayi zeplinin gidemedigi komsuluk degerlerine null atandi.
            }
        }
    }
    
    public void setKomsulukdegerleri2(ArrayList<Node> dugumler, int yolcusayisi) { // zeplinin kalkisi icin komsuluk degerlerini set eden metot
        for (int i=0; i<komsuluklar.length; i++) {
            if (Zeplin.getYeni().gidebilirmi2(this, dugumler.get(komsuluklar[i]-1), yolcusayisi)) { // gidebilirmi3() metotu sadece ilk dugum yani zeplinin kalkisinda kullanilacak.
                komsulukdegerleri.put(komsuluklar[i], Zeplin.getYeni().distanceBetweenTwoCities(this, dugumler.get(komsuluklar[i]-1)));
            } else {
                komsulukdegerleri.put(komsuluklar[i], null); // Egim sorunundan dolayi zeplinin gidemedigi komsuluk degerlerine null atandi.
            }
        }
    }
    
    public void setKomsulukdegerleri3(ArrayList<Node> dugumler, int yolcusayisi) { // zeplinin inisi icin komsuluk degerlerini set eden metot
        for (int i=0; i<komsuluklar.length; i++) {
            if (Zeplin.getYeni().gidebilirmi3(this, dugumler.get(komsuluklar[i]-1), yolcusayisi)) { // gidebilirmi3() metotu sadece son dugum yani zeplinin inisinde kullanilacak.
                komsulukdegerleri.put(komsuluklar[i], Zeplin.getYeni().distanceBetweenTwoCities(this, dugumler.get(komsuluklar[i]-1)));
            } else {
                komsulukdegerleri.put(komsuluklar[i], null); // Egim sorunundan dolayi zeplinin gidemedigi komsuluk degerlerine null atandi.
            }
        }
    }
    
    public void komsulukdegeriniGuncelle(int index, double value) {
        this.komsulukdegerleri.put(index, value);
    }

}
