package sistemaIndustrial;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public class SistemaIndustrial {


    static Semaphore trabajando = new Semaphore (0, true);
    static Semaphore [] sensores = new Semaphore [3];

    static Random r = new Random ();
    static int [] valores = new int [3];

    public static class Trabajador extends Thread {

        public void run () {

            while (true) {

                try {
                    trabajando.acquire ();
                    trabajando.acquire ();
                    trabajando.acquire ();

                    System.out.println ("valores medidos: " + valores [0] + " " + valores [1] + " " + valores [2]);

                    sensores [0].release ();
                    sensores [1].release ();
                    sensores [2].release ();

                } catch (InterruptedException e) {
                    throw new RuntimeException ("Error en el Trabajador");
                }

            }

        }

    }

    public static class Sensor extends Thread {

        private int indice;

        public Sensor (int i) {
            indice = i;
        }

        public void run () {
       
            while (true) {
       
                try {
                    sensores [indice].acquire();
                    valores [indice] = r.nextInt (100);
                    trabajando.release ();
                } catch (InterruptedException e) {
                    throw new RuntimeException ("Error en el sensor");
                }
       
            }
       
        }

    }

    public static void main (String [] args) {

        sensores [0] = new Semaphore (1, true);
        sensores [1] = new Semaphore (1, true);
        sensores [2] = new Semaphore (1, true);

        Trabajador trabajador = new Trabajador ();
        Sensor sensor0 = new Sensor (0);
        Sensor sensor1 = new Sensor (1);
        Sensor sensor2 = new Sensor (2);

        trabajador.start ();
        sensor0.start ();
        sensor1.start ();
        sensor2.start ();

    }

}