package test;

import org.junit.jupiter.api.Test;

import generadores.*;
import grafo.*;

@SuppressWarnings("unused")
class TestGrafo {

	@Test
	void test() throws Exception {
		// MatrizSimetrica matriz = new GeneradorAleatorioNyAdyacencia(6,0.7).generar();

		boolean[][] matrizBoolean = {
				{ false, true, true, true, false, true },
				{ true, false, true, false, false, true },
				{ true, true, false, true, true, true },
				{ true, false, true, false, true, false },
				{ false, false, true, true, false, false },
				{ true, true, true, false, false, false } };

		MatrizSimetrica matriz = new MatrizSimetrica(matrizBoolean, 6);

		Grafo grafo = new Grafo(matriz);

		System.out.println(grafo);
		// System.out.println(grafo.getNodos());
		System.out.println(grafo.colorearMatula().getNodos());
		// System.out.println(grafo.getNodos());
		/*
		 * grafo.colorearMatula(); System.out.println(grafo.getNodos());
		 * grafo.colorearPowell(); System.out.println(grafo.getNodos());
		 */
	}

}
