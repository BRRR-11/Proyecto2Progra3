/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.CambioClave;
import java.util.Observable;
import javax.swing.JOptionPane;
import sistema.Aplicacion;
import sistema.logico.Cliente;
/**
 *
 * @author ariqq
 */
public class ViewCambio extends javax.swing.JFrame implements java.util.Observer{
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
    }
//************** END MVC ***********
    /**
     * Creates new form ViewCambio
     */
    public ViewCambio() {
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

        actualLabel = new javax.swing.JLabel();
        nuevaLabel = new javax.swing.JLabel();
        confirmarLabel = new javax.swing.JLabel();
        actualPass = new javax.swing.JPasswordField();
        nuevaPass = new javax.swing.JPasswordField();
        confirmarPass = new javax.swing.JPasswordField();
        limpiarBoton = new javax.swing.JButton();
        aceptarBoton = new javax.swing.JButton();
        regresarBoton = new javax.swing.JButton();
        usuarioLabelCambio = new javax.swing.JLabel();
        usuarioTextCambio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actualLabel.setText("Clave Actual");

        nuevaLabel.setText("Clave Nueva");

        confirmarLabel.setText("Confirmar Clave");

        limpiarBoton.setText("Limpiar");
        limpiarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBotonActionPerformed(evt);
            }
        });

        aceptarBoton.setText("Aceptar");
        aceptarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBotonActionPerformed(evt);
            }
        });

        regresarBoton.setText("Regresar");
        regresarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBotonActionPerformed(evt);
            }
        });

        usuarioLabelCambio.setText("Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actualLabel)
                            .addComponent(nuevaLabel)
                            .addComponent(confirmarLabel)
                            .addComponent(usuarioLabelCambio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(limpiarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aceptarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(regresarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(usuarioTextCambio, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(actualPass, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nuevaPass, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(confirmarPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioLabelCambio)
                    .addComponent(usuarioTextCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualLabel)
                    .addComponent(actualPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevaLabel)
                    .addComponent(nuevaPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarLabel)
                    .addComponent(confirmarPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiarBoton)
                    .addComponent(aceptarBoton)
                    .addComponent(regresarBoton))
                .addGap(161, 161, 161))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBotonActionPerformed
        controller.hide();
    }//GEN-LAST:event_regresarBotonActionPerformed

    private void aceptarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBotonActionPerformed
        if(controller.verficarContra()== true){
            if(controller.validarContraseña(String.valueOf(actualPass.getPassword()))){
                if(String.valueOf(nuevaPass.getPassword()).equals(String.valueOf(confirmarPass.getPassword()))){
                    controller.modificarContraseña(String.valueOf(usuarioTextCambio.getText()),String.valueOf(nuevaPass.getPassword()));
                    actualPass.setText("");
                    nuevaPass.setText("");
                    confirmarPass.setText("");
                    JOptionPane.showMessageDialog(null,"Clave modificada exitosamente");
                }
                else{
                    JOptionPane.showMessageDialog(null,"La contraseña no coincide");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"La contraseña es incorrecta");
            }
        }
    }//GEN-LAST:event_aceptarBotonActionPerformed

    private void limpiarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBotonActionPerformed
        actualPass.setText("");
        nuevaPass.setText("");
        confirmarPass.setText("");
    }//GEN-LAST:event_limpiarBotonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCambio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBoton;
    private javax.swing.JLabel actualLabel;
    public javax.swing.JPasswordField actualPass;
    private javax.swing.JLabel confirmarLabel;
    private javax.swing.JPasswordField confirmarPass;
    private javax.swing.JButton limpiarBoton;
    private javax.swing.JLabel nuevaLabel;
    public javax.swing.JPasswordField nuevaPass;
    private javax.swing.JButton regresarBoton;
    private javax.swing.JLabel usuarioLabelCambio;
    public javax.swing.JTextField usuarioTextCambio;
    // End of variables declaration//GEN-END:variables
}
