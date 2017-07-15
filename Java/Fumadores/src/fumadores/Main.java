package fumadores;

public class Main {

    public static void main(String[] args) {

        Mesa mes = new Mesa();

        Fumador f1 = new Fumador(0, mes);
        Fumador f2 = new Fumador(1, mes);
        Fumador f3 = new Fumador(2, mes);

        Agente ag = new Agente(mes);

        ag.start();

        f1.start();
        f2.start();
        f3.start();



    }

}
