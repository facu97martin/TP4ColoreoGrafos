package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrizSimetrica {

	private boolean[] vector;
	private int orden;
	private int vectorSize;

	// variables para escribir archivos

	private int nodos;
	private int aristas = 0;
	private double porcAdy;
	private int grMax;
	private int grMin;

	public MatrizSimetrica(int orden) {
		this.orden = orden;
		vector = new boolean[vectorSize(orden)];
		vectorSize = vectorSize(orden);
	}

	public MatrizSimetrica(String fileName) {

		try {
			Scanner sc = new Scanner(new File(fileName));
			this.orden = this.nodos = sc.nextInt();
			this.aristas = sc.nextInt();
			this.porcAdy = sc.nextDouble();
			this.grMax = sc.nextInt();
			this.grMin = sc.nextInt();

			this.vectorSize = vectorSize(orden);

			this.vector = new boolean[getVectorSize()];
			for (int i = 0; i < this.aristas; i++) {
				this.setValor(sc.nextInt() - 1, sc.nextInt() - 1, true);
			}

			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al abrir el archivo " + fileName);
			e.printStackTrace();
			return;
		}

	}
	

	public MatrizSimetrica(boolean[][] matriz, int orden) {

		vector = new boolean[vectorSize(orden)];

		this.orden = orden;

		for (int i = 0; i < orden; i++) {
			for (int j = i; j < orden; j++) {
				vector[getIndex(i, j)] = matriz[i][j];
			}
		}
		vectorSize = vectorSize(orden);
	}

	public MatrizSimetrica(boolean[] vector, int orden) {
		this.vector = vector;
		this.orden = orden;
		vectorSize = vectorSize(orden);
	}
	
	public int getGrado(int nodo) {
		int grado = 0;
		int j = nodo-1;
		for(int i = 0; i < this.orden; i++) {
			if(this.getValor(i,j) == true) {
				grado++;
			}
		}
		return grado;
	}

	public void calcularVariablesInternas() {

		this.nodos = this.orden;

		int[] grado = new int[this.nodos];

		for (int i = 0; i < this.nodos; i++) {
			for (int j = i + 1; j < this.nodos; j++) {
				if (this.getValor(i, j)) {
					aristas++;
					grado[i]++;
					grado[j]++;
				}
			}
		}
		this.porcAdy = (double) this.aristas / ((this.nodos * (this.nodos - 1)) / 2);

		int min = nodos - 1;
		int max = 0;

		for (int i : grado) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}
		this.grMax = max;
		this.grMin = min;

	}

	private int vectorSize(int orden) {
		return ((orden * (orden - 1)) / 2) + (orden);
	}

	public int getIndex(int i, int j) {

		if (i > j) {
			int aux = j;
			j = i;
			i = aux;
		}

		return (i * orden) + (j) - ((i * (i + 1) / 2));

	}

	public boolean getValor(int i, int j) throws IndexOutOfBoundsException {

		if (i >= orden || j >= orden) {
			throw new IndexOutOfBoundsException("Elija valores menores a " + this.orden);
		}

		return vector[getIndex(i, j)];

	}

	public boolean getValor(int index) throws IndexOutOfBoundsException {
		if (index >= this.vectorSize) {
			throw new IndexOutOfBoundsException("Elija valores menores a " + this.vectorSize);
		}

		return vector[index];

	}

	public void setValor(int i, int j, boolean valor) throws IndexOutOfBoundsException {
		if (i >= orden || j >= orden) {
			throw new IndexOutOfBoundsException("Elija valores menores a " + this.orden);
		}
		vector[getIndex(i, j)] = valor;
	}

	public void setValor(int index, boolean valor) throws IndexOutOfBoundsException {
		if (index >= this.vectorSize) {
			throw new IndexOutOfBoundsException("Elija valores menores a " + this.vectorSize);
		}
		vector[index] = valor;
	}

	public String toString() {

		String string = "";

		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++) {
				if (vector[getIndex(i, j)]) {
					string += "[1]";
				} else {
					string += "[-]";
				}
			}
			string += "\n";
		}

		return string;
	}

	public boolean[] getVector() {
		return vector;
	}

	public int getOrden() {
		return orden;
	}

	public int getVectorSize() {
		return vectorSize;
	}

	public int getNodos() {
		return nodos;
	}

	public int getAristas() {
		return aristas;
	}

	public double getPorcAdy() {
		return porcAdy;
	}

	public int getGrMax() {
		return grMax;
	}

	public int getGrMin() {
		return grMin;
	}

}
