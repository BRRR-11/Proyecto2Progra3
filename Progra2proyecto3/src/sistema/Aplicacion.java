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
        
        sistema.presentacion.Consultar.Model modelConsultar =new sistema.presentacion.Consultar.Model() ;
        sistema.presentacion.Consultar.ViewConsultar viewConsultar = new sistema.presentacion.Consultar.ViewConsultar();
        sistema.presentacion.Consultar.Controller controllerConsultar = new sistema.presentacion.Consultar.Controller(modelConsultar,viewConsultar);
        CONSULTAR = controllerConsultar;
        
        sistema.presentacion.Retiro.Model modelRetiro =new sistema.presentacion.Retiro.Model() ;
        sistema.presentacion.Retiro.ViewRetiro viewRetiro = new sistema.presentacion.Retiro.ViewRetiro();
        sistema.presentacion.Retiro.Controller controllerRetiro = new sistema.presentacion.Retiro.Controller(modelRetiro,viewRetiro);
        RETIRO = controllerRetiro;
        
        sistema.presentacion.CambioClave.Model modelCambioClave =new sistema.presentacion.CambioClave.Model() ;
        sistema.presentacion.CambioClave.ViewCambio viewCambioClave = new sistema.presentacion.CambioClave.ViewCambio();
        sistema.presentacion.CambioClave.Controller controllerCambioClave = new sistema.presentacion.CambioClave.Controller(modelCambioClave,viewCambioClave);
        CAMBIO = controllerCambioClave;
        
        
        INICIO.show();
        System.out.print(" Listo");
    }
    public static sistema.presentacion.Inicial.Controller INICIO;
    public static sistema.presentacion.Principal.Controller PRINCIPAL;
    public static sistema.presentacion.Consultar.Controller CONSULTAR;
    public static sistema.presentacion.Retiro.Controller RETIRO;
    public static sistema.presentacion.CambioClave.Controller CAMBIO;
}
