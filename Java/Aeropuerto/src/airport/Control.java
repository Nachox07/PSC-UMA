package airport;

import java.util.concurrent.Semaphore;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public class Control implements Runnable {

    private Semaphore avion_espera = new Semaphore(0, true);
    private Semaphore control_espera = new Semaphore(0, true);
    private Semaphore pista_espera = new Semaphore(0, true);
    private Semaphore pista;
    private int id;

    public Control(int id, Semaphore p) {
        this.id = id;
        this.pista = p;
    }

    public void solicitar_permiso() throws InterruptedException {
        control_espera.release();
        avion_espera.acquire();
    }

    public void fin_aterrizaje() {
        pista_espera.release();
    }

    public void esperar_solicitud() throws InterruptedException {
        control_espera.acquire();
    }

    public void atender_solicitud() throws InterruptedException {

        pista.acquire();

        try {
            avion_espera.release();
            pista_espera.acquire();
        } finally {
            pista.release();
        }

    }

    public void run() {
        try {
            while (true) {
                esperar_solicitud();
                atender_solicitud();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}