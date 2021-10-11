
import SanPham.SanPham;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class QuanLySanPham extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySanPham
     */
    public QuanLySanPham() {
        initComponents();
        setLocationRelativeTo(null);
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
        themMoi = new javax.swing.JButton();
        tim = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        display = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outPut = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quan ly san pham");
        setResizable(false);

        themMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        themMoi.setText("Them moi");
        themMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMoiActionPerformed(evt);
            }
        });

        tim.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tim.setText("Tim sp theo ma");
        tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timActionPerformed(evt);
            }
        });

        xoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        xoa.setText("Xoa sp theo ma");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });

        sua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sua.setText("Sua ten sp theo ma");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });

        display.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        display.setText("Hien danh sach");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
            }
        });

        outPut.setColumns(20);
        outPut.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        outPut.setRows(5);
        jScrollPane1.setViewportView(outPut);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(themMoi)
                        .addGap(18, 18, 18)
                        .addComponent(tim)
                        .addGap(18, 18, 18)
                        .addComponent(xoa)
                        .addGap(18, 18, 18)
                        .addComponent(sua))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(display)
                .addGap(340, 340, 340))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoa)
                    .addComponent(tim)
                    .addComponent(sua)
                    .addComponent(themMoi))
                .addGap(66, 66, 66)
                .addComponent(display)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
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

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        // TODO add your handling code here:
        if(list.isEmpty()) {outPut.setText("Danh sach rong, hay them moi san pham!"); return;}
        xtm.dispose();
        xtm = new XoaTheoMa();
        xtm.setVisible(true);
    }//GEN-LAST:event_xoaActionPerformed

    private void themMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMoiActionPerformed
        // TODO add your handling code here:'
        tm.dispose();
        tm = new ThemMoi();
        tm.setVisible(true);
    }//GEN-LAST:event_themMoiActionPerformed

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
        // TODO add your handling code here:
        if(list.isEmpty()) {outPut.setText("Danh sach rong, hay them moi san pham!"); return;}
        outPut.setText(null);
        for (SanPham sanPham : list) {
            outPut.append(sanPham + "\n");
        }
    }//GEN-LAST:event_displayActionPerformed

    private void timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timActionPerformed
        // TODO add your handling code here:
        if(list.isEmpty()) {outPut.setText("Danh sach rong, hay them moi san pham!"); return;}
        tk.dispose();
        tk = new TimTheoMa();
        tk.setVisible(true);
    }//GEN-LAST:event_timActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        // TODO add your handling code here:
        if(list.isEmpty()) {outPut.setText("Danh sach rong, hay them moi san pham!"); return;}
        stm.dispose();
        stm = new SuaTheoMa();
        stm.setVisible(true);
    }//GEN-LAST:event_suaActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySanPham().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton display;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outPut;
    private javax.swing.JButton sua;
    private javax.swing.JButton themMoi;
    private javax.swing.JButton tim;
    private javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables
    
    public static List<SanPham> list = new ArrayList<>();
    ThemMoi tm = new ThemMoi();
    TimTheoMa tk = new TimTheoMa();
    XoaTheoMa xtm = new XoaTheoMa();
    SuaTheoMa stm = new SuaTheoMa();
}