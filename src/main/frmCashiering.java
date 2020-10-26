
package main;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static java.lang.Thread.sleep;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class frmCashiering extends javax.swing.JFrame {
Connection conn;
ResultSet rs;
PreparedStatement pstmt;
int iChecker =0, row, ba, getTransactionID;
DecimalFormat df = new DecimalFormat("#.00");
double showAmountPaid;
int qty;
boolean foc=false;
String retrieveProductName;
    public frmCashiering() {
        initComponents();
        doConnect();
        sortTable();
        runningTime();
        fillProductTable();
        btnCash.setText("<html><center>CASH <br> PAYMENT</html>");
        btnNew.setText("<html><center>NEW <br>TRANSACTION</html>");
        txtSearchProduct.requestFocus();
        txtSearchProduct.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {listenSearch();}
            @Override
            public void removeUpdate(DocumentEvent e) {listenSearch();}
            @Override
            public void changedUpdate(DocumentEvent e) {listenSearch();}
        });
       
    }
    
private void fillProductTable(){
    try{
        String fillTable = "Select product_id,product_name,product_price,product_qoh from tblwrs_product";
        pstmt = conn.prepareStatement(fillTable);
        rs = pstmt.executeQuery();
        tableProduct.setModel(DbUtils.resultSetToTableModel(rs));
        tableProduct.setAutoCreateRowSorter(true);
        sortProductTable();
    }catch(SQLException e){
        e.getMessage();
    }   
}
private void sortProductTable(){
    tableProduct.getColumnModel().getColumn(0).setHeaderValue("ID");
    tableProduct.getColumnModel().getColumn(1).setHeaderValue("NAME");
    tableProduct.getColumnModel().getColumn(2).setHeaderValue("PRICE");
    tableProduct.getColumnModel().getColumn(3).setHeaderValue("QOH");
    
    tableProduct.getColumnModel().getColumn(0).setPreferredWidth(50);
    tableProduct.getColumnModel().getColumn(1).setPreferredWidth(150);
    tableProduct.getColumnModel().getColumn(2).setPreferredWidth(50);
    tableProduct.getColumnModel().getColumn(3).setPreferredWidth(50);
}

private void sortTable(){
    DefaultTableModel model = (DefaultTableModel)tableInvoice.getModel();   
    model.addColumn("ID");
    model.addColumn("NAME");
    model.addColumn("UNIT PRICE");
    model.addColumn("Qty");
    model.addColumn("Sub Total");
}    


