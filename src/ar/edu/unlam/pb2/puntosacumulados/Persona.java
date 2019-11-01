package ar.edu.unlam.pb2.puntosacumulados;

import java.time.LocalDate;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private LocalDate edad;

	public Persona(String nombre, String apellido, LocalDate edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public abstract void calcularEdad(); // puse este metodo de prueba, habria que elegir uno correcto

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getEdad() {
		return edad;
	}

	public void setEdad(LocalDate edad) {
		this.edad = edad;
	}

}
