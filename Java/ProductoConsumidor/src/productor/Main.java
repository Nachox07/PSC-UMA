package productor;

public class Main {

    public static void main(String[] args) {

        int elem[] = new int[100];
        int p = 0;
        int c = 0;
        int nelem = 0;

	    Productor proc = new Productor(elem, p, c, nelem);
	    Consumidor cons = new Consumidor(elem, p, c, nelem);

        Thread pT = new Thread(proc);
        Thread cT = new Thread(cons);

        pT.start();
        cT.start();
    }
}