private void listenSearch(){
 try{
        String searchSQL = "Select product_id,product_name,product_price,product_qoh from tblwrs_product where product_name like? OR product_id like?";
        pstmt = conn.prepareStatement(searchSQL);
        pstmt.setString(1,"%"+txtSearchProduct.getText()+"%");
        pstmt.setString(2,"%"+txtSearchProduct.getText()+"%");
        rs = pstmt.executeQuery();
        tableProduct.setModel(DbUtils.resultSetToTableModel(rs));
         tableProduct.setAutoCreateRowSorter(true);
        sortProductTable();
    }catch(SQLException e){
        e.getMessage();
    }
}
private void runningTime(){
    Thread clock = new Thread(){
    public void run(){       
    for(;;){        
    Calendar cal = new GregorianCalendar();
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    int day = cal.get(Calendar.DAY_OF_MONTH);
        lblDate.setText(day+"/"+(month+1)+"/"+year);

    int second = cal.get(Calendar.SECOND);
    int minute = cal.get(Calendar.MINUTE);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
        lblTime.setText(hour+":"+(minute)+":"+second);
    try {
    sleep(1000);
    } catch (InterruptedException ex) {
    Logger.getLogger(frmCashiering.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }}};
    clock.start();
} 
private void doConnect(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","rootroot");
    }catch(SQLException | ClassNotFoundException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblChange = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        php50 = new javax.swing.JButton();
        php500 = new javax.swing.JButton();
        php100 = new javax.swing.JButton();
        php1000 = new javax.swing.JButton();
        btnCash = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAmountPaid = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        php200 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        php20 = new javax.swing.JButton();
        chkFoc = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btn6 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        btnDot = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUnitPrice = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblProductId = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableInvoice = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtSearchProduct = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        btnRemoveItem = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btnReportZ = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton111 = new javax.swing.JButton();
        jButton112 = new javax.swing.JButton();
        jButton114 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblChange.setBackground(new java.awt.Color(204, 204, 0));
        lblChange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblChange.setForeground(new java.awt.Color(255, 255, 255));
        lblChange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChange.setOpaque(true);
        jPanel4.add(lblChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 160, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("AMOUNT PAID:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 130, 30));

        php50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        php50.setText("50.00");
        php50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                php50ActionPerformed(evt);
            }
        });
        jPanel4.add(php50, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 120, 50));

        php500.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        php500.setText("500.00");
        php500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                php500ActionPerformed(evt);
            }
        });
        jPanel4.add(php500, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 110, 50));

        php100.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        php100.setText("100.00");
        php100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                php100ActionPerformed(evt);
            }
        });
        jPanel4.add(php100, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 120, 50));

        php1000.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        php1000.setText("1000.00");
        php1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                php1000ActionPerformed(evt);
            }
        });
        jPanel4.add(php1000, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 110, 50));

        btnCash.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCash.setText("CASH PAYMENT");
        btnCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashActionPerformed(evt);
            }
        });
        jPanel4.add(btnCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 100, 170));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PHP");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 30, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PHP");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 30, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CHANGE:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 200, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TOTAL AMOUNT:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        txtAmountPaid.setBackground(new java.awt.Color(0, 102, 0));
        txtAmountPaid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAmountPaid.setForeground(new java.awt.Color(255, 255, 255));
        txtAmountPaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAmountPaid.setOpaque(true);
        jPanel4.add(txtAmountPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 90, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PHP");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, 40));

        lblTotalAmount.setBackground(new java.awt.Color(153, 153, 153));
        lblTotalAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalAmount.setOpaque(true);
        jPanel4.add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, 40));

        php200.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        php200.setText("200.00");
        php200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                php200ActionPerformed(evt);
            }
        });
        jPanel4.add(php200, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 110, 50));

        jButton2.setText("CLEAR ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 310, 30));

        php20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        php20.setText("20.00");
        php20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                php20ActionPerformed(evt);
            }
        });
        jPanel4.add(php20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 120, 50));

        chkFoc.setText("FOC");
        chkFoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFocActionPerformed(evt);
            }
        });
        jPanel4.add(chkFoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, 40));

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 770, 240));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 40));

        btn3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 140, 40));

        btn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 140, 40));

        btn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 140, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BARCODE:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 30));

        txtQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, 30));

        btn6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 140, 40));

        btn4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 140, 40));

        btn5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 40));

        btn9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 140, 40));

        btn7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 140, 40));

        btn8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 140, 40));

        btnEnter.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnEnter.setText("ENTER");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        jPanel2.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 210, 120));

        btnDot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDot.setText("CLEAR");
        btnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDotActionPerformed(evt);
            }
        });
        jPanel2.add(btnDot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 140, 40));

        btn0.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel2.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 140, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("QUANTITY:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 160, 30));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 530, 420));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Unit Price:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 50));

        lblUnitPrice.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblUnitPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblUnitPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 320, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product Name:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product ID:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 50));

        lblProductId.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblProductId.setForeground(new java.awt.Color(255, 255, 255));
        lblProductId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblProductId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 320, 50));

        lblProductName.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblProductName.setForeground(new java.awt.Color(255, 255, 255));
        lblProductName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 320, 50));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 240));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableInvoice);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 130));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 580, 150));

        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel5.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 260, 230, 80));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Search:");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));
        jPanel6.add(txtSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 460, 30));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduct);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 190));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 580, 260));

        btnRemoveItem.setText("REMOVE");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });
        jPanel5.add(btnRemoveItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 350, 110, 60));

        lblTime.setBackground(new java.awt.Color(51, 153, 0));
        lblTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setOpaque(true);
        jPanel5.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 620, 100, 60));

        lblDate.setBackground(new java.awt.Color(51, 153, 0));
        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setOpaque(true);
        jPanel5.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 620, 110, 60));

        btnReportZ.setText("RECEIPT DB");
        btnReportZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportZActionPerformed(evt);
            }
        });
        jPanel5.add(btnReportZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 420, 110, 60));

        jButton1.setText("MAIN MENU");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 420, 100, 60));

        jButton111.setText("PRINT LAST TRANSACTION");
        jButton111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton111ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton111, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 353, 100, 60));

        jButton112.setText("SALES REPORT");
        jButton112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton112ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton112, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 490, 110, 50));

        jButton114.setText("STOCK COUNT");
        jButton114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton114ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton114, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 490, 100, 50));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1370, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        txtQuantity.setText(txtQuantity.getText() + "1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        txtQuantity.setText(txtQuantity.getText() + "2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        txtQuantity.setText(txtQuantity.getText() + "3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        txtQuantity.setText(txtQuantity.getText() + "4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
              txtQuantity.setText(txtQuantity.getText() + "5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        txtQuantity.setText(txtQuantity.getText() + "6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        txtQuantity.setText(txtQuantity.getText() + "7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        txtQuantity.setText(txtQuantity.getText() + "8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        txtQuantity.setText(txtQuantity.getText() + "9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
           txtQuantity.setText(txtQuantity.getText() + "0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDotActionPerformed
        txtQuantity.setText("");
    }//GEN-LAST:event_btnDotActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
    if (txtQuantity.getText().equals("")){
            JOptionPane.showMessageDialog(this, "ENTER QUANTITY","QUANTITY", JOptionPane.ERROR_MESSAGE);
        }else{
            String prodId = lblProductId.getText();
            String prodName = lblProductName.getText();
            String unPrice = lblUnitPrice.getText();
            String getQty = txtQuantity.getText();
            Double uPrice = Double.valueOf(unPrice);
            DefaultTableModel model = (DefaultTableModel)tableInvoice.getModel();
            if(model.getRowCount() == 0){
            qty = Integer.valueOf(getQty);                
                Object[] adRow = {prodId, prodName,unPrice,qty, String.valueOf(df.format(qty*uPrice))};
                model.addRow(adRow);    
            }else{
            int duplicateRow = -1;
            for(int j=0; j<model.getRowCount();j++){
                Object obj = model.getValueAt(j, 0);
                if(obj.equals(prodId)){
                    duplicateRow = j;
                    break;
                }
            }
             if(duplicateRow == -1){
                qty = Integer.valueOf(txtQuantity.getText());
                Object[] adRow = {prodId, prodName,unPrice,qty, String.valueOf(df.format(qty*uPrice))};
                model.addRow(adRow);
             }else{
                qty = Integer.valueOf(model.getValueAt(duplicateRow, 3).toString()) + 1;
                model.setValueAt(prodId, duplicateRow, 0);
                model.setValueAt(prodName, duplicateRow, 1);
                model.setValueAt(unPrice, duplicateRow, 2);
                model.setValueAt(qty, duplicateRow, 3);
                model.setValueAt(df.format(qty*uPrice), duplicateRow, 4);
             }
            }
            
            float totalPrice=0;
                for(int i=0; i<tableInvoice.getRowCount(); i++){
                    totalPrice += Float.valueOf(tableInvoice.getValueAt(i, 4).toString());
                    lblTotalAmount.setText(String.valueOf(df.format(totalPrice)));
        }
            txtSearch.requestFocus();
            txtSearch.setText("");
            txtQuantity.setText("");
}       
          
    }//GEN-LAST:event_btnEnterActionPerformed

    private void php50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_php50ActionPerformed
    showAmountPaid +=Double.parseDouble(php50.getText());;
    txtAmountPaid.setText(String.valueOf(df.format(showAmountPaid)));
    }//GEN-LAST:event_php50ActionPerformed

    private void php500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_php500ActionPerformed
    showAmountPaid +=Double.parseDouble(php500.getText());;
    txtAmountPaid.setText(String.valueOf(df.format(showAmountPaid)));
    }//GEN-LAST:event_php500ActionPerformed

    private void php100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_php100ActionPerformed
    showAmountPaid +=Double.parseDouble(php100.getText());;
    txtAmountPaid.setText(String.valueOf(df.format(showAmountPaid)));
    }//GEN-LAST:event_php100ActionPerformed

    private void php1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_php1000ActionPerformed
    showAmountPaid +=Double.parseDouble(php1000.getText());;
    txtAmountPaid.setText(String.valueOf(df.format(showAmountPaid)));
    }//GEN-LAST:event_php1000ActionPerformed
