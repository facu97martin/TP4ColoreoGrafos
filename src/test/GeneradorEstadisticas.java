package test;

import org.junit.jupiter.api.Test;

import generadores.GeneradorAleatorioNyAdyacencia;
import generadores.GeneradorAleatorioNyProb;
import generadores.GeneradorRegularNyAdyacencia;
import grafo.Grafo;
import grafo.MatrizSimetrica;

class GeneradorEstadisticas {

	@Test
	void test() {

		int cantVeces = 10000;
		
		int cantidadVecesA1 = cantVeces;
		int cantidadVecesA2 = cantVeces;
		int cantidadVecesA3 = cantVeces;
		int cantidadVecesR1 = cantVeces;
		int cantidadVecesR2 = cantVeces;

		int nodosA = 600;
		double aA1 = 0.40;
		double aA2 = 0.60;
		double aA3 = 0.90;

		int nodosR = 1000;
		double aR1 = 0.50;
		double aR2 = 0.75;

		Grafo grafoA1 = new Grafo(new GeneradorAleatorioNyAdyacencia(nodosA, aA1).generar());
		String tituloA1 = "Aleatorio-" + nodosA + "-Nodos-" + String.format("%2.0f", aA1 * 100) + "-Adyacencia";
		Grafo grafoA2 = new Grafo(new GeneradorAleatorioNyAdyacencia(nodosA, aA2).generar());
		String tituloA2 = "Aleatorio-" + nodosA + "-Nodos-" + String.format("%2.0f", aA2 * 100) + "-Adyacencia";
		Grafo grafoA3 = new Grafo(new GeneradorAleatorioNyAdyacencia(nodosA, aA3).generar());
		String tituloA3 = "Aleatorio-" + nodosA + "-Nodos-" + String.format("%2.0f", aA3 * 100) + "-Adyacencia";
		Grafo grafoR1 = new Grafo(new GeneradorRegularNyAdyacencia(nodosR, aR1).generar());
		String tituloR1 = "Regular-" + nodosR + "-Nodos-" + String.format("%2.0f", aR1 * 100) + "-Adyacencia";
		Grafo grafoR2 = new Grafo(new GeneradorRegularNyAdyacencia(nodosR, aR2).generar());
		String tituloR2 = "Regular-" + nodosR + "-Nodos-" + String.format("%2.0f", aR2 * 100) + "-Adyacencia";
		
		/*new MiThread(grafoA1, tituloA1, cantidadVecesA1).run();
		new MiThread(grafoA2, tituloA2, cantidadVecesA2).run();
		new MiThread(grafoA3, tituloA3, cantidadVecesA3).run();*/
		//new MiThread(grafoR1, tituloR1, cantidadVecesR1).run();
		new MiThread(grafoR2, tituloR2, cantidadVecesR2).run();
	}
	
	@Test
	void test2() {

		int cantVeces = 10000;
		
		int cantidadVecesA1 = cantVeces;
		int cantidadVecesA2 = cantVeces;
		int cantidadVecesA3 = cantVeces;
		int cantidadVecesR1 = cantVeces;
		int cantidadVecesR2 = cantVeces;

		int nodosA = 600;
		double aA1 = 0.40;
		double aA2 = 0.60;
		double aA3 = 0.90;

		int nodosR = 1000;
		double aR1 = 0.50;
		double aR2 = 0.75;

		Grafo grafoA1 = new Grafo(new GeneradorAleatorioNyAdyacencia(nodosA, aA1).generar());
		String tituloA1 = "Aleatorio-" + nodosA + "-Nodos-" + String.format("%2.0f", aA1 * 100) + "-Adyacencia";
		Grafo grafoA2 = new Grafo(new GeneradorAleatorioNyAdyacencia(nodosA, aA2).generar());
		String tituloA2 = "Aleatorio-" + nodosA + "-Nodos-" + String.format("%2.0f", aA2 * 100) + "-Adyacencia";
		Grafo grafoA3 = new Grafo(new GeneradorAleatorioNyAdyacencia(nodosA, aA3).generar());
		String tituloA3 = "Aleatorio-" + nodosA + "-Nodos-" + String.format("%2.0f", aA3 * 100) + "-Adyacencia";
		Grafo grafoR1 = new Grafo(new GeneradorRegularNyAdyacencia(nodosR, aR1).generar());
		String tituloR1 = "Regular-" + nodosR + "-Nodos-" + String.format("%2.0f", aR1 * 100) + "-Adyacencia";
		Grafo grafoR2 = new Grafo(new GeneradorRegularNyAdyacencia(nodosR, aR2).generar());
		String tituloR2 = "Regular-" + nodosR + "-Nodos-" + String.format("%2.0f", aR2 * 100) + "-Adyacencia";
		
		/*new MiThread(grafoA1, tituloA1, cantidadVecesA1).run();
		new MiThread(grafoA2, tituloA2, cantidadVecesA2).run();
		new MiThread(grafoA3, tituloA3, cantidadVecesA3).run();*/
		new MiThread(grafoR1, tituloR1, cantidadVecesR1).run();
		//new MiThread(grafoR2, tituloR2, cantidadVecesR2).run();
	}

}
