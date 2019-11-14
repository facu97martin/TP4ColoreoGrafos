package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProgramaProbador {

	private MatrizSimetrica grafo;
	private TreeMap<Integer, Integer> nodosColoreados; // Key = Nodo, Value =
														// Color
	private TreeSet<Integer> coloresUsados;
	private int cantNodosEntrada;
	private int cantNodosSalida;
	private int cantAristasEntrada;
	private boolean coloreadoCorrectamente;

	public ProgramaProbador(String pathIn, String pathOut) {
		nodosColoreados = new TreeMap<Integer, Integer>();
		coloresUsados = new TreeSet<Integer>();
		coloreadoCorrectamente = true;
		leerArchivoEntrada(pathIn);
		leerArchivoSalida(pathOut);
	}

	private void leerArchivoEntrada(String pathIn) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(pathIn));
			cantNodosEntrada = scanner.nextInt();
			grafo = new MatrizSimetrica(cantNodosEntrada);
			cantAristasEntrada = scanner.nextInt();
			scanner.nextDouble();
			scanner.nextInt();
			scanner.nextInt();
			for (int i = 0; i < cantAristasEntrada; i++) {
				grafo.setValor(scanner.nextInt(), scanner.nextInt(),true);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void leerArchivoSalida(String pathOut) {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(pathOut));
			cantNodosSalida = scanner.nextInt();

			scanner.nextInt();
			scanner.nextDouble();
			scanner.nextInt();
			scanner.nextInt();
			for (int i = 0; i < cantNodosSalida; i++) {
				Integer nodo = scanner.nextInt();
				Integer color = scanner.nextInt();
				if (nodosColoreados.containsKey(nodo)) {
					coloreadoCorrectamente = false;
					scanner.close();
					return;
				} else {
					nodosColoreados.put(nodo, color);
					coloresUsados.add(color);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean probarSiEstaColoreadoCorrectamente() {
		return coloreadoCorrectamente && siNoHayNodosAdyacentesDelMismoColor();
	}

	private boolean siNoHayNodosAdyacentesDelMismoColor() {
		for (int i = 0; i < grafo.getOrden() - 1; i++) {
			for (int j = i + 1; j < grafo.getOrden(); j++) {
				if (grafo.getValor(i, j) && nodosColoreados.get(i) == nodosColoreados.get(j)) {
					return false;
				}
			}
		}
		return true;
	}

}