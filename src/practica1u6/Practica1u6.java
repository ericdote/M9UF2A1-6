package practica1u6;

public class Practica1u6 {

    private static Cuenta cuenta;
    private static Thread[] ingressador;
    private static Thread[] retirador;
    private static final int CANTIDADINGRESSADORES = 5;
    private static final int CANTIDADRETIRADORES = 5;

    /**
     * Metode main e qual inicliatza la clase Cuenta  i crea els arrays de Ingressador i Retirador.
     * Fa un bucle recorrent tots els retiradors i ingressadors per anar realitzant les diferents operacions que realitza el programa.
     * @param args 
     */
    public static void main(String[] args) {
        cuenta = new Cuenta();
        ingressador = new Thread[CANTIDADINGRESSADORES];
        retirador = new Thread[CANTIDADRETIRADORES];
        for (int i = 0; i < CANTIDADRETIRADORES; i++) {
            retirador[i] = new Thread(new Retirar(cuenta, i));
            retirador[i].start();
        }
        for (int i = 0; i < CANTIDADINGRESSADORES; i++) {
            ingressador[i] = new Thread(new Ingressar(cuenta, i));
            ingressador[i].start();
        }
    }

}
