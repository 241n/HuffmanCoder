/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Window.java
 *
 * Created on 26.05.2011, 23:15:52
 */
package de.flomeise.huffmancoder;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Flohw
 */
public class Window extends javax.swing.JFrame {

    /** Creates new form Window */
    public Window() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelInput = new javax.swing.JLabel();
        jTextFieldInput = new javax.swing.JTextField();
        jButtonInput = new javax.swing.JButton();
        jLabelOutput = new javax.swing.JLabel();
        jTextFieldOutput = new javax.swing.JTextField();
        jButtonOutput = new javax.swing.JButton();
        jButtonCompress = new javax.swing.JButton();
        jButtonDecompress = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Huffman-Coder");
        setName("frame1"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelInput.setText("Input:");
        jPanel1.add(jLabelInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(jTextFieldInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 390, -1));

        jButtonInput.setText("...");
        jButtonInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInputActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 30, -1));

        jLabelOutput.setText("Output:");
        jPanel1.add(jLabelOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel1.add(jTextFieldOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 390, -1));

        jButtonOutput.setText("...");
        jButtonOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutputActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 30, -1));

        jButtonCompress.setText("Compress");
        jButtonCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompressActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCompress, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 80, -1));

        jButtonDecompress.setText("Decompress");
        jButtonDecompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecompressActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDecompress, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 120));

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDecompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecompressActionPerformed
        String inputFile = jTextFieldInput.getText(), outputFile = jTextFieldOutput.getText();
        File input = new File(inputFile), output = new File(outputFile);
        if(!input.exists()) {
            JOptionPane.showMessageDialog(null, "The input file cannot be found!");
            return;
        }
        if(output.exists()) {
            int choice = JOptionPane.showConfirmDialog(null, "The output file already exists. Would you like to overwrite it?", "File already exists", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.NO_OPTION) {
                return;
            }
        }
        new Huffman().decompress(input, output);
}//GEN-LAST:event_jButtonDecompressActionPerformed

    private void jButtonCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompressActionPerformed
        String inputFile = jTextFieldInput.getText(), outputFile = jTextFieldOutput.getText();
        File input = new File(inputFile), output = new File(outputFile);
        if(!input.exists()) {
            JOptionPane.showMessageDialog(null, "The input file cannot be found!");
            return;
        }
        if(output.exists()) {
            int choice = JOptionPane.showConfirmDialog(null, "The output file already exists. Would you like to overwrite it?", "File already exists", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.NO_OPTION) {
                return;
            }
        }
        new Huffman().compress(input, output);
}//GEN-LAST:event_jButtonCompressActionPerformed

    private void jButtonOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutputActionPerformed
        jTextFieldInput.setText(FileOpenDialog.open());
}//GEN-LAST:event_jButtonOutputActionPerformed

    private void jButtonInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputActionPerformed
        String s = FileOpenDialog.open();
        jTextFieldInput.setText(s);
        if(s.endsWith(".huf")) {
            jTextFieldOutput.setText(s.substring(0, s.length()-4));
        } else {
            jTextFieldOutput.setText(s+".huf");
        }
    }//GEN-LAST:event_jButtonInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Window().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCompress;
    private javax.swing.JButton jButtonDecompress;
    private javax.swing.JButton jButtonInput;
    private javax.swing.JButton jButtonOutput;
    private javax.swing.JLabel jLabelInput;
    private javax.swing.JLabel jLabelOutput;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldInput;
    private javax.swing.JTextField jTextFieldOutput;
    // End of variables declaration//GEN-END:variables
}