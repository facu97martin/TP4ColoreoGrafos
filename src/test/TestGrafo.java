package test;

import org.junit.jupiter.api.Test;

import generadores.*;
import grafo.*;

@SuppressWarnings("unused")
class TestGrafo {

	@Test
	void test() throws Exception {

		int orden = 6;

		double prob = 0.5;

		// MatrizSimetrica matrizSim = new GeneradorAleatorioNyAdyacencia(orden,
		// prob).generar();

		boolean[][] matriz = {
				{false, false, true, false, true, false},
				{false, false, true, false, true, false},
				{true, true, false, false, true, true},
				{false, false, false, false, false, true},
				{true, true, true, false, false, false},
				{false, false, true, true, false, false}
		};

		MatrizSimetrica matrizSim = new MatrizSimetrica(matriz, orden);

		Grafo grafo = new Grafo(matrizSim);

		System.out.println(grafo);
		System.out.println(grafo.getNodos());
		System.out.println(grafo.colorearAleatorio().getNodos());
		System.out.println(grafo.colorearMatula().getNodos());
		System.out.println(grafo.colorearPowell().getNodos());

	}

}
