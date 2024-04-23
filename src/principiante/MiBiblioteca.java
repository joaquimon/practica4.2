package principiante;

import java.util.ArrayList;

public class MiBiblioteca {

	public String nombre;
	public ArrayList<Libro> libros;
	public ArrayList<Persona> personas;

	public MiBiblioteca(String name) {
		this.nombre =name;
		libros = new ArrayList<Libro>();
		personas = new ArrayList<Persona>();
		
		
	}
	public String getName() {
		return nombre;
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public ArrayList<Persona> getPersonas() {
		return personas;
	}
	public void anadirLibro(Libro b1) {
		this.libros.add(b1);
	}
	public void quitarLibro(Libro b1) {
		this.libros.remove(b1);
	}
	public void anadirPersona(Persona p1) {
		this.personas.add(p1);
	}
	public void quitarPersona(Persona p1) {
		this.personas.remove(p1);
	}
	public boolean prestar(Libro b1, Persona p1) {
		int booksOut = this.getLibrosDePersona(p1).size();
		if ((b1.getPersona() == null) &&
		booksOut < p1.getMaximoLibros()){
		b1.setPersona(p1);
		return true;
		}
		else {
		return false;
		}
		}
	public boolean devolver(Libro b1) {
		if (b1.getPersona() != null) {
			b1.setPersona(null);
			return true;
			}
			else {
			return false;
			}
			
		}
	public ArrayList<Libro> getLibrosDePersona(Persona p1) {
		ArrayList<Libro> result = new ArrayList<Libro>();
		for (Libro aBook : this.getLibros()) {
		if ((aBook.getPersona() != null) &&
		(aBook.getPersona().getNombre()
		.equals(p1.getNombre())))
		{
		result.add(aBook);
		}
		}
		return result;
		}
	public ArrayList<Libro> getLibrosDisponibles() {
		ArrayList<Libro> result = new ArrayList<Libro>();
		for (Libro aLibro : this.getLibros()) {
		if (aLibro.getPersona() == null) {
		result.add(aLibro);
		}
		}
		return result;
		}
		public ArrayList<Libro> getLibrosNoDisponibles() {
		ArrayList<Libro> result = new ArrayList<Libro>();
		for (Libro aLibro : this.getLibros()) {
		if (aLibro.getPersona() != null) {
		result.add(aLibro);
		}
		}
		return result;
		}
		public String toString() {
		return this.nombre + ": " +
		this.getLibros().size() + " Libros; " +
		this.getPersonas().size() + " personas.";
		}
		public static void main(String[] args) {
			// create a new MiBiblioteca
			MiBiblioteca testLibrary = new MiBiblioteca("Test Drive Library");
			Libro b1 = new Libro("War And Peace");
			Libro b2 = new Libro("Great Expectations");
			b1.setAutor("Tolstoy");
			b2.setAutor("Dickens");
			Persona jim = new Persona();
			Persona sue = new Persona();
			jim.setNombre("Jim");
			sue.setNombre("Sue");
			testLibrary.anadirLibro(b1);
			testLibrary.anadirLibro(b2);
			testLibrary.anadirPersona(jim);
			testLibrary.anadirPersona(sue);
			System.out.println("Just created new library");
			testLibrary.printStatus();
			System.out.println("Check out War And Peace to Sue");
			testLibrary.prestar(b1, sue);
			testLibrary.printStatus();
			System.out.println("Do some more stuff");
			testLibrary.devolver(b1);
			testLibrary.prestar(b2, jim);
			testLibrary.printStatus();
			}
			private void printStatus() {
			System.out
			.println("Status Report of MiBiblioteca \n" +
			this.toString());
			for (Libro thisLibro : this.getLibros()) {
			System.out.println(thisLibro);
			}
			for (Persona p : this.getPersonas()) {
			int count = this.getLibrosDePersona(p).size();
			System.out.println(p + " (has " + count
			+ " of my Libros)");
			}
			System.out.println("Libros Available: "
			+ this.getLibrosDisponibles().size());
			System.out.println("--- End of Status Report ---");
			}
}
