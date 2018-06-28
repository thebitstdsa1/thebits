package presentacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplicarTest {

	@Test
	void testMultiplicar() {
		//fail("Not yet implemented");
	}
	
	@Test //debe fallar pq esta enviando 2*3 y tiene que dar 6
	void testDebeFallar() {
		Calculadora test = new Calculadora();//new
		assertNotEquals(4, test.multiplicar(2, 3), "multiplicar(2,3) debe dar 6");
	}
	
	@Test //debe pasar pq 2 por 4 es 8
	void testDebeAndar() {
		Calculadora test = new Calculadora();
		assertEquals(8, test.multiplicar(2, 4), "multiplicar(2,4) debe dar 8");
	}
		
	
}