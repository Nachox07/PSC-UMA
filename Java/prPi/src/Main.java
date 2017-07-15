import javax.swing.*;

/**
 * @author Nacho González-Garilleti <<nachox07@users.noreply.github.com>>
 */
public class Main{

    public static void crearGUI(JFrame ventana){
        Panel panel = new Panel();
        Controlador ctr = new Controlador(panel);

        panel.controlador(ctr);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setContentPane(panel);
        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final JFrame ventana = new JFrame("Calculadora de PI");
        SwingUtilities.invokeLater(() -> {
            crearGUI(ventana);
        });
    }

}
