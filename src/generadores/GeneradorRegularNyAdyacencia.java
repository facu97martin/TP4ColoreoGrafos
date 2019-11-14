package generadores;

import generadores.interfaces.GeneradorGrafos;
import grafo.MatrizSimetrica;

public class GeneradorRegularNyAdyacencia implements GeneradorGrafos {

	private int nodos;
	private int grado;

	public GeneradorRegularNyAdyacencia(int nodos, double adyacencia) {

		this.nodos = nodos;		
		this.grado = Math.max(0, (int) (this.nodos * adyacencia) - 1);
	}

	@Override
	public MatrizSimetrica generar() {

		MatrizSimetrica matriz = new MatrizSimetrica(nodos);

		int gradoAct = grado;

		while (gradoAct > 0) {
			if (gradoAct % 2 == 0) {
				for (int i = 0; i < nodos; i++) {
					matriz.setValor(i, (nodos + i + gradoAct / 2) % nodos, true);
					matriz.setValor(i, (nodos + i - gradoAct / 2) % nodos, true);
				}
				gradoAct -= 2;
			} else {
				for (int i = 0; i < nodos / 2; i++) {
					matriz.setValor(i, i + nodos / 2, true);
				}
				gradoAct -= 1;
			}
		}
		
		matriz.vectorShuffle();

		return matriz;

	}
}
