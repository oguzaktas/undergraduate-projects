
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Programlama Laboratuvari II Proje 4
 * @author Oguz Aktas
 */
public class IlanWindow extends javax.swing.JFrame {
    
    /**
     * Creates new form IlanWindow
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public IlanWindow() throws SQLException, ClassNotFoundException {
        initComponents();
        ilanlaritablodaGoster();
        comboboxgetList();
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arac_alisveris", "root", "123456");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Veritabanina baglanti saglanamadi");
        }
        return null;
    }
    
    public boolean checkInputs() {
        if (text_ilanadi.getText().trim().isEmpty() || text_fiyat.getText().trim().isEmpty() || text_km.getText().trim().isEmpty() || text_tarih.getDate() == null) {
            return false;
        } else {
            try {
                Float.parseFloat(text_fiyat.getText());
                Float.parseFloat(text_km.getText());
                return true;
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }
    
    public ArrayList<Ilan> getIlanList() throws SQLException, ClassNotFoundException {
        ArrayList<Ilan> ilanlistesi = new ArrayList<Ilan>();
        Connection conn = getConnection();
        String query = "SELECT * FROM Tbl_Ilan;";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Ilan ilan;
            while(rs.next()) {
                ilan = new Ilan(rs.getInt("IlanID"), rs.getString("Ilan_Adi"), Float.parseFloat(rs.getString("Ilan_Fiyat")), Float.parseFloat(rs.getString("Ilan_Km")), rs.getString("Ilan_Tarih"), rs.getInt("Ilan_ArabaID"), rs.getInt("Ilan_SehirID"));
                ilanlistesi.add(ilan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ilanlistesi;
    }
    
    public void comboboxgetList() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        String query = "SELECT * FROM Tbl_Araba;";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                combobox_arabaid.addItem(rs.getString("ArabaID"));
            }
            query = "SELECT * FROM Tbl_Sehir;";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                combobox_sehir.addItem(rs.getString("Sehir"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ilanlaritablodaGoster() throws SQLException, ClassNotFoundException {
        ArrayList<Ilan> list = getIlanList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] kayit = new Object[7];
        for (int i=0; i < list.size(); i++) {
            kayit[0] = list.get(i).getId();
            kayit[1] = list.get(i).getIlanadi();
            kayit[2] = list.get(i).getFiyat();
            kayit[3] = list.get(i).getKm();
            kayit[4] = list.get(i).getTarih();
            kayit[5] = list.get(i).getArabaid();
            kayit[6] = list.get(i).getSehirid();
            model.addRow(kayit);
        }
    }
    
    public void showItem(int index) throws SQLException, ClassNotFoundException {
        text_id.setText(Integer.toString(getIlanList().get(index).getId()));
        text_ilanadi.setText(getIlanList().get(index).getIlanadi());
        text_fiyat.setText(Float.toString(getIlanList().get(index).getFiyat()));
        text_km.setText(Float.toString(getIlanList().get(index).getKm()));
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse((String) getIlanList().get(index).getTarih());
            text_tarih.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        combobox_arabaid.setSelectedItem(Integer.toString(getIlanList().get(index).getArabaid()));
        combobox_sehir.setSelectedIndex((getIlanList().get(index).getSehirid())-1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_arabaid = new javax.swing.JLabel();
        label_id = new javax.swing.JLabel();
        label_ilanadi = new javax.swing.JLabel();
        label_fiyat = new javax.swing.JLabel();
        label_km = new javax.swing.JLabel();
        label_tarih = new javax.swing.JLabel();
        label_sehirid = new javax.swing.JLabel();
        text_ilanadi = new javax.swing.JTextField();
        text_id = new javax.swing.JTextField();
        text_fiyat = new javax.swing.JTextField();
        text_km = new javax.swing.JTextField();
        text_tarih = new com.toedter.calendar.JDateChooser();
        Btn_Update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Btn_Menu = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_Insert = new javax.swing.JButton();
        combobox_sehir = new javax.swing.JComboBox<>();
        combobox_arabaid = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        label_arabaid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_arabaid.setText("Araba ID : ");

        label_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_id.setText("Ilan ID : ");

        label_ilanadi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_ilanadi.setText("Ilan Adi : ");

        label_fiyat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_fiyat.setText("Fiyat : ");

        label_km.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_km.setText("Km : ");

        label_tarih.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_tarih.setText("Tarih : ");

        label_sehirid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_sehirid.setText("Sehir : ");

        text_ilanadi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_ilanadi.setPreferredSize(new java.awt.Dimension(69, 39));
        text_ilanadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_ilanadiActionPerformed(evt);
            }
        });

        text_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_id.setPreferredSize(new java.awt.Dimension(69, 39));
        text_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_idActionPerformed(evt);
            }
        });

        text_fiyat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_fiyat.setPreferredSize(new java.awt.Dimension(69, 39));
        text_fiyat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_fiyatActionPerformed(evt);
            }
        });

        text_km.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_km.setPreferredSize(new java.awt.Dimension(69, 39));
        text_km.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_kmActionPerformed(evt);
            }
        });

        text_tarih.setDateFormatString("yyyy-MM-dd");
        text_tarih.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        text_tarih.setPreferredSize(new java.awt.Dimension(100, 39));

        Btn_Update.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java/icons/update.png"))); // NOI18N
        Btn_Update.setText("Update");
        Btn_Update.setIconTextGap(10);
        Btn_Update.setPreferredSize(new java.awt.Dimension(131, 51));
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ilan ID", "Ilan Adi", "Fiyat", "Km", "Tarih", "Araba ID", "Sehir ID"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Btn_Menu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Btn_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java/icons/home.png"))); // NOI18N
        Btn_Menu.setText("Ana Ekrana Git");
        Btn_Menu.setIconTextGap(10);
        Btn_Menu.setPreferredSize(new java.awt.Dimension(180, 51));
        Btn_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MenuActionPerformed(evt);
            }
        });

        Btn_Delete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java/icons/delete.png"))); // NOI18N
        Btn_Delete.setText("Delete");
        Btn_Delete.setIconTextGap(10);
        Btn_Delete.setPreferredSize(new java.awt.Dimension(131, 51));
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        Btn_Insert.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Btn_Insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java/icons/add.png"))); // NOI18N
        Btn_Insert.setText("Insert");
        Btn_Insert.setIconTextGap(10);
        Btn_Insert.setPreferredSize(new java.awt.Dimension(180, 51));
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        combobox_sehir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        combobox_arabaid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_arabaid.setMinimumSize(new java.awt.Dimension(60, 23));
        combobox_arabaid.setPreferredSize(new java.awt.Dimension(60, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_sehirid)
                                    .addComponent(label_id)
                                    .addComponent(label_ilanadi)
                                    .addComponent(label_fiyat)
                                    .addComponent(label_km)
                                    .addComponent(label_tarih)
                                    .addComponent(label_arabaid))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(text_tarih, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(text_km, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_fiyat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_ilanadi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combobox_sehir, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combobox_arabaid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Btn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(Btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_id)
                            .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_ilanadi)
                            .addComponent(text_ilanadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_fiyat)
                            .addComponent(text_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_km)
                            .addComponent(text_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(text_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(label_tarih)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_arabaid)
                            .addComponent(combobox_arabaid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_sehirid)
                            .addComponent(combobox_sehir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(Btn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_ilanadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_ilanadiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_ilanadiActionPerformed

    private void text_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_idActionPerformed

    private void text_fiyatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_fiyatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_fiyatActionPerformed

    private void text_kmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_kmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_kmActionPerformed

    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
        if (checkInputs() && text_id.getText() != null) {
            String query = null;
            Connection conn = null;
            try {
                conn = getConnection();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement ps = null;
            query = "UPDATE Tbl_Ilan SET Ilan_Adi = ?, Ilan_Fiyat = ?, Ilan_Km = ?, Ilan_Tarih = ?, Ilan_ArabaID = ?, Ilan_SehirID = ? WHERE IlanID = ?;";
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1, text_ilanadi.getText());
                ps.setString(2, text_fiyat.getText());
                ps.setString(3, text_km.getText());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(text_tarih.getDate());
                ps.setString(4, date);
                ps.setString(5, (String) combobox_arabaid.getSelectedItem());
                ps.setInt(6, combobox_sehir.getSelectedIndex()+1);
                ps.setInt(7, Integer.parseInt(text_id.getText()));
                ps.executeUpdate();
                ilanlaritablodaGoster();
                JOptionPane.showMessageDialog(null, "Kayit guncellendi.");
            } catch (SQLException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Kayit guncelleme sirasinda hata olustu.");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bir ya da daha fazla alani bos biraktiniz.");
        }
    }//GEN-LAST:event_Btn_UpdateActionPerformed

    private void Btn_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MenuActionPerformed
        this.dispose();
        new MainWindow().setVisible(true);
    }//GEN-LAST:event_Btn_MenuActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        if(!text_id.getText().equals("")) {
            Connection conn = null;
            try {
                conn = getConnection();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Tbl_Ilan WHERE IlanID = ?;");
                int id = Integer.parseInt(text_id.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                ilanlaritablodaGoster();
                JOptionPane.showMessageDialog(null, "Kayit silindi.");
            } catch (SQLException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Kayit silinme sirasinda hata olustu.");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kayit silinemedi. Dogru ID numarasini girdiginizden emin olun.");
        }
    }//GEN-LAST:event_Btn_DeleteActionPerformed
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        try {
            showItem(index);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
        if (checkInputs()) {
            Connection conn = null;
            try {
                conn = getConnection();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement ps = null;
            try {
                if (text_id.getText().trim().isEmpty()) {
                    ps = conn.prepareStatement("INSERT INTO Tbl_Ilan(Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES(?, ?, ?, ?, ?, ?);");
                    ps.setString(1, text_ilanadi.getText());
                    ps.setString(2, text_fiyat.getText());
                    ps.setString(3, text_km.getText());
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String date = df.format(text_tarih.getDate());
                    ps.setString(4, date);
                    ps.setString(5, (String) combobox_arabaid.getSelectedItem());
                    ps.setInt(6, combobox_sehir.getSelectedIndex()+1);
                } else {
                    ps = conn.prepareStatement("INSERT INTO Tbl_Ilan(IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES(?, ?, ?, ?, ?, ?, ?);");
                    ps.setString(1, text_id.getText());
                    ps.setString(2, text_ilanadi.getText());
                    ps.setString(3, text_fiyat.getText());
                    ps.setString(4, text_km.getText());
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String date = df.format(text_tarih.getDate());
                    ps.setString(5, date);
                    ps.setString(6, (String) combobox_arabaid.getSelectedItem());
                    ps.setInt(7, combobox_sehir.getSelectedIndex()+1);
                }
                ps.executeUpdate();
                ilanlaritablodaGoster();
                JOptionPane.showMessageDialog(null, "Kayit eklendi.");
            } catch (SQLException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Kayit ekleme sirasinda hata olustu.");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IlanWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bir ya da daha fazla alani bos biraktiniz.");
        }
    }//GEN-LAST:event_Btn_InsertActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Menu;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JComboBox<String> combobox_arabaid;
    private javax.swing.JComboBox<String> combobox_sehir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_arabaid;
    private javax.swing.JLabel label_fiyat;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_ilanadi;
    private javax.swing.JLabel label_km;
    private javax.swing.JLabel label_sehirid;
    private javax.swing.JLabel label_tarih;
    private javax.swing.JTextField text_fiyat;
    private javax.swing.JTextField text_id;
    private javax.swing.JTextField text_ilanadi;
    private javax.swing.JTextField text_km;
    private com.toedter.calendar.JDateChooser text_tarih;
    // End of variables declaration//GEN-END:variables
}