private void clearTexts(){
    lblChange.setText("");
    lblProductId.setText("");
    lblProductName.setText("");
    lblTotalAmount.setText("");
    lblUnitPrice.setText("");
    txtAmountPaid.setText("");
    txtQuantity.setText("");
    txtSearch.setText("");
    
}
    private void btnCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashActionPerformed
        double getAmtPaid, getTotalAmt, showChange;       
        
        if (tableInvoice.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "No products entered", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if( txtAmountPaid.getText().equals("") || txtAmountPaid.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "ENTER AMOUNT PAID", "NO AMOUNT ENTERED", JOptionPane.ERROR_MESSAGE);
        }else{
             getAmtPaid = Double.valueOf(txtAmountPaid.getText());
             getTotalAmt = Double.valueOf(lblTotalAmount.getText());
             if (getAmtPaid< getTotalAmt){
                 JOptionPane.showMessageDialog(null, "INSUFFICIENT PAYMENT", "INSUFFICIENT", JOptionPane.ERROR_MESSAGE);
             }else{
                 showChange = getAmtPaid - getTotalAmt;
                 lblChange.setText(String.valueOf(df.format(showChange)));
                 checkTransactionId();
                 saveReceipt();
                 int itemSelected = JOptionPane.showConfirmDialog(this, "NEW TRANSACTION?","NEW TRANSACTION",JOptionPane.YES_NO_OPTION);
                 if (itemSelected == JOptionPane.YES_OPTION){
                     btnNewActionPerformed(evt);
                 }
             }
        }        
    }//GEN-LAST:event_btnCashActionPerformed
