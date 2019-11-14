package entradasalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import grafo.Grafo;
import grafo.MatrizSimetrica;
import grafo.Nodo;

public class EntradaSalidaColoreados {

	public static final String DELIM = " ";

	private Scanner sc;
	private PrintWriter pw;

	public Grafo leer(String fileName) {

		try {
			this.sc = new Scanner(new File(fileName));

			MatrizSimetrica matriz = new MatrizSimetrica(sc.nextInt());
			int cantAristas = sc.nextInt();
			matriz.setCantAristas(cantAristas);
			matriz.setPorcAdy(sc.nextDouble());
			matriz.setGrMax(sc.nextInt());
			matriz.setGrMin(sc.nextInt());

			for (int i = 0; i < cantAristas; i++) {
				matriz.setValor(sc.nextInt() - 1, sc.nextInt() - 1, true);
			}

			sc.close();
			return new Grafo(matriz);
		} catch (FileNotFoundException e) {
			System.out.println("Problema con el archivo " + fileName + ":\n" + e);
			e.printStackTrace();
		}
		return null;
	}

	public void escribir(String fileName, Grafo grafo) {

		try {
			this.pw = new PrintWriter(new File(fileName));

			pw.println(grafo.getMatriz().getOrden() + DELIM + grafo.getCantColores() + DELIM
					+ String.format("%2.4f", grafo.getMatriz().getPorcAdy()) + DELIM + grafo.getMatriz().getGrMax()
					+ DELIM + grafo.getMatriz().getGrMin());

			List<Nodo> listaNodos = grafo.getNodos();

			for (Nodo nodo : listaNodos) {
				pw.println((nodo.getNodo() + 1) + DELIM + nodo.getColor());
			}

			pw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Problema con el archivo " + fileName + ":\n" + e);
			e.printStackTrace();
		}
	}

}
