package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import generadores.clases.aleatorio.GeneradorAleatorioNyAdyacencia;
import generadores.clases.aleatorio.GeneradorAleatorioNyProb;
import generadores.clases.regular.GeneradorRegularNyGrado;
import matrizsimetrica.MatrizSimetrica;

@SuppressWarnings("unused")
class TestRegulares {

	@Test
	void test() {
		
		int orden = 9;

		int grado = 4;
		
		double ady = 0.5;

		MatrizSimetrica matriz = new MatrizSimetrica(orden);

		try {
			matriz = new GeneradorRegularNyGrado(orden, grado).generar();
			System.out.println("Matriz regular - Con " + orden + " nodos y grado " + grado);
			System.out.println(matriz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		/*MatrizSimetrica matriz2 = new MatrizSimetrica(orden);

		matriz2 = new GeneradorAleatorioNyAdyacencia(orden, grado).generar();
		
		System.out.println("Matriz aleatoria - Con " + orden + " nodos y % de ady " + ady);
		System.out.println(matriz2);*/

	}

}
