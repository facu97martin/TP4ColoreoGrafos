package algoritmos;


public class Arista {
	private static int idArista=0;
	private int nodo1;
	private int nodo2;

	
	public Arista(int nodo1,int nodo2) {
		this.idArista = idArista+1;
		idArista++;
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
	}

	public int getIdArista() {
		return this.idArista;
	}
	public int getNodo1() {
		return nodo1;
	}

	public void setNodo1(int nodo1) {
		this.nodo1 = nodo1;
	}

	public int getNodo2() {
		return nodo2;
	}

	public void setNodo2(int nodo2) {
		this.nodo2 = nodo2;
	}

	public Integer compareTo(Arista o2) {
		if(this.getIdArista()==o2.getIdArista()) {
			return 0;
		}else if(this.getIdArista()>o2.getIdArista()) {
			return 1;
		}else {
			return -1;
		}
		
	}


}
