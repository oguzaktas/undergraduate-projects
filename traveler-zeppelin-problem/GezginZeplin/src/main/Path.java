
package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Programlama Laboratuvari II Proje 1
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Path extends JFrame {
    
    public Path(String title, ArrayList<Node> yol, String data) throws IOException { // JFrame harita ekrani icin constructor
        this.setTitle(title);
        this.setContentPane(new Harita(yol));
        String[] temp = data.split(",");
        JLabel gidilenyol  = new JLabel(temp[0]);
        gidilenyol.setBounds(15, 455, 400, 30);
        gidilenyol.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(gidilenyol);
        JLabel tutar = new JLabel(temp[1]);
        tutar.setBounds(15, 480, 400, 30);
        tutar.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(tutar);
        JLabel yolcusayisi = new JLabel(temp[2]);
        yolcusayisi.setBounds(15, 505, 400, 30);
        yolcusayisi.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(yolcusayisi);
        JLabel kar = new JLabel(temp[3]);
        kar.setBounds(15, 530, 400, 30);
        kar.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(kar);

        this.setSize(1043, 610);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }
}
