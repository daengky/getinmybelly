package GUI;

import Jama.Matrix;
import Transforms.*;
import Signals.Reader;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Tom Pepels - 25-9-2011
 */
public class ECGFrame extends javax.swing.JFrame {
    
    // Daubechies D4 wavelet coefficients
    private final static double h0 = (1 + Math.sqrt(3)) / (4 * Math.sqrt(2));
    private final static double h1 = (3 + Math.sqrt(3)) / (4 * Math.sqrt(2));
    private final static double h2 = (3 - Math.sqrt(3)) / (4 * Math.sqrt(2));
    private final static double h3 = (1 - Math.sqrt(3)) / (4 * Math.sqrt(2));
    private static double[] daubs = new double[]{h0,h1,h2,h3};
    private String selectedFile;
    private double[] samples;
    private String yAxis;

    /** Creates new form ECGFrame */
    public ECGFrame() {
        initComponents();

        drawButton.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transformButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        signalNamesList = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        drawButton = new javax.swing.JButton();
        fileTextField = new javax.swing.JTextField();
        sigCountText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        dwtWeightTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        thresholdTxt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        haarRadioButton = new javax.swing.JRadioButton();
        d4RadioButton = new javax.swing.JRadioButton();
        fourierRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        graphPanel2 = new GUI.GraphPanel();
        graphPanel1 = new GUI.GraphPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuration"));

        jButton1.setText("Select File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Signal:");

        drawButton.setText("Draw graph");
        drawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawButtonActionPerformed(evt);
            }
        });

        sigCountText.setText("1000");

        jLabel2.setText("Signal count:");

        jButton2.setText("Wavelet Transform");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        dwtWeightTxt.setText("2");

        jLabel3.setText("DWT Weight:");

        thresholdTxt.setText("0.05");

        jButton3.setText("Noise reduction");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Threshold:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Wavelet Transform"));

        transformButtonGroup.add(haarRadioButton);
        haarRadioButton.setSelected(true);
        haarRadioButton.setText("Haar");

        transformButtonGroup.add(d4RadioButton);
        d4RadioButton.setText("Daubechies D4");

        transformButtonGroup.add(fourierRadioButton);
        fourierRadioButton.setText("Fourier");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(haarRadioButton)
                    .addComponent(d4RadioButton)
                    .addComponent(fourierRadioButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(haarRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(d4RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fourierRadioButton))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signalNamesList, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sigCountText, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(thresholdTxt, 0, 0, Short.MAX_VALUE)
                    .addComponent(dwtWeightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(dwtWeightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(thresholdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3)
                                .addComponent(jLabel4)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(signalNamesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(sigCountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(drawButton))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setLayout(new java.awt.BorderLayout());

        graphPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        graphPanel2.setPreferredSize(new java.awt.Dimension(412, 250));
        jPanel2.add(graphPanel2, java.awt.BorderLayout.SOUTH);

        graphPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        graphPanel1.setPreferredSize(new java.awt.Dimension(412, 250));
        jPanel2.add(graphPanel1, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            fileTextField.setText(file.getName());
            this.selectedFile = file.getPath();
            Reader.closeEDFFile();
            Reader.openEDFFile(selectedFile);
            fillComboBox();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void drawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawButtonActionPerformed
        Reader.openEDFFile(selectedFile);
        int signal = ((ComboItem) signalNamesList.getSelectedItem()).getId();
        int sigCount = Integer.parseInt(sigCountText.getText());
        samples = Reader.readSamples(signal, sigCount);
        yAxis = Reader.physicalDimension(signal);
        String signalName = Reader.signalName(signal);
        Reader.closeEDFFile();
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        graphPanel1.drawGraph(samples, yAxis, signalName);

    }//GEN-LAST:event_drawButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        graphPanel2.drawGraph(doTransform(), yAxis, "Wavelet Transform");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        double t = Double.parseDouble(thresholdTxt.getText());
        double[] trans = doTransform();
        double[] newSigH = NoiseReduction.reduceNoiseHardT(trans, t);
        double[] newSigS = NoiseReduction.reduceNoiseSoftT(trans, t);
        double[] newSigD = NoiseReduction.reduceNoiseDynamicT(trans, daubs);
        graphPanel2.drawGraph(doInvTransform(newSigD), yAxis, "Dynamic Threshold");      
//        graphPanel2.drawGraph(doInvTransform(newSigH), yAxis, "Hard Threshold: " + thresholdTxt.getText());
//        graphPanel2.addGraph(doInvTransform(newSigS), "Soft Threshold: " + thresholdTxt.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private double[] doTransform() {
        if (haarRadioButton.isSelected()) {

            int wgt = Integer.parseInt(dwtWeightTxt.getText());
            double weight = Math.sqrt(wgt);
            Matrix result = DWT.waveletTransform(weight, samples);
            return result.transpose().getArray()[0];

        } else if (d4RadioButton.isSelected()) {

            double[] newSig = Arrays.copyOf(samples, samples.length);
            DWT.d4Transform(newSig);
            return newSig;

        } else { //Fourier here!
            return new double[0];
        }
    }

    private double[] doInvTransform(double[] signal) {
        if (haarRadioButton.isSelected()) {

            int wgt = Integer.parseInt(dwtWeightTxt.getText());
            double weight = Math.sqrt(wgt);
            return DWT.inverseHaarWaveletTransform(signal, weight);

        } else if (d4RadioButton.isSelected()) {

            double[] newSig = Arrays.copyOf(signal, signal.length);
            DWT.invD4Transform(newSig);
            return newSig;
            
        } else { //Fourier here!
            return new double[0];
        }
    }

    private void fillComboBox() {
        int signals = Reader.noOfSignals();
        if (signals > 0) {

            for (int i = 0; i < signals; i++) {
                this.signalNamesList.addItem(new ComboItem(Reader.signalName(i), i));
            }

            drawButton.setEnabled(true);
        } else {
            drawButton.setEnabled(false);
        }
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
            java.util.logging.Logger.getLogger(ECGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ECGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ECGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ECGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                        } catch (Exception ex) {
                        }
                        break;
                    }
                }
                new ECGFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton d4RadioButton;
    private javax.swing.JButton drawButton;
    private javax.swing.JTextField dwtWeightTxt;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JRadioButton fourierRadioButton;
    private GUI.GraphPanel graphPanel1;
    private GUI.GraphPanel graphPanel2;
    private javax.swing.JRadioButton haarRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField sigCountText;
    private javax.swing.JComboBox signalNamesList;
    private javax.swing.JTextField thresholdTxt;
    private javax.swing.ButtonGroup transformButtonGroup;
    // End of variables declaration//GEN-END:variables
}
