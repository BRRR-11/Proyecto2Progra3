/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.Retiro;
import java.util.Observable;
import sistema.logico.Cliente;
/**
 *
 * @author ariqq
 */
public class ViewRetiro extends javax.swing.JFrame implements java.util.Observer{
//**************  MVC ***********
    Controller controller;
    Model model;
    
    public void setController(Controller controller){
        this.controller=controller;
    }

    public Controller getController() {
        return controller;
    }
    
    public void setModel(Model model){
        this.model=model;
         model.addObserver(this);
    }

    public Model getModel() {
        return model;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Cliente cliente = model.getCliente();
        //actualPass.setText(cliente.getContraseña());
        //saldoText.setText(String.valueOf(cliente.getSaldo()));
       // resultadoText.setText(String.copyValueOf((Double.parseDouble(saldoText.getText()))-(Double.parseDouble(retirarText.getText()));
         resultadoText.setText((cliente.getSaldo()-Double.parseDouble(retirarText.getText())));
    }
//************** END MVC ***********
    /**
     * Creates new form ViewRetiro
     */
    public ViewRetiro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saldoLabel = new javax.swing.JLabel();
        retirarLabel = new javax.swing.JLabel();
        resultadoLabel = new javax.swing.JLabel();
        saldoText = new javax.swing.JTextField();
        retirarText = new javax.swing.JTextField();
        resultadoText = new javax.swing.JTextField();
        limpiarBotonRetiro = new javax.swing.JButton();
        agregarBotonRetiro = new javax.swing.JButton();
        regresarBotonRetiro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        saldoLabel.setText("Saldo de Cuenta");

        retirarLabel.setText("Monto a Retirar");

        resultadoLabel.setText("Resultado");

        saldoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoTextActionPerformed(evt);
            }
        });

        retirarText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarTextActionPerformed(evt);
            }
        });

        resultadoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadoTextActionPerformed(evt);
            }
        });

        limpiarBotonRetiro.setText("Limpiar");

        agregarBotonRetiro.setText("Agregar");

        regresarBotonRetiro.setText("Regresar");
        regresarBotonRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBotonRetiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saldoLabel)
                            .addComponent(retirarLabel)
                            .addComponent(resultadoLabel))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saldoText)
                            .addComponent(retirarText)
                            .addComponent(resultadoText, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(limpiarBotonRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(agregarBotonRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(regresarBotonRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saldoLabel)
                            .addComponent(saldoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(retirarLabel))
                    .addComponent(retirarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultadoLabel)
                    .addComponent(resultadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiarBotonRetiro)
                    .addComponent(agregarBotonRetiro)
                    .addComponent(regresarBotonRetiro))
                .addGap(138, 138, 138))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBotonRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBotonRetiroActionPerformed
        controller.hide();
    }//GEN-LAST:event_regresarBotonRetiroActionPerformed

    private void saldoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoTextActionPerformed
        // TODO add your handling code here:
         controller.clienteGet(saldoText.getText());
    }//GEN-LAST:event_saldoTextActionPerformed

    private void resultadoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadoTextActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_resultadoTextActionPerformed

    private void retirarTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retirarTextActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRetiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRetiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRetiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRetiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRetiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBotonRetiro;
    private javax.swing.JButton limpiarBotonRetiro;
    private javax.swing.JButton regresarBotonRetiro;
    private javax.swing.JLabel resultadoLabel;
    public javax.swing.JTextField resultadoText;
    private javax.swing.JLabel retirarLabel;
    public javax.swing.JTextField retirarText;
    private javax.swing.JLabel saldoLabel;
    public javax.swing.JTextField saldoText;
    // End of variables declaration//GEN-END:variables
}
