package principiante;

import java.util.ArrayList;

import junit.framework.TestCase;

public class MiBibliotecaTest extends TestCase implements PrestarLibros {

//test del constructor
	public void testMiBiblioteca() {
		
		MiBiblioteca mb =new MiBiblioteca ("Test");
		assertEquals("Test", mb.nombre);
		assertTrue(mb.libros instanceof ArrayList<Libro>);
		assertTrue(mb.personas instanceof ArrayList<Persona>);
	}

		public void testAnadirLibro() {
		//create test objects
			creacionPrevia();
			MiBiblioteca mb = new MiBiblioteca("Test");
		//test initial size is 0
		assertEquals(0, mb.getLibros().size());
		mb.anadirLibro(b1);
		mb.anadirLibro(b2);
		assertEquals(2, mb.getLibros().size());
		assertEquals(0, mb.getLibros().indexOf(b1));
		assertEquals(1, mb.getLibros().indexOf(b2));
		mb.quitarLibro(b1);
		assertEquals(1, mb.getLibros().size());
		assertEquals(0, mb.getLibros().indexOf(b2));
		mb.quitarLibro(b2);
		assertEquals(0, mb.getLibros().size());
		}
		
		
		@Override
		public void testPrestar() {
		// set up objects
			creacionPrevia();
			MiBiblioteca mb = new MiBiblioteca("Test");
			mb.anadirLibro(b1);
			mb.anadirLibro(b2);
			mb.anadirPersona(p1);
			mb.anadirPersona(p2);
		assertTrue("El libro no se presto adecuadamente",
		mb.prestar(b1,p1));
		assertEquals("Fred", b1.getPersona().getNombre());
		assertFalse("el libro ya está prestado",
		mb.prestar(b1,p2));
		assertTrue("La devolución falló", mb.devolver(b1));
		assertFalse("El libro ya está prestado", mb.devolver(b1));
		assertFalse("El libro nunca se prestó", mb.devolver(b2));
		}

		private void creacionPrevia() {
			Libro b1 = new Libro("Book1");
			Libro b2 = new Libro("Book2");
			Persona p1 = new Persona();
			Persona p2 = new Persona();
			p1.setNombre("Fred");
			p2.setNombre("Sue");
		}
		public void testGetLibrosDsiponibles() {
			creacionPrevia();
			MiBiblioteca mb = new MiBiblioteca("Test");
			mb.anadirLibro(b1);
			mb.anadirLibro(b2);
			mb.anadirPersona(p1);
			mb.anadirPersona(p2);
			ArrayList<Libro> testLibros = mb.getLibrosDisponibles();
			assertEquals(2, testLibros.size());
			assertEquals(1, testLibros.indexOf(b2));
			mb.prestar(b1, p1);
			testLibros = mb.getLibrosDisponibles();
			assertEquals(1, testLibros.size());
			assertEquals(0, testLibros.indexOf(b2));
			mb.prestar(b2, p1);
			testLibros = mb.getLibrosDisponibles();
			assertEquals(0, testLibros.size());
			}
		
		public void testGetLibrosNoDisponibles() {
			creacionPrevia();
			MiBiblioteca mb = new MiBiblioteca("Test");
			mb.anadirLibro(b1);
			mb.anadirLibro(b2);
			mb.anadirPersona(p1);
			mb.anadirPersona(p2);
			assertEquals(0, mb.getLibrosNoDisponibles().size());
			mb.prestar(b1, p1);
			ArrayList<Libro> testLibros = mb.getLibrosNoDisponibles();
			assertEquals(1, testLibros.size());
			assertEquals(0, testLibros.indexOf(b1));
			mb.prestar(b2, p2);
			testLibros = mb.getLibrosNoDisponibles();
			assertEquals(2, testLibros.size());
			assertEquals(1, testLibros.indexOf(b2));
			}
		public void testToString() {
			creacionPrevia();
			MiBiblioteca mb = new MiBiblioteca("Test");
			mb.anadirLibro(b1);
			mb.anadirLibro(b2);
			mb.anadirPersona(p1);
			mb.anadirPersona(p2);
			assertEquals("Test: 2 Libros; 2 personas.",
			mb.toString());
		}
}
