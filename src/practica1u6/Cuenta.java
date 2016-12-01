/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1u6;

/**
 *
 * @author ALUMNEDAM
 */
public class Cuenta {

    private static float saldo = 100;
    public boolean estat = Boolean.FALSE;

    public synchronized void get(float retirada) {
        while (estat && (saldo-retirada) > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        this.saldo -= retirada;
        estat = !estat;
        System.out.println("S'ha realitzat una retirada de: " + retirada + " el saldo actual es: " + saldo);
        notifyAll();
    }

    public synchronized void put(float ingres) {
        while (estat) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        this.saldo += ingres;
        estat = !estat;
        System.out.println("S'ha realitzat un ingres de: " + ingres + " el saldo actual es: " + saldo);
        notifyAll();
    }
}
