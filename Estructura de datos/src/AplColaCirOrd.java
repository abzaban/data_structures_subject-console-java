
public class AplColaCirOrd {
	class Dato {
		public String Nombre;
		public int Edad;
		public Dato(String Nombre, int Edad) {
			this.Nombre = Nombre;
			this.Edad = Edad;
		}
		public String toString() {
			return Rutinas.PonCeros(Edad, 3) + Rutinas.PonBlancos(Nombre, 50);
		}
	}
	
	public AplColaCirOrd() {
		ColaCir<Dato> C = new ColaCir<Dato>(5);
		ColaCir<Dato> CAux = new ColaCir<Dato>(5);
		String Nombre, NombreC, EdadC, Nombre2;
		int Edad;
		boolean Band;
		while (!C.Llena()) {
			Nombre = Rutinas.nextNombre(1, Rutinas.nextInt(2, 2));
			Edad = Rutinas.nextInt(18, 60);
			EdadC = Rutinas.PonCeros(Edad, 4);
			Band = false;
			while (C.Retira()) {
				CAux.Inserta(C.Dr);
				if(C.Dr.Nombre.compareTo(Nombre) < 0) {
					Band = true;
				}
			}
			if(Band) {
				while(CAux.Retira()) {
					Nombre2 = CAux.Dr.Nombre;
					if(Nombre2.length() > Nombre.length()) {
						NombreC = Rutinas.PonBlancos(Nombre, Nombre2.length());
						if(NombreC.compareTo(Nombre2) < 0) {
							C.Inserta(new Dato(Nombre, Edad));
						}
						C.Inserta(CAux.Dr);
					}
					else {
						Nombre2 = Rutinas.PonBlancos(Nombre2, Nombre.length());
						if(Nombre.compareTo(Nombre2) < 0) {
							C.Inserta(new Dato(Nombre, Edad));
						}
						C.Inserta(CAux.Dr);
					}
				}
			}
			while(CAux.Retira() && C.Inserta(CAux.Dr));
			C.Inserta(new Dato(Nombre, Edad));
		}
		System.out.println("Contenido de la EDCC");
		while(C.Retira()) {
			System.out.println(C.Dr.Nombre+"\t"+C.Dr.Edad);
		}
	}
	
	public static void main(String [] a) {
		new AplColaCirOrd();
	}
}
	