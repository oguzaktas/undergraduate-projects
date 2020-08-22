
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Programlama Laboratuvari II Proje 1
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Zeplin {
    
    public final int maxyolcu = 50;
    public final int minyolcu = 5;
    public final int yukseklik = 50;
    
    private static Zeplin yeni = new Zeplin();
    
    public static Zeplin getYeni() {
        return yeni;
    }
    
    public Zeplin() {
        
    }

    public int getMaxyolcu() {
        return maxyolcu;
    }

    public int getMinyolcu() {
        return minyolcu;
    }

    public int getYukseklik() {
        return yukseklik;
    }

    public ArrayList<Node> dugumleriOlustur() { // dugumleri tum ozellikleriyle tanimlama fonksiyonu
        ArrayList<Node> dugumler = new ArrayList<Node>();
        int counter;
        String line;
        String[] temp;
        try (BufferedReader lat_long = new BufferedReader(new FileReader("lat_long.txt"))) {
            counter = 0;
            while ((line = lat_long.readLine()) != null) {
                Node city = new Node();
                temp = line.split(",");
                city.latitude = Double.parseDouble(temp[0]);
                city.longitude = Double.parseDouble(temp[1]);
                city.plaka = Integer.parseInt(temp[2]);
                city.rakim = Integer.parseInt(temp[3]);
                dugumler.add(city);
                counter++;
                if (counter == 81) {
                    break;
                }
            }
            lat_long.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (BufferedReader komsuluklar = new BufferedReader(new FileReader("komsuluklar.txt"))) {
            counter = 0;
            while ((line = komsuluklar.readLine()) != null) {
                temp = line.split(",");
                int[] komsular = new int[temp.length-1];
                for (int j = 1; j < temp.length; j++) {
                    komsular[j-1] = Integer.parseInt(temp[j]);
                }
                dugumler.get(counter).setKomsuluklar(komsular);
                counter++;
            }
            komsuluklar.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try (BufferedReader koordinatlar = new BufferedReader(new FileReader("koordinatlar.txt"))) {
            counter = 0;
            while ((line = koordinatlar.readLine()) != null) {
                temp = line.split(",");
                dugumler.get(counter).koordinatx = Integer.parseInt(temp[1]);
                dugumler.get(counter).koordinaty = Integer.parseInt(temp[2]);
                counter++;
            }
            koordinatlar.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return dugumler;
    }
    
    public double distanceBetweenTwoCities(Node city1, Node city2) {
        /** Formulu uygulamak icin http://jan.ucc.nau.edu/~cvm/latlon_formula.html ve
        * https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi
        * kaynaklarindan faydalandik.
        */
        final int radius = 6371;
        double latDistance = Math.toRadians(city2.getLatitude() - city1.getLatitude());
        double lonDistance = Math.toRadians(city2.getLongitude() - city1.getLongitude());
        double d1 = Math.sin(latDistance/2) * Math.sin(latDistance/2) + Math.cos(Math.toRadians(city1.getLatitude())) * Math.cos(Math.toRadians(city2.getLatitude())) * Math.sin(lonDistance/2) * Math.sin(lonDistance/2);
        double d2 = 2 * Math.atan2(Math.sqrt(d1), Math.sqrt(1-d1));
        double distance = radius * d2;
        
        return distance;
    }
    
    public boolean gidebilirmi(Node konum, Node hedef, int yolcusayisi) {
        double distance = distanceBetweenTwoCities(konum, hedef); // iki sehir arasi uzaklik
        int yukseklikfarki = Math.abs(hedef.getRakim() - konum.getRakim()); // iki sehir arasi yukseklik farki
        //int yukseklikfarki = Math.abs(hedef.getRakim() - konum.getRakim()); // eger 50 m zeplin yuksekligi sorun olusturursa kullanilacak.
        double angle = Math.toDegrees(Math.atan(yukseklikfarki / distance)); // arctan fonksiyonu ile egim hesabi
        
        return (80 - yolcusayisi) > Math.floor(angle); // 50 yolcu varsa egim <= 80-50'den egim 30'dan buyukse false dondurur.
    }
    
    public boolean gidebilirmi2(Node konum, Node hedef, int yolcusayisi) { // zeplinin baslangicinda yani ilk dugum icin kullanilacak.
        double distance = distanceBetweenTwoCities(konum, hedef);
        int yukseklikfarki = Math.abs((hedef.getRakim() + this.yukseklik) - konum.getRakim()); // +50 m zeplin yuksekligi
        double angle = Math.toDegrees(Math.atan(yukseklikfarki / distance));
        
        return (80 - yolcusayisi) > Math.floor(angle);
    }
    
    public boolean gidebilirmi3(Node konum, Node hedef, int yolcusayisi) { // zeplinin inisinde yani son dugum icin kullanilacak.
        double distance = distanceBetweenTwoCities(konum, hedef);
        int yukseklikfarki = Math.abs((hedef.getRakim() - this.yukseklik) - konum.getRakim()); // -50 m zeplin yuksekligi
        double angle = Math.toDegrees(Math.atan(yukseklikfarki / distance));
        
        return (80 - yolcusayisi) > Math.floor(angle);
    }
    
    public void problem1DosyayaYaz(ArrayList<Node> dugumler, int yolcusayisi) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("problem1-output-yolcusayisi-" + yolcusayisi + ".txt");
        int counter = 0;
        while (counter < 81) {
            Node current = dugumler.get(counter);
            writer.println(current.getPlaka() + " plakali sehrin latitude, longitude, altitude ve komsuluk degerleri: ");
            String komsuluklar = "";
            for (int i=0; i<current.getKomsuluklar().length; i++) {
                if (current.getKomsulukdegerleri().get(current.getKomsuluklar()[i]) == null) {
                    komsuluklar = komsuluklar + "null,";
                } else if (i == current.getKomsuluklar().length-1) {
                    komsuluklar = komsuluklar + current.getKomsulukdegerleri().get(current.getKomsuluklar()[i]);
                } else {
                    komsuluklar = komsuluklar + current.getKomsulukdegerleri().get(current.getKomsuluklar()[i]) + ", ";
                }
            }
            komsuluklar = komsuluklar.substring(0, komsuluklar.length()-1);
            writer.println("" + current.getLatitude() + ", " + current.getLongitude() + ", " + current.getRakim() + ", " + komsuluklar);
            if (counter != 80) {
                writer.println();
            }
            counter++;
        }
        writer.close();
    }
    
    public void problem2DosyayaYaz(ArrayList<Node> dugumler, int yolcusayisi) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("problem2-output-yolcusayisi-" + yolcusayisi + ".txt");
        int counter = 0;
        while (counter < 81) {
            Node current = dugumler.get(counter);
            writer.println(current.getPlaka() + " plakali sehrin latitude, longitude, altitude ve komsuluk degerleri: ");
            String komsuluklar = "";
            for (int i=0; i<current.getKomsuluklar().length; i++) {
                if (current.getKomsulukdegerleri().get(current.getKomsuluklar()[i]) == null) {
                    komsuluklar = komsuluklar + "null,";
                } else if (i == current.getKomsuluklar().length-1) {
                    komsuluklar = komsuluklar + current.getKomsulukdegerleri().get(current.getKomsuluklar()[i]);
                } else {
                    komsuluklar = komsuluklar + current.getKomsulukdegerleri().get(current.getKomsuluklar()[i]) + ", ";
                }
            }
            komsuluklar = komsuluklar.substring(0, komsuluklar.length()-1);
            writer.println("" + current.getLatitude() + ", " + current.getLongitude() + ", " + current.getRakim() + ", " + komsuluklar);
            writer.println();
            counter++;
        }
        writer.close();
    }
    
    /**
    public void problem1DosyayaYaz(ArrayList<Node> dugumler, int yolcusayisi) {
        try (BufferedWriter problem1 = new BufferedWriter(new FileWriter("problem1-yolcusayisi-" + yolcusayisi + ".txt"))) {
        int counter = 0;
        while (counter < 81) {
            problem1.write(dugumler.get(counter).getPlaka() + " plakali sehrin latitude, longitude, plaka no, altitude ve komsuluklari: ");
            problem1.newLine();
            problem1.write(dugumler.get(counter).getLatitude() + " - " + sehir.get(counter).getLongitude() + " - " + sehir.get(counter).getPlaka() + " - " + sehir.get(counter).getRakim() + " - komsuluklar: ");
            for (int i=0; i<sehir.get(counter).komsuluklar.size(); i++) {
                problem1.write(sehir.get(counter).komsuluklar.get(i).getPlaka() + " ");
            }
            problem1.newLine();
            counter++;
        }
            problem1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
    }
    */
    
}
