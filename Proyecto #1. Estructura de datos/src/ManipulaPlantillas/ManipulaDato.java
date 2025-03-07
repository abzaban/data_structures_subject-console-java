package ManipulaPlantillas;
import Plantillas.Cliente;
import Utilerías.Leer;

public class ManipulaDato {
	private static int DatosCreados = 0;
	private static int SubIndice = 0;
	public static int Inicio = -1;
	
	public void AltaClientes(Cliente [] v) {
		int resp = 0;
		boolean bandera = false;
		int TamañoArray = v.length;
		int Clave;
		for (int i = SubIndice; i < TamañoArray; i++) {
			System.out.print("Clave: ");
			do {
				Clave = Leer.datoInt();
				bandera = false;
				for (int j = Inicio; j < DatosCreados; j = v[j].getSiguiente()) {
					if (j == -1)
						break;
					if (v[j].getClave() == Clave) {
						bandera = true;
						System.out.println("La clave "+Clave+" ya existe, favor de ingresar una nueva:");
						break;
					}
				}
			} while (bandera == true);
			System.out.print("Nombre: ");
			String Nombre;
			do {
				bandera = false;
				Nombre = Leer.dato().toLowerCase();
				if (StringCorrecto(Nombre) == true)
					System.out.println("Hubo un error con la palabra, igresa nuevamente el nombre: ");		
				for (int j = Inicio; j < DatosCreados; j = v[j].getSiguiente()) {
					if (j == -1)
						break;
					if (v[j].getNombre().equals(Nombre)) {
						bandera = true;
						System.out.println("El nombre "+Nombre+" ya existe, favor de ingresar un nombre nuevo:");
						break;	
					}
				}
			} while (bandera == true || StringCorrecto(Nombre) == true);
			System.out.print("Edad: ");
			int Edad = Leer.datoInt();
			System.out.println("Estado civil: ");
			System.out.println("S = Soltero(a)"+"\nC = Casado(a)"+"\nD = Divorciado(a)"+"\nV = Viudo(a)");
			char EdoCivil;
			do {
				EdoCivil = Leer.datocar();
				if (EdoCivil != 's' && EdoCivil != 'S' && EdoCivil != 'c' && EdoCivil != 'C' && EdoCivil != 'd' && EdoCivil != 'D' && EdoCivil != 'v' && EdoCivil != 'V')
					System.out.println("Ingrese un estado civil valido: ");
			} while (EdoCivil != 's' && EdoCivil != 'S' && EdoCivil != 'c' && EdoCivil != 'C' && EdoCivil != 'd' && EdoCivil != 'D' && EdoCivil != 'v' && EdoCivil != 'V');
			System.out.println();
			if (EdoCivil == 's')
				EdoCivil = 'S';
			if (EdoCivil == 'c')
				EdoCivil = 'C';
			if (EdoCivil == 'd')
				EdoCivil = 'D';
			if (EdoCivil == 'v')
				EdoCivil = 'V';
			System.out.println("1.- Registrar");
			System.out.println("2.- Menu anterior");
			resp = Leer.datoInt();
			if (resp == 2)
				return;
			if (resp == 1) {
				Cliente dato = new Cliente(Clave, Nombre, Edad, EdoCivil);
				v[i] = dato;
				dato.setSiguiente(-1);
				SubIndice++;
				DatosCreados++;
				// Caso 1er elemento del vector
				if (Inicio == -1) {
					Inicio = i;
					return;
				}
				int anterior = Inicio;
				int siguiente;
				for (int j = 0; j < DatosCreados; j++) {
					if (anterior == -1)
						break;
					//Caso último elemento
					if (Nombre.compareTo(v[anterior].getNombre()) > 0 && v[anterior].getSiguiente() == -1) {
						dato.setSiguiente(v[anterior].getSiguiente());
						v[anterior].setSiguiente(i);
						break;	
					}
					//Caso primer elemento
					if (Nombre.compareTo(v[anterior].getNombre()) < 0) {
						dato.setSiguiente(anterior);
						Inicio = i;
						break;	
					}
					siguiente = v[anterior].getSiguiente();
					// Caso entre medio
					if (Nombre.compareTo(v[anterior].getNombre()) > 0 && Nombre.compareTo(v[siguiente].getNombre()) < 0) {
						v[anterior].setSiguiente(i);
						dato.setSiguiente(siguiente);
						break;
					}
					anterior = v[anterior].getSiguiente();
				}
				break;	
			}
		}
	}
	
