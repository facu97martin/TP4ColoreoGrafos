package test;

import generadores.GeneradorAleatorioNyAdyacencia;
import generadores.GeneradorRegularNyAdyacencia;
import grafo.Grafo;

public class Estadisticas {

	public static void main(String[] args) {
		
		int cantVeces = 10000;
		int cantidadVecesR1 = cantVeces;
		int cantidadVecesR2 = cantVeces;
		int nodosR = 1000;
		double aR1 = 0.50;
		double aR2 = 0.75;
		Grafo grafoR1 = new Grafo(new GeneradorRegularNyAdyacencia(nodosR, aR1).generar());
		String tituloR1 = "Regular-" + nodosR + "-Nodos-" + String.format("%2.0f", aR1 * 100) + "-Adyacencia";
		Grafo grafoR2 = new Grafo(new GeneradorRegularNyAdyacencia(nodosR, aR2).generar());
		String tituloR2 = "Regular-" + nodosR + "-Nodos-" + String.format("%2.0f", aR2 * 100) + "-Adyacencia";
		new MiThread(grafoR1, tituloR1, cantidadVecesR1).run();
		//new MiThread(grafoR2, tituloR2, cantidadVecesR2).run();

	}

}
