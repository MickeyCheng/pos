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

public class frmSalesExpense extends javax.swing.JFrame {
ResultSet rs;
Connection conn;
PreparedStatement pstmt;
String getTransactionId;
DecimalFormat df = new DecimalFormat("#.00");
SimpleDateFormat tdf = new SimpleDateFormat("dd/M/YYYY");

    public frmSalesExpense() {
        initComponents();
        doConnect();
        fillTableSales();
    }
    private void fillTableSales(){
        DefaultTableModel model = (DefaultTableModel)tblSales.getModel();
        model.setRowCount(0);
    try{
        int i=0;
        String fillStockSQL = "Select productName,quantity,bdPrice,totalAmount,date from tblreceipt";
        pstmt = conn.prepareStatement(fillStockSQL);
        rs = pstmt.executeQuery();
        tblSales.setModel(DbUtils.resultSetToTableModel(rs));
        
        
        tblSales.getColumnModel().getColumn(0).setHeaderValue("Name");
        tblSales.getColumnModel().getColumn(1).setHeaderValue("Qty");  
        tblSales.getColumnModel().getColumn(2).setHeaderValue("Price");  
        tblSales.getColumnModel().getColumn(3).setHeaderValue("Amount");  
        tblSales.getColumnModel().getColumn(4).setHeaderValue("Date");        
    }catch(SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
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
        tblSales.setModel(DbUtils.resultSetToTableModel(rs));
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
        tblSales = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblExpense = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        datePicker = new com.toedter.calendar.JDateChooser();
        btnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalGross = new javax.swing.JLabel();
        lblExpense = new javax.swing.JLabel();
        lblNet = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSalesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSales);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 450, 170));

        tblExpense.setModel(new javax.swing.table.DefaultTableModel(
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
        tblExpense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExpenseMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblExpense);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 440, 170));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 10, 170));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Expense");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 140, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Sales");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 30));
        jPanel2.add(datePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 260));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Net Sales:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gross Sales:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Expense:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 30));

        lblTotalGross.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblTotalGross.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblTotalGross, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 150, 30));

        lblExpense.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblExpense.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblExpense, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 150, 30));

        lblNet.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblNet.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblNet, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, 30));

        jButton2.setText("Back To Main");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 110, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 940, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalesMouseClicked
        int row = tblSales.getSelectedRow();
        int ba = tblSales.convertRowIndexToModel(row);
        getTransactionId = (tblSales.getModel().getValueAt(ba, 1)).toString();
        String tableQuery = "SELECT * from tblReceipt where transactionId=?";
        
        try{
            pstmt = conn.prepareStatement(tableQuery);
            pstmt.setString(1, getTransactionId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                lblExpense.setText(String.valueOf(df.format(rs.getFloat("amountPaid"))));
                lblNet.setText(String.valueOf(df.format(rs.getFloat("amountChange"))));
                lblTotalGross.setText(String.valueOf(df.format(rs.getFloat("totalAmount"))));
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }//GEN-LAST:event_tblSalesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frmModulePicker obj = new frmModulePicker();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblExpenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExpenseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblExpenseMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    //fill Sales
        DefaultTableModel model = (DefaultTableModel)tblSales.getModel();
        model.setRowCount(0);
    try{
        String fillStockSQL = "Select productName,quantity,bdPrice,totalAmount,date from tblreceipt where date=?";
        pstmt = conn.prepareStatement(fillStockSQL);
        pstmt.setString(1, tdf.format(datePicker.getDate()));
        rs = pstmt.executeQuery();
        tblSales.setModel(DbUtils.resultSetToTableModel(rs));
        tblSales.getColumnModel().getColumn(0).setHeaderValue("Name");
        tblSales.getColumnModel().getColumn(1).setHeaderValue("Qty");  
        tblSales.getColumnModel().getColumn(2).setHeaderValue("Price");  
        tblSales.getColumnModel().getColumn(3).setHeaderValue("Amount");  
        tblSales.getColumnModel().getColumn(4).setHeaderValue("Date");  
       //get sum
        double sumSales = 0;
        for(int i = 0; i < tblSales.getRowCount(); i++)
        {
            sumSales = sumSales + Double.parseDouble(tblSales.getValueAt(i,2).toString());
        }
        
        lblTotalGross.setText(Double.toString(sumSales));
     
    }catch(SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    
    //fill expense
        DefaultTableModel modelExpense = (DefaultTableModel)tblExpense.getModel();
        modelExpense.setRowCount(0);
    try{
        String fillStockSQL = "Select expense_name,expense_amount,expense_status, expense_date from tblexpense where expense_date=? "
                + "and expense_status=?"
                + "order by expense_status asc";
        pstmt = conn.prepareStatement(fillStockSQL);
        pstmt.setString(1, tdf.format(datePicker.getDate()));
        pstmt.setString(2, "Approved");
        rs = pstmt.executeQuery();
        tblExpense.setModel(DbUtils.resultSetToTableModel(rs));
        tblExpense.getColumnModel().getColumn(0).setHeaderValue("Name");
        tblExpense.getColumnModel().getColumn(1).setHeaderValue("Amount");  
        tblExpense.getColumnModel().getColumn(2).setHeaderValue("Status");  
        tblExpense.getColumnModel().getColumn(3).setHeaderValue("Date");  
        //get total expense
        double sumExpense = 0;
        for(int i = 0; i < tblExpense.getRowCount(); i++)
        {
            sumExpense = sumExpense + Double.parseDouble(tblExpense.getValueAt(i,1).toString());
        }
        
        lblExpense.setText(Double.toString(sumExpense));
    }catch(SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
        Double getNet = Double.parseDouble(lblTotalGross.getText()) - Double.parseDouble(lblExpense.getText());
        lblNet.setText(getNet.toString());
        
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(frmSalesExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSalesExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSalesExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSalesExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSalesExpense().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser datePicker;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblExpense;
    private javax.swing.JLabel lblNet;
    private javax.swing.JLabel lblTotalGross;
    private javax.swing.JTable tblExpense;
    private javax.swing.JTable tblSales;
    // End of variables declaration//GEN-END:variables
}
