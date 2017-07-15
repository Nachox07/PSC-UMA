import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author Nacho González-Garilleti <<nachox07@users.noreply.github.com>>
 */
public class WorkerMontecarlo extends SwingWorker<Void, Double> {

    private int iteracciones;

    public WorkerMontecarlo(Controlador ctr, int n) {
        this.addPropertyChangeListener(ctr);
        iteracciones = n;
    }

    @Override
    protected Void doInBackground() throws Exception {

        Random rnd = new Random();

        double puntosCir = 0, puntosCuad = 0, coordX, coordY, punto, radio = 1.0;
        int progreso = 0;

        for (double i = 1; i < iteracciones; i++) {
            coordX = rnd.nextDouble();
            coordY = rnd.nextDouble();

            punto = coordX * coordX + coordY * coordY;

            if(punto < (radio*radio)) {
                puntosCir++;
            }

            puntosCuad++;

            publish(4.0 * (puntosCir/puntosCuad));

            progreso = (int) Math.round(i/iteracciones*100);
            firePropertyChange("progress1",0, progreso);
        }

        firePropertyChange("progress1",0, Math.max(100, progreso));

        return null;

    }

    protected void process(List<Double> n){
        Iterator it = n.iterator();
        double nu = 0;

        while(it.hasNext()) {
            nu = (double) it.next();
            firePropertyChange("final1",0,nu);
        }
    }

}
