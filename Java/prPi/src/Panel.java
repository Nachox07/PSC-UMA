import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public class Panel extends JPanel{

	private JLabel label = new JLabel("Numero de iteraciones: ");

	private JTextField tam = new JTextField(16);
	private JButton comenzar = new JButton("COMENZAR");
	
	private JTextField pi1 = new JTextField(16);
	private JTextField pi2 = new JTextField(16);
	
	private JProgressBar progreso = new JProgressBar(0,100);
	private JProgressBar progreso2 = new JProgressBar(0,100);

	
	
	public Panel(){
		this.setLayout(new GridLayout(3,1,0,0));
		JPanel fila1=new JPanel();
		fila1.add(label);
		fila1.add(tam);
		fila1.add(comenzar);
		this.add(fila1);
		
		JPanel fila2=new JPanel();
		fila2.add(new JLabel("Montecarlo"));
		progreso.setStringPainted(true);
		fila2.add(progreso);
		fila2.add(pi1);
		this.add(fila2);

		JPanel fila3=new JPanel();
		fila3.add(new JLabel("Series GLe."));
		progreso2.setStringPainted(true);
		fila3.add(progreso2);
		fila3.add(pi2);
		this.add(fila3);

	}
	
	public void controlador(ActionListener ctr){
		comenzar.addActionListener(ctr);
		comenzar.setActionCommand("COMENZAR");
	}
	
	public int numero(){
		return Integer.parseInt(tam.getText());
	}
	
	public void escribeFinal(Double v) {
		pi1.setText(v.toString());
	}

	public void escribeFinal2(Double v) {
		pi2.setText(v.toString());
	}
	
	public void limpia1(){
		pi1.setText("");
	}
	
	public void limpia2(){
		pi2.setText("");
	}
	

	public void progreso(int p){
		progreso.setValue(p);
	}
	
	public void progreso2(int p){
		progreso2.setValue(p);
	}

}
