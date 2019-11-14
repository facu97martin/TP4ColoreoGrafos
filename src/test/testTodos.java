package test;

import org.junit.jupiter.api.Test;

import entradasalida.EntradaSalidaColoreados;
import entradasalida.EntradaSalidaGeneradores;
import generadores.GeneradorAleatorioNyAdyacencia;
import generadores.GeneradorAleatorioNyProb;
import generadores.GeneradorNPartito;
import generadores.GeneradorRegularNyAdyacencia;
import generadores.GeneradorRegularNyGrado;
import grafo.MatrizSimetrica;

class testTodos {

	@Test
	void test() throws Exception {

		EntradaSalidaGeneradores esGen = new EntradaSalidaGeneradores();
		EntradaSalidaColoreados esCol = new EntradaSalidaColoreados();

		String aleatorioNyA = "aleatorioNyA";
		String aleatorioNyP = "aleatorioNyP";
		String regularNyA = "regularNyA";
		String regularNyG = "regularNyG";
		String nPartito = "nPartito";

		int nodos = 10;
		
		double adyacencia = 0.5;
		double probArista = 0.5;
		int grado = 4;
		int partes = 4;

		MatrizSimetrica matrizAleatorioNyA = new GeneradorAleatorioNyAdyacencia(nodos, adyacencia).generar();
		MatrizSimetrica matrizAleatorioNyP = new GeneradorAleatorioNyProb(nodos, probArista).generar();
		MatrizSimetrica matrizRegularNyA = new GeneradorRegularNyAdyacencia(nodos, adyacencia).generar();
		MatrizSimetrica matrizRegularNyG = new GeneradorRegularNyGrado(nodos, grado).generar();
		MatrizSimetrica matrizNpartito = new GeneradorNPartito(nodos, partes).generar();
		
		esGen.escribir(aleatorioNyA, matrizAleatorioNyA);
		esGen.escribir(aleatorioNyP, matrizAleatorioNyP);
		esGen.escribir(regularNyA, matrizRegularNyA);
		esGen.escribir(regularNyG, matrizRegularNyG);
		esGen.escribir(nPartito, matrizNpartito);
	}

}
