
public class AplFerrocarriles {
	// Alumno: Berrelleza Beltrán Abraham
	// Materia: Estructura de Datos
	// Horario: 12:00 - 13:00
	
	private Cola<Integer> CTren;
	private Cola<Integer> ViaEstacionamiento;
	private int Elementos;
	
	public AplFerrocarriles() {
		Elementos = Rutinas.nextInt(50, 70);
		System.out.println("Cantidad de vagones: "+Elementos);
		System.out.println();
		CTren = new Cola<Integer>(Elementos);
		int CantidadAsig = (int)(0.6 * Elementos);
		int TamañoViaE = 150 - CantidadAsig;
		ViaEstacionamiento = new Cola<Integer>(TamañoViaE);
		Procesa(CantidadAsig, TamañoViaE);	
	}
	
	public void Procesa(int CantidadAsig, int TamañoViaE) {
		int NoVagon;
		CTren.Inserta(1);
		CantidadAsig--;
		for(int i = 0 ; i < CantidadAsig ; i++) {
			NoVagon = Rutinas.nextInt(2, 200);
			if(!RepiteNo(NoVagon, CTren)) {
				i--;
				continue;
			}
			CTren.Inserta(NoVagon);
		}
		for(int i = 0 ; i < TamañoViaE ; i++) {
			NoVagon = Rutinas.nextInt(2, 200);
			if(!RepiteNo(NoVagon, ViaEstacionamiento)) {
				i--;
				continue;
			}
			if(!RepiteNo(NoVagon, CTren)) {
				i--;
				continue;
			}
			ViaEstacionamiento.Inserta(NoVagon);
		}
		while(!CTren.Llena()) {
			ViaEstacionamiento.Retira();
			CTren.Inserta(ViaEstacionamiento.Dr);
		}
		int i = 1;
		while(CTren.Retira()) {
			System.out.println(i+" "+CTren.Dr);
			i++;
		}
	}
	
	public boolean RepiteNo(int NoVagon, Cola<Integer> C) {
		boolean Band = true;
		if(C.Vacia())
			return true;
		// Cola taller
		Cola<Integer> CAux = new Cola<Integer>(Elementos);
		int NoActual;
		while(C.Retira()) {
			CAux.Inserta(C.Dr);
			NoActual = C.Dr;
			if(NoActual == NoVagon)
				Band = false;
		}
		while(CAux.Retira())
			C.Inserta(CAux.Dr);
		return Band;
	}
	
	public static void main(String [] a) {
		new AplFerrocarriles();
	}
}
