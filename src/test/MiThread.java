package test;

import grafo.Grafo;

public class MiThread implements Runnable {
	
	private Grafo grafo;
	private String titulo;
	private int cantidadVeces;
	
	public MiThread(Grafo grafo, String titulo, int cantidadVeces) {
		this.grafo = grafo;
		this.titulo = titulo;
		this.cantidadVeces = cantidadVeces;
	}
	
	public void run() {		
		grafo.colorearMuchasVecesEImprimir(this.cantidadVeces, this.titulo);
		System.out.println("---------------------------------------------");
	}
	
}
