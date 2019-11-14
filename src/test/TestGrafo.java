package test;

import org.junit.jupiter.api.Test;

import entradasalida.EntradaSalidaColoreados;
import generadores.*;
import grafo.*;

@SuppressWarnings("unused")
class TestGrafo {

	@Test
	void test() {

		EntradaSalidaColoreados interfaz = new EntradaSalidaColoreados();

		Grafo grafo = interfaz.leer("Grafo_Aleatorio_NyP.in");

		interfaz.escribir("Grafo_Aleatorio_NyP_Coloreado_Aleatorio.out", grafo.colorearAleatorio());
		interfaz.escribir("Grafo_Aleatorio_NyP_Coloreado_Matula.out", grafo.colorearMatula());
		interfaz.escribir("Grafo_Aleatorio_NyP_Coloreado_Powell.out", grafo.colorearPowell());

	}

}
