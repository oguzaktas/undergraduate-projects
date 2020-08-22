
package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Programlama Laboratuvari II Proje 1
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Dijkstra extends Node {
    
    public ArrayList<Node> dugumler;
    public ArrayList<Node> gezilenler = new ArrayList<Node>();
    public HashMap<Integer, Double> ildeger = new HashMap<Integer, Double>(); // Integer olarak sehirleri (keys) ve Double olarak şehirlere olan uzakliklari (values) tutan HashMap turunde ozellik
    public HashMap<Integer, String> yol = new HashMap<Integer, String>();
    
    public Dijkstra(ArrayList<Node> dugumler) {
        this.dugumler = dugumler;
    }
    
    public ArrayList<Node> yoluBul(int baslangicplaka, int bitisplaka) {
        Node baslangic = dugumler.get(baslangicplaka-1);
        gezilenler.add(baslangic);
        Node bitis = dugumler.get(bitisplaka-1);
        Node currentdestination = null;
        double weight = Double.MAX_VALUE;
        int destination = 0;
        int oncekiplaka = baslangicplaka;
        int counter = 0;
        while (true) {
            for (int i=0; i<gezilenler.size(); i++) {
                baslangic = gezilenler.get(i);
                for (int j=0; j<baslangic.getKomsuluklar().length; j++) {
                    if (baslangic.getKomsulukdegerleri().get(baslangic.getKomsuluklar()[j]) != null && baslangic.getKomsulukdegerleri().get(baslangic.getKomsuluklar()[j]) < weight) {
                        if (ildeger.get(baslangic.getKomsuluklar()[j]) == null) {
                            oncekiplaka = baslangic.getPlaka();
                            destination = baslangic.getKomsuluklar()[j];
                            weight = baslangic.getKomsulukdegerleri().get(baslangic.getKomsuluklar()[j]);
                        } else if (ildeger.get(baslangic.getKomsuluklar()[j]) > baslangic.getKomsulukdegerleri().get(baslangic.getKomsuluklar()[j])) {
                            ildeger.put(baslangic.getKomsuluklar()[j], baslangic.getKomsulukdegerleri().get(baslangic.getKomsuluklar()[j]));
                        }
                    }
                }
            }
            
            boolean control = false;
            for (int i=1; i<82; i++) {
                if (ildeger.get(i) == null) {
                    control = true;
                    break;
                }
            }
            
            if (control == true && destination != 0 && weight != Double.MAX_VALUE) {
                ildeger.put(destination, weight);
                yol.put(counter, "" + oncekiplaka + "->" + destination);
                oncekiplaka = destination;
                currentdestination = dugumler.get(destination-1);
                currentdestination.komsulukdegeriniGuncelle(baslangic.getPlaka(), Integer.MAX_VALUE);
                dugumler.set(destination-1, currentdestination);
                komsuluklariGuncelle(currentdestination, weight);
                gezilenler.add(currentdestination);
                weight = Double.MAX_VALUE;
                destination = 0;
                counter++;
            } else {
                break;
            }
        }
        
        return yoluGoster(baslangicplaka, bitisplaka);
    }
    
    public void komsuluklariGuncelle(Node current, double weight) {
        for (int i=0; i<current.getKomsuluklar().length; i++) {
            if (current.getKomsulukdegerleri().get(current.getKomsuluklar()[i]) != null) {
                current.komsulukdegeriniGuncelle(current.getKomsuluklar()[i], current.getKomsulukdegerleri().get(current.getKomsuluklar()[i]) + weight);
            }
        }
        dugumler.set(current.getPlaka()-1, current);
    }
    
    public double gidilenMesafe(int destination) {
        return ildeger.get(destination);
    }
    
    public ArrayList<Node> yoluGoster(int baslangic, int bitis) {
        ArrayList<Node> path = new ArrayList<Node>();
        for (int i=yol.size()-1; i>=0; i--) {
            String[] adim = yol.get(i).replace("->", " ").split(" ");
            if (Integer.parseInt(adim[1]) == bitis) {
                path.add(dugumler.get(Integer.parseInt(adim[1])-1));
                bitis = Integer.parseInt(adim[0]);
            }
        }
        
        return path;
    }
    
}
