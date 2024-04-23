package principiante;

public class Libro {

	String titulo;
	String autor;
	Persona persona;

	public Libro(String string) {
		this.titulo = string;
		this.autor ="Desconocido";
	
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setPersona(Persona p2) {
		this.persona = p2;
	}

	public Persona getPersona() {
		return this.persona;
	}

}
