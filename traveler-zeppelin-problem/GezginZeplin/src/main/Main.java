
package main;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;

/**
 * Programlama Laboratuvari II Proje 1
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        long startTime = System.nanoTime();
        
        Scanner sc = new Scanner(System.in);
        int baslangic;
        do {
            System.out.print("Baslangic sehrini giriniz [1-81]: ");
            baslangic = sc.nextInt();
        } while (baslangic < 1 || baslangic > 81);
        System.out.println();
        int bitis;
        do {
            System.out.print("Bitis sehrini giriniz [1-81]: ");
            bitis = sc.nextInt();
        } while (bitis < 1 || bitis > 81 || bitis == baslangic);
        System.out.println();
        int problem;
        do {
            System.out.print("Problemi seciniz (1 veya 2): ");
            problem = sc.nextInt();
        } while (problem != 1 && problem != 2);
        System.out.println();
        sc.close();
        if (problem == 1) { // Problem 1'in Dijkstra shortest path algoritmasi ile cozulmesi
            ArrayList<Node> grafdugumler = Zeplin.getYeni().dugumleriOlustur();
            ArrayList<Graph> guzergahlar = new ArrayList<Graph>();
            
            for (int yolcusayisi = 5; yolcusayisi <= 50; yolcusayisi++) {
                for (int i = 0; i < grafdugumler.size(); i++) {
                    if (i == baslangic-1) { // zeplinin kalkisi icin 0'dan 50 m yukselmesi icin yapilan kontrol
                        grafdugumler.get(i).setKomsulukdegerleri2(grafdugumler, yolcusayisi);
                    } else if (i == bitis-1) { // zeplinin inisi icin 50 m'den 0'a varis yerine inmesi icin yapilan kontrol
                        grafdugumler.get(i).setKomsulukdegerleri3(grafdugumler, yolcusayisi);
                    } else {
                        grafdugumler.get(i).setKomsulukdegerleri(grafdugumler, yolcusayisi);
                    }
                }
                Dijkstra yolbul = new Dijkstra(grafdugumler);
                ArrayList<Node> yol = yolbul.yoluBul(baslangic, bitis);
                /** bulunan yollarin eleme islemi yapilmadan yazdirilmasi (bir sehirden diger sehire birden fazla yol var)
                for (int j = 0; j < yolbul.yol.size(); j++) {
                    System.out.println(yolbul.yol.get(j));
                }
                */
                if (yol.size() != 0) { // problem 1 konsola yazma ve dosyaya yazma islemi
                    System.out.println(yolcusayisi + " yolcu icin en iyi cozumu veren yol: ");
                    System.out.print(baslangic + " -> ");
                    for (int j = yol.size()-1; j > 0; j--) {
                        System.out.print(yol.get(j).getPlaka() + " -> ");
                    }
                    System.out.print(bitis);
                    System.out.println();
                    System.out.println();
                    
                    Zeplin.getYeni().problem1DosyayaYaz(grafdugumler, yolcusayisi);
                    double gidilenmesafe = yolbul.gidilenMesafe(bitis);
                    double tutar = (gidilenmesafe / 100) * 1000;
                    double fiyat = 100;
                    double kar = (yolcusayisi * fiyat) - tutar;
                    yol.add(grafdugumler.get(baslangic-1));
                    Graph graph = new Graph(yol, yol.size(), gidilenmesafe, tutar, yolcusayisi, kar);
                    guzergahlar.add(graph);
                } else {
                    System.out.println(yolcusayisi + " yolcu icin en iyi cozumu veren yol: ");
                    System.out.println();
                    System.out.println("Yol bulunamadi.");
                    System.out.println();
                }
            }
            
            Collections.sort(guzergahlar, new Comparator<Graph>() { // guzergahlarin kara gore siralanmasi
                @Override
                public int compare(Graph z1, Graph z2) {
                    if (z1.kar > z2.kar) {
                        return -1;
                    } else if (z1.kar < z2.kar) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            
            if (guzergahlar.size() == 0) {
                System.out.println("Hic yol bulunamadigi icin harita uzerinde gosterilemiyor.");
                System.out.println();
            }
            
            HashMap<Double, Double> kontrol = new HashMap<Double, Double>(); // guzergahlarin duzenlenmesi ve eleme islemi
            ArrayList<Graph> enkisaguzergahlar = new ArrayList<Graph>();
            for (int i=0; i<guzergahlar.size(); i++) {
                Graph current = guzergahlar.get(i);
                if (kontrol.get(current.yol) == null) {
                    kontrol.put(current.yol, current.kar);
                    enkisaguzergahlar.add(current);
                }
            }
            
            int counter = 0;
            for (int i = 0; i < enkisaguzergahlar.size(); i++) { // guzergahlarin en iyi kardan en kotu kara dogru haritada gosterilmesi
                Graph current = enkisaguzergahlar.get(i);
                counter++;
                NumberFormat formatter = new DecimalFormat("#0.00");
                String data = "Toplam gidilen mesafe: " + formatter.format(current.yol) + " km" + ",Tutar: " + formatter.format(current.tutar) + " TL" + ",Yolcu sayisi: " + current.yolcusayisi + ",Elde edilen kar: " + formatter.format(current.kar) + " TL";
                new Path("En iyi cozumu veren yol " + counter + " - yolcu sayisi: " + current.yolcusayisi, current.dugumler, data);
                // bulunan tum farkli yollar harita uzerinde gosterildi.
            }
        
        } else if (problem == 2) { // Problem 2'nin Dijkstra shortest path algoritmasi ile cozulmesi
            ArrayList<Node> grafdugumler = Zeplin.getYeni().dugumleriOlustur();
            ArrayList<Graph> guzergahlar = new ArrayList<Graph>();
            
            for (int yolcusayisi = 10; yolcusayisi <= 50; yolcusayisi+=10) {
                for (int i = 0; i < grafdugumler.size(); i++) {
                    grafdugumler.get(i).setKomsulukdegerleri(grafdugumler, yolcusayisi);
                }
                Dijkstra yolbul = new Dijkstra(grafdugumler);
                ArrayList<Node> yol = yolbul.yoluBul(baslangic, bitis);
                /** Bulunan yollarin eleme islemi yapilmadan yazdirilmasi
                for (int j = 0; j < yolbul.yol.size(); j++) {
                    System.out.println(yolbul.yol.get(j));
                }
                */
                if (yol.size() != 0) { // problem 2 konsola yazma ve dosyaya yazma islemi
                    System.out.println(yolcusayisi + " yolcu icin en iyi cozumu veren yol: ");
                    System.out.print(baslangic + " -> ");
                    for (int j = yol.size()-1; j > 0; j--) {
                        System.out.print(yol.get(j).getPlaka() + " -> ");
                    }
                    System.out.print(bitis);
                    System.out.println();
                    System.out.println();
                    
                    Zeplin.getYeni().problem2DosyayaYaz(grafdugumler, yolcusayisi);
                    double gidilenmesafe = yolbul.gidilenMesafe(bitis);
                    double tutar = (gidilenmesafe / 100) * 1000;
                    double fiyat = ((tutar/2) + tutar) / yolcusayisi; // %50 kar icin bir yolcudan alinmasi gereken fiyat
                    yol.add(grafdugumler.get(baslangic-1));
                    Graph graph = new Graph(yol, yol.size(), gidilenmesafe, tutar, yolcusayisi, tutar, fiyat);
                    guzergahlar.add(graph);
                } else {
                    System.out.println(yolcusayisi + " yolcu icin en iyi cozumu veren yol: ");
                    System.out.println("Yol bulunamadi.");
                    System.out.println();
                }
            }
            
            Collections.sort(guzergahlar, new Comparator<Graph>() { // guzergahlarin kara gore siralanmasi
                @Override
                public int compare(Graph g1, Graph g2) {
                    if (g1.kar < g2.kar) {
                        return -1;
                    } else if (g1.kar > g2.kar) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            
            if (guzergahlar.size() == 0) {
                System.out.println("Hic yol bulunamadigi icin harita uzerinde gosterilemiyor.");
                System.out.println();
            }
            
            HashMap<Double, Double> kontrol = new HashMap<Double, Double>(); // guzergahlarin en iyi kardan en kotu kara dogru haritada gosterilmesi
            ArrayList<Graph> enkisaguzergahlar = new ArrayList<Graph>();
            int counter = 0;
            for (int i=0; i<guzergahlar.size(); i++) {
                Graph current = guzergahlar.get(i);
                counter++;
                NumberFormat formatter = new DecimalFormat("#0.00");
                String data = "Toplam gidilen mesafe: " + formatter.format(current.yol) + " km" + ",Tutar: " + formatter.format(current.tutar) + " TL" + ",Yolcu sayisi: " + current.yolcusayisi + ",%50 kar icin alinmasi gereken fiyat: " + formatter.format(current.yuzdeellifiyat) + " TL";
                new Path("En iyi cozumu veren yol " + counter + " - yolcu sayisi: " + current.yolcusayisi, current.dugumler, data);
                // bulunan tum farkli yollar harita uzerinde gosterildi.
            }
            
        } else {
            
        }
        
        long endTime = System.nanoTime();
        long estimatedTime = endTime - startTime;
        double seconds = (double)estimatedTime/1000000000;
        System.out.println("Programin calisma suresi: " + seconds + " saniyedir.");
        
    }
    
}
