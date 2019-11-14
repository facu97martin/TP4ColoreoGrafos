package generadores;

import java.util.HashMap;
import java.util.Map;

import generadores.interfaces.GeneradorGrafos;
import grafo.MatrizSimetrica;

public class GeneradorNPartito implements GeneradorGrafos {

	private int nodos;
	private int partes;

	public GeneradorNPartito(int nodos, int partes) {
		this.nodos = nodos;
		this.partes = partes;
	}

	@Override
	public MatrizSimetrica generar() {
		MatrizSimetrica matriz = new MatrizSimetrica(nodos);

		Map<Integer, Integer> mapa = new HashMap<Integer, Integer>(); // <clave "Nodo", valor "Grupo / Particion">;

		int resto = nodos % partes;
		int ce = nodos / partes;
		int contElem = 0;

		for (int i = 0; i < partes; i++) {

			int contador = 0;

			while (contador < ce) {
				mapa.put(contElem++, i);
				contador++;
			}

			if (resto >= 1) {
				mapa.put(contElem++, i);
				resto--;
			}

		}

		for (int i = 0; i < nodos-1; i++) {
			for (int j = i + 1; j < nodos; j++) {
				matriz.setValor(i, j, (mapa.get(i) != mapa.get(j)) && (Math.random() <= 0.85));
				// le pongo el rand para que no sea completamente conexo en las particiones, pero que se note que ahi se conecta y en  las particiones no
			}
		}
		
		matriz.vectorShuffle();

		return matriz;
	}

}
