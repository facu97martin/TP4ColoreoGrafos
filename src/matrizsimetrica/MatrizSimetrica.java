package matrizsimetrica;

public class MatrizSimetrica {

	private boolean[] vector;
	private final int orden;
	private final int vectorSize;

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
