package Menú;
import Utilerías.Leer;
import Plantillas.Cliente;
import ManipulaPlantillas.ManipulaDato;

public class AplicacionOrdenamientoLogico {
	public static void main(String[] args) {
		ManipulaDato manipula = new ManipulaDato();
		System.out.println("Proporcione el tamaño del vector en el cual se guardaran los datos:");
		int N = Leer.datoInt();
		Cliente []v = new Cliente[N];
		int resp;
		do {
			System.out.println();
			System.out.println("--- Menu principal ---");
			System.out.println();
			System.out.println("1.- Altas de clientes");
			System.out.println("2.- Baja de clientes");
			System.out.println("3.- Consultas");
			System.out.println("4.- Salir");
			resp = Leer.datoInt();
			switch (resp) {
			case 0:
				int a = manipula.Imprime(v, ManipulaDato.Inicio);
				System.out.println("Se repitio "+a);
				break;
			case 1:
				System.out.println();
				manipula.AltaClientes(v);
				break;
				
			case 2:
				System.out.println();
				manipula.BajaClientes(v);
				break;
				
			case 3:
				System.out.println();
				manipula.Consulta(v);
				break;
				
			case 4:
				break;
			}
		} while (resp != 4);
	}
}
