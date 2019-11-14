package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {

	private MatrizSimetrica matriz;
	private List<Nodo> nodos;
	private int cantColores;

	public int getCantColores() {
		return cantColores;
	}

	public Grafo(MatrizSimetrica matriz) {
		this.matriz = matriz;
		this.nodos = matriz.getListaNodos();
	}

	private Grafo(MatrizSimetrica matriz, List<Nodo> nodos, int cantColores) {
		this.matriz = matriz;
		this.nodos = nodos;
		this.cantColores = cantColores;
	}

	private Grafo colorearGrafo(List<Nodo> listaNodos) {
		int colorActual = 1;

		listaNodos.get(0).setColor(colorActual);

		int orden = listaNodos.size();

		for (int i = 1; i < orden; i++) {
			colorActual = colorear(listaNodos, i, colorActual);
		}
		return new Grafo(this.matriz, listaNodos, colorActual);
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

	public void colorearMuchasVecesEImprimir(int cantidadVeces) {
		System.out.println("Cantidad de nodos: " + matriz.getNodos());
		System.out.println("Porcentaje de adyacencia: " + (matriz.getPorcAdy() * 100) + "%\n");

		List<Nodo> lista = ordenarMatula();
		recorrerNVecesYmostrar(lista, "Matula", cantidadVeces);

		List<Nodo> listaAletorio = ordenarAleatorio();
		recorrerNVecesYmostrar(listaAletorio, "Aleatorio", cantidadVeces);

		List<Nodo> listaPowell = ordenarPowell();
		recorrerNVecesYmostrar(listaPowell, "Powell", cantidadVeces);
	}

	private void recorrerNVecesYmostrar(List<Nodo> lista, String nombreOrdenamiento, int cantidadVeces) {
		System.out.println(nombreOrdenamiento + ":");
		int menorCantColores = 0, posMenorCantColores = -1;

		for (int i = 0; i < cantidadVeces; i++) {
			Grafo grafo = colorearGrafo(lista);
			lista = grafo.intercambiarElementosLista(nombreOrdenamiento);
			int cantidadDeColores = grafo.cantColores;

			if (cantidadDeColores > menorCantColores) {
				menorCantColores = cantidadDeColores;
				posMenorCantColores = i;
			}
		}
		System.out.println("Menor cantidad de colores: " + menorCantColores);
		System.out.println("En la pasada: " + (posMenorCantColores + 1) + "\n");
	}

	private List<Nodo> intercambiarElementosLista(String nombreOrdenamiento) {
		Collections.shuffle(nodos);
		
		switch (nombreOrdenamiento) {
		case "Matula":
			ordenarMatula();
			break;
		case "Powell":
			ordenarPowell();
			break;
		}
		return nodos;
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
