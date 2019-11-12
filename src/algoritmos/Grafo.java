package algoritmos;


import java.util.ArrayList;

public class Grafo {

	private int cantidadNodos;
	private int cantidadAristas;
	private String porcAdy;
	private int gradoMax;
	private int gradoMin;
	private ArrayList<Integer> listado;
	private ArrayList<Nodo> listaNodos;
	private ArrayList<Arista> listaAristas;
	private Nodo nodo;
	
	public Grafo(Grafo grafo) {
		this.cantidadAristas = grafo.cantidadAristas;
		this.cantidadNodos = grafo.cantidadNodos;
		this.listado = grafo.listado;
	}
	
	public Grafo(int cantidadNodos,int cantidadAristas, String porcAdy,int gradoMax,int gradoMin, ArrayList<Integer> listado) {
		this.cantidadNodos	= cantidadNodos;
		this.cantidadAristas = cantidadAristas;
		this.listado = listado;
	}
	
	public void generarNodos(Grafo grafo) {
		int i=0;
		listaNodos = new ArrayList<Nodo>();
		listaAristas = new ArrayList<Arista>();
		
		while(i<cantidadNodos) {
			nodo = new Nodo(i+1);
			listaNodos.add(nodo);
			i++;
		}
		i=0;
		while(i<cantidadAristas*2) {
			//System.out.println(listaNodos.get(grafo.listado.get(i)-1).getNodoId());
			nodo = listaNodos.get(grafo.listado.get(i)-1);
			this.nodo.addArista(grafo.listado.get(i), grafo.listado.get(i+1));
			i+=2;
		}
	}

	public void imprimirNodos() {
		for (Nodo nodos : listaNodos) {
			System.out.println(nodos.toString());
		}
	}

	public ArrayList<Nodo> getListaNodos() {
		return listaNodos;
	}

	public void setListaNodos(ArrayList<Nodo> listaNodos) {
		this.listaNodos = listaNodos;
	}

	public ArrayList<Arista> getListaAristas() {
		return listaAristas;
	}

	public void setListaAristas(ArrayList<Arista> listaAristas) {
		this.listaAristas = listaAristas;
	}
	
	
}