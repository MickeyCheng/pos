package main;
import java.io.File;
import static java.lang.Thread.sleep;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import sun.swing.table.*;

public class frmOrdering extends javax.swing.JFrame {
ResultSet rs;
Connection conn;
PreparedStatement pstmt;
int showOrderQty =0;
SimpleDateFormat df = new SimpleDateFormat("dd/M/YYYY");
    public frmOrdering() {
        initComponents();
        doConnect();
        fillTable();
        setLocationRelativeTo(null);
        tableMinimum.setAutoCreateRowSorter(true);
        tableReceive.setAutoCreateRowSorter(true);
        tableOrder.setAutoCreateRowSorter(true);
        sortTableOrder();
    }
private void fillTable(){
    try{
        pstmt = conn.prepareStatement("SELECT * from tblProduct");
        rs = pstmt.executeQuery();
        tableMinimum.setModel(DbUtils.resultSetToTableModel(rs));
        sortTable();
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
private void sortTable(){    
    
tableMinimum.getColumnModel().getColumn(0).setHeaderValue("BARCODE");
tableMinimum.getColumnModel().getColumn(1).setHeaderValue("NAME");
tableMinimum.getColumnModel().getColumn(2).setHeaderValue("U/PRICE");
tableMinimum.getColumnModel().getColumn(3).setHeaderValue("CATEGORY");
tableMinimum.getColumnModel().getColumn(4).setHeaderValue("QTY");
tableMinimum.getColumnModel().getColumn(5).setHeaderValue("MIN ORDER");
tableMinimum.getColumnModel().getColumn(6).setHeaderValue("MAX ORDER");

tableMinimum.removeColumn(tableMinimum.getColumnModel().getColumn(6));
tableMinimum.removeColumn(tableMinimum.getColumnModel().getColumn(3));
tableMinimum.removeColumn(tableMinimum.getColumnModel().getColumn(2));
tableMinimum.removeColumn(tableMinimum.getColumnModel().getColumn(0));

DefaultTableCellHeaderRenderer renderer = (DefaultTableCellHeaderRenderer)tableMinimum.getTableHeader().getDefaultRenderer();
renderer.setHorizontalAlignment(JLabel.CENTER);
DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
rightRenderer.setHorizontalAlignment(JLabel.CENTER);
tableMinimum.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
tableMinimum.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
tableMinimum.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCategory = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMinimum = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSoh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMax = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtOrderQty = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        dateOrder = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        radOthers = new javax.swing.JRadioButton();
        radBread = new javax.swing.JRadioButton();
        radKitchen = new javax.swing.JRadioButton();
        radPastries = new javax.swing.JRadioButton();
        radStore = new javax.swing.JRadioButton();
        btnCategoryFill = new javax.swing.JButton();
        radCake = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnCritical = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        datePicker = new com.toedter.calendar.JDateChooser();
        btnShowOrder = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        btnReceiveAll = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblReceiveOrder = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblReceiveQtyOrder = new javax.swing.JLabel();
        lblReceiveCategory = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableReceive = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        btnClearOrder = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableMinimum.setModel(new javax.swing.table.DefaultTableModel(
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
        tableMinimum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMinimumMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableMinimumMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tableMinimum);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 580, 410));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 270, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ORDER DATE:");
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 120, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STOCK ON HAND:");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 40));

        lblSoh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoh.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lblSoh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 120, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MIN LEVEL:");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 40));

        lblMin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMin.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lblMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MAX LEVEL:");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 120, 40));

        lblMax.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMax.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lblMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 120, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("QTY TO ORDER:");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 40));

        txtOrderQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderQtyActionPerformed(evt);
            }
        });
        jPanel10.add(txtOrderQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 110, 40));

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("0");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 50, -1));

        jButton4.setText("1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, -1));

        jButton5.setText("2");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 50, -1));

        jButton6.setText("3");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 50, -1));

        jButton7.setText("4");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, -1));

        jButton8.setText("5");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 50, -1));

        jButton9.setText("6");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 50, -1));

        jButton10.setText("7");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, -1));

        jButton11.setText("8");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 50, -1));

        jButton13.setText("CLEAR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 10, 70, 100));

        jButton18.setText("9");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 50, -1));

        jPanel10.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 290, 150));

        jButton12.setText("ORDER");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, 130));

        jButton14.setText("MAX");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, 40));

        jButton15.setText("MIN");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CATEGORY");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 120, 40));

        lblCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 120, 40));
        jPanel10.add(dateOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 120, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ITEM NAME:");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 40));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 590, 360));

        jToggleButton2.setText("RE-PRINT ORDER");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 90, 50));

        jTabbedPane2.addTab("ORDER FORM", jPanel3);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 710, 410));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCategory.add(radOthers);
        radOthers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radOthers.setText("OTHERS");
        radOthers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radOthersActionPerformed(evt);
            }
        });
        jPanel9.add(radOthers, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 130, 40));

        btnCategory.add(radBread);
        radBread.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radBread.setText("BREAD");
        radBread.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        radBread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBreadActionPerformed(evt);
            }
        });
        jPanel9.add(radBread, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 40));

        btnCategory.add(radKitchen);
        radKitchen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radKitchen.setText("KITCHEN");
        radKitchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radKitchenActionPerformed(evt);
            }
        });
        jPanel9.add(radKitchen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 40));

        btnCategory.add(radPastries);
        radPastries.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radPastries.setText("PASTRIES");
        radPastries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPastriesActionPerformed(evt);
            }
        });
        jPanel9.add(radPastries, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 130, 40));

        btnCategory.add(radStore);
        radStore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radStore.setText("STORE");
        radStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radStoreActionPerformed(evt);
            }
        });
        jPanel9.add(radStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 130, 40));

        btnCategoryFill.setText("VIEW CRITICAL ITEMS");
        btnCategoryFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryFillActionPerformed(evt);
            }
        });
        jPanel9.add(btnCategoryFill, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 250, 40));

        btnCategory.add(radCake);
        radCake.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radCake.setText("CAKE");
        radCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCakeActionPerformed(evt);
            }
        });
        jPanel9.add(radCake, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 130, 40));

        jButton2.setText("VIEW ALL BY CATEGORY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 40));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 480, 160));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 500, 180));

        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 70));

        btnCritical.setText("CRITICAL");
        btnCritical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriticalActionPerformed(evt);
            }
        });
        jPanel1.add(btnCritical, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, 80));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableOrder);

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 140));

        jButton16.setText("SAVE ORDER");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 80, 90));

        jButton17.setText("REMOVE");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 80, 40));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 160));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 710, 180));

        jTabbedPane1.addTab("ORDERING", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(datePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 50));

        btnShowOrder.setText("SHOW ORDER");
        btnShowOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowOrderActionPerformed(evt);
            }
        });
        jPanel6.add(btnShowOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 120, 50));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 640, 150));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 170));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(102, 102, 102));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReceiveAll.setText("PROCESS");
        btnReceiveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceiveAllActionPerformed(evt);
            }
        });
        jPanel14.add(btnReceiveAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 190, 60));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CATEGORY:");
        jPanel14.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 120, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ITEM NAME:");
        jPanel14.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 40));

        lblReceiveOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblReceiveOrder.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(lblReceiveOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 270, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("QTY ORDERED:");
        jPanel14.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 40));

        lblReceiveQtyOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblReceiveQtyOrder.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(lblReceiveQtyOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 120, 40));

        lblReceiveCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblReceiveCategory.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(lblReceiveCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 120, 40));

        jButton30.setText("COMPLETE FILL UP");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 60));

        jPanel7.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, 390));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 630, 410));

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableReceive.setModel(new javax.swing.table.DefaultTableModel(
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
        tableReceive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReceiveMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableReceive);

        jPanel16.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 380));

        jPanel15.setBackground(new java.awt.Color(102, 102, 102));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton19.setText("0");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 40, -1));

        jButton20.setText("1");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, -1));

        jButton21.setText("2");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 40, -1));

        jButton22.setText("3");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 40, -1));

        jButton23.setText("4");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, -1));

        jButton24.setText("5");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, -1));

        jButton25.setText("6");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 40, -1));

        jButton26.setText("7");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 40, -1));

        jButton27.setText("8");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 40, -1));

        btnClearOrder.setText("c");
        btnClearOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearOrderActionPerformed(evt);
            }
        });
        jPanel15.add(btnClearOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 40, -1));

        jButton29.setText("9");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 40, -1));

        jPanel16.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 160, 130));

        jPanel4.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 670, 410));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 640));

        jTabbedPane1.addTab("RECEIVING", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1340, 670));

        jMenu1.setText("File");

        jMenuItem1.setText("MAIN MENU");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriticalActionPerformed
        DefaultTableModel model = (DefaultTableModel)tableMinimum.getModel(); 
        try{
            String viewCriticalSQL = "Select * from tblProduct";
            pstmt = conn.prepareStatement(viewCriticalSQL);
            rs = pstmt.executeQuery();
            while(model.getRowCount()>0){
                model.setRowCount(0);
            }
            while(rs.next()){
                String prodName = rs.getString("productName");
                int getStock = rs.getInt("stockOnHand");
                int getMinimum = rs.getInt("minimumOrder");
                 if (getStock<getMinimum){
                    Object[] adRow = {"",prodName,"","",getStock,getMinimum,""};
                    model.addRow(adRow);
            }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnCriticalActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
frmModulePicker obj = new frmModulePicker();
        obj.setVisible(true);
        this.dispose();
        try{
            conn.close();
            rs.close();
            pstmt.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void radOthersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radOthersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radOthersActionPerformed

    private void radBreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBreadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radBreadActionPerformed

    private void radKitchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radKitchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radKitchenActionPerformed

    private void radPastriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPastriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radPastriesActionPerformed

    private void radStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radStoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radStoreActionPerformed

    private void btnCategoryFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryFillActionPerformed
        String getCategory="";   
            if (radBread.isSelected()){
                getCategory = "Bread";
            }else if (radKitchen.isSelected()){
                getCategory = "Kitchen";
            }else if (radOthers.isSelected()){
                getCategory = "Other";
            }else if (radPastries.isSelected()){
                getCategory = "Pastry";
            }else if (radCake.isSelected()){
                getCategory = "Cake Items";
            }else if (radStore.isSelected()){
                getCategory = "Store Items";
            }
        DefaultTableModel model = (DefaultTableModel)tableMinimum.getModel(); 
        try{
            String viewCriticalSQL = "Select * from tblProduct where category=?";
            pstmt = conn.prepareStatement(viewCriticalSQL);
            pstmt.setString(1,getCategory);
            rs = pstmt.executeQuery();
            while(model.getRowCount()>0){
                model.setRowCount(0);
            }
            while(rs.next()){
                String prodName = rs.getString("productName");
                int getStock = rs.getInt("stockOnHand");
                int getMinimum = rs.getInt("minimumOrder");
                 if (getStock<getMinimum){
                    Object[] adRow = {"",prodName,"","",getStock,getMinimum,""};
                    model.addRow(adRow);
            }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }    
            
        
    }//GEN-LAST:event_btnCategoryFillActionPerformed

    private void radCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCakeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radCakeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String getCategory="";   
            if (radBread.isSelected()){
                getCategory = "Bread";
            }else if (radKitchen.isSelected()){
                getCategory = "Kitchen";
            }else if (radOthers.isSelected()){
                getCategory = "Other";
            }else if (radPastries.isSelected()){
                getCategory = "Pastry";
            }else if (radCake.isSelected()){
                getCategory = "Cake Items";
            }else if (radStore.isSelected()){
                getCategory = "Store Items";
            }
            try{
                pstmt = conn.prepareStatement("Select * from tblProduct where category=?");
                pstmt.setString(1, getCategory);
                rs = pstmt.executeQuery();
                tableMinimum.setModel(DbUtils.resultSetToTableModel(rs));
                sortTable();
            }catch(SQLException e){
                e.getMessage();
            }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableMinimumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMinimumMouseClicked
        int row = tableMinimum.getSelectedRow();
        int ba = tableMinimum.convertRowIndexToModel(row);
        String tblClick = (tableMinimum.getModel().getValueAt(ba, 1).toString());
        String selectedItemSQL = "Select * from tblProduct where productName=?";
        try{
            pstmt = conn.prepareStatement(selectedItemSQL);
            pstmt.setString(1, tblClick);
            rs = pstmt.executeQuery();
            if (rs.next()){
                lblName.setText(rs.getString("productName"));
                lblSoh.setText(String.valueOf(rs.getInt("stockOnHand")));
                lblMin.setText(String.valueOf(rs.getInt("minimumOrder")));
                lblMax.setText(String.valueOf(rs.getInt("maximumOrder")));
                lblCategory.setText(String.valueOf(rs.getString("category")));
            }
            txtOrderQty.setText("");
        }catch(SQLException e){
            e.getMessage();
        }
    }//GEN-LAST:event_tableMinimumMouseClicked

    private void tableMinimumMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMinimumMouseEntered
       
    }//GEN-LAST:event_tableMinimumMouseEntered

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        DefaultTableModel model = (DefaultTableModel)tableOrder.getModel();
        model.removeRow(tableOrder.getSelectedRow());
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        txtOrderQty.setText(lblMin.getText());
        showOrderQty = Integer.valueOf(lblMin.getText());
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        txtOrderQty.setText(lblMax.getText());
        showOrderQty = Integer.valueOf(lblMax.getText());
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DefaultTableModel model = (DefaultTableModel)tableOrder.getModel();
        int duplicateRow = -1;
        if (model.getRowCount() ==0){
            Object [] adRow = {lblName.getText(),lblSoh.getText(), txtOrderQty.getText(),lblCategory.getText()};
            model.addRow(adRow);
        }else{
            for(int j=0;j<model.getRowCount();j++){
                Object obj = model.getValueAt(j, 0);
                if (obj.equals(lblName.getText())){
                    duplicateRow = j;
                    break;
                }
            }
            if (duplicateRow == -1){
                Object [] adRow = {lblName.getText(),lblSoh.getText(), txtOrderQty.getText(),lblCategory.getText()};
                model.addRow(adRow);
            }else{
                int getQty = Integer.valueOf(txtOrderQty.getText()) + Integer.valueOf(model.getValueAt(duplicateRow,1).toString());
                model.setValueAt(lblName.getText(), duplicateRow, 0);
                model.setValueAt(lblSoh.getText(),duplicateRow,1);
                model.setValueAt(getQty,duplicateRow, 2);
                model.setValueAt(lblCategory.getText(), duplicateRow, 3);
            }
        }
        showOrderQty=0;
        txtOrderQty.setText("");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        showOrderQty=0;
        txtOrderQty.setText("");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
txtOrderQty.setText(txtOrderQty.getText() + "8");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
txtOrderQty.setText(txtOrderQty.getText() + "7");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
txtOrderQty.setText(txtOrderQty.getText() + "6");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
txtOrderQty.setText(txtOrderQty.getText() + "5");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
txtOrderQty.setText(txtOrderQty.getText() + "4");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
txtOrderQty.setText(txtOrderQty.getText() + "3");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        txtOrderQty.setText(txtOrderQty.getText() + "2");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtOrderQty.setText(txtOrderQty.getText() + "1");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
txtOrderQty.setText(txtOrderQty.getText() + "0");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtOrderQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderQtyActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
txtOrderQty.setText(txtOrderQty.getText() + "9");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
//add category of products and save in the report
        try{
            for(int i=0; i<tableOrder.getRowCount();i++){
                pstmt = conn.prepareStatement("INSERT INTO tblOrder (productName,qtyOrder,orderDate,category) values(?,?,?,?)");
                pstmt.setString(1,tableOrder.getValueAt(i, 0).toString());
                pstmt.setInt(2,Integer.valueOf(tableOrder.getValueAt(i, 2).toString()));
                pstmt.setString(3, String.valueOf(df.format(dateOrder.getDate())));
                pstmt.setString(4,tableOrder.getValueAt(i, 3).toString());
                pstmt.execute();
                pstmt.close();
            }
            JOptionPane.showMessageDialog(this, "ORDER SAVED FOR: " + String.valueOf(df.format(dateOrder.getDate())));
            DefaultTableModel model = (DefaultTableModel)tableOrder.getModel();
            model.setRowCount(0);
            printOrder();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void btnShowOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowOrderActionPerformed
        Date getDate = datePicker.getDate();
        try{
            String getOrderSQL = "Select * from tblOrder where orderDate=? order by category";
            pstmt = conn.prepareStatement(getOrderSQL);
            pstmt.setString(1,String.valueOf(df.format(getDate)));
            rs = pstmt.executeQuery();
            tableReceive.setModel(DbUtils.resultSetToTableModel(rs));
            pstmt.close();
            sortTableReceive();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnShowOrderActionPerformed

    private void btnReceiveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceiveAllActionPerformed
        processReceiveAll();
    }//GEN-LAST:event_btnReceiveAllActionPerformed
private void processReceiveAll(){
    DefaultTableModel model = (DefaultTableModel)tableReceive.getModel();
        try{
            String receiveAllSQL = "UPDATE tblOrder set orderReceived=? where orderDate=? and productName=?";
            for(int i=0;i<tableReceive.getRowCount();i++){
                pstmt = conn.prepareStatement(receiveAllSQL);
                pstmt.setInt(1,Integer.valueOf(tableReceive.getValueAt(i, 3).toString()));
                pstmt.setString(2,String.valueOf(df.format(datePicker.getDate())));
                pstmt.setString(3, tableReceive.getValueAt(i, 0).toString());
                pstmt.executeUpdate();
                pstmt.close();
            }
                 JOptionPane.showMessageDialog(this, "ALL ORDER RECEIVED FOR DATE: ");
        }catch(SQLException e){
            e.getMessage();
        }
        //fill up all no orders of tblProduct

        // add to SOH
        try{
            String addToStockSQL = "UPDATE tblProduct set stockOnHand= stockOnHand+? where productName=?";
            for(int i=0;i<tableReceive.getRowCount();i++){
                pstmt = conn.prepareStatement(addToStockSQL);
                pstmt.setInt(1,Integer.valueOf(tableReceive.getValueAt(i, 3).toString()));
                pstmt.setString(2, tableReceive.getValueAt(i, 0).toString());
                pstmt.executeUpdate();
                pstmt.close();
            }
        }catch (SQLException e){
            e.getMessage();
        }
        model.setRowCount(0);
}
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("0", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "0", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
                for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("1", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "1", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("2", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "2", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("3", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "3", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("4", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "4", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("5", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "5", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("6", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "6", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("7", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "7", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
            for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("8", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "8", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void btnClearOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearOrderActionPerformed
                for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    if(obj.equals(lblReceiveOrder.getText())){
                        tableReceive.setValueAt("", i, 3);
                    }
                }
    }//GEN-LAST:event_btnClearOrderActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
for(int i=0;i<tableReceive.getRowCount();i++){
                    Object obj= tableReceive.getValueAt(i, 0);
                    String currentQTY = tableReceive.getValueAt(i, 3).toString();
                    if(obj.equals(lblReceiveOrder.getText())){
                        if(currentQTY.equals("")){
                            tableReceive.setValueAt("9", i, 3);
                        }else{
                        tableReceive.setValueAt(currentQTY + "9", i, 3);
                        }
                        }
                }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void tableReceiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReceiveMouseClicked
        int row = tableReceive.getSelectedRow();
        int ba = tableReceive.convertRowIndexToModel(row);
        String tblClick = tableReceive.getModel().getValueAt(ba, 0).toString();
        String getSelectedItem = "Select * from tblOrder where productName=?";
        try{
            pstmt = conn.prepareStatement(getSelectedItem);
            pstmt.setString(1,tblClick);
            rs = pstmt.executeQuery();
            if (rs.next()){
            lblReceiveOrder.setText(tblClick);
            lblReceiveCategory.setText(tableReceive.getValueAt(ba, 2).toString());
            lblReceiveQtyOrder.setText(tableReceive.getValueAt(ba, 1).toString());
            }
            pstmt.close();
            btnClearOrderActionPerformed(null);
        }catch(SQLException e){
            e.getMessage();
        }
    }//GEN-LAST:event_tableReceiveMouseClicked

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        for(int i=0; i<tableReceive.getRowCount();i++){
            tableReceive.setValueAt(tableReceive.getValueAt(i, 1), i, 3);
        }
       
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        printOrder();
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    private void sortTableReceive(){
        tableReceive.removeColumn(tableReceive.getColumnModel().getColumn(2));
        tableReceive.removeColumn(tableReceive.getColumnModel().getColumn(4));
        tableReceive.getColumnModel().getColumn(0).setHeaderValue("ITEM");
        tableReceive.getColumnModel().getColumn(1).setHeaderValue("QTY ORDERED");
        tableReceive.getColumnModel().getColumn(2).setHeaderValue("CATEGORY");
        tableReceive.getColumnModel().getColumn(3).setHeaderValue("QTY RECEIVED");
        
        try{
            pstmt = conn.prepareStatement("SELECT * FROM tblProduct order by category");
            rs = pstmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel)tableReceive.getModel();
            while (rs.next()){
                String getProd = rs.getString("productName");
                int duplicateRow =-1;
                for (int j=0; j<model.getRowCount();j++){
                    Object obj2 = model.getValueAt(j, 0);
                    if (obj2.equals(getProd)){
                        duplicateRow = j;
                        break;
                    }
                }
                if (duplicateRow == -1){
                    Object[] obj = {getProd,"0",rs.getString("category")};
                 model.addRow(obj);
                }
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void printOrder(){
        Map param = new HashMap();
        param.put("date", String.valueOf(df.format(dateOrder.getDate())));
        try{
            conn.close();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","root");
            JasperDesign jd = JRXmlLoader.load(new File("src\\Reports\\repOrder.jrxml"));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param,conn);
            JasperViewer.viewReport(jp,false);

        }catch(ClassNotFoundException | SQLException | JRException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    
    }
    private void sortTableOrder(){
        DefaultTableModel model = (DefaultTableModel)tableOrder.getModel();
        model.setRowCount(0);
        model.addColumn("ITEM NAME");
        model.addColumn("STOCK ON HAND");
        model.addColumn("QTY ORDER");
        model.addColumn("CATEGORY");
    }
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
            java.util.logging.Logger.getLogger(frmOrdering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmOrdering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmOrdering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmOrdering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmOrdering().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnCategory;
    private javax.swing.JButton btnCategoryFill;
    private javax.swing.JButton btnClearOrder;
    private javax.swing.JButton btnCritical;
    private javax.swing.JButton btnReceiveAll;
    private javax.swing.JButton btnShowOrder;
    private com.toedter.calendar.JDateChooser dateOrder;
    private com.toedter.calendar.JDateChooser datePicker;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblReceiveCategory;
    private javax.swing.JLabel lblReceiveOrder;
    private javax.swing.JLabel lblReceiveQtyOrder;
    private javax.swing.JLabel lblSoh;
    private javax.swing.JRadioButton radBread;
    private javax.swing.JRadioButton radCake;
    private javax.swing.JRadioButton radKitchen;
    private javax.swing.JRadioButton radOthers;
    private javax.swing.JRadioButton radPastries;
    private javax.swing.JRadioButton radStore;
    private javax.swing.JTable tableMinimum;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTable tableReceive;
    private javax.swing.JTextField txtOrderQty;
    // End of variables declaration//GEN-END:variables
}
