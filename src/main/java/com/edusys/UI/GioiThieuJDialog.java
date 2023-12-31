
package com.edusys.UI;

import com.edusys.Utils.XImages;
import javax.swing.JOptionPane;


public class GioiThieuJDialog extends javax.swing.JDialog {
    void init(){
        setIconImage(XImages.getAppIcon());
        setLocationRelativeTo(null);
        setTitle(" EDUSYS ĐĂNG NHẬP HỆ THỐNG");
      
    }
    /**
     * Creates new form GioiThieuJDialog
     */
    public GioiThieuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGioiThieu = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/images/logo-small.png"))); // NOI18N
        getContentPane().add(jLabel3, java.awt.BorderLayout.PAGE_START);

        txtGioiThieu.setEditable(false);
        txtGioiThieu.setPreferredSize(new java.awt.Dimension(62, 180));
        txtGioiThieu.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtGioiThieuAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(txtGioiThieu);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGioiThieuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtGioiThieuAncestorAdded
        txtGioiThieu.setText("Polypro là dự án mẫu. Mục tiêu chính là huấn luyện sinh viên qui trình thực hiên dự án. \n\n"
            + "Mục tiêu của dự án này là để rèn luyện kỹ năng IO(CDIO) tức không yêu cầu sinh viên phải\nthu thập phân tích mà chỉ thực hiên và vận hành một phần mềm chuẩn bị cho các dự án \nsau này. Các kỹ năng CD (Trong CDIO sẽ được huấn luyện ở dự án 1 và dự án 2.)\n\n"
            + "Yêu cầu về môi trường\n"
            + "1.Hệ điều hành bất kỳ\n"
            + "2.IDK 1.8 trở lên\n"
            + "3.SQL Sever 2008 trở lên");
    }//GEN-LAST:event_txtGioiThieuAncestorAdded

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
            java.util.logging.Logger.getLogger(GioiThieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GioiThieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GioiThieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GioiThieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GioiThieuJDialog dialog = new GioiThieuJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txtGioiThieu;
    // End of variables declaration//GEN-END:variables
}
