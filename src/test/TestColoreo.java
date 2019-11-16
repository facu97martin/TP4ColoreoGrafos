package test;

import org.junit.jupiter.api.Test;

import generadores.GeneradorAleatorioNyAdyacencia;
import generadores.GeneradorAleatorioNyProb;
import grafo.Grafo;
import grafo.MatrizSimetrica;

class TestColoreo {

	@Test
	void test() {

		int nodos = 600;
		double prob = 0.9;

		MatrizSimetrica matriz = new GeneradorAleatorioNyAdyacencia(nodos, prob).generar();

		// System.out.println(matriz);

		Grafo grafo1 = new Grafo(matriz);
		Grafo grafo2 = new Grafo(matriz);
		Grafo grafo3 = new Grafo(matriz);
		Grafo coloreadoPowell = grafo1.colorearPowell();
		Grafo coloreadoMatula = grafo2.colorearMatula();
		Grafo coloreadoAleatorio = grafo3.colorearAleatorio();

		// System.out.println(grafo1);

		System.out.println("Powell " + coloreadoPowell.getCantColores());
		System.out.println("Aleatorio " + coloreadoAleatorio.getCantColores());
		System.out.println("Matula " + coloreadoMatula.getCantColores());
	}

}
