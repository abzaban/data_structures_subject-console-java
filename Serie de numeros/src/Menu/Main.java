/*
Nombre: Berrelleza Beltrán Abraham
Materia: Estructura de datos
Grupo: 12:00 - 13:00
 */
package Menu;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Enumeration;

public class Main {
	
	public static void main(String []args) {
		Scanner entrada = new Scanner(System.in);
		Hashtable<Integer, Integer> tabla = new Hashtable<Integer, Integer>();
		
		int No;
		int repeticiones = 1;
		while (true) {
			System.out.println("Proporciona un número:");
			No = entrada.nextInt();
			
			System.out.println("");
			
			if (No <= 0)
				break;
			
			if (tabla.containsKey(No)) {
				repeticiones = tabla.get(No) + 1;
				tabla.put(No, repeticiones);
				repeticiones = 1;
				
			}
			else
				tabla.put(No, repeticiones);
			
		}
		
		Enumeration<Integer> e = tabla.keys();
		while (e.hasMoreElements()) {
			int num = e.nextElement();
			System.out.println("Numero: "+num+"  Repeticiones: "+tabla.get(num));
			
		}
		
	}
	
}