private void saveReceipt(){
    if (foc == false){
    try{
        String saveReceiptSQL = "INSERT INTO tblReceipt"
                + "(transactionId,productName,quantity,unitPrice,bdPrice,totalAmount,amountPaid,amountChange,cashier,date,time)"
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        for(int i=0; i<tableInvoice.getRowCount();i++){
        pstmt =conn.prepareStatement(saveReceiptSQL);
        pstmt.setInt(1,getTransactionID);
        pstmt.setString(2,tableInvoice.getValueAt(i, 1).toString());
        pstmt.setInt(3,Integer.valueOf(tableInvoice.getValueAt(i, 3).toString()));
        pstmt.setDouble(4,Double.valueOf(tableInvoice.getValueAt(i, 2).toString()));
        pstmt.setDouble(5,Double.valueOf(tableInvoice.getValueAt(i, 4).toString()));
        pstmt.setDouble(6, Double.valueOf(lblTotalAmount.getText()));
        pstmt.setDouble(7, Double.valueOf(txtAmountPaid.getText()));
        pstmt.setDouble(8,Double.valueOf(lblChange.getText()));
        pstmt.setString(9,frmLogin.showUserName);
        pstmt.setString(10,lblDate.getText());
        pstmt.setString(11,lblTime.getText());
        pstmt.execute();
        pstmt.close();
        }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    //UPDATE STOCK QTY
    try{
        String deductStockOnHand = "UPDATE tblwrs_product set product_qoh=product_qoh-? where product_id=?";
        pstmt = conn.prepareStatement(deductStockOnHand);
        DefaultTableModel model = (DefaultTableModel)tableInvoice.getModel();
        for(int j=0; j<model.getRowCount();j++){
            pstmt.setInt(1,Integer.valueOf(model.getValueAt(j, 3).toString()));
            pstmt.setString(2,model.getValueAt(j, 0).toString());
            pstmt.executeUpdate();
        }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }else if(foc == true){
    try{
        String saveReceiptSQL = "INSERT INTO tblReceipt"
                + "(transactionId,productName,quantity,unitPrice,bdPrice,totalAmount,amountPaid,amountChange,cashier,date,time)"
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        for(int i=0; i<tableInvoice.getRowCount();i++){
        pstmt =conn.prepareStatement(saveReceiptSQL);
        pstmt.setInt(1,getTransactionID);
        pstmt.setString(2,tableInvoice.getValueAt(i, 1).toString());
        pstmt.setInt(3,Integer.valueOf(tableInvoice.getValueAt(i, 3).toString()));
        pstmt.setDouble(4,Double.valueOf(tableInvoice.getValueAt(i, 2).toString()));
        pstmt.setDouble(5,Double.valueOf(tableInvoice.getValueAt(i, 4).toString()));
        pstmt.setDouble(6, Double.valueOf(lblTotalAmount.getText()));
        pstmt.setDouble(7, Double.valueOf(txtAmountPaid.getText()));
        pstmt.setDouble(8,Double.valueOf(lblChange.getText()));
        pstmt.setString(9,frmLogin.showUserName);
        pstmt.setString(10,lblDate.getText());
        pstmt.setString(11,lblTime.getText());
        pstmt.execute();
        pstmt.close();
        }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    //UPDATE STOCK QTY
    try{
        String deductStockOnHand = "UPDATE tblwrs_product set product_qoh=product_qoh-? where product_id=?";
        pstmt = conn.prepareStatement(deductStockOnHand);
        DefaultTableModel model = (DefaultTableModel)tableInvoice.getModel();
        for(int j=0; j<model.getRowCount();j++){
            pstmt.setInt(1,Integer.valueOf(model.getValueAt(j, 3).toString()));
            pstmt.setString(2,model.getValueAt(j, 0).toString());
            pstmt.executeUpdate();
        }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
}
private void checkTransactionId(){
    try{
        String checkReceiptId = "SELECT * from tblReceipt order by transactionId DESC LIMIT 1";
        pstmt =conn.prepareStatement(checkReceiptId);
        rs = pstmt.executeQuery();
        if (rs.next()){
            getTransactionID = rs.getInt(1);
            getTransactionID++;
        }else{
            getTransactionID=1;
        }
    }catch(SQLException e){
        e.getMessage();
    }
}
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        DefaultTableModel model =(DefaultTableModel)tableInvoice.getModel();
        while(model.getRowCount()>0){
            model.setRowCount(0);
        }
        clearTexts();
        showAmountPaid=0;
        txtSearch.requestFocus();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
        DefaultTableModel model =(DefaultTableModel)tableInvoice.getModel();
        int numRows = tableInvoice.getSelectedRows().length;
        for (int i=0; i<numRows;i++){
            model.removeRow(tableInvoice.getSelectedRow());
        }
        float totalPrice=0;
            for(int i=0; i<tableInvoice.getRowCount(); i++){
                totalPrice += Float.valueOf(tableInvoice.getValueAt(i, 4).toString());
                lblTotalAmount.setText(String.valueOf(df.format(totalPrice)));
        }
    }//GEN-LAST:event_btnRemoveItemActionPerformed
    
    
        private void printReceipt(){
    Map param = new HashMap();
        param.put("tranId", getTransactionID);
        try{
            conn.close();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","root");
            JasperDesign jd = JRXmlLoader.load(new File("src\\Reports\\repReceipt.jrxml"));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param,conn);
            JasperPrintManager.printReport(jp, false);

        }catch(ClassNotFoundException | SQLException | JRException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void btnReportZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportZActionPerformed
        Map param = new HashMap();
        param.put("date", lblDate.getText());
        try{
            conn.close();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","rootroot");
            JasperDesign jd = JRXmlLoader.load(new File("src/Reports/repAllReceipt.jrxml"));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param,conn);
            JasperViewer.viewReport(jp,false);

        }catch(ClassNotFoundException | SQLException | JRException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnReportZActionPerformed

    private void php200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_php200ActionPerformed
        showAmountPaid +=Double.parseDouble(php200.getText());;
    txtAmountPaid.setText(String.valueOf(df.format(showAmountPaid)));
    }//GEN-LAST:event_php200ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmModulePicker obj = new frmModulePicker();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtAmountPaid.setText("");
        showAmountPaid=0;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton111ActionPerformed
    Map param = new HashMap();
        param.put("tranId", getTransactionID);
        try{
            conn.close();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","rootroot");
            JasperDesign jd = JRXmlLoader.load(new File("src/Reports/repReceipt.jrxml"));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param,conn);
            JasperViewer.viewReport(jp,false);

        }catch(ClassNotFoundException | SQLException | JRException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }        
    }//GEN-LAST:event_jButton111ActionPerformed

    private void php20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_php20ActionPerformed
        showAmountPaid += Double.parseDouble(php20.getText());
    txtAmountPaid.setText(String.valueOf(df.format(showAmountPaid)));
    }//GEN-LAST:event_php20ActionPerformed

    private void jButton112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton112ActionPerformed
        Map param = new HashMap();
        param.put("date", lblDate.getText());
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
    }//GEN-LAST:event_jButton112ActionPerformed

    private void jButton114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton114ActionPerformed
        Map param = new HashMap();
        param.put("date", lblDate.getText());
        try{
            conn.close();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbebpos","root","rootroot");
            JasperDesign jd = JRXmlLoader.load(new File("src/Reports/repCurrentStock.jrxml"));
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param,conn);
            JasperViewer.viewReport(jp,false);

        }catch(ClassNotFoundException | SQLException | JRException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton114ActionPerformed

    private void chkFocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFocActionPerformed
        foc = chkFoc.isSelected();
        System.out.println("current state ay: " + foc);
    }//GEN-LAST:event_chkFocActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        int row = tableProduct.getSelectedRow();
        int ba = tableProduct.convertRowIndexToModel(row);
        try{
            String tblClick = (tableProduct.getModel().getValueAt(ba, 0).toString());
            String tableQuery = "Select * from tblwrs_product where product_id=?";
            pstmt = conn.prepareStatement(tableQuery);
            pstmt.setString(1, tblClick);
            rs = pstmt.executeQuery();
            if (rs.next()){
                lblProductId.setText(rs.getString("product_id"));
                lblProductName.setText(rs.getString("product_name"));
                lblUnitPrice.setText(String.valueOf(rs.getInt("product_price")));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tableProductMouseClicked

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
            java.util.logging.Logger.getLogger(frmCashiering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCashiering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCashiering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCashiering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCashiering().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnCash;
    private javax.swing.JButton btnDot;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnReportZ;
    private javax.swing.JCheckBox chkFoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton111;
    private javax.swing.JButton jButton112;
    private javax.swing.JButton jButton114;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblProductId;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JButton php100;
    private javax.swing.JButton php1000;
    private javax.swing.JButton php20;
    private javax.swing.JButton php200;
    private javax.swing.JButton php50;
    private javax.swing.JButton php500;
    private javax.swing.JTable tableInvoice;
    private javax.swing.JTable tableProduct;
    private javax.swing.JLabel txtAmountPaid;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchProduct;
    // End of variables declaration//GEN-END:variables
}
