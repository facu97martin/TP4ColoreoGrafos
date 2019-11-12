package entradasalida.generadores;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Scanner;

import algoritmos.Grafo;

	public class EntradaSalidaGrafos {
		
		private Scanner sc;
		private int cantidadNodos;
		private int cantidadAristas;
		private String porcAdy;
		private int gradoMax;
		private int gradoMin;
		private ArrayList<Integer> listado;
		private Grafo grafo;

		
		
		public Grafo leer(String entrada) {
			
			try {
				sc = new Scanner(new File(entrada));
			} catch (FileNotFoundException e) {
				System.out.println("error de archivo");
				e.printStackTrace();
			}
			cantidadNodos = sc.nextInt();
			cantidadAristas = sc.nextInt();
			porcAdy = sc.next();
			gradoMax = sc.nextInt();
			gradoMin = sc.nextInt();
			listado = new ArrayList<Integer>();
			while(sc.hasNextLine()) {
				listado.add(sc.nextInt());
			}
			grafo = new Grafo(cantidadNodos,cantidadAristas,porcAdy,gradoMax,gradoMin,listado);
			
			sc.close();
			return grafo;
		}
	}
	
