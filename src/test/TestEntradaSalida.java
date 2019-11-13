package test;

import org.junit.jupiter.api.Test;

import generadores.GeneradorAleatorioNyAdyacencia;
import generadores.GeneradorAleatorioNyProb;
import generadores.GeneradorNPartito;
import generadores.GeneradorRegularNyAdyacencia;
import generadores.GeneradorRegularNyGrado;
import generadores.entradasalida.EntradaSalidaGeneradores;
import generadores.interfaces.GeneradorGrafos;

class TestEntradaSalida {

	@Test
	void test() throws Exception {
		
		int nodos = 12;
		int partes = 2;
		
		int grado = 5;
		
		double ady = 0.5;
		double probArista = 0.5;
		
		EntradaSalidaGeneradores esGen = new EntradaSalidaGeneradores();
		
		GeneradorGrafos generador1 = new GeneradorAleatorioNyAdyacencia(nodos, ady);
		GeneradorGrafos generador2 = new GeneradorAleatorioNyProb(nodos, probArista);
		GeneradorGrafos generador3 = new GeneradorRegularNyAdyacencia(nodos, ady);
		GeneradorGrafos generador4 = new GeneradorRegularNyGrado(nodos, grado);
		GeneradorGrafos generador5 = new GeneradorNPartito(nodos, partes);
		
		esGen.escribir("Grafo_Aleatorio_NyA", generador1.generar());
		esGen.escribir("Grafo_Aleatorio_NyP", generador2.generar());
		esGen.escribir("Grafo_Regular_NyA", generador3.generar());
		esGen.escribir("Grafo_Regular_NyG", generador4.generar());
		esGen.escribir("Grafo_N_Partito", generador5.generar());
	}

}
