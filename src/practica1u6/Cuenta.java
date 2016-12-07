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
    /**
     * Metode que realitza una retirada de diners.
     * Aquest metode mentres l'estat o el saldo sigui inferior a 0 mostra un missatge per pantalla i posa el fil en espera.
     * En cas de que no sigui com el cas anterior es canvia l'estat, es recalcula el saldo i es mostra l'operacio per pantalla. 
     * Després d'aixo s'alliberen els fils que estaben en wait.
     * @param retirada li arriba la quantitat de diners a retirar del saldo
     */
    public synchronized void get(float retirada) {        
        while (estat  || (saldo-retirada) < 0) {
            try {
                if(saldo-retirada < 0){
                    System.out.println("Intentando retirar: " + retirada + " esperando Ingreso...");
                }                
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        estat = !estat;
        this.saldo -= retirada;        
        System.out.println("S'ha realitzat una retirada de: " + retirada + " el saldo actual es: " + saldo);
        estat = !estat;
        notifyAll();
    }
    /**
     * Metode semblat al de ingresar, pero que mira l'estat per posar o no el fil en wait.
     * En cas de que no el pos en wait, canvia l'estat, actualitza el saldo i mostra per pantalla el saldo actual i de quina quantitat ha sigut el ingres.
     * @param ingres la quantitat de diners que li entra per paramentre
     */
    public synchronized void put(float ingres) {
        while (estat) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        estat = !estat;
        this.saldo += ingres;        
        System.out.println("S'ha realitzat un ingres de: " + ingres + " el saldo actual es: " + saldo);
        estat = !estat;
        notifyAll();
    }
}
