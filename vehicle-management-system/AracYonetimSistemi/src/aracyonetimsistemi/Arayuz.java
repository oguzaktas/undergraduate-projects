
package aracyonetimsistemi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Programlama Laboratuvari II Proje 2
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Arayuz {

    private int secim;
    private int secim2;
    private int secim3;
    private String guncellenecekserino;

    private static Arayuz yeni = new Arayuz(); // Object instance

    public static Arayuz getInstance() { // Bu sekilde classtan sadece bir obje olusturulmasina izin verilir.
        return yeni;
    }

    private Arayuz() { // Singleton class

    }

    public Arayuz(int secim, int secim2, int secim3, String guncellenecekserino) {
        this.secim = secim;
        this.secim2 = secim2;
        this.secim3 = secim3;
        this.guncellenecekserino = guncellenecekserino;
    }

    public int getSecim() {
        return secim;
    }

    public int getSecim2() {
        return secim2;
    }

    public int getSecim3() {
        return secim3;
    }

    public String getGuncellenecekserino() {
        return guncellenecekserino;
    }

    public void setSecim(int secim) {
        this.secim = secim;
    }

    public void setSecim2(int secim2) {
        this.secim2 = secim2;
    }

    public void setSecim3(int secim3) {
        this.secim3 = secim3;
    }

    public void setGuncellenecekserino(String guncellenecekserino) {
        this.guncellenecekserino = guncellenecekserino;
    }

    public void menu() throws IOException { // ana menu tasarimi
        System.out.println("Ana Menu");
        System.out.println("Yapmak istediginiz islemi seciniz: ");
        System.out.println("1. Veri girisinde bulun");
        System.out.println("2. Veri listele");
        System.out.println("3. Veri guncelle");
        System.out.println("4. Programi sonlandir");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Seciminizi giriniz [1-4]: ");
            secim = sc.nextInt();
        } while (secim < 1 || secim > 4);
        if (secim != 4) {
            System.out.println("----------------------------------------");
        }
        System.out.println();
        if (secim == 1) {
            menu2();
        } else if (secim == 2) {
            menu3();
        } else if (secim == 3) {
            menu4();
        } else if (secim == 4) {
            try (FileOutputStream writer = new FileOutputStream("AracKayit.txt")) {
                writer.write(("").getBytes());
            }
            System.out.println("Tum kayitlar silindi ve program sonlandirildi.");
            System.exit(0);
        }
    }

    public void menu2() throws IOException { // veri girisinde bulun menusu tasarimi
        System.out.println("Veri Girisinde Bulun");
        System.out.println("Veri girisinde bulunacaginiz araci seciniz:");
        System.out.println("1. Otomobil");
        System.out.println("2. Bisiklet");
        System.out.println("3. Gemi");
        System.out.println("4. Ucak");
        System.out.println("5. Ucan gemi");
        System.out.println("6. Bir onceki menuye don");
        System.out.println("7. Programi sonlandir");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Seciminizi giriniz [1-7]: ");
            secim2 = sc.nextInt();
        } while (secim2 < 1 || secim2 > 7);
        if (secim2 != 7) {
            System.out.println("----------------------------------------");
        }
        System.out.println();
        if (secim2 == 1) {
            Otomobil o = new Otomobil();
            Scanner scan = new Scanner(System.in);
            String serino = "Otomobil" + Otomobil.getId();
            o.setSerino(serino);
            String marka;
            System.out.print("Otomobilin markasini giriniz: ");
            marka = scan.nextLine();
            o.setMarka(marka);
            int hiz;
            System.out.print("Otomobilin hizini giriniz: ");
            hiz = scan.nextInt();
            o.setHiz(hiz);
            int yolcusayisi;
            System.out.print("Otomobilin yolcu sayisini giriniz: ");
            yolcusayisi = scan.nextInt();
            o.setYolcusayisi(yolcusayisi);
            int tekerleksayisi;
            System.out.print("Otomobilin tekerlek sayisini giriniz: ");
            tekerleksayisi = scan.nextInt();
            o.setTekerleksayisi(tekerleksayisi);
            int fiyat;
            System.out.print("Otomobilin fiyatini giriniz: ");
            fiyat = scan.nextInt();
            o.setFiyat(fiyat);
            int uretimyili;
            System.out.print("Otomobilin uretim yilini giriniz: ");
            uretimyili = scan.nextInt();
            o.setUretimyili(uretimyili);
            String renk;
            System.out.print("Otomobilin rengini giriniz: ");
            scan.nextLine();
            renk = scan.nextLine();
            o.setRenk(renk);
            String yakitturu;
            System.out.print("Otomobilin yakit turunu giriniz (dizel, LPG, benzin veya elektrik): ");
            yakitturu = scan.nextLine();
            o.setYakitturu(yakitturu);
            System.out.println("Otomobil olusturuldu.");
            System.out.println("Otomobilin hizinda degisiklik yapmak ister misiniz?");
            System.out.println("1. Hizlandir");
            System.out.println("2. Yavaslat");
            System.out.println("3. Durdur");
            System.out.println("4. Hayir " + o.getHiz() + " km/sa olarak kalsin");
            System.out.print("Seciminizi giriniz [1-4]: ");
            int davranis = scan.nextInt();
            if (davranis == 1) {
                System.out.print("Hizini kac km/sa arttirmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                o.hizlan(hiz1);
            } else if (davranis == 2) {
                System.out.print("Hizini kac km/sa azaltmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                o.yavasla(hiz1);
            } else if (davranis == 3) {
                o.dur();
            }
            //Otomobil o = new Otomobil(serino, marka, hiz, yolcusayisi, tekerleksayisi, fiyat, uretimyili, renk, yakitturu);
            dosyayaEkle1(o);
            System.out.println("Otomobil dosyaya eklendi.");
            System.out.println("----------------------------------------");
            System.out.println();
            menu();
        } else if (secim2 == 2) {
            Bisiklet b = new Bisiklet();
            Scanner scan = new Scanner(System.in);
            String serino = "Bisiklet" + Bisiklet.getId();
            b.setSerino(serino);
            String marka;
            System.out.print("Bisikletin markasini giriniz: ");
            marka = scan.nextLine();
            b.setMarka(marka);
            int hiz;
            System.out.print("Bisikletin hizini giriniz: ");
            hiz = scan.nextInt();
            b.setHiz(hiz);
            int yolcusayisi;
            System.out.print("Bisikletin yolcu sayisini giriniz: ");
            yolcusayisi = scan.nextInt();
            b.setYolcusayisi(yolcusayisi);
            int tekerleksayisi;
            System.out.print("Bisikletin tekerlek sayisini giriniz: ");
            tekerleksayisi = scan.nextInt();
            b.setTekerleksayisi(tekerleksayisi);
            int fiyat;
            System.out.print("Bisikletin fiyatini giriniz: ");
            fiyat = scan.nextInt();
            b.setFiyat(fiyat);
            int uretimyili;
            System.out.print("Bisikletin uretim yilini giriniz: ");
            uretimyili = scan.nextInt();
            b.setUretimyili(uretimyili);
            String renk;
            System.out.print("Bisikletin rengini giriniz: ");
            scan.nextLine();
            renk = scan.nextLine();
            b.setRenk(renk);
            System.out.println("Bisiklet olusturuldu.");
            System.out.println("Bisikletin hizinda degisiklik yapmak ister misiniz?");
            System.out.println("1. Hizlandir");
            System.out.println("2. Yavaslat");
            System.out.println("3. Durdur");
            System.out.println("4. Hayir " + b.getHiz() + " km/sa olarak kalsin");
            System.out.print("Seciminizi giriniz [1-4]: ");
            int davranis = scan.nextInt();
            if (davranis == 1) {
                System.out.print("Hizini kac km/sa arttirmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                b.hizlan(hiz1);
            } else if (davranis == 2) {
                System.out.print("Hizini kac km/sa azaltmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                b.yavasla(hiz1);
            } else if (davranis == 3) {
                b.dur();
            }
            //Bisiklet b = new Bisiklet(serino, marka, hiz, yolcusayisi, tekerleksayisi, fiyat, uretimyili, renk);
            dosyayaEkle2(b);
            System.out.println("Bisiklet dosyaya eklendi.");
            System.out.println("----------------------------------------");
            System.out.println();
            menu();
        } else if (secim2 == 3) {
            Gemi g = new Gemi();
            Scanner scan = new Scanner(System.in);
            String serino = "Gemi" + Gemi.getId();
            g.setSerino(serino);
            String marka;
            System.out.print("Geminin markasini giriniz: ");
            marka = scan.nextLine();
            g.setMarka(marka);
            int hiz;
            System.out.print("Geminin hizini giriniz: ");
            hiz = scan.nextInt();
            g.setHiz(hiz);
            int yolcusayisi;
            System.out.print("Geminin yolcu sayisini giriniz: ");
            yolcusayisi = scan.nextInt();
            g.setYolcusayisi(yolcusayisi);
            int fiyat;
            System.out.print("Geminin fiyatini giriniz: ");
            fiyat = scan.nextInt();
            g.setFiyat(fiyat);
            int uretimyili;
            System.out.print("Geminin uretim yilini giriniz: ");
            uretimyili = scan.nextInt();
            g.setUretimyili(uretimyili);
            String renk;
            System.out.print("Geminin rengini giriniz: ");
            scan.nextLine();
            renk = scan.nextLine();
            g.setRenk(renk);
            System.out.println("Gemi olusturuldu.");
            System.out.println("Geminin hizinda degisiklik yapmak ister misiniz?");
            System.out.println("1. Hizlandir");
            System.out.println("2. Yavaslat");
            System.out.println("3. Durdur");
            System.out.println("4. Hayir " + g.getHiz() + " km/sa olarak kalsin");
            System.out.print("Seciminizi giriniz [1-4]: ");
            int davranis = scan.nextInt();
            if (davranis == 1) {
                System.out.print("Hizini kac km/sa arttirmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                g.hizlan(hiz1);
            } else if (davranis == 2) {
                System.out.print("Hizini kac km/sa azaltmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                g.yavasla(hiz1);
            } else if (davranis == 3) {
                g.dur();
            }
            //Gemi g = new Gemi(serino, marka, hiz, yolcusayisi, fiyat, uretimyili, renk);
            dosyayaEkle3(g);
            System.out.println("Gemi dosyaya eklendi.");
            System.out.println("----------------------------------------");
            System.out.println();
            menu();
        } else if (secim2 == 4) {
            Ucak u = new Ucak();
            Scanner scan = new Scanner(System.in);
            String serino = "Ucak" + Ucak.getId();
            u.setSerino(serino);
            String marka;
            System.out.print("Ucagin markasini giriniz: ");
            marka = scan.nextLine();
            u.setMarka(marka);
            int hiz;
            System.out.print("Ucagin hizini giriniz: ");
            hiz = scan.nextInt();
            u.setHiz(hiz);
            int yolcusayisi;
            System.out.print("Ucagin yolcu sayisini giriniz: ");
            yolcusayisi = scan.nextInt();
            u.setYolcusayisi(yolcusayisi);
            int tekerleksayisi;
            System.out.print("Ucagin tekerlek sayisini giriniz: ");
            tekerleksayisi = scan.nextInt();
            u.setTekerleksayisi(tekerleksayisi);
            int fiyat;
            System.out.print("Ucagin fiyatini giriniz: ");
            fiyat = scan.nextInt();
            u.setFiyat(fiyat);
            int uretimyili;
            System.out.print("Ucagin uretim yilini giriniz: ");
            uretimyili = scan.nextInt();
            u.setUretimyili(uretimyili);
            String renk;
            System.out.print("Ucagin rengini giriniz: ");
            scan.nextLine();
            renk = scan.nextLine();
            u.setRenk(renk);
            int indimi;
            System.out.print("Ucak havadaysa 0 yerde hareket ediyorsa 1 giriniz [0 veya 1]: ");
            indimi = scan.nextInt();
            if (indimi == 0) {
                u.setIndimi(false);
            } else if (indimi == 1) {
                u.setIndimi(true);
            }
            System.out.println("Ucak olusturuldu.");
            System.out.println("Ucagin hizinda degisiklik yapmak ister misiniz?");
            System.out.println("1. Hizlandir");
            System.out.println("2. Yavaslat");
            System.out.println("3. Durdur");
            System.out.println("4. Hayir " + u.getHiz() + " km/sa olarak kalsin");
            System.out.print("Seciminizi giriniz [1-4]: ");
            int davranis = scan.nextInt();
            if (davranis == 1) {
                System.out.print("Hizini kac km/sa arttirmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                u.hizlan(hiz1);
            } else if (davranis == 2) {
                System.out.print("Hizini kac km/sa azaltmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                u.yavasla(hiz1);
            } else if (davranis == 3) {
                u.dur();
            }
            //Ucak u = new Ucak(serino, false, marka, hiz, yolcusayisi, tekerleksayisi, fiyat, uretimyili, renk);
            dosyayaEkle4(u);
            System.out.println("Ucak dosyaya eklendi.");
            System.out.println("----------------------------------------");
            System.out.println();
            menu();
        } else if (secim2 == 5) {
            UcanGemi ug = new UcanGemi();
            Scanner scan = new Scanner(System.in);
            String serino = "UcanGemi" + UcanGemi.getId();
            ug.setSerino(serino);
            String marka;
            System.out.print("Ucan geminin markasini giriniz: ");
            marka = scan.nextLine();
            ug.setMarka(marka);
            int hiz;
            System.out.print("Ucan geminin hizini giriniz: ");
            hiz = scan.nextInt();
            ug.setHiz(hiz);
            int yolcusayisi;
            System.out.print("Ucan geminin yolcu sayisini giriniz: ");
            yolcusayisi = scan.nextInt();
            ug.setYolcusayisi(yolcusayisi);
            int fiyat;
            System.out.print("Ucan geminin fiyatini giriniz: ");
            fiyat = scan.nextInt();
            ug.setFiyat(fiyat);
            int uretimyili;
            System.out.print("Ucan geminin uretim yilini giriniz: ");
            uretimyili = scan.nextInt();
            ug.setUretimyili(uretimyili);
            String renk;
            System.out.print("Ucan geminin rengini giriniz: ");
            scan.nextLine();
            renk = scan.nextLine();
            ug.setRenk(renk);
            int indimi;
            System.out.print("Ucan gemi havadaysa 0 yerde hareket ediyorsa 1 giriniz [0 veya 1]: ");
            indimi = scan.nextInt();
            if (indimi == 0) {
                ug.setIndimi(false);
            } else if (indimi == 1) {
                ug.setIndimi(true);
            }
            System.out.println("Ucan gemi olusturuldu.");
            System.out.println("Ucan geminin hizinda degisiklik yapmak ister misiniz?");
            System.out.println("1. Hizlandir");
            System.out.println("2. Yavaslat");
            System.out.println("3. Durdur");
            System.out.println("4. Hayir " + ug.getHiz() + " km/sa olarak kalsin");
            System.out.print("Seciminizi giriniz [1-4]: ");
            int davranis = scan.nextInt();
            if (davranis == 1) {
                System.out.print("Hizini kac km/sa arttirmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                ug.hizlan(hiz1);
            } else if (davranis == 2) {
                System.out.print("Hizini kac km/sa azaltmak istersiniz?: ");
                int hiz1 = scan.nextInt();
                ug.yavasla(hiz1);
            } else if (davranis == 3) {
                ug.dur();
            }
            //UcanGemi ug = new UcanGemi(serino, false, marka, hiz, yolcusayisi, fiyat, uretimyili, renk);
            dosyayaEkle5(ug);
            System.out.println("Ucan gemi dosyaya eklendi.");
            System.out.println("----------------------------------------");
            System.out.println();
            menu();
        } else if (secim2 == 6) {
            menu();
        } else if (secim2 == 7) {
            try (FileOutputStream writer = new FileOutputStream("AracKayit.txt")) {
                writer.write(("").getBytes());
            }
            System.out.println("Tum kayitlar silindi ve program sonlandirildi.");
            System.exit(0);
        }
    }

    public void menu3() throws IOException { // veri listele menusu tasarimi
        System.out.println("Veri Listele");
        System.out.println("Listelemek istediginiz veri tipini seciniz:");
        System.out.println("1. Kara tasitlari");
        System.out.println("2. Deniz tasitlari");
        System.out.println("3. Hava tasitlari");
        System.out.println("4. Bir onceki menuye don");
        System.out.println("5. Programi sonlandir");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Seciminizi giriniz [1-5]: ");
            secim3 = sc.nextInt();
        } while (secim3 < 1 || secim3 > 5);
        if (secim3 != 5) {
            System.out.println("----------------------------------------");
        }
        System.out.println();
        if (secim3 == 1) { // kara tasitlari (otomobiller ve bisikletler) listelenir.
            dosyadanOku1();
            System.out.println("----------------------------------------");
            System.out.println();
            menu();
        } else if (secim3 == 2) { // deniz tasitlari (gemiler ve ucan gemiler) listelenir.
            dosyadanOku2();
            System.out.println("----------------------------------------");
            System.out.println();
            menu();
        } else if (secim3 == 3) { // hava tasitlari (ucaklar ve ucan gemiler) listelenir.
            dosyadanOku3();
            System.out.println("----------------------------------------");
            System.out.println();
            menu();
        } else if (secim3 == 4) {
            menu();
        } else if (secim3 == 5) {
            try (FileOutputStream writer = new FileOutputStream("AracKayit.txt")) {
                writer.write(("").getBytes());
            }
            System.out.println("Tum kayitlar silindi ve program sonlandirildi.");
            System.exit(0);
        }
    }

    public void menu4() throws IOException { // veri guncelle menusu tasarimi
        System.out.println("Veri Guncelle");
        Scanner sc = new Scanner(System.in);
        System.out.print("Guncellemek istediginiz aracin seri numarasini giriniz (Otomobil1, UcanGemi2 gibi): ");
        guncellenecekserino = sc.nextLine();
        dosyadanGuncelle(guncellenecekserino);
    }
    
    
    public void dosyayaEkle1(Otomobil otomobil) throws FileNotFoundException, IOException { // Otomobil sinifi icin dosyaya ekleme islemleri
        FileWriter fw = new FileWriter("AracKayit.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        try (PrintWriter writer = new PrintWriter(bw)) {
            writer.println(otomobil.getSerino() + " seri numarali aracin ozellikleri: ");
            writer.println("" + "markasi: " + otomobil.getMarka() + ", hizi: " + otomobil.getHiz() + " km/sa, yolcu sayisi: " + otomobil.getYolcusayisi() + ", tekerlek sayisi: " + otomobil.getTekerleksayisi() + ", fiyati: " + otomobil.getFiyat() + " TL, uretim yili: " + otomobil.getUretimyili() + ", rengi: " + otomobil.getRenk() + ", yakit turu: " + otomobil.getYakitturu());
            writer.println();
        }
    }
    
    public void dosyayaEkle2(Bisiklet bisiklet) throws FileNotFoundException, IOException { // Bisiklet sinifi icin dosyaya ekleme islemleri
        FileWriter fw = new FileWriter("AracKayit.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        try (PrintWriter writer = new PrintWriter(bw)) {
            writer.println(bisiklet.getSerino() + " seri numarali aracin ozellikleri: ");
            writer.println("" + "markasi: " + bisiklet.getMarka() + ", hizi: " + bisiklet.getHiz() + " km/sa, yolcu sayisi: " + bisiklet.getYolcusayisi() + ", tekerlek sayisi: " + bisiklet.getTekerleksayisi() + ", fiyati: " + bisiklet.getFiyat() + " TL, uretim yili: " + bisiklet.getUretimyili() + ", rengi: " + bisiklet.getRenk());
            writer.println();
        }
    }
    
    public void dosyayaEkle3(Gemi gemi) throws FileNotFoundException, IOException { // Gemi sinifi icin dosyaya ekleme islemleri
        FileWriter fw = new FileWriter("AracKayit.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        try (PrintWriter writer = new PrintWriter(bw)) {
            writer.println(gemi.getSerino() + " seri numarali aracin ozellikleri: ");
            writer.println("" + "markasi: " + gemi.getMarka() + ", hizi: " + gemi.getHiz() + " km/sa, yolcu sayisi: " + gemi.getYolcusayisi() + ", fiyati: " + gemi.getFiyat() + " TL, uretim yili: " + gemi.getUretimyili() + ", rengi: " + gemi.getRenk());
            writer.println();
        }
    }
    
    public void dosyayaEkle4(Ucak ucak) throws FileNotFoundException, IOException { // Ucak sinifi icin dosyaya ekleme islemleri
        FileWriter fw = new FileWriter("AracKayit.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        try (PrintWriter writer = new PrintWriter(bw)) {
            writer.println(ucak.getSerino() + " seri numarali aracin ozellikleri: ");
            writer.println("" + "markasi: " + ucak.getMarka() + ", hizi: " + ucak.getHiz() + " km/sa, yolcu sayisi: " + ucak.getYolcusayisi() + ", tekerlek sayisi: " + ucak.getTekerleksayisi() + ", fiyati: " + ucak.getFiyat() + " TL, uretim yili: " + ucak.getUretimyili() + ", rengi: " + ucak.getRenk());
            writer.println();
        }
    }
    
    public void dosyayaEkle5(UcanGemi ucangemi) throws FileNotFoundException, IOException { // UcanGemi sinifi icin dosyaya ekleme islemleri
        FileWriter fw = new FileWriter("AracKayit.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        try (PrintWriter writer = new PrintWriter(bw)) {
            writer.println(ucangemi.getSerino() + " seri numarali aracin ozellikleri: ");
            writer.println("" + "markasi: " + ucangemi.getMarka() + ", hizi: " + ucangemi.getHiz() + " km/sa, yolcu sayisi: " + ucangemi.getYolcusayisi() + ", fiyati: " + ucangemi.getFiyat() + " TL, uretim yili: " + ucangemi.getUretimyili() + ", rengi: " + ucangemi.getRenk());
            writer.println();
        }
    }
    
    public void dosyadanOku1() throws FileNotFoundException, IOException { // Kara tasitlari icin dosyadan okuma ve listeleme islemleri
        BufferedReader in = new BufferedReader(new FileReader("AracKayit.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.contains("Bisiklet") || line.contains("Otomobil")) {
                System.out.println(line);
                System.out.println(in.readLine());
                System.out.println();
            }
        }
        in.close();
    }
    
    public void dosyadanOku2() throws FileNotFoundException, IOException { // Deniz tasitlari icin dosyadan okuma ve listeleme islemleri
        BufferedReader in = new BufferedReader(new FileReader("AracKayit.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.contains("Gemi") || line.contains("UcanGemi")) {
                System.out.println(line);
                System.out.println(in.readLine());
                System.out.println();
            }
        }
        in.close();
    }
    
    public void dosyadanOku3() throws FileNotFoundException, IOException { // Hava tasitlari icin dosyadan okuma ve listeleme islemleri
        BufferedReader in = new BufferedReader(new FileReader("AracKayit.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.contains("Ucak") || line.contains("UcanGemi")) {
                System.out.println(line);
                System.out.println(in.readLine());
                System.out.println();
            }
        }
        in.close();
    }
    
    public void dosyadanGuncelle(String serino) throws FileNotFoundException, IOException { // Veri guncelleme metodu
        BufferedReader in = new BufferedReader(new FileReader("AracKayit.txt"));
        String line;
        String[] temp;
        List<String> lines = new ArrayList<String>();
        int counter = 0;
        while ((line = in.readLine()) != null) {
            if (line.contains(serino)) {
                int guncellenecekozellik;
                if (line.contains("Otomobil")) {
                    System.out.println("Guncellemek istediginiz ozelligi seciniz:");
                    System.out.println("1. Marka");
                    System.out.println("2. Hiz");
                    System.out.println("3. Yolcu sayisi");
                    System.out.println("4. Tekerlek sayisi");
                    System.out.println("5. Fiyat");
                    System.out.println("6. Uretim yili");
                    System.out.println("7. Renk");
                    System.out.println("8. Yakit turu");
                    Scanner sc = new Scanner(System.in);
                    do {
                        System.out.print("Seciminizi giriniz [1-8]: ");
                        guncellenecekozellik = sc.nextInt();
                    } while (guncellenecekozellik < 1 || guncellenecekozellik > 8);
                    String marka, renk, yakitturu;
                    int hiz, yolcusayisi, tekerleksayisi, fiyat, uretimyili;
                    if (guncellenecekozellik == 1) {
                        System.out.print("Otomobilin yeni markasini giriniz: ");
                        sc.nextLine();
                        marka = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni1 = "markasi: " + marka;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[0], yeni1);
                    } else if (guncellenecekozellik == 2) {
                        System.out.print("Otomobilin yeni hizini giriniz: ");
                        hiz = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni2 = " hizi: " + hiz + " km/sa";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[1], yeni2);                        
                    } else if (guncellenecekozellik == 3) {
                        System.out.print("Otomobilin yeni yolcu sayisini giriniz: ");
                        yolcusayisi = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni3 = " yolcu sayisi: " + yolcusayisi;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[2], yeni3);
                    } else if (guncellenecekozellik == 4) {
                        System.out.print("Otomobilin yeni tekerlek sayisini giriniz: ");
                        tekerleksayisi = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni4 = " tekerlek sayisi: " + tekerleksayisi;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[3], yeni4);
                    } else if (guncellenecekozellik == 5) {
                        System.out.print("Otomobilin yeni fiyatini giriniz: ");
                        fiyat = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni5 = " fiyati: " + fiyat + " TL";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[4], yeni5);
                    } else if (guncellenecekozellik == 6) {
                        System.out.print("Otomobilin yeni uretim yilini giriniz: ");
                        uretimyili = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni6 = " uretim yili: " + uretimyili;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[5], yeni6);
                    } else if (guncellenecekozellik == 7) {
                        System.out.print("Otomobilin yeni rengini giriniz: ");
                        sc.nextLine();
                        renk = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni7 = " rengi: " + renk;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[6], yeni7);
                    } else if (guncellenecekozellik == 8) {
                        System.out.print("Otomobilin yeni yakit turunu giriniz: ");
                        yakitturu = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni8 = " yakit turu: " + yakitturu;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[7], yeni8);
                    }
                    System.out.println("Otomobil guncellendi.");
                    System.out.println("----------------------------------------");
                } else if (line.contains("Bisiklet")) {
                    System.out.println("Guncellemek istediginiz ozelligi seciniz:");
                    System.out.println("1. Marka");
                    System.out.println("2. Hiz");
                    System.out.println("3. Yolcu sayisi");
                    System.out.println("4. Tekerlek sayisi");
                    System.out.println("5. Fiyat");
                    System.out.println("6. Uretim yili");
                    System.out.println("7. Renk");
                    Scanner sc = new Scanner(System.in);
                    do {
                        System.out.print("Seciminizi giriniz [1-7]: ");
                        guncellenecekozellik = sc.nextInt();
                    } while (guncellenecekozellik < 1 || guncellenecekozellik > 7);
                    String marka, renk;
                    int hiz, yolcusayisi, tekerleksayisi, fiyat, uretimyili;
                    if (guncellenecekozellik == 1) {
                        System.out.print("Bisikletin yeni markasini giriniz: ");
                        sc.nextLine();
                        marka = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni1 = "markasi: " + marka;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[0], yeni1);
                    } else if (guncellenecekozellik == 2) {
                        System.out.print("Bisikletin yeni hizini giriniz: ");
                        hiz = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni2 = " hizi: " + hiz + " km/sa";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[1], yeni2);                        
                    } else if (guncellenecekozellik == 3) {
                        System.out.print("Bisikletin yeni yolcu sayisini giriniz: ");
                        yolcusayisi = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni3 = " yolcu sayisi: " + yolcusayisi;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[2], yeni3);
                    } else if (guncellenecekozellik == 4) {
                        System.out.print("Bisikletin yeni tekerlek sayisini giriniz: ");
                        tekerleksayisi = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni4 = " tekerlek sayisi: " + tekerleksayisi;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[3], yeni4);
                    } else if (guncellenecekozellik == 5) {
                        System.out.print("Bisikletin yeni fiyatini giriniz: ");
                        fiyat = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni5 = " fiyati: " + fiyat + " TL";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[4], yeni5);
                    } else if (guncellenecekozellik == 6) {
                        System.out.print("Bisikletin yeni uretim yilini giriniz: ");
                        uretimyili = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni6 = " uretim yili: " + uretimyili;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[5], yeni6);
                    } else if (guncellenecekozellik == 7) {
                        System.out.print("Bisikletin yeni rengini giriniz: ");
                        sc.nextLine();
                        renk = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni7 = " rengi: " + renk;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[6], yeni7);
                    }
                    System.out.println("Bisiklet guncellendi.");
                    System.out.println("----------------------------------------");
                } else if (line.startsWith("Gemi")) {
                    System.out.println("Guncellemek istediginiz ozelligi seciniz:");
                    System.out.println("1. Marka");
                    System.out.println("2. Hiz");
                    System.out.println("3. Yolcu sayisi");
                    System.out.println("4. Fiyat");
                    System.out.println("5. Uretim yili");
                    System.out.println("6. Renk");
                    Scanner sc = new Scanner(System.in);
                    do {
                        System.out.print("Seciminizi giriniz [1-6]: ");
                        guncellenecekozellik = sc.nextInt();
                    } while (guncellenecekozellik < 1 || guncellenecekozellik > 6);
                    String marka, renk;
                    int hiz, yolcusayisi, fiyat, uretimyili;
                    if (guncellenecekozellik == 1) {
                        System.out.print("Geminin yeni markasini giriniz: ");
                        sc.nextLine();
                        marka = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni1 = "markasi: " + marka;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[0], yeni1);
                    } else if (guncellenecekozellik == 2) {
                        System.out.print("Geminin yeni hizini giriniz: ");
                        hiz = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni2 = " hizi: " + hiz + " km/sa";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[1], yeni2);                        
                    } else if (guncellenecekozellik == 3) {
                        System.out.print("Geminin yeni yolcu sayisini giriniz: ");
                        yolcusayisi = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni3 = " yolcu sayisi: " + yolcusayisi;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[2], yeni3);
                    } else if (guncellenecekozellik == 4) {
                        System.out.print("Geminin yeni fiyatini giriniz: ");
                        fiyat = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni4 = " fiyat: " + fiyat + " TL";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[3], yeni4);
                    } else if (guncellenecekozellik == 5) {
                        System.out.print("Geminin yeni uretim yilini giriniz: ");
                        uretimyili = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni5 = " uretim yili: " + uretimyili;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[4], yeni5);
                    } else if (guncellenecekozellik == 6) {
                        System.out.print("Geminin yeni rengini giriniz: ");
                        sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        renk = sc.nextLine();
                        String yeni6 = " rengi: " + renk;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[5], yeni6);
                    }
                    System.out.println("Gemi guncellendi.");
                    System.out.println("----------------------------------------");             
                } else if (line.contains("Ucak")) {
                    System.out.println("Guncellemek istediginiz ozelligi seciniz:");
                    System.out.println("1. Marka");
                    System.out.println("2. Hiz");
                    System.out.println("3. Yolcu sayisi");
                    System.out.println("4. Tekerlek sayisi");
                    System.out.println("5. Fiyat");
                    System.out.println("6. Uretim yili");
                    System.out.println("7. Renk");
                    Scanner sc = new Scanner(System.in);
                    do {
                        System.out.print("Seciminizi giriniz [1-7]: ");
                        guncellenecekozellik = sc.nextInt();
                    } while (guncellenecekozellik < 1 || guncellenecekozellik > 7);
                    String marka, renk;
                    int hiz, yolcusayisi, tekerleksayisi, fiyat, uretimyili;
                    if (guncellenecekozellik == 1) {
                        System.out.print("Ucagin yeni markasini giriniz: ");
                        sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        marka = sc.nextLine();
                        String yeni1 = "markasi: " + marka;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[0], yeni1);
                    } else if (guncellenecekozellik == 2) {
                        System.out.print("Ucagin yeni hizini giriniz: ");
                        hiz = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni2 = " hizi: " + hiz + " km/sa";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[1], yeni2);                        
                    } else if (guncellenecekozellik == 3) {
                        System.out.print("Ucagin yeni yolcu sayisini giriniz: ");
                        yolcusayisi = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni3 = " yolcu sayisi: " + yolcusayisi;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[2], yeni3);
                    } else if (guncellenecekozellik == 4) {
                        System.out.print("Ucagin yeni tekerlek sayisini giriniz: ");
                        tekerleksayisi = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni4 = " tekerlek sayisi: " + tekerleksayisi;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[3], yeni4);
                    } else if (guncellenecekozellik == 5) {
                        System.out.print("Ucagin yeni fiyatini giriniz: ");
                        fiyat = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni5 = " fiyati: " + fiyat + " TL";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[4], yeni5);
                    } else if (guncellenecekozellik == 6) {
                        System.out.print("Ucagin yeni uretim yilini giriniz: ");
                        uretimyili = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni6 = " uretim yili: " + uretimyili;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[5], yeni6);
                    } else if (guncellenecekozellik == 7) {
                        System.out.print("Ucagin yeni rengini giriniz: ");
                        sc.nextLine();
                        renk = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni7 = " rengi: " + renk;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[6], yeni7);
                    }
                    System.out.println("Ucak guncellendi.");
                    System.out.println("----------------------------------------");             
                } else if (line.contains("UcanGemi")) {
                    System.out.println("Guncellemek istediginiz ozelligi seciniz:");
                    System.out.println("1. Marka");
                    System.out.println("2. Hiz");
                    System.out.println("3. Yolcu sayisi");
                    System.out.println("4. Fiyat");
                    System.out.println("5. Uretim yili");
                    System.out.println("6. Renk");
                    Scanner sc = new Scanner(System.in);
                    do {
                        System.out.print("Seciminizi giriniz [1-6]: ");
                        guncellenecekozellik = sc.nextInt();
                    } while (guncellenecekozellik < 1 || guncellenecekozellik > 6);
                    String marka, renk;
                    int hiz, yolcusayisi, fiyat, uretimyili;
                    if (guncellenecekozellik == 1) {
                        System.out.print("Ucan geminin yeni markasini giriniz: ");
                        sc.nextLine();
                        marka = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni1 = "markasi: " + marka;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[0], yeni1);
                    } else if (guncellenecekozellik == 2) {
                        System.out.print("Ucan geminin yeni hizini giriniz: ");
                        hiz = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni2 = " hizi: " + hiz + " km/sa";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[1], yeni2);                        
                    } else if (guncellenecekozellik == 3) {
                        System.out.print("Ucan geminin yeni yolcu sayisini giriniz: ");
                        yolcusayisi = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni3 = " yolcu sayisi: " + yolcusayisi;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[2], yeni3);
                    } else if (guncellenecekozellik == 4) {
                        System.out.print("Ucan geminin yeni fiyatini giriniz: ");
                        fiyat = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni4 = " fiyat: " + fiyat + " TL";
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[3], yeni4);
                    } else if (guncellenecekozellik == 5) {
                        System.out.print("Ucan geminin yeni uretim yilini giriniz: ");
                        uretimyili = sc.nextInt();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni5 = " uretim yili: " + uretimyili;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[4], yeni5);
                    } else if (guncellenecekozellik == 6) {
                        System.out.print("Ucan geminin yeni rengini giriniz: ");
                        sc.nextLine();
                        renk = sc.nextLine();
                        line = in.readLine();
                        temp = line.split(",");
                        String yeni6 = " rengi: " + renk;
                        line = serino + " seri numarali aracin ozellikleri:" + System.lineSeparator() + line.replace(temp[5], yeni6);
                    }
                    System.out.println("Ucan gemi guncellendi.");
                    System.out.println("----------------------------------------");                
                }
            }
            lines.add(counter, line);
            counter++;
        }
        in.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("AracKayit.txt"));
        for (int i = 0; i < lines.size(); i++) {
            bw.write(lines.get(i));
            bw.newLine();
        }
        bw.close();
        System.out.println();
        menu();
    }

}
