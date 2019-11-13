package coloreo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import matrizsimetrica.MatrizSimetrica;

public class ColoreadorGrafos {

	List<Integer> listaNodos;

	public ColoreadorGrafos() {
		listaNodos = new ArrayList<Integer>();
	}
	
	public List<Integer> ordenarAleatorio(MatrizSimetrica grafo){
		
		for(int i = 0; i < grafo.getOrden(); i++) {
			listaNodos.add(i);
		}
		
		Collections.shuffle(listaNodos);
		return listaNodos;
	}
	
	public List<Integer> ordenarMatula(MatrizSimetrica grafo){
		
		int orden = grafo.getOrden();
		
		int[] grados = new int[orden];
		
		for(int i = 0; i < orden; i++) {
			for(int j = i + 1; j < orden; j++) {
				if(grafo.getValor(i, j) == true) {
					grados[i]++;
				}
			}
		}
		
		//aca la quede
		
		return listaNodos;
	}

}
