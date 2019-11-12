package algoritmos;



public class Welsh {

	public Welsh(Grafo grafo) {
		
		grafo.getListaAristas().sort((o1, o2) -> o1.compareTo(o2));
		System.out.println(grafo.getListaNodos().toString());
	}
	
	
}
