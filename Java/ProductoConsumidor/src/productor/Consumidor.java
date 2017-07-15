package productor;

public class Consumidor extends Thread{

    Peterson s;
    public volatile int lista[], p, c, nelem;

    public Consumidor(int elem[], int p, int c, int nelem) {
        this.s = new Peterson();
        this.lista = elem;
        this.p = p;
        this.c = c;
        this.nelem = nelem;
    }

    public void run() {

        while (true) {
            s.preProt1();

            for(int i = 0;i < 100;i++) {
                lista[i] = 0;
                c++;
                nelem--;
                System.out.println("Elemento " + i + " consumido");
            }

            s.postPro1();
        }

    }

}
