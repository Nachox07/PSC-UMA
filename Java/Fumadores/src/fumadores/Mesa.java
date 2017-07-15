package fumadores;

import java.util.Random;
import java.util.concurrent.locks.*;

import static java.lang.Thread.sleep;

public class Mesa {

    private int id;
    private boolean fumar = false;
    private Lock l = new ReentrantLock(true);

    private Condition okFumar = l.newCondition();
    private Condition okIngredientes = l.newCondition();

    private static Random r = new Random();

    public void QuieroFumar(int id) {

        l.lock();

        try {

            while (!fumar || (fumar && this.id != id)) {

                try {
                    okFumar.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        } finally {

            l.unlock();

        }

    }

    public void Fumar(){

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void FinFumar() {
        l.lock();

        try {
            fumar = false;
            okIngredientes.signal();
        } finally {
            l.unlock();
        }

    }

    public void ponerIngredientes() {

        l.lock();

        try {

            while (fumar) {

                try {
                    okIngredientes.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (!fumar) {
                id = r.nextInt(3);
                fumar = true;
                okFumar.signalAll();
            }

        } finally {
            l.unlock();
        }

    }

}
