package principiante;

import junit.framework.TestCase;

public class PersonaTest extends TestCase {

	public void testPersona() {
		Persona p1 = new Persona();
		assertEquals("nombre desconocido", p1.getNombre());
		assertEquals(3, p1.getMaximoLibros());
	}

	public void testSetNombre() {
		Persona p2 = new Persona();
		p2.setNombre("Pedro");
		assertEquals("Pedro", p2.getNombre());
	}

	public void testSetMaximoLibros() {
		Persona p3 = new Persona();
		p3.setMaximoLibros(10);
		assertEquals(10, p3.getMaximoLibros());
	}
	public void testToString() {
		Persona p4 = new Persona();
		p4.setNombre("Pedro Picapiedra");
		p4.setMaximoLibros(7);
		String testString = "Pedro Picapiedra (7 libros)";
		assertEquals(testString, p4.toString());
	}

}
