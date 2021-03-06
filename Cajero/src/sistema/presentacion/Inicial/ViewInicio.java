/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.Inicial;
import java.util.Observable;
import sistema.logico.Cliente;
/**
 *
 * @author ariqq
 */
public class ViewInicio extends javax.swing.JFrame implements java.util.Observer{
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
        // usuarioText.setText("");
        // passText.setText("");
        //usuarioText.setText(cliente.getNombre());
        //passText.setText(cliente.getContraseña());  
    }
//************** END MVC ***********
    /**
     * Creates new form ViewInicio
     */
    public ViewInicio() {
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

        usuarioLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        agregarBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();
        usuarioText = new javax.swing.JTextField();
        passText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usuarioLabel.setText("Usuario");

        passLabel.setText("Contraseña");

        agregarBoton.setText("Agregar");
        agregarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBotonActionPerformed(evt);
            }
        });

        cancelarBoton.setText("Cancelar");
        cancelarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioLabel)
                            .addComponent(passLabel))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passText, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(usuarioText)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(agregarBoton)
                        .addGap(120, 120, 120)
                        .addComponent(cancelarBoton)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioLabel)
                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarBoton)
                    .addComponent(cancelarBoton))
                .addGap(115, 115, 115))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBotonActionPerformed
        if(controller.verficarContra()==true){
            if(controller.validarUsuario(String.valueOf(usuarioText.getText()), String.valueOf(passText.getPassword()))){
                System.out.println("valido usuario");
                controller.principalShow(String.valueOf(usuarioText.getText()));
            }
        }
    }//GEN-LAST:event_agregarBotonActionPerformed

    private void cancelarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBotonActionPerformed
       usuarioText.setText("");
       passText.setText("");
    }//GEN-LAST:event_cancelarBotonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBoton;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JLabel passLabel;
    public javax.swing.JPasswordField passText;
    private javax.swing.JLabel usuarioLabel;
    public javax.swing.JTextField usuarioText;
    // End of variables declaration//GEN-END:variables

 
}
