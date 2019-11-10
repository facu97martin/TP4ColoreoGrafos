package grafos;

import static org.junit.jupiter.api.Assertions.*;

import generadores.clases.GeneradorAleatorioNyAdyacencia;
import generadores.clases.GeneradorAleatorioNyProb;

@SuppressWarnings("unused")
class Test {

	@org.junit.jupiter.api.Test
	void test() {

		int orden = 10;
		
		double prob = 0.15;

		MatrizSimetrica matriz = new MatrizSimetrica(orden);

		matriz = new GeneradorAleatorioNyProb(orden, prob).generar();

		System.out.println(matriz);

		MatrizSimetrica matriz2 = new MatrizSimetrica(orden);

		matriz2 = new GeneradorAleatorioNyAdyacencia(orden, prob).generar();

		System.out.println(matriz2);
	}

}
