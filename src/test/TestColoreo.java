package test;

import org.junit.jupiter.api.Test;

import generadores.GeneradorAleatorioNyAdyacencia;
import generadores.GeneradorAleatorioNyProb;
import grafo.Grafo;
import grafo.MatrizSimetrica;

class TestColoreo {

	@Test
	void test() {

		int nodos = 300;
		double adyacencia = 0.50;
		double prob = 0.25;

		MatrizSimetrica matriz = new GeneradorAleatorioNyProb(nodos, prob).generar();

		// System.out.println(matriz);

		// Grafo grafo = new Grafo(matriz);

		System.out.println("Powell " + new Grafo(matriz).colorearPowell().getCantColores());
		System.out.println("Aleatorio " + new Grafo(matriz).colorearAleatorio().getCantColores());
		System.out.println("Matula " + new Grafo(matriz).colorearMatula().getCantColores());
	}

}
