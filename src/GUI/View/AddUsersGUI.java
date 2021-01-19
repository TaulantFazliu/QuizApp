package GUI.View;

import BLL.Perdoruesi;
import BLL.Roli;
import DAL.PerdoruesiRepository;
import DAL.CrudFormException;
import DAL.RoliRepository;
import GUI.Model.PerdoruesiTableModel;
import GUI.Model.RoliComboBoxModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class AddUsersGUI extends javax.swing.JFrame {

    PerdoruesiRepository pr = new PerdoruesiRepository();
    RoliRepository ppr = new RoliRepository();
    PerdoruesiTableModel ptm = new PerdoruesiTableModel();
    RoliComboBoxModel pcmb = new RoliComboBoxModel();
    
    public AddUsersGUI() {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
        setLocationRelativeTo(null);
        loadComboBox();
    }

   public void loadTable(){
        try{
            List<Perdoruesi> lista = pr.findAll();
            ptm.addList(lista);
            table.setModel(ptm);
            ptm.fireTableDataChanged();
        }catch(CrudFormException ex){
            Logger.getLogger(AddUsersGUI.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    Perdoruesi p = ptm.getPerdoruesi(selectedIndex);
                    username.setText(p.getUsername().toString());
                    pasi.setText(p.getPassword().toString());
                  //  roli.setText(p.getRoliID().toString());
                    pcmb.setSelectedItem((p.getRoliID()));
                    RoliCombo.repaint();
                   
                }
            }
        });
    }
     public void loadComboBox(){
        try{
            List<Roli> lista = ppr.findAll();
            pcmb.add(lista);
            RoliCombo.setModel((ComboBoxModel)pcmb);
            RoliCombo.repaint();
        }catch(CrudFormException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        pasi = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        RoliCombo = new javax.swing.JComboBox();
        shto = new javax.swing.JButton();
        anulo = new javax.swing.JButton();
        fshij = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 220, 30));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setText("Username:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 170, 30));

        pasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasiActionPerformed(evt);
            }
        });
        getContentPane().add(pasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 220, 30));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setText("Password:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 170, 30));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setText("Roli:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 170, 30));

        RoliCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Profesor", "Student" }));
        getContentPane().add(RoliCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 220, 30));

        shto.setBackground(new java.awt.Color(51, 51, 51));
        shto.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        shto.setForeground(new java.awt.Color(255, 255, 0));
        shto.setText("Shto");
        shto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        shto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        shto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoActionPerformed(evt);
            }
        });
        getContentPane().add(shto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 100, 30));

        anulo.setBackground(new java.awt.Color(51, 51, 51));
        anulo.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        anulo.setForeground(new java.awt.Color(255, 255, 0));
        anulo.setText("Anulo");
        anulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        anulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        anulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anuloActionPerformed(evt);
            }
        });
        getContentPane().add(anulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 100, 30));

        fshij.setBackground(new java.awt.Color(51, 51, 51));
        fshij.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        fshij.setForeground(new java.awt.Color(255, 255, 0));
        fshij.setText("Fshij");
        fshij.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fshij.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fshij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshijActionPerformed(evt);
            }
        });
        getContentPane().add(fshij, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 100, 30));

        table.setBackground(new java.awt.Color(51, 51, 51));
        table.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 520, 150));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel7.setText("Shto përdorues të rinjë");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed
    public void clear(){
                            table.clearSelection();
                            username.setText("");
                            pasi.setText("");
                            RoliCombo.repaint();
                           pcmb.setSelectedItem(null);
        

                        }
    private void pasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pasiActionPerformed

    private void shtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoActionPerformed
        if(username.getText() == " " || username.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Nuk keni shtypur username!");
        }
        else if(pasi.getText() == " " || pasi.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Nuk keni shtypur password!");
        }
        else if(RoliCombo.getSelectedItem() == null || RoliCombo.getSelectedItem() == " "){
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asnje rol");
        }
        else
        try{
            int row = table.getSelectedRow();
            if(row == -1){
                Perdoruesi p = new Perdoruesi();
                p.setUsername(username.getText());
                p.setPassword(pasi.getText());
                p.setRoliID((Roli)pcmb.getSelectedItem());
                pr.create(p);
            }else{
                Perdoruesi p = ptm.getPerdoruesi(row);
                p.setUsername(username.getText());
                p.setPassword(pasi.getText());
                p.setRoliID((Roli)pcmb.getSelectedItem());
                pr.edit(p);
            }

            clear();
            loadTable();
        }catch(CrudFormException ex){
            JOptionPane.showMessageDialog(this, "E dhena ekziston!");
        }
    }//GEN-LAST:event_shtoActionPerformed

    private void anuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anuloActionPerformed
        clear();
    }//GEN-LAST:event_anuloActionPerformed

    private void fshijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshijActionPerformed
        int row = table.getSelectedRow();
        if(row != -1){
            Object[] ob = {"Po","Jo"};
            int i = JOptionPane.showOptionDialog(this,"A deshironi ta fshini?","Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if(i == 0){
                Perdoruesi p = ptm.getPerdoruesi(row);
                try{
                    pr.delete(p);
                }catch(CrudFormException ex){
                    JOptionPane.showMessageDialog(this,ex.getMessage());
                }
                clear();
                loadTable();
            }else{
                clear();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_fshijActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddUsersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUsersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUsersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUsersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUsersGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox RoliCombo;
    private javax.swing.JButton anulo;
    private javax.swing.JButton fshij;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pasi;
    private javax.swing.JButton shto;
    private javax.swing.JTable table;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
