package fumadores;

import java.util.Random;

public class Agente extends Thread{

    private Mesa mes;

    public Agente(Mesa mes) {
        this.mes = mes;
    }

    public void run() {

        while(true) {

            mes.ponerIngredientes();
            System.out.println("Ingredientes puestos");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
