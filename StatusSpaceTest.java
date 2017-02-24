import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class StatusSpaceTest {
	
	private StatusSpace statusSpace = new StatusSpace(4,2);;
	

	@Test
	public void testIsEmpty() {
		assertTrue(statusSpace.isEmpty());
	}

	@Test
	public void testStatusGenerate() {
		statusSpace.statusGenerate();
		assertFalse("yes",statusSpace.isEmpty());
	}
	

	@Test
	public void testSize() {
		assertEquals(7,statusSpace.size()); 
	}

	@Test
	public void testNstir2k() {
		assertEquals(7,statusSpace.nstir2k(4,2)); 
	}

	@Test @Ignore
	public void testWriteObjectOfThis() {
		fail("Not yet implemented");
	}

	@Test @Ignore
	public void testReadObjectOfThis() {
		fail("Not yet implemented");
	}
	
	@Test(timeout = 1000)
	public void testDeadLoop(){
		statusSpace.deadLoop();
	}

}
