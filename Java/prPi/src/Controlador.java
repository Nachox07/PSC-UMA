import java.awt.event.*;
import java.beans.*;
import java.awt.*;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public  class Controlador implements ActionListener,PropertyChangeListener{

	private Panel panel;
    private WorkerMontecarlo wm;
    private WorkerSeries ws;
		
	public Controlador(Panel panel){
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("COMENZAR")){

			panel.progreso(0);
			panel.progreso2(0);
			panel.limpia1();
			panel.limpia2();

			int n = panel.numero();

            WorkerMontecarlo wm = new WorkerMontecarlo(this, n);
            WorkerSeries ws = new WorkerSeries(this, n);

            wm.execute();
            ws.execute();

        }
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		if(arg0.getPropertyName().equals("progress1")) {

		    int progreso = (Integer) arg0.getNewValue();

			panel.progreso(progreso);

		} else if(arg0.getPropertyName().equals("progress2")) {

			int progreso = (Integer) arg0.getNewValue();
			panel.progreso2(progreso);

        } else if(arg0.getPropertyName().equals("final1")) {
            double nu = (double) arg0.getNewValue();

			panel.escribeFinal(nu);

		} else if(arg0.getPropertyName().equals("final2")) {
			double nu = (double) arg0.getNewValue();

			panel.escribeFinal2(nu);
		}

	}

}
