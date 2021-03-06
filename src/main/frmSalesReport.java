package main;

import java.io.File;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class frmSalesReport extends javax.swing.JFrame {
ResultSet rs;
Connection conn;
PreparedStatement pstmt;
String getTransactionId;
DecimalFormat df = new DecimalFormat("#.00");
SimpleDateFormat tdf = new SimpleDateFormat("dd/M/YYYY");

    public frmSalesReport() {
        initComponents();
        doConnect();
        fillTable();
        fillTableStock();
    }
    private void fillTableStock(){
        DefaultTableModel model = (DefaultTableModel)tableStock.getModel();
        model.setRowCount(0);
    try{
        int i=0;
        String fillStockSQL = "Select product_name,product_qoh from tblwrs_product order by product_name";
        pstmt = conn.prepareStatement(fillStockSQL);
        rs = pstmt.executeQuery();
        while (rs.next()){
            Object[] adRow={rs.getString(1), rs.getString(2)};
            model.addRow(adRow);
        }
        tableStock.getColumnModel().getColumn(0).setHeaderValue("ITEM");
        tableStock.getColumnModel().getColumn(1).setHeaderValue("QOH");        
    }catch(SQLException e){
        e.getMessage();
    }
    }
private void doConnect(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","rootroot");
    }catch(SQLException | ClassNotFoundException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
private void fillTable(){
    try{
        pstmt = conn.prepareStatement("Select * from tblReceipt order by transactionId DESC");
        rs = pstmt.executeQuery();
        tableReceipt.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(SQLException e){
        e.getMessage();
    }
}
private void sortTable(){

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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReceipt = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        lblAmountPaid = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        datePicker = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStock = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableReceipt.setModel(new javax.swing.table.DefaultTableModel(
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
        tableReceipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReceiptMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableReceipt);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 920, 180));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 200));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("View Receipt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 120, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHANGE:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL AMOUNT:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AMOUNT PAID:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 30));

        lblTotalAmount.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblTotalAmount.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 150, 30));

        lblAmountPaid.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblAmountPaid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblAmountPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 150, 30));

        lblChange.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblChange.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, 30));

        jButton2.setText("Back To Main");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 480, 280));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(datePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 180, 40));

        jButton3.setText("View Sales Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 210, 40));

        tableStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tableStock);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, 190));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 440, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableReceiptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReceiptMouseClicked
        int row = tableReceipt.getSelectedRow();
        int ba = tableReceipt.convertRowIndexToModel(row);
        getTransactionId = (tableReceipt.getModel().getValueAt(ba, 1)).toString();
        String tableQuery = "SELECT * from tblReceipt where transactionId=?";
        
        try{
            pstmt = conn.prepareStatement(tableQuery);
            pstmt.setString(1, getTransactionId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                lblAmountPaid.setText(String.valueOf(df.format(rs.getFloat("amountPaid"))));
                lblChange.setText(String.valueOf(df.format(rs.getFloat("amountChange"))));
                lblTotalAmount.setText(String.valueOf(df.format(rs.getFloat("totalAmount"))));
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }//GEN-LAST:event_tableReceiptMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Map param = new HashMap();
        param.put("tranId", getTransactionId);
        try{
            conn.close();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","rootroot");
            JasperDesign jd = JRXmlLoader.load(new File("src/reports/repReceipt.jrxml"));
           
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param,conn);
            JasperViewer.viewReport(jp,false);

        }catch(ClassNotFoundException | SQLException | JRException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frmModulePicker obj = new frmModulePicker();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int itemSelected= JOptionPane.showConfirmDialog(this, "GENERATE SALES?","SALES",JOptionPane.YES_NO_OPTION);
        if (itemSelected==JOptionPane.YES_OPTION){
            
            Map param = new HashMap();
            param.put("date", String.valueOf(tdf.format(datePicker.getDate())));
            try{
                conn.close();
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","rootroot");
                JasperDesign jd = JRXmlLoader.load(new File("src/Reports/repSalesSummary.jrxml"));
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr, param,conn);
                JasperViewer.viewReport(jp,false);
            }catch(ClassNotFoundException | SQLException | JRException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(frmSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSalesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser datePicker;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAmountPaid;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JTable tableReceipt;
    private javax.swing.JTable tableStock;
    // End of variables declaration//GEN-END:variables
}
