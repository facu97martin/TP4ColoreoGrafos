package generadores;

import generadores.exceptions.GrafoRegularException;
import generadores.interfaces.GeneradorGrafos;
import grafo.MatrizSimetrica;

public class GeneradorRegularNyGrado implements GeneradorGrafos {

	private int nodos;
	private int grado;

	public GeneradorRegularNyGrado(int nodos, int grado) throws Exception {

		if (nodos % 2 != 0 && grado % 2 != 0) {
			throw new GrafoRegularException(
					"No se puede formar un grafo regular con grado impar, si tiene una cantidad impar de nodos");
		}
		this.nodos = nodos;
		this.grado = grado;
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
