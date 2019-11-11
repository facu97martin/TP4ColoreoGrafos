package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entradasalida.generadores.EntradaSalidaGeneradores;
import generadores.clases.aleatorio.GeneradorAleatorioNyAdyacencia;
import generadores.clases.aleatorio.GeneradorAleatorioNyProb;
import generadores.clases.npartito.GeneradorNPartito;
import generadores.clases.regular.GeneradorRegularNyAdyacencia;
import generadores.clases.regular.GeneradorRegularNyGrado;
import generadores.interfaces.GeneradorGrafos;
import matrizsimetrica.MatrizSimetrica;

class TestEntradaSalida {

	@Test
	void test() throws Exception {
		
		int nodos = 10;
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
