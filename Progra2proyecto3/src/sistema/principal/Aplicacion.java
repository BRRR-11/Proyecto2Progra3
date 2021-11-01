
package sistema.principal;
        
//import sistema.presentacion.inicio.Controller;
//import sistema.presentacion.inicio.inicio;
//import sistema.presentacion.inicio.Model;

/**
 *
 * @author _ArianaQuesada_PabloChavarria_DanielBarrientos
 */
public class Aplicacion {

    public static void main(String[] args) {
       
        sistema.presentacion.inicio.Model modelClientes=new sistema.presentacion.inicio.Model() ;
        sistema.presentacion.inicio.ViewInicio viewClientes= new sistema.presentacion.inicio.ViewInicio();
        sistema.presentacion.inicio.Controller controllerInicio = new sistema.presentacion.inicio.Controller(modelClientes,viewClientes);//Cambiar model y el view
        INICIO = controllerInicio;
        
        sistema.presentacion.principal.Model modelPrincipal=new sistema.presentacion.principal.Model() ;
        sistema.presentacion.principal.ViewPrincipal viewPrincipal= new sistema.presentacion.principal.ViewPrincipal();
        sistema.presentacion.principal.Controller controllerPrincipal = new sistema.presentacion.principal.Controller(modelPrincipal,viewPrincipal);//Cambiar model y el view
        PRINCIPAL = controllerPrincipal;
        
        sistema.presentacion.clave.Model modelClave=new sistema.presentacion.clave.Model() ;
        sistema.presentacion.clave.ViewClave viewclave= new sistema.presentacion.clave.ViewClave();
        sistema.presentacion.clave.Controller controllerClave = new sistema.presentacion.clave.Controller(modelClave,viewclave);//Cambiar model y el view
        CLAVE = controllerClave;
        
        sistema.presentacion.retiro.Model modelRetiro=new sistema.presentacion.retiro.Model() ;
        sistema.presentacion.retiro.ViewRetiro viewRetiro= new sistema.presentacion.retiro.ViewRetiro();
        sistema.presentacion.retiro.Controller controllerRetiro = new sistema.presentacion.retiro.Controller(modelRetiro,viewRetiro);//Cambiar model y el view
        RETIRO = controllerRetiro;

 
        
       System.out.print("_ArianaQuesada_PabloChavarria_DanielBarrientos");
       RETIRO.show();
        
        
    }
    
    public static sistema.presentacion.inicio.Controller INICIO;
    public static sistema.presentacion.principal.Controller PRINCIPAL;
    public static sistema.presentacion.clave.Controller CLAVE;
    public static sistema.presentacion.retiro.Controller RETIRO;
}
