package grafo;

import java.util.List;

public class Grafo {
	
	private MatrizSimetrica matriz;
	private Nodo[] nodos;
	
	
	private Grafo colorearGrafo(List<Nodo> nodos) {
		return null;
	}

	private List<Nodo> ordenarAleatorio() {

		return null;
	}

	private List<Nodo> ordenarMatula() {

		return null;
	}
	
	private List<Nodo> ordenarPowell() {

		return null;
	}
	
	public void colorearAleatorio() {
		List<Nodo> lista = ordenarAleatorio();
		colorearGrafo(lista);
	}
	
	public void colorearMatula() {
		List<Nodo> lista = ordenarMatula();
		colorearGrafo(lista);
	}
	
	public void colorearPowell() {
		List<Nodo> lista = ordenarPowell();
		colorearGrafo(lista);
	}

}