	public int Imprime(Cliente [] v, int Sig) {
		if(v[Sig].getSiguiente() == -1) {
			System.out.println(v[Sig]);
			return 1;
		}
		int num = 1 + Imprime(v, v[Sig].getSiguiente());
		System.out.println(v[Sig]);
		return num;
	}
	
	public void BajaClientes(Cliente [] v) {
		if (DatosCreados == 0) {
			System.out.println("No se han registrado datos aun");
			return;
		}
		System.out.println("Proporcione el nombre del cliente a borrar: ");
		String Nombre;
		do {
			Nombre = Leer.dato().toLowerCase();
			if (StringCorrecto(Nombre) == true)
				System.out.println("Hubo un error con la palabra, ingresa nuevamente el nombre: ");
		} while (StringCorrecto(Nombre) == true);
		System.out.println();
		boolean bandera = false;
		int anteriorLocalizacion = Inicio;
		/*for (int i = 0; i < DatosCreados; i++) {
			if (Nombre.equals(v[i].getNombre()) {
			
			}
		}*/
		for (int i = 0; i < DatosCreados; i++) {
			if (Nombre.equals(v[anteriorLocalizacion].getNombre())) {
				bandera = true;
				int resp;
				System.out.println("Seguro que deseas eliminar a "+Nombre+", ingresa una respuesta: ");
				System.out.println("1.- Si");
				System.out.println("2.- No");
				do {
					resp = Leer.datoInt();
					if (resp != 1 && resp != 2)
						System.out.println("La respuesta ingresada no es valida, intentalo de nuevo: ");
				} while(resp != 1 && resp != 2);
				if (resp == 1) {
					DatosCreados--;
					int anterior = Inicio;
					int siguiente;
					if (v[Inicio].getNombre().equals(Nombre) && v[Inicio].getSiguiente() == -1) {
						Inicio = -1;
						break;
					}
					for (int j = 0; j < DatosCreados; j++) {
						siguiente = v[anterior].getSiguiente();
						if (v[anterior].getNombre().equals(Nombre)) {
							Inicio = siguiente;
							break;
						}
						if (Nombre.equals(v[siguiente].getNombre())) {
							v[anterior].setSiguiente(v[siguiente].getSiguiente());
							break;
						}
						anterior = v[anterior].getSiguiente();
					}
					System.out.println("El cliente "+Nombre+" fue eliminado exitosamente");
					return;
				}
				if (resp == 2) {
					System.out.println("La eliminacion de "+Nombre+" fue cancelada correctamente");
					return;
				}
			}
			anteriorLocalizacion = v[anteriorLocalizacion].getSiguiente();
		}
		if (bandera == false)
			System.out.println("No existe el cliente "+Nombre);
	}
	
	public void Consulta(Cliente [] v) {
		if (DatosCreados == 0) {
			System.out.println("No se han registrado datos aun");
			return;
		}
		System.out.println("Clave"+"\tNombre"+"\tEdad"+"\tEstado Civil");
		int aux = Inicio;
		for (int i = 0; i < DatosCreados; i++) {
			if (aux == -1)
				break;
			System.out.println(v[aux].getClave()+"\t"+v[aux].getNombre()+"\t"+v[aux].getEdad()+"\t"+v[aux].getEdoCivil());
			aux = v[aux].getSiguiente();
		}
		System.out.println();
		/*for (int i = 0; i < SubIndice; i++) {
			System.out.println(v[i]+" "+v[i].getSiguiente());
		}*/
	}
	
	public boolean StringCorrecto(String cadena) {
        boolean validacion = false;
        if ( (cadena == null) || (cadena.isEmpty() || cadena.trim().length() == 0))
            validacion = true;
        if (!(cadena.replaceAll("\\D","").length() == 0))
            validacion = true;
        return validacion;
    }
	public int retInicio() {
		return Inicio;
		
	}
}
