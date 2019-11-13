package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {

	private MatrizSimetrica matriz;
	private List<Nodo> nodos;

	public Grafo(MatrizSimetrica matriz) {
		this.matriz = matriz;
		this.nodos = matriz.getListaNodos();
	}

	private Grafo(MatrizSimetrica matriz, List<Nodo> nodos) {
		this.matriz = matriz;
		this.nodos = nodos;
	}

	private Grafo colorearGrafo(List<Nodo> listaNodos) {
		int colorActual = 1;

		listaNodos.get(0).setColor(colorActual);

		int orden = listaNodos.size();

		for (int i = 1; i < orden; i++) {
			colorActual = colorear(listaNodos, i, colorActual);
		}

		return new Grafo(this.matriz, listaNodos);

	}

	private int colorear(List<Nodo> listaNodos, int posActual, int colorMax) {

		List<Integer> coloresNoPosibles = new ArrayList<Integer>();

		Nodo nodoAColorear = listaNodos.get(posActual);
		int posAColorear = nodoAColorear.getNodo();

		int i;
		Nodo nodoI;

		for (i = 0; i < posActual; i++) {

			nodoI = listaNodos.get(i);

			if (matriz.getValor(posAColorear, nodoI.getNodo())) {
				int colorActual = nodoI.getColor(); // si hay arista, agrego el color a la lista de no
													// posibles, evitando duplicados
				if (!coloresNoPosibles.contains(colorActual)) {
					coloresNoPosibles.add(colorActual);
				}
			}
		}

		i = 1;

		while (i < posActual) {
			if (!coloresNoPosibles.contains(i)) {
				nodoAColorear.setColor(i);
				return colorMax;
			} else {
				i++;
			}
		}
		colorMax++;
		nodoAColorear.setColor(colorMax);
		return colorMax;
	}

	private List<Nodo> ordenarAleatorio() {

		List<Nodo> newList = new ArrayList<Nodo>(this.nodos);
		Collections.shuffle(newList);
		return newList;
	}

	private List<Nodo> ordenarMatula() {

		List<Nodo> newList = new ArrayList<Nodo>(this.nodos);
		Collections.sort(newList);
		return newList;
	}

	private List<Nodo> ordenarPowell() {

		List<Nodo> newList = new ArrayList<Nodo>(this.nodos);
		Collections.sort(newList);
		Collections.reverse(newList);
		return newList;

	}

	public Grafo colorearAleatorio() {
		List<Nodo> lista = ordenarAleatorio();
		return colorearGrafo(lista);
	}

	public Grafo colorearMatula() {
		List<Nodo> lista = ordenarMatula();
		return colorearGrafo(lista);
	}

	public Grafo colorearPowell() {
		List<Nodo> lista = ordenarPowell();
		return colorearGrafo(lista);
	}

	public String toString() {
		return matriz.toString();
	}

	public MatrizSimetrica getMatriz() {
		return matriz;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

}
