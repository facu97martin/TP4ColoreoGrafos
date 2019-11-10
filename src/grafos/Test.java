package grafos;

import static org.junit.jupiter.api.Assertions.*;

import generadores.clases.GeneradorNyProb;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		
		int orden = 4;
		
		MatrizSimetrica matriz = new MatrizSimetrica(orden);
		
		matriz = new GeneradorNyProb(orden, 0.5).generar();
		
		System.out.println(matriz);
	}

}
