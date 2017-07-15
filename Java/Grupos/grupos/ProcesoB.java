package grupos;

import java.util.Random;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public class ProcesoB extends Thread{
	private int id;
	private Grupo g;
	private Random r = new Random();
	public ProcesoB(int id,Grupo g){
		this.id = id;
		this.g = g;
	}
	public void run(){

		while (true){

			try{
				g.nuevoGrupoB(id);
				Thread.sleep(r.nextInt(2000));
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		
		}

	}

}
