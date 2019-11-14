package test;

import generadores.GeneradorAleatorioNyAdyacencia;
import grafo.Grafo;
import grafo.MatrizSimetrica;

public class Main {

	public static void main(String[] args) {
		MatrizSimetrica matriz = new GeneradorAleatorioNyAdyacencia(4, 0.7).generar();
		Grafo grafo = new Grafo(matriz);

		System.out.println(grafo);
		//System.out.println(grafo.getNodos());
		grafo.colorearAleatorio();
		//System.out.println(grafo.getNodos());
		grafo.colorearMatula();
		//System.out.println(grafo.getNodos());
		grafo.colorearPowell();
		//System.out.println(grafo.getNodos());
		
		/*MatrizSimetrica matriz2 = new GeneradorAleatorioNyAdyacencia(600, 0.4).generar();
		Grafo grafo2 = new Grafo(matriz2);
		grafo2.getMatriz().calcularVariablesInternas();
		grafo2.colorearMuchasVecesEImprimir(10000);*/
	}

}
