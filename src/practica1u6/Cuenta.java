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

    private static float saldo = 1500;
    private boolean estat = Boolean.FALSE;

    public synchronized float get(float retirada) {
        while (!estat) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        estat = !estat;
        notify();
        return saldo - retirada;
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
        notify();
    }
}
