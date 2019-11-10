package grafos;

public class MatrizSimetrica {

	private boolean[] vector;
	private final int orden;
	private final int vectorSize;

	public MatrizSimetrica(int orden) {
		this.orden = orden;
		vector = new boolean[vectorSize(orden)];
		vectorSize = vectorSize(orden);
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
		if(index >= this.vectorSize) {
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

}
