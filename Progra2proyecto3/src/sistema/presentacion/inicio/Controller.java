/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.inicio;


import java.io.IOException;
import sistema.logico.Cliente;
import java.util.ArrayList;
import sistema.principal.Aplicacion;
import java.util.Random;

public class Controller {
     Model model;
     inicio view;

    public Controller(Model model, inicio view) {
        this.model = model;
        this.view = view;
       
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
    }
    
    public void exit(){
    }
    
    public boolean verificaContraseña()
    {
        String contraseña=this.view.TextPass.getText();
        int contador=0;
        int cant=0;
        int mayus = 0;
        int minus=0;
        int num=0;
       

        if(contraseña.length()==7)
        {
            cant+=1;
        }
        
        for(int j=0; j<contraseña.length();j++) {

            char caracter= contraseña.charAt(j);
            if(Character.isUpperCase(caracter))
            {
                mayus+=1;
            }
        }
         //////////////////////////////////////////////
         for(int j=0; j<contraseña.length();j++) {

            char caracter= contraseña.charAt(j);
            if(Character.isLowerCase(caracter))
            {
                minus+=1;
            }
        }
         ///////////////////////////////////////////////
         for(int j=0; j<contraseña.length();j++) {

            char caracter= contraseña.charAt(j);
            if(Character.isDigit(caracter))
            {
                num+=1;
            }
        }

        if(cant==1&&mayus>1&&minus>1&&num>1)
        {
            System.out.println("La contaseña es fuerte");
            return true;
        }
        else
        {
            System.out.println("La contraseña es débil");
            return false;
        }
    }
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    /*public void clientesShow(){
        this.hide();
        Application.CLIENTES.show();
    }
    
    public void facturasShow(){
        this.hide();
        //Application.FACTURAS.show();
    } */
    
}