
package main;

import java.util.ArrayList;

/**
 * Programlama Laboratuvari II Proje 1
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Graph {
    
    public ArrayList<Node> dugumler;
    public int dugumsayisi;
    public double yol;
    public double tutar;
    public int yolcusayisi;
    public double kar;
    public double yuzdeellifiyat;
    
    public Graph(ArrayList<Node> dugumler, int dugumsayisi, double yol, double tutar, int yolcusayisi, double kar) { // Problem 1 constructor
        this.dugumler = dugumler;
        this.dugumsayisi = dugumsayisi;
        this.yol = yol;
        this.tutar = tutar;
        this.yolcusayisi = yolcusayisi;
        this.kar = kar;
    }
    
    public Graph(ArrayList<Node> dugumler, int dugumsayisi, double yol, double tutar, int yolcusayisi, double kar, double yuzdeellifiyat) { // Problem 2 constructor
        this.dugumler = dugumler;
        this.dugumsayisi = dugumsayisi;
        this.yol = yol;
        this.tutar = tutar;
        this.yolcusayisi = yolcusayisi;
        this.kar = kar;
        this.yuzdeellifiyat = yuzdeellifiyat;
    }
    
    
    public int getYolcusayisi() {
        return yolcusayisi;
    }
    
    public void setYolcusayisi(int yolcusayisi) {
        this.yolcusayisi = yolcusayisi;
    }
    
}
