package generadores;

import generadores.interfaces.GeneradorGrafos;
import grafo.MatrizSimetrica;

public class GeneradorAleatorioNyProb implements GeneradorGrafos {

	private int nodos;
	private double probArista; // entre 0 y 1

	public GeneradorAleatorioNyProb(int nodos, double probArista) {
		this.nodos = nodos;
		this.probArista = probArista;
	}

	@Override
	public MatrizSimetrica generar() {

		MatrizSimetrica matriz = new MatrizSimetrica(nodos);

		for (int i = 0; i < nodos; i++) {
			for (int j = i + 1; j < nodos; j++) {
				matriz.setValor(i, j, Math.random() <= this.probArista);
			}
		}

		return matriz;
	}

}
