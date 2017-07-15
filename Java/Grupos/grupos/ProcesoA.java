package grupos;

import java.util.Random;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public class ProcesoA extends Thread {

	private int id;
	private Grupo g;
	private Random r = new Random();

	public ProcesoA(int id,Grupo g){
		this.id = id;
		this.g = g;
	}

	public void run(){

		while (true){

			try{
				g.nuevoGrupoA(id);
				Thread.sleep(r.nextInt(2000));
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		
		}

	}

}
