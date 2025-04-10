package Plantillas;

public class Cliente {
	private int Clave;
	private String Nombre;
	private int Edad;
	private char EdoCivil;
	private int Siguiente;
	public Cliente(int Clave, String Nombre, int Edad, char EdoCivil) {
		this.Clave = Clave;
		this.Nombre = Nombre;
		this.Edad = Edad;
		this.EdoCivil = EdoCivil;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setSiguiente(int Siguiente) {
		this.Siguiente = Siguiente;
	}
	public int getEdad() {
		return Edad;
	}
	public char getEdoCivil() {
		return EdoCivil;
	}
	public int getSiguiente() {
		return Siguiente;
	}
	public int getClave() {
		return Clave;
	}
	public String toString() {
		return Nombre+" Clave: "+Clave+" Edad: "+Edad+" Estado Civil: "+EdoCivil;
	}
}
