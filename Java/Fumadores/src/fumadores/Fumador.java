package fumadores;

public class Fumador extends Thread{

    private Mesa mes;
    private int id;

    public Fumador(int id, Mesa mes) {

        this.id = id;
        this.mes = mes;

    }

    public void run() {

        while(true) {

            mes.QuieroFumar(id);

            System.out.println("Fumador " + id + " fumando");

            mes.Fumar();
            mes.FinFumar();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
