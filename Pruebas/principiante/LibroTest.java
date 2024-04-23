package principiante;

import junit.framework.TestCase;

public class LibroTest extends TestCase {
	public void testLibro() {
		Libro b1 =new Libro ("Great expectations");
		assertEquals("Great expectations", b1.titulo);
		assertEquals("Desconocido", b1.autor);
	}
	public void testGetPersona() {
		Libro b2 =new Libro ("Guerra y Paz");
		Persona p2= new Persona();
		p2.setNombre("Elvis");
		//Metodo para decir a que persona lo prestamos
		b2.setPersona(p2);
//		Persona testPersona = b2.getPersona();
//		String  testNombre = testPersona.getNombre();
		String testNombre=b2.getPersona().getNombre();
		assertEquals("Elvis", testNombre);
		
	}

}
