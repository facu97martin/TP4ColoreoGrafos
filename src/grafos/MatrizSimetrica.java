package grafos;

public class MatrizSimetrica {

	private int[] vector;
	private int orden;

	public MatrizSimetrica(int[][] matriz, int orden) {
		
		vector = new int[vectorSize(orden)];
		
		this.orden = orden;
		
		for(int i = 0; i < orden; i++) {
			for(int j = i; j < orden; j++) {
				vector[getIndex(i,j)] = matriz[i][j];
			}
		}
	}

	public MatrizSimetrica(int[] vector, int orden) {
		this.vector = vector;
		this.orden = orden;
	}

	private int vectorSize(int orden) {
		return ((orden * (orden - 1)) / 2) + (orden);
	}
	
	private int getIndex(int i, int j) {

		if (i > j) {
			int aux = j;
			j = i;
			i = aux;
		}

		return (i * orden) + (j) - ((i * (i + 1) / 2));

	}

	public int getValor(int i, int j) throws IndexOutOfBoundsException {

		if (i >= orden || j >= orden) {
			throw new IndexOutOfBoundsException("Elija valores menores a " + orden);
		}

		return vector[getIndex(i, j)];

	}

}
