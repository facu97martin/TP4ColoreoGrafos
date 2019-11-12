package algoritmos;

import java.util.ArrayList;
import java.util.Comparator;


public class Nodo implements Comparator<Nodo>{
	private int nodoId;
	private ArrayList<Arista> aristas;
	private int grado;
	
	public Nodo(int id) {
		this.nodoId = id;
		aristas = new ArrayList<Arista>();
		grado = aristas.size();
	}
	
	public void addArista(int nodo1,int nodo2) {
		
		Arista relacion = new Arista(nodo1,nodo2);
		aristas.add(relacion);
	}

	public  int getNodoId() {
		return nodoId;
	}

	

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}

	@Override
	public String toString() {
		return "NodoId=" + nodoId + ", Aristas()=" + getAristas() + "";
	}

	public int getGrado() {
		return this.grado;
	}

	@Override
	public int compare(Nodo o1, Nodo o2) {
		if(o1.grado == o2.grado) {
			return 0;
		}else if(o1.grado > o2.grado) {
			return 1;
		}else {
			return -1;
		}
	}

}
