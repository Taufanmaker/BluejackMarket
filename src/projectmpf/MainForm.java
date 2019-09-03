/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmpf;

import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ASUS
 */
public class MainForm extends javax.swing.JFrame {
    
    File editPict = new File("Assets\\edit.png");
    File shopPict = new File("Assets\\shop.png");
    File exitPict = new File("Assets\\exit.png");
    Image editImg, shopImg, exitImg, img1, img2, img3, img4;
    Image resized1, resized2, resized3, resized4;
    boolean bigSize = true, smallSize =  false, isDragging = false, isDragged1 = false, isDragged2 = true, isDragged3 = false, isDragged4 = false;
    int x, y, totalComponent = 0, qty1 = 0, qty2 = 0, qty3 = 0, qty4 = 0, totalPrice = 0, reservedRow = -1, totalPrice1 = 0, totalPrice2 = 0, totalPrice3 = 0, totalPrice4 = 0;
    Player musicPlayer;
    DefaultTableModel tableModel;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        
//        try{  
//           File musicFile = new File("Assets\\canon.wav");
//            URL urlMusic = musicFile.toURI().toURL();
//            musicPlayer = Manager.createRealizedPlayer(urlMusic);
//            musicPlayer.start();
//            
//        }catch(Exception e){
//            e.printStackTrace();
//        }       

        if(UserList.itemName.isEmpty() && UserList.itemPrice.isEmpty() && UserList.imagePath.isEmpty())
        {
            UserList.itemName.add("Notebook Case");
            UserList.itemName.add("Mouse");
            UserList.itemName.add("Shoes");
            UserList.itemName.add("T-Shirt");
            
            UserList.itemPrice.add(25000);
            UserList.itemPrice.add(125000);
            UserList.itemPrice.add(300000);
            UserList.itemPrice.add(75000);
             
            UserList.imagePath.add("Assets\\case.png");
            UserList.imagePath.add("Assets\\mouse.png");
            UserList.imagePath.add("Assets\\shoes.png");
            UserList.imagePath.add("Assets\\t-shirt.png");
             
        }
        
        tableModel = (DefaultTableModel) tblData.getModel();
        
