
public class AplSoldadoVoluntario {
	class Soldado {
		public int NoSoldado;
		public int Edad;
		public Soldado(int NoSoldado, int Edad) {
			this.NoSoldado = NoSoldado;
			this.Edad = Edad;
		}
	}
	public AplSoldadoVoluntario() {
		Procesa();
	}
	
	public void Procesa() {
		Lista<Soldado> L = new Lista<Soldado>();
		int NoNodos = Rutinas.nextInt(20, 50), NoSoldado;
		System.out.println("Número de soldados = "+NoNodos);
		for(int i = 0 ; i < NoNodos ; i++) {
			NoSoldado = Rutinas.nextInt(1000);
			if(RepiteNoSoldado(NoSoldado, L)) {
				i--;
				continue;
			}
			L.InsertaFrente(new Soldado(NoSoldado, Rutinas.nextInt(18, 35)));
		}
		int Sorteo;
		Nodo<Soldado> Aux = L.getFrente();
		while(true) {
			if(L.Length() == 1)
				break;
			Sorteo = Rutinas.nextInt(NoNodos);
			L.Retira(Sorteo);
			NoNodos--;
			System.out.println("El soldado "+L.Dr.NoSoldado+" se salvó");
		}
		System.out.println(L.Length());
		System.out.println("El soldado que irá a la misón, es el "+L.getFrente().Info.NoSoldado+" con edad de "+L.getFrente().Info.Edad);
	}
	
	public boolean RepiteNoSoldado(int NoSoldado, Lista<Soldado> L) {
		Nodo<Soldado> Aux = L.getFrente();
		while(Aux != null) {
			if(Aux.Info.NoSoldado == NoSoldado)
				return true;
			Aux = Aux.getSig();
		}
		return false;
	}
	
	public static void main(String [] a) {
		new AplSoldadoVoluntario();
	}
}
