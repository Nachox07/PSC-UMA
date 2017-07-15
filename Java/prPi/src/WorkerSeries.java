import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nacho González-Garilleti <<nachox07@users.noreply.github.com>>
 */
public class WorkerSeries extends SwingWorker<Void,Double> {

    private int iteracciones;

    public WorkerSeries(Controlador ctr, int n) {
        this.addPropertyChangeListener(ctr);
        iteracciones = n;
    }

    @Override
    protected Void doInBackground() throws Exception {

        int progreso = 0;
        Double pi = 0.0, a, b, d = 1.0;

        for (double i = -1; i < iteracciones; i++) {

            a = 4.0 / d;
            b = 4.0 / (d + 2);

            pi += a - b;

            d += 4.0;

            publish(pi);

            progreso = (int) Math.round(i/iteracciones*100);
            firePropertyChange("progress2",0, progreso);
        }

        firePropertyChange("progress2",0, Math.max(100, progreso));

        return null;

    }

    @Override
    protected final void process(List<Double> n){
        Iterator it = n.iterator();
        double nu = 0;

        while(it.hasNext()) {
            nu = (double) it.next();
            firePropertyChange("final2",0,nu);
        }
    }

}
