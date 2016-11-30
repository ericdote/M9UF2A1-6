/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1u6;

public class Practica1u6 {

    private static Cuenta cuenta;
    private static Thread[] ingressador;
    private static Thread[] retirador;
    private static final int CANTIDADINGRESSADORES = 5;
    private static final int CANTIDADRETIRADORES = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cuenta = new Cuenta();
        ingressador = new Thread[CANTIDADINGRESSADORES];
        retirador = new Thread[CANTIDADRETIRADORES];
        for (int i = 0; i < CANTIDADRETIRADORES; i++) {
            System.out.println(i);
            retirador[i] = new Thread(new Retirar(cuenta, i));
            System.out.println(i);
            retirador[i].start();
        }
        for (int i = 0; i < CANTIDADINGRESSADORES; i++) {
            System.out.println(i);
            ingressador[i] = new Thread(new Ingressar(cuenta, i));
            ingressador[i].start();
        }
    }

}
