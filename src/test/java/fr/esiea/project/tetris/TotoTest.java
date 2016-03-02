package fr.esiea.project.tetris;

import static org.junit.Assert.*;

import org.junit.Test;

public class TotoTest {
	@Test
	public void shouldReturnNonNull(){
		Toto t = new Toto();
		assertNotNull(t.titi());
		assertTrue(t.titi().length() > 12);
	}
}
