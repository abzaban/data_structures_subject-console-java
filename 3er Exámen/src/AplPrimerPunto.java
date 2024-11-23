import java.util.*;

public class AplPrimerPunto {
	/*
	Alumno: Berrelleza Beltrán Abraham
	Materia: Estructura de Datos
	Hora: 12:00 - 13:00
	 */
	static int NombCrea = 0;
	public static void main(String [] a) {
		String [] Nombres = new String[5];
		String Nombre;
		for(int i = 0 ; i < Nombres.length ; i++) {
			Nombre = Rutinas.nextNombre(1, 1);
			if(RepiteNombre(Nombres, Nombre)) {
				i--;
				continue;
			}
			Nombres[i] = Rutinas.PonBlancos(Nombre, 30);
			NombCrea++;
		}
		Burbuja(Nombres);
		ArbolBinarioBusqueda<String> Obj = new ArbolBinarioBusqueda<String>();
		int Aleatorio;
		for(int i = 0 ; i < Nombres.length ; i++) {
			Aleatorio = Rutinas.nextInt(0, Nombres.length - 1);
			if(!Obj.Inserta(Nombres[Aleatorio]))
				i--;
		}
	}
	
	public static boolean RepiteNombre(String [] V, String Nombre) {
		for(int i = 0 ; i < NombCrea ; i++)
			if(V[i].compareTo(Nombre) == 0)
				return true;
		return false;
	}
	
	public static void Burbuja(String [] V) {
		int Sup, i;
		String Temp;
		boolean Band = true;
		Sup = V.length;
		while(Band) {
			Band = false;
			Sup--;
			for(i = 0 ; i < Sup ; i++) {
				if (V[i].compareTo(V[i+1]) > 0) {
					Temp = V[i];
					V[i] = V[i+1];
					V[i+1] = Temp;
					Band = true;
				} 
			}
		}
	}
}
