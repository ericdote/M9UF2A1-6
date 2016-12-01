/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1u6;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Random rn = new Random();
       retirada = rn.nextInt(50);
        while (Boolean.TRUE) {
            cuenta.get(retirada);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Retirar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
