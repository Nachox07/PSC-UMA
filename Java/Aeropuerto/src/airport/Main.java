package airport;

import java.util.concurrent.Semaphore;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public class Main {

    private static final int N_AVIONES = 10;
    private static final int N_CONTROL = 2;

    public static void main(String[] args) {
        try {

            Semaphore pista = new Semaphore(1, true);

            Control[] control = new Control[N_CONTROL];

            for (int i = 0; i < control.length; ++i) {
                control[i] = new Control(i, pista);
            }

            Thread[] h_control = new Thread[control.length];

            for (int i = 0; i < h_control.length; ++i) {
                h_control[i] = new Thread(control[i]);
                h_control[i].start();
            }

            Thread[] avion = new Thread[N_AVIONES];

            for (int i = 0; i < avion.length; ++i) {
                avion[i] = new Thread(new Avion(i, control));
                avion[i].start();
            }

            for (int i = 0; i < h_control.length; ++i) {
                h_control[i].join();
            }

            for (int i = 0; i < avion.length; ++i) {
                avion[i].join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

