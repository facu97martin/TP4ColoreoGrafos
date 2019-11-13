package test;

import org.junit.jupiter.api.Test;

import generadores.GeneradorRegularNyAdyacencia;
import generadores.GeneradorRegularNyGrado;
import grafo.MatrizSimetrica;

@SuppressWarnings("unused")
class TestRegulares {

	@Test
	void test() {

		int orden = 10;

		int grado = 6;

		double ady = 0.40;

		MatrizSimetrica matriz = new MatrizSimetrica(orden);

		try {
			matriz = new GeneradorRegularNyGrado(orden, grado).generar();
			System.out.println("Matriz regular - Con " + orden + " nodos y grado " + grado + "\n");
			System.out.println(matriz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MatrizSimetrica matriz2 = new MatrizSimetrica(orden);

		matriz2 = new GeneradorRegularNyAdyacencia(orden, ady).generar();

		System.out.println(
				"Matriz regular - Con " + orden + " nodos y " + String.format("%2.0f", ady * 100) + "% de ady \n");
		System.out.println(matriz2);

	}

}
