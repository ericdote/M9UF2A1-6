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
public class Retirar implements Runnable {

    private final Cuenta cuenta;
    private final int idretirador;
    private float retirada;
        private float saldo;


    public Retirar(Cuenta cuenta, int idretirador) {
        this.cuenta = cuenta;
        this.idretirador = idretirador;
    }

    @Override
    public void run() {
        retirada = (float) Math.random() * (200 - 0) + 200;
        saldo -= retirada;
        while (Boolean.TRUE) {
            System.out.println("El ingressador " + idretirador + " ingressa: " + cuenta.get(retirada));
        }
    }

}
