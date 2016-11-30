
package practica1u6;


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
        
        ingres = (float) Math.random() * (200 - 0) + 200;
        saldo += ingres;
        while(Boolean.TRUE){    
           System.out.println("El ingressador " + idingressador + " ingressa: " + cuenta.get(ingres));
        }
    }
}
