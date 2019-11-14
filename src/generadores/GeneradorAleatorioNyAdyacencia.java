package generadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import generadores.interfaces.GeneradorGrafos;
import grafo.MatrizSimetrica;

public class GeneradorAleatorioNyAdyacencia implements GeneradorGrafos {

	private int nodos;
	private double porcAdyacencia; // entre 0 y 1
	private int aristasPosibles;
	private int aristasGeneradas;

	public GeneradorAleatorioNyAdyacencia(int nodos, double porcAdyacencia) {
		this.nodos = nodos;
		this.porcAdyacencia = porcAdyacencia;

		this.aristasPosibles = (nodos * (nodos - 1)) / 2;
		this.aristasGeneradas = (int) (this.aristasPosibles * this.porcAdyacencia);

	}

	@Override
	public MatrizSimetrica generar() {

		Random random = new Random(System.currentTimeMillis());

		MatrizSimetrica matriz = new MatrizSimetrica(nodos);

		List<Integer> listaPosibles = new ArrayList<Integer>();

		for (int i = 0; i < nodos; i++) {
			for (int j = i + 1; j < nodos; j++) {

				listaPosibles.add(matriz.getIndex(i, j));
			}
		}

		for (int i = 0; i < aristasGeneradas; i++) {

			int rand = random.nextInt(aristasPosibles - i);

			matriz.setValor(listaPosibles.get(rand), true);
			listaPosibles.remove(rand);
		}

		return matriz;
	}

}
