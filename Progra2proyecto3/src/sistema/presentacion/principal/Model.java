/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.Principal;

/**
 *
 * @author ariqq
 */
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable{
    
    // Model attributes here
    // Model gets and sets here

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
        this.commit();
    }
    
    public void commit(){
        this.setChanged();
        this.notifyObservers();
    }
    
}