        try {
            editImg = ImageIO.read(editPict);
            Image resizedEdit = editImg.getScaledInstance(50, 50, Image.SCALE_DEFAULT); 
            ImageIcon editIcon = new ImageIcon(resizedEdit);   
            btnEdit.setIcon(editIcon);
            
            shopImg = ImageIO.read(shopPict);
            Image resizedShop = shopImg.getScaledInstance(50, 50, Image.SCALE_DEFAULT); 
            ImageIcon shopIcon = new ImageIcon(resizedShop);   
            btnShop.setIcon(shopIcon);
            
            exitImg = ImageIO.read(exitPict);
            Image resizedExit = exitImg.getScaledInstance(50, 50, Image.SCALE_DEFAULT); 
            ImageIcon exitIcon = new ImageIcon(resizedExit);   
            btnExit.setIcon(exitIcon);
            
            img1 = ImageIO.read(new File(UserList.imagePath.elementAt(0)));
            resized1 = img1.getScaledInstance(125, 125, Image.SCALE_DEFAULT); 
            ImageIcon icon1 = new ImageIcon(resized1);   
            lbl1.setIcon(icon1);

            img2 = ImageIO.read(new File(UserList.imagePath.elementAt(1)));
            resized2 = img2.getScaledInstance(125, 125, Image.SCALE_DEFAULT); 
            ImageIcon icon2 = new ImageIcon(resized2);   
            lbl2.setIcon(icon2);

            img3 = ImageIO.read(new File(UserList.imagePath.elementAt(2)));
            resized3 = img3.getScaledInstance(125, 125, Image.SCALE_DEFAULT); 
            ImageIcon icon3 = new ImageIcon(resized3);   
            lbl3.setIcon(icon3);

            img4 = ImageIO.read(new File(UserList.imagePath.elementAt(3)));
            resized4 = img4.getScaledInstance(125, 125, Image.SCALE_DEFAULT); 
            ImageIcon icon4 = new ImageIcon(resized4);   
            lbl4.setIcon(icon4);
        } catch (IOException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform transformer = g2d.getTransform();
        
        Line2D line = new Line2D.Float(1465, 55, 1465, 1100);
        g2d.draw(line);
        
        if(isDragging)
        {
            x = MouseInfo.getPointerInfo().getLocation().x;
            y = MouseInfo.getPointerInfo().getLocation().y;
            
            if(isDragged1)
            {
                if(bigSize)
                {
                    transformer.scale(1.0, 1.0);
                    g2d.setTransform(transformer);
                    g2d.drawImage(resized1,x-(resized1.getWidth(null) / 2),y-(resized1.getHeight(null)/ 2),this);
                }

                if(smallSize)
                {
                    transformer.scale(0.75, 0.75);
                    g2d.setTransform(transformer);
                    g2d.drawImage(resized1,x-(resized1.getWidth(null) / 2),y-(resized1.getHeight(null)/ 2),this);
                }
            }
            
            else if(isDragged2)
            {
                if(bigSize)
                {
                    transformer.scale(1.0, 1.0);
                    g2d.setTransform(transformer);
                    g2d.drawImage(resized2,x-(resized2.getWidth(null) / 2),y-(resized2.getHeight(null)/ 2),this);
                }

                if(smallSize)
                {
                    transformer.scale(0.75, 0.75);
                    g2d.setTransform(transformer);
                    g2d.drawImage(resized2,x-(resized2.getWidth(null) / 2),y-(resized2.getHeight(null)/ 2),this);
                }
            }
            
            else if(isDragged3)
            {
                if(bigSize)
                {
                    transformer.scale(1.0, 1.0);
                    g2d.setTransform(transformer);
                    g2d.drawImage(resized3,x-(resized3.getWidth(null) / 2),y-(resized3.getHeight(null)/ 2),this);
                }

                if(smallSize)
                {
                    transformer.scale(0.75, 0.75);
                    g2d.setTransform(transformer);
                    g2d.drawImage(resized3,x-(resized3.getWidth(null) / 2),y-(resized3.getHeight(null)/ 2),this);
                }
            }
            
            else if(isDragged4)
            {
                if(bigSize)
                {
                    transformer.scale(1.0, 1.0);
                    g2d.setTransform(transformer);
                    g2d.drawImage(resized4,x-(resized4.getWidth(null) / 2),y-(resized4.getHeight(null)/ 2),this);
                }

                if(smallSize)
                {
                    transformer.scale(0.75, 0.75);
                    g2d.setTransform(transformer);
                    g2d.drawImage(resized4,x-(resized4.getWidth(null) / 2),y-(resized4.getHeight(null)/ 2),this);
                }
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        Main = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        Size = new javax.swing.JPanel();
        rbtBigSize = new javax.swing.JRadioButton();
        rbtSmallSize = new javax.swing.JRadioButton();
        Table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        Icon = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        btnShop = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        CartArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bluejack Market");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Main.setBackground(new java.awt.Color(236, 244, 190));
        Main.setLayout(new java.awt.BorderLayout());

        jLabel9.setBackground(new java.awt.Color(153, 153, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Bluejack Market");
        jLabel9.setOpaque(true);
        Main.add(jLabel9, java.awt.BorderLayout.PAGE_START);

        Left.setOpaque(false);
        Left.setLayout(new java.awt.GridLayout(4, 1));

        lbl1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl1MouseDragged(evt);
            }
        });
        lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl1MouseReleased(evt);
            }
        });
        Left.add(lbl1);

        lbl2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl2MouseDragged(evt);
            }
        });
        lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl2MouseReleased(evt);
            }
        });
        Left.add(lbl2);

        lbl3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl3MouseDragged(evt);
            }
        });
        lbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl3MouseReleased(evt);
            }
        });
        Left.add(lbl3);

        lbl4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl4MouseDragged(evt);
            }
        });
        lbl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl4MouseReleased(evt);
            }
        });
        Left.add(lbl4);

        Main.add(Left, java.awt.BorderLayout.LINE_START);

        Right.setOpaque(false);
        Right.setLayout(new java.awt.BorderLayout());

        Size.setOpaque(false);

        buttonGroup1.add(rbtBigSize);
        rbtBigSize.setSelected(true);
        rbtBigSize.setText("Big Size");
        rbtBigSize.setOpaque(false);
        rbtBigSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtBigSizeMouseClicked(evt);
            }
        });
        Size.add(rbtBigSize);

        buttonGroup1.add(rbtSmallSize);
        rbtSmallSize.setText("Small Size");
        rbtSmallSize.setOpaque(false);
        rbtSmallSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtSmallSizeMouseClicked(evt);
            }
        });
        Size.add(rbtSmallSize);

        Right.add(Size, java.awt.BorderLayout.NORTH);

        Table.setLayout(new java.awt.GridLayout(1, 1));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Qty", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        Table.add(jScrollPane1);

        Right.add(Table, java.awt.BorderLayout.CENTER);

        Icon.setOpaque(false);

        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        Icon.add(btnEdit);

        btnShop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShopMouseClicked(evt);
            }
        });
        Icon.add(btnShop);

        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        Icon.add(btnExit);

        Right.add(Icon, java.awt.BorderLayout.SOUTH);

        Main.add(Right, java.awt.BorderLayout.LINE_END);

        CartArea.setPreferredSize(new java.awt.Dimension(600, 316));
        CartArea.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        Main.add(CartArea, java.awt.BorderLayout.CENTER);

        getContentPane().add(Main, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtBigSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtBigSizeMouseClicked
        // TODO add your handling code here:
        bigSize = true;
        smallSize = false;
    }//GEN-LAST:event_rbtBigSizeMouseClicked

    private void rbtSmallSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtSmallSizeMouseClicked
        // TODO add your handling code here:
        smallSize = true;
        bigSize = false;
    }//GEN-LAST:event_rbtSmallSizeMouseClicked

    private void lbl1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseDragged
        // TODO add your handling code here:
        isDragging = true;
        isDragged1 = true;
        repaint();
    }//GEN-LAST:event_lbl1MouseDragged

    private void lbl1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseReleased
        // TODO add your handling code here:
        isDragging = false;
        isDragged1 = false;
        
        if(totalComponent == 16)
        {
            JOptionPane.showMessageDialog(null, "The Cart is full!");
        }
        else
        {
            if(MouseInfo.getPointerInfo().getLocation().x > 130)
            {
                JLabel lbl1New = new JLabel();
                if(bigSize)
                {
                   lbl1New.setIcon(new ImageIcon (resized1)); 
                }
                else if(smallSize)
                {
                    lbl1New.setIcon(new ImageIcon (resized1.getScaledInstance(94, 94, resized1.SCALE_DEFAULT)));
                }
                CartArea.add(lbl1New);
                revalidate();
                totalComponent++;
                qty1++;
                
                if(existsInTable(tblData, UserList.itemName.elementAt(0)))
                {
                    tblData.setValueAt(qty1, reservedRow, 1);
                    tblData.setValueAt(qty1 * UserList.itemPrice.elementAt(0), reservedRow, 2);
                    totalPrice1 = qty1 * UserList.itemPrice.elementAt(0);
                }
                else
                {
                    Object[] row = {UserList.itemName.elementAt(0), qty1, UserList.itemPrice.elementAt(0)};
                    tableModel.addRow(row);           
                    totalPrice1 = UserList.itemPrice.elementAt(0);
                }
            }
        }
        repaint();
    }//GEN-LAST:event_lbl1MouseReleased

    private void lbl2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseDragged
        // TODO add your handling code here:
        isDragging = true;
        isDragged2 = true;
        repaint();
    }//GEN-LAST:event_lbl2MouseDragged

    private void lbl2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseReleased
        // TODO add your handling code here:
        isDragging = false;
        isDragged2 = false;
        
        if(totalComponent == 16)
        {
            JOptionPane.showMessageDialog(null, "The Cart is full!");
        }
        else
        {
            if(MouseInfo.getPointerInfo().getLocation().x > 130)
            {
                JLabel lbl2New = new JLabel();
                if(bigSize)
                {
                   lbl2New.setIcon(new ImageIcon (resized2)); 
                }
                else if(smallSize)
                {
                    lbl2New.setIcon(new ImageIcon (resized2.getScaledInstance(94, 94, resized1.SCALE_DEFAULT)));
                }
                CartArea.add(lbl2New);
                revalidate();
                totalComponent++;
                qty2++;
                
                if(existsInTable(tblData, UserList.itemName.elementAt(1)))
                {
                    tblData.setValueAt(qty2, reservedRow, 1);
                    tblData.setValueAt(qty2 * UserList.itemPrice.elementAt(1), reservedRow, 2);
                    totalPrice2 = qty2 * UserList.itemPrice.elementAt(1);
                }
                else
                {
                    Object[] row = {UserList.itemName.elementAt(1), qty2, UserList.itemPrice.elementAt(1)};
                    tableModel.addRow(row);           
                    totalPrice2 = UserList.itemPrice.elementAt(1);
                }
            }
        }   
         repaint();
    }//GEN-LAST:event_lbl2MouseReleased

    private void lbl3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3MouseDragged
        // TODO add your handling code here:
        isDragging = true;
        isDragged3 = true;
        repaint();
    }//GEN-LAST:event_lbl3MouseDragged

    private void lbl3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3MouseReleased
        // TODO add your handling code here:
        isDragging = false;
        isDragged3 = false;
        
        if(totalComponent == 16)
        {
            JOptionPane.showMessageDialog(null, "The Cart is full!");
        }
        else
        {
            if(MouseInfo.getPointerInfo().getLocation().x > 130){
                JLabel lbl3New = new JLabel();
               if(bigSize)
                {
                   lbl3New.setIcon(new ImageIcon (resized3)); 
                }
                else if(smallSize)
                {
                    lbl3New.setIcon(new ImageIcon (resized3.getScaledInstance(94, 94, resized1.SCALE_DEFAULT)));
                }
                CartArea.add(lbl3New);
                revalidate();
                totalComponent++;
                qty3++;
                
                if(existsInTable(tblData, UserList.itemName.elementAt(2)))
                {
                    tblData.setValueAt(qty3, reservedRow, 1);
                    tblData.setValueAt(qty3 * UserList.itemPrice.elementAt(2), reservedRow, 2);
                    totalPrice3 = qty3 * UserList.itemPrice.elementAt(2);
                }
                else
                {
                    Object[] row = {UserList.itemName.elementAt(2), qty3, UserList.itemPrice.elementAt(2)};
                    tableModel.addRow(row);           
                    totalPrice3 = UserList.itemPrice.elementAt(2);
                }
            }      
        }
         repaint();
    }//GEN-LAST:event_lbl3MouseReleased

    private void lbl4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl4MouseDragged
        // TODO add your handling code here:
        isDragging = true;
        isDragged4 = true;
        repaint();
    }//GEN-LAST:event_lbl4MouseDragged

    private void lbl4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl4MouseReleased
        // TODO add your handling code here:      
        isDragging = false;
        isDragged4 = false;
        
        if(totalComponent == 16)
        {
            JOptionPane.showMessageDialog(null, "The Cart is full!");
        }
        else
        {
            if(MouseInfo.getPointerInfo().getLocation().x > 130)
            {
                JLabel lbl4New = new JLabel();
                if(bigSize)
                {
                   lbl4New.setIcon(new ImageIcon (resized4)); 
                }
                else if(smallSize)
                {
                    lbl4New.setIcon(new ImageIcon (resized4.getScaledInstance(94, 94, resized1.SCALE_DEFAULT)));
                }
                CartArea.add(lbl4New);
                revalidate();
                totalComponent++;
                qty4++;
                
                if(existsInTable(tblData, UserList.itemName.elementAt(3)))
                {
                    tblData.setValueAt(qty4, reservedRow, 1);
                    tblData.setValueAt(qty4 * UserList.itemPrice.elementAt(3), reservedRow, 2);
                    totalPrice4 = qty4 * UserList.itemPrice.elementAt(3);
                }
                else
                {
                    Object[] row = {UserList.itemName.elementAt(3), qty4, UserList.itemPrice.elementAt(3)};
                    tableModel.addRow(row);           
                    totalPrice4 = qty4 * UserList.itemPrice.elementAt(3);
                }
            }
        }
        repaint(); 
    }//GEN-LAST:event_lbl4MouseReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnShopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShopMouseClicked
        // TODO add your handling code here:
        if(tableModel.getRowCount() <= 0)
        {
            JOptionPane.showMessageDialog(null, "There is no item!");
        }
        else if(totalComponent != 0)
        {
            totalPrice = totalPrice1 + totalPrice2 + totalPrice3 + totalPrice4;
            if(JOptionPane.showConfirmDialog(null, "You Will Buy " + String.valueOf(totalPrice), "Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION) ==  JOptionPane.YES_OPTION)
            {
                 JOptionPane.showMessageDialog(null, "Buy Success!");
                 tableModel.setRowCount(0);
                 CartArea.removeAll();
                 CartArea.revalidate();
                 CartArea.repaint();
                 
                 totalComponent = 0;
                 qty1 = 0; qty2 = 0; qty3 = 0; qty4 = 0;
                 totalPrice = 0; totalPrice1 = 0; totalPrice2 = 0; totalPrice3 = 0; totalPrice4 = 0;      
            }
        }
    }//GEN-LAST:event_btnShopMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        //musicPlayer.stop();
        new EditForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditMouseClicked
    

    public boolean existsInTable(JTable table, String data) 
    {
        reservedRow = -1;
        int rowCount = table.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String rowEntry = "";
                rowEntry = table.getValueAt(i, 0).toString();
            if (rowEntry.equals(data)) {
                reservedRow = i;
                return true;
            }
        }
        return false;
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CartArea;
    private javax.swing.JPanel Icon;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel Size;
    private javax.swing.JPanel Table;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnShop;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JRadioButton rbtBigSize;
    private javax.swing.JRadioButton rbtSmallSize;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
