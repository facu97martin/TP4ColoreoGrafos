package algoritmos;

import entradasalida.generadores.EntradaSalidaGrafos;

public class Main {

	public static void main(String[] args) {
		EntradaSalidaGrafos ES= new EntradaSalidaGrafos();
		Grafo grafo = new Grafo(ES.leer("Grafo_Aleatorio_NyA.in"));
		grafo.generarNodos(grafo);
		Welsh w = new Welsh(grafo);
	}

}
