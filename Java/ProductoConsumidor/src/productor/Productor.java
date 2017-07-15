package productor;

public class Productor extends Thread{

    Peterson s;
    int lista[], p, c, nelem;

    public Productor(int elem[], int p, int c, int nelem) {
        this.s = new Peterson();
        this.lista = elem;
        this.p = p;
        this.c = c;
        this.nelem = nelem;
    }

    public void run() {

        while (true) {
            s.preProt0();

            for(int i = 0;i < 100;i++) {
                lista[i] = i;
                p++;
                nelem++;
                System.out.println("Elemento " + i + " producido");
            }

            s.postPro0();
        }
    }

}
