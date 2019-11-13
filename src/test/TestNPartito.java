package test;

import org.junit.jupiter.api.Test;

import generadores.GeneradorNPartito;
import grafo.MatrizSimetrica;

@SuppressWarnings("unused")
class TestNPartito {

	@Test
	void test() {
		
		int orden = 24;
		int particiones = 3;
		
		MatrizSimetrica matriz = new GeneradorNPartito(orden, particiones).generar();		
		System.out.println(matriz);
	}

}
