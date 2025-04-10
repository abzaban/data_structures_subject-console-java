
public class AplSpool {
	class Reporte {
		public int NoComp, TotalPaginas, Paginas;
		public Reporte(int NoComp, int TotalPaginas, int Paginas){
			this.NoComp = NoComp;
			this.TotalPaginas = TotalPaginas;
			this.Paginas = Paginas;
		}
	}
	
	public AplSpool() {
		ColaCir<Reporte> C = new ColaCir<Reporte>(30);
		ColaCir<Reporte> CAux = new ColaCir<Reporte>(30);
		ColaCir<Reporte> CClon = new ColaCir<Reporte>(30);
		int Ac = Rutinas.nextInt(10, 20);
		int Accion, Total, EleNecesitado;
		boolean Band;
		for(int i = 0 ; i < Ac ; i++){
			Accion = Rutinas.nextInt(3) + 1;
			switch(Accion) {
			case 1:
				// Se hace una cola identica a la original (CClon) para trabajar sobre ella
				while(C.Retira() && CAux.Inserta(C.Dr) && CClon.Inserta(C.Dr));
				while(CAux.Retira() && C.Inserta(CAux.Dr));
				int TotalPaginas = Rutinas.nextInt(1, 150), Comp = Rutinas.nextInt(1, 5);
				
				// Evaluar si cabe el reporte
				Band = false;
				EleNecesitado = TotalPaginas / 50;
				for(byte j = 0 ; j < EleNecesitado ; j++)
					if(!CClon.Inserta(new Reporte(Comp, TotalPaginas, 50)))
						Band = true;
				if(TotalPaginas % 50 > 0)
					if(!CClon.Inserta(new Reporte(Comp, TotalPaginas, TotalPaginas % 50)))
						Band = true;
				while(CClon.Retira());
				if(Band) {
					System.out.println("No se pudo insertar el reporte");
					i--;
					continue;
				}
				
				// Si llega aqui el flujo, indica que si cabe por lo que hay que meterlo
				for(byte j = 0 ; j < EleNecesitado ; j++)
					C.Inserta(new Reporte(Comp, TotalPaginas, 50));
				if(TotalPaginas % 50 > 0)
					C.Inserta(new Reporte(Comp, TotalPaginas, TotalPaginas%50));
				System.out.println("Reporte Insertado");
				break;
				
			case 2:
				if(C.Vacia()) {
					i--;
					continue;
				}
				Total = 0;
				while(C.Retira()) {
					Total += C.Dr.Paginas;
					if(Total == C.Dr.TotalPaginas) {
						System.out.println("Impreso "+C.Dr.NoComp+"\t"+C.Dr.TotalPaginas+"\t"+Total);
						break;
					}
				}
				break;
				
			case 3:
				System.out.println("Estado Actual");
				Total = 0;
				while(!C.Vacia()) {
					Total = 0;
					while(C.Retira()) {
						CAux.Inserta(C.Dr);
						Total += C.Dr.Paginas;
						if(Total == C.Dr.TotalPaginas) {
							System.out.println(C.Dr.NoComp+"\t"+C.Dr.TotalPaginas+"\t"+Total);
							break;
						}
					}
				}
				while(CAux.Retira() && C.Inserta(CAux.Dr));
				i--;
				break;
			}
		}
		System.out.println("Estado Actual Final");
		ImprimeRecursiva(C);
		System.out.println("VACIA "+C.Vacia());
	}
	
	private void ImprimeRecursiva(ColaCir<Reporte> C) {
		if(C.Vacia())
			return;
		C.Retira();
		Reporte DrAux=C.Dr;
		ImprimeRecursiva(C);
		System.out.println(DrAux.NoComp+"\t"+DrAux.TotalPaginas+"\t"+DrAux.Paginas);
	}
	
	public static void main(String [] a) {
		new AplSpool();
	}
}
