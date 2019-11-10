package grafos;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		
		int[][] matriz = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
		
		MatrizSimetrica vectorMS = new MatrizSimetrica(matriz, 5);
		
		for(int i = 0; i < 5; i++) {
			for(int j = i; j < 5; j++) {
				assertEquals(vectorMS.getValor(i, j), matriz[i][j]);
			}
		}
	}

}
