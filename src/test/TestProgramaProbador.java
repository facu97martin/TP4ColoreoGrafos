package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import entradasalida.EntradaSalidaColoreados;
import grafo.Grafo;
import grafo.ProgramaProbador;

public class TestProgramaProbador {

	@Test
	void test() {

		EntradaSalidaColoreados interfaz = new EntradaSalidaColoreados();

		Grafo grafo = interfaz.leer("Grafo_Aleatorio_NyP.in");

		interfaz.escribir("Grafo_Aleatorio_NyP_Coloreado_Aleatorio.out", grafo.colorearAleatorio());
		interfaz.escribir("Grafo_Aleatorio_NyP_Coloreado_Matula.out", grafo.colorearMatula());
		interfaz.escribir("Grafo_Aleatorio_NyP_Coloreado_Powell.out", grafo.colorearPowell());
		
		assertEquals(true,new ProgramaProbador("Grafo_Aleatorio_NyP.in", "Grafo_Aleatorio_NyP_Coloreado_Aleatorio.out").probarSiEstaColoreadoCorrectamente());
		assertEquals(true,new ProgramaProbador("Grafo_Aleatorio_NyP.in", "Grafo_Aleatorio_NyP_Coloreado_Matula.out").probarSiEstaColoreadoCorrectamente());
		assertEquals(true,new ProgramaProbador("Grafo_Aleatorio_NyP.in", "Grafo_Aleatorio_NyP_Coloreado_Powell.out").probarSiEstaColoreadoCorrectamente());
			
	}
		
	}
	
