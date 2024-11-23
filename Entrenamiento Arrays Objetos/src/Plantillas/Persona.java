package Plantillas;

public class Persona {
	private String nombre;
	private String apellido;
	private int repeticiones;
	
	public Persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
		
	}
	
	public String getApellido() {
		return apellido;
		
	}
	
	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
		
	}
	
	public int getRepeticiones() {
		return repeticiones;
		
	}
	
	public String toString() {
		return nombre+" "+apellido+" "+repeticiones;
		
	}

}
