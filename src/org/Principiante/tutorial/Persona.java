package org.Principiante.tutorial;

public class Persona {
	//campos
		private String nombre; //nombre de la persona
		private int maximoLibros; // maximo de libros de una persona
	//constructor
		public Persona() {
			nombre="nombre desconocido";
			maximoLibros = 3;
		}
	//metodos
		public String getNombre() {
			return nombre;
			
		}
		public void setNombre(String cualquierNombre) {
			nombre = cualquierNombre;
			
		}
		public int getMaximoLibros() {
			return maximoLibros;
			
		}
		public void setMaximoLibros(int maximoLibros) {
			this.maximoLibros = maximoLibros;
		}


}
