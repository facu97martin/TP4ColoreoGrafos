package grafo;

public class Nodo implements Comparable<Nodo> {
	
	private int nodo;
	private int color;
	private int grado;

	
	public Nodo(int nodo, int color, int grado) {
		super();
		this.nodo = nodo;
		this.color = color;
		this.grado = grado;
	}
	
	public Nodo(int nodo, int grado) {
		super();
		this.nodo = nodo;
		this.grado = grado;
	}

	public int getNodo() {
		return nodo;
	}

	public int getColor() {
		return color;
	}

	public int getGrado() {
		return grado;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.grado - o.grado;
	}
	
	public String toString() {
		return "[ " + nodo + ", " + color + ", " + grado + "]";
	}

	/*public void setNodo(int nodo) {
		this.nodo = nodo;
	}*/

	public void setColor(int color) {
		this.color = color;
	}

	/*public void setGrado(int grado) {
		this.grado = grado;
	}*/

}
