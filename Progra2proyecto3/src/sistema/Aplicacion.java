/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author ariqq
 */
public class Aplicacion {

    public static void main(String[] args) {
        System.out.print("Hola");
        
        sistema.presentacion.Inicial.Model modelInicio=new sistema.presentacion.Inicial.Model() ;
        sistema.presentacion.Inicial.ViewInicio viewInicio = new sistema.presentacion.Inicial.ViewInicio();
        sistema.presentacion.Inicial.Controller controllerInicio = new sistema.presentacion.Inicial.Controller(modelInicio,viewInicio);
        INICIO = controllerInicio;
        
        sistema.presentacion.Principal.Model modelPrincipal=new sistema.presentacion.Principal.Model() ;
        sistema.presentacion.Principal.ViewPrincipal viewPrincipal = new sistema.presentacion.Principal.ViewPrincipal();
        sistema.presentacion.Principal.Controller controllerPrincipal = new sistema.presentacion.Principal.Controller(modelPrincipal,viewPrincipal);
        PRINCIPAL = controllerPrincipal;
        
        
        INICIO.show();
        System.out.print(" Listo");
    }
    public static sistema.presentacion.Inicial.Controller INICIO;
    public static sistema.presentacion.Principal.Controller PRINCIPAL;
}
