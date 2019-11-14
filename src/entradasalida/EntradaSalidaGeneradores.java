package entradasalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import grafo.MatrizSimetrica;

public class EntradaSalidaGeneradores {

	public static final String DELIM = " ";
	//public static final String FIN_LINEA = "\n";

	private PrintWriter pw;

	public void escribir(String titulo, MatrizSimetrica matriz) {

		try {
			
			matriz.calcularVariablesInternas();
			int nodos = matriz.getNodos();
			
			pw = new PrintWriter(new File(titulo + ".in"));
			pw.println(
					nodos + DELIM + 
					matriz.getAristas() + DELIM + 
					String.format("%2.4f", matriz.getPorcAdy()) + DELIM + 
					matriz.getGrMax() + DELIM + 
					matriz.getGrMin()/* + FIN_LINEA*/);
			
			for(int i = 0; i < nodos; i++) {
				for(int j = i + 1; j < nodos; j++) {
					if(matriz.getValor(i, j)) {
						pw.println((i+1) + DELIM + (j+1));
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.close();

	}

}
