package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		this.matriz.calcularVariablesInternas();
	}

	private Grafo(MatrizSimetrica matriz, List<Nodo> nodos, int cantColores) {
		this.matriz = matriz;
		this.nodos = nodos;
		this.cantColores = cantColores;
	}

	private Grafo colorearGrafo(List<Nodo> listaNodos) {

		int colorActual = 0;
		int nodosColoreados = 0;
		int cantNodos = listaNodos.size();
		while (nodosColoreados < cantNodos) {
			colorActual++;
			for (Nodo nodo : listaNodos) {
				if (puedoPintar(nodo, listaNodos, colorActual)) {
					nodo.setColor(colorActual);
					nodosColoreados++;
				}
			}
		}

		return new Grafo(this.matriz, listaNodos, colorActual);

	}

	private boolean puedoPintar(Nodo nodo, List<Nodo> listaNodos, int colorActual) {

		for (Nodo nodoI : listaNodos) {
			if (nodo.getNodo() != nodoI.getNodo() && this.matriz.getValor(nodo.getNodo(), nodoI.getNodo())) {
				if (nodoI.getColor() == colorActual || nodo.getColor() != 0) {// le agrego la condicion de que si ya
																				// esta pintado no lo vuelva a pintar
					return false;
				}
			}
		}
		return true;
	}

	private List<Nodo> ordenarAleatorio() {
		List<Nodo> newList = new ArrayList<Nodo>(this.nodos);
		for (Nodo nodo : newList) {
			nodo.setColor(0);
		}
		Collections.shuffle(newList);
		return newList;
	}

	private List<Nodo> ordenarMatula() {
		List<Nodo> newList = new ArrayList<Nodo>(this.nodos);
		for (Nodo nodo : newList) {
			nodo.setColor(0);
		}
		Collections.sort(newList);
		return newList;
	}

	private List<Nodo> ordenarPowell() {
		List<Nodo> newList = new ArrayList<Nodo>(this.nodos);
		for (Nodo nodo : newList) {
			nodo.setColor(0);
		}
		Collections.sort(newList);
		Collections.reverse(newList);
		return newList;
	}

	public void colorearMuchasVecesEImprimir(int cantidadVeces, String titulo) {
		System.out.println("Cantidad de nodos: " + matriz.getNodos());
		System.out.println("Porcentaje de adyacencia: " + String.format("%2.0f",(matriz.getPorcAdy() * 100)) + "%\n");

		List<Nodo> listaMatula = ordenarMatula();
		recorrerNVecesYmostrar(listaMatula, "Matula", titulo, cantidadVeces);

		List<Nodo> listaAleatorio = ordenarAleatorio();
		recorrerNVecesYmostrar(listaAleatorio, "Aleatorio", titulo, cantidadVeces);

		List<Nodo> listaPowell = ordenarPowell();
		recorrerNVecesYmostrar(listaPowell, "Powell", titulo, cantidadVeces);
	}

	private void recorrerNVecesYmostrar(List<Nodo> lista, String nombreOrdenamiento, String titulo, int cantidadVeces) {
		System.out.println(nombreOrdenamiento + "_" + titulo + ":");

		try {
			PrintWriter pw = new PrintWriter(new File(nombreOrdenamiento + "_" + titulo + ".out"));

			int menorCantColores = this.getMatriz().getOrden(), posMenorCantColores = -1;

			for (int i = 0; i < cantidadVeces; i++) {
				Grafo grafo;
				lista = intercambiarElementosLista(nombreOrdenamiento);
				grafo = colorearGrafo(lista);
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
		
		for (Nodo nodo : nodos) {
			nodo.setColor(0);
		}

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
		List<Nodo> lista = new ArrayList<Nodo>(ordenarAleatorio());
		for (Nodo nodo : lista) {
			nodo.setColor(0);
		}
		return colorearGrafo(lista);
	}

	public Grafo colorearMatula() {
		List<Nodo> lista = new ArrayList<Nodo>(ordenarMatula());
		for (Nodo nodo : lista) {
			nodo.setColor(0);
		}
		return colorearGrafo(lista);
	}

	public Grafo colorearPowell() {
		List<Nodo> lista = new ArrayList<Nodo>(ordenarPowell());
		for (Nodo nodo : lista) {
			nodo.setColor(0);
		}
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
