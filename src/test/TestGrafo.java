package test;

import org.junit.jupiter.api.Test;

import generadores.*;
import generadores.entradasalida.EntradaSalidaGeneradores;
import grafo.*;

class TestGrafo {

	@Test
	void test() throws Exception {
		MatrizSimetrica matriz = new GeneradorAleatorioNyAdyacencia(4, 0.7).generar();
		Grafo grafo = new Grafo(matriz);

		System.out.println(grafo);
		//System.out.println(grafo.getNodos());
		grafo.colorearAleatorio();
		System.out.println(grafo.getNodos());
		/*grafo.colorearMatula();
		System.out.println(grafo.getNodos());
		grafo.colorearPowell();
		System.out.println(grafo.getNodos());*/
	}

}
