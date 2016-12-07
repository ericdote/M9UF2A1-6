
package practica1u6;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ingressar implements Runnable{
    
    private final Cuenta cuenta;
    private final int idingressador;
    private static float ingres;
    private float saldo;
    /**
     * Constructor que inicialitza cuenta i el idingressador
     * @param cuenta
     * @param idingressador 
     */
    public Ingressar(Cuenta cuenta, int idingressador) {
        this.cuenta = cuenta;
        this.idingressador = idingressador;
    }
    
    /**
     * Crea el Random i fa un while infinit. 
     * Calcula un numero al atzar per despres cridat al metode put enviant per parametre el ingres(numero atzar) per realitzar les operacions
     * I espera 1 segon per mostrar la seguent accio.
     */
    @Override
    public void run(){        
       Random rn = new Random();
        while(Boolean.TRUE){ 
            ingres = rn.nextInt(10);
            cuenta.put(ingres);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Retirar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
