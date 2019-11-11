package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import generadores.clases.npartito.GeneradorNPartito;
import matrizsimetrica.MatrizSimetrica;

class TestNPartito {

	@Test
	void test() {
		
		int orden = 24;
		int particiones = 3;
		
		MatrizSimetrica matriz = new GeneradorNPartito(orden, particiones).generar();		
		System.out.println(matriz);
	}

}
