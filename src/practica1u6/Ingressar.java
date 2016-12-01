
package practica1u6;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ingressar implements Runnable{
    
    private final Cuenta cuenta;
    private final int idingressador;
    private static float ingres;
    private float saldo;

    public Ingressar(Cuenta cuenta, int idingressador) {
        this.cuenta = cuenta;
        this.idingressador = idingressador;
    }
    
    
    @Override
    public void run(){        
       Random rn = new Random();
       ingres = rn.nextInt(10);
        while(Boolean.TRUE){    
            cuenta.put(ingres);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Retirar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
