package grupos;

import java.util.concurrent.*;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public class Grupo {

	private boolean puertaA = true;
	private boolean puertaB = true;
	private boolean puertaSalida = false;

	private int maxTamGrupo = 6;
	private int tamGrupo = 0;
	
	public synchronized void nuevoGrupoA(int id) throws InterruptedException {

		// Si el grupo esta completo, se vacia
		if(tamGrupo == maxTamGrupo) {
			puertaSalida = true;
		}

		// Si se vacia se vuelve a abrir la puerta
		if(tamGrupo == 0 && puertaSalida) {
			puertaA = true;
			puertaB = true;
			puertaSalida = false;
		}

		notifyAll();

		//while(!puertaA && tamGrupo < maxTamGrupo)
		while(!puertaA || puertaSalida)
			wait();

		System.out.println("proceso A "+id+" llega");

		tamGrupo++;

		// Si es el ultimo que llega, cierra la puerta
		if(tamGrupo == maxTamGrupo) {
			System.out.println("GRUPO ENTERO - PROCESO A");
			puertaA = false;
		}

		while(!puertaSalida)
			wait();

		System.out.println("proceso A "+id+" sale");

		tamGrupo--;

	}
	
	public synchronized void nuevoGrupoB(int id) throws InterruptedException {

		// Si el grupo esta completo, se vacia
		if(tamGrupo == maxTamGrupo) {
			puertaSalida = true;
		}

		// Si se vacia se vuelve a abrir la puerta
		if(tamGrupo == 0 && puertaSalida) {
			puertaA = true;
			puertaB = true;
			puertaSalida = false;
		}

		notifyAll();

		while (!puertaB || puertaSalida)
			wait();

		System.out.println("proceso B "+id+" llega");

		tamGrupo++;

		// Si es el ultimo que llega, cierra la puerta
		if(tamGrupo == maxTamGrupo) {
			System.out.println("GRUPO ENTERO - PROCESO B");
			puertaB = false;
		}

		while(!puertaSalida)
			wait();

		System.out.println("proceso B "+id+" sale");

		tamGrupo--;

	}
}
