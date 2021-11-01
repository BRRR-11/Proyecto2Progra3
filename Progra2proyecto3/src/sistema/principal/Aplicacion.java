
package sistema.principal;
        
import sistema.presentacion.inicio.Controller;
import sistema.presentacion.inicio.inicio;
import sistema.presentacion.inicio.Model;

/**
 *
 * @author _ArianaQuesada_PabloChavarria_DanielBarrientos
 */
public class Aplicacion {

    public static void main(String[] args) {
       /* Model model = new Model();
        Mapa m = new Mapa();
        Controller controller = new Controller(model,m);
        m.setVisible(true);
        controller.show();*/
        
       
        sistema.presentacion.inicio.Model modelClientes=new sistema.presentacion.inicio.Model() ;
        sistema.presentacion.inicio.inicio viewClientes= new sistema.presentacion.inicio.inicio();
        sistema.presentacion.inicio.Controller controllerInicio = new sistema.presentacion.inicio.Controller(modelClientes,viewClientes);//Cambiar model y el view
        INICIO = controllerInicio;
        
        sistema.presentacion.principal.Model modelPrincipal=new sistema.presentacion.principal.Model() ;
        sistema.presentacion.principal.ViewPrincipal viewPrincipal= new sistema.presentacion.principal.ViewPrincipal();
        sistema.presentacion.principal.Controller controllerPrincipal = new sistema.presentacion.principal.Controller(modelPrincipal,viewPrincipal);//Cambiar model y el view
        PRINCIPAL = controllerPrincipal;

 
        
       System.out.print("_ArianaQuesada_PabloChavarria_DanielBarrientos");

       INICIO.show();
        
        
    }
    
    //public static sistema.presentacion.prestamoCliente.Controller PRESTAMOCLIENTE;
    public static sistema.presentacion.inicio.Controller INICIO;
    public static sistema.presentacion.principal.Controller PRINCIPAL;

    
}
