package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
		this.matriz.calcularVariablesInternas();
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

	@SuppressWarnings("deprecation")
	private int colorear(List<Nodo> listaNodos, int posActual, int colorMax) {

		List<Integer> coloresPosibles = new LinkedList<Integer>();

		for (int i = 1; i <= colorMax; i++) {
			coloresPosibles.add(i);
		}
		
		Nodo nodoAct = listaNodos.get(posActual);

		for (int i = 0; i < posActual; i++) {
			if (this.matriz.getValor(i, posActual)) {
				coloresPosibles.remove(new Integer(listaNodos.get(i).getColor()));
			}
		}

		if (coloresPosibles.isEmpty()) {
			colorMax++;
			nodoAct.setColor(colorMax);
		} else {
			nodoAct.setColor(coloresPosibles.get(0));
		}

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

		try {
			PrintWriter pw = new PrintWriter(new File(nombreOrdenamiento + ".out"));

			int menorCantColores = this.getMatriz().getOrden(), posMenorCantColores = -1;

			for (int i = 0; i < cantidadVeces; i++) {
				Grafo grafo = colorearGrafo(lista);
				lista = grafo.intercambiarElementosLista(nombreOrdenamiento);
				int cantidadDeColores = grafo.cantColores;

				pw.println(cantidadDeColores);

				if (cantidadDeColores < menorCantColores) {
					menorCantColores = cantidadDeColores;
					posMenorCantColores = i;
				}
			}
			System.out.println("Menor cantidad de colores: " + menorCantColores);
			System.out.println("En la pasada: " + (posMenorCantColores + 1) + "\n");

			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
