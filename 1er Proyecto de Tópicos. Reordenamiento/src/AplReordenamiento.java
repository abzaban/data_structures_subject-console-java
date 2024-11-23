import java.util.Scanner;

public class AplReordenamiento {

	class Dato {
		String Nombre;
		int Edad;
		double Estatura;
		String Retorno;

		public Dato(String Nombre, int Edad, double Estatura) {
			this.Nombre = Nombre;
			this.Edad = Edad;
			this.Estatura = Estatura;
			Retorno = Nombre;
		}

		public void setoString(int Orden) {
			if (Orden == 0) {
				Retorno = Nombre;
				return;
			}
			if (Orden == 1) {
				Retorno = Edad + "";
				return;
			}
			if (Orden == 2) {
				Retorno = Estatura + "";
				return;
			}
			if (Orden == 3) {
				Retorno = Rutinas.PonCeros(Edad, 3) + "" + Estatura + "" + Rutinas.PonBlancos(Nombre, 15);
				return;
			}
		}

		public String toString() {
			return Rutinas.PonBlancos(Retorno, 15);
		}

		public String toString(int Orden) {
			if (Orden == 0)
				return Rutinas.PonBlancos(Nombre, 15);
			if (Orden == 1)
				return Rutinas.PonCeros(Edad, 3);
			if (Orden == 2)
				return Estatura + "";
			return Rutinas.PonCeros(Edad, 3) + "" + Estatura + "" + Rutinas.PonBlancos(Nombre, 15);
		}
	}

	private Scanner In;
	private Lista<Dato> L;

	public AplReordenamiento() {
		L = new Lista<Dato>();
		In = new Scanner(System.in);

		int Op;
		while (true) {
			System.out.println("¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Ingresar una persona");
			System.out.println("2. Elegir forma de ordenamiento");
			System.out.println("3. Consultar");
			Op = In.nextInt();

			if (Op == 0) {
				return;
			}
			if (Op == 1) {
				IngresaPersona();
				continue;
			}
			if (Op == 2) {
				EligeOrdenamiento();
				continue;
			}
			if (Op == 3) {
				Consulta();
				continue;
			}
		}
	}

	public void IngresaPersona() {
		String Nombre = Rutinas.nextNombre(1, Rutinas.nextInt(2));
		int Edad = Rutinas.nextInt(1, 100);
		double Estatura = (double) (Rutinas.nextInt(10, 20)) * 0.1;
		Dato D = new Dato(Nombre, Edad, Estatura);
		L.InsertaOrdenado(D);
	}

	public void EligeOrdenamiento() {
		System.out.println("¿Cómo desea reordenar?");
		System.out.println("1. Nombre");
		System.out.println("2. Edad");
		System.out.println("3. Estatura");
		System.out.println("4. Edad-Estatura-Nombre");
		int Op = In.nextInt();

		if (Op == 1) {
			Reordenar(Rutinas.PonBlancos(L.getFrente().Info.Nombre, 15), 1);
			return;
		}
		if (Op == 2) {
			Reordenar(Rutinas.PonCeros(L.getFrente().Info.Edad, 3), 2);
			return;
		}
		if (Op == 3) {
			Reordenar(L.getFrente().Info.Estatura + "", 3);
			return;
		}
	}

	public void Reordenar(String Dato, int Orden) {
		Nodo<Dato> Aux = L.getFrente().getSig();
		int Sup, i;
		String Temp;
		boolean Band = true;
		Sup = L.Length();
		while (Band) {
			Band = false;
			Sup--;
			for (i = 0; i < Sup; i++) {
				if (Orden == 1 && Dato.compareTo(Rutinas.PonBlancos(Aux.Info.Nombre, 15)) > 0) {
					Temp = Aux.Info.Nombre;
					Aux.Info.Nombre = Aux.getSig().Info.Nombre;
					Aux.getSig().Info.Nombre = Temp;
					Band = true;
				}
				if (Orden == 2 && Dato.compareTo(Aux.Info.Edad + "") > 0) {
					Temp = Aux.Info.Edad + "";
					Aux.Info.Nombre = Aux.getSig().Info.Edad + "";
					Aux.getSig().Info.Nombre = Temp;
					Band = true;
				}
				if (Orden == 3 && Dato.compareTo(Aux.Info.Estatura + "") > 0) {
					Temp = Aux.Info.Nombre;
					Aux.Info.Nombre = Aux.getSig().Info.Nombre;
					Aux.getSig().Info.Nombre = Temp;
					Band = true;
				}
			}
		}
	}

	public void Consulta() {
		Nodo<Dato> Aux = L.getFrente();
		int i = 1;
		while (Aux != null) {
			System.out.println("Persona No. " + i);
			i++;
			System.out.println("Nombre: " + Aux.Info.Nombre + "\n" + "Edad: " + Aux.Info.Edad + "\n"
					+ "Estatura: " + Aux.Info.Estatura);
			Aux = Aux.getSig();
			if (Aux != null)
				System.out.println();
		}
	}

	public static void main(String[] a) {
		new AplReordenamiento();
	}
}
