package test;

import generadores.GeneradorAleatorioNyAdyacencia;
import generadores.GeneradorAleatorioNyProb;
import grafo.MatrizSimetrica;

@SuppressWarnings("unused")
class TestAleatorias {

	@org.junit.jupiter.api.Test
	void test() {

		int orden = 10;

		double prob = 1;

		MatrizSimetrica matriz = new MatrizSimetrica(orden);

		matriz = new GeneradorAleatorioNyProb(orden, prob).generar();

		System.out.println("Matriz aleatoria - Con " + orden + " nodos y " + String.format("%2.0f", prob * 100)
				+ "% probabilidad para cada arista");
		System.out.println(matriz);

		MatrizSimetrica matriz2 = new MatrizSimetrica(orden);

		matriz2 = new GeneradorAleatorioNyAdyacencia(orden, prob).generar();

		System.out.println("Matriz aleatoria - Con " + orden + " nodos y " + String.format("%2.0f", prob * 100)
				+ "% de adyacencia");
		System.out.println(matriz2);
	}

}
