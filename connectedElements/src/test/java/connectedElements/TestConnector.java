package connectedElements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestConnector {
	
	@Test
	public void testConstructor() {
		assertThrows(NumberFormatException.class, () -> new Network(-8));
	}
	
	@Test
	public void testNetwork() {
		
		Network connector = new Network(8);
		
		connector.connect(1, 2);
		connector.connect(2, 4);
		
		Boolean directConnected = connector.query(1, 2);
		Boolean indirectConnected = connector.query(1, 4);
		
		// validando conexões existentes
		assertEquals(true, directConnected);
		assertEquals(true, indirectConnected);
		
		
		// validando conexões não existentes
		Boolean testConnection = connector.query(1, 3);
		
		assertEquals(false, testConnection);
	}
	
}
