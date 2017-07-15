package airport;

import java.util.Random;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */
public class Avion implements Runnable {

    private Random rnd = new Random();
    private int id;
    private Control[] control;

    public Avion(int id, Control[] c) {
        this.id = id;
        this.control = c;
    }

    public void run() {
        try {

            while (true) {

                int c = rnd.nextInt(control.length);

                control[c].solicitar_permiso();

                System.out.println("Maverick "+ id +" a control: Pista visualizada, aterrizaje en proceso");

                Thread.sleep(1000);

                System.out.println("Maverick "+ id +" a control: Aterrizaje completado");

                control[c].fin_aterrizaje();

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
