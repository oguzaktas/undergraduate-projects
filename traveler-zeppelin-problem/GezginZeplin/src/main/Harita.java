
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Programlama Laboratuvari II Proje 1
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public class Harita extends JPanel {
    
    public BufferedImage img;
    public ArrayList<Node> yol;
    
    public Harita(ArrayList<Node> yol) throws IOException {
        this.yol = yol;
        img = ImageIO.read(new File("map.jpg"));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, 0, 0, null);
        g2.setColor(Color.BLUE);
        for (int i=0; i<yol.size()-1; i++) {
            //g.drawLine(yol.get(i).getKoordinatx(), yol.get(i).getKoordinaty(), yol.get(i+1).getKoordinatx(), yol.get(i+1).getKoordinaty());
            g2.setStroke(new BasicStroke((float) 2.5));
            g2.drawLine(yol.get(i).getKoordinatx(), yol.get(i).getKoordinaty(), yol.get(i+1).getKoordinatx(), yol.get(i+1).getKoordinaty());
        }
        for (int j=0; j<yol.size(); j++) {
            g2.setColor(Color.RED);
            g2.fillOval(yol.get(j).getKoordinatx(), yol.get(j).getKoordinaty(), 10, 10);
        }
        
    }
}
