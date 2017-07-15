package grupos;

/**
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

public class Principal {
		
		public static void main(String[] args){

			int numProc = 5;

			Grupo g = new Grupo();

			ProcesoA[] pA = new ProcesoA[numProc];
			ProcesoB[] pB = new ProcesoB[numProc];

			for (int i = 0; i<numProc; i++){
				pA[i] = new ProcesoA(i,g);
				pB[i] = new ProcesoB(i,g);
			}

			for (int i = 0; i<numProc; i++){
				pA[i].start();
				pB[i].start();
			}

		}

	

}
