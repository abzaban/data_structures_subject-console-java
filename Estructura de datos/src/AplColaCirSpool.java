
public class AplColaCirSpool {
	private int Ele;
	class Reporte {
		public int NoComp, TotalPaginas, Paginas;
		public Reporte(int NoComp, int TotalPaginas, int Paginas){
			this.NoComp = NoComp;
			this.TotalPaginas = TotalPaginas;
			this.Paginas = Paginas;
		}
	}
	
	public AplColaCirSpool() {
		Ele = 30;
		ColaCir<Reporte> C = new ColaCir<Reporte>(Ele);
		ColaCir<Reporte> CAux = new ColaCir<Reporte>(Ele);

		int Ac = Rutinas.nextInt(10, 20);
		System.out.println(Ac);
		int Accion, Total;
		for(int i = 0 ; i < Ac ; i++){
			Accion=Rutinas.nextInt(3) + 1;
			switch(Accion) {
			case 1: //enviar reporte al spool
				int TotalPaginas=Rutinas.nextInt(1, 150);
				int EleNecesita=TotalPaginas/50;
				if(TotalPaginas%50 > 0)
					EleNecesita++;
				if(EleNecesita > Ele) {
					System.out.println("Reporte no fue enviado al spool");
					i--;
					continue;
				}
				Reporte Rep;
				int Comp=Rutinas.nextInt(1, 5);
				for(int j=0 ; j<TotalPaginas/50 ; j++) {
					Rep=new Reporte(Comp,TotalPaginas,50);
					C.Inserta(Rep);
					Ele--;
				}
				if(TotalPaginas%50 >0) {
					Rep=new Reporte(Comp,TotalPaginas,TotalPaginas%50);
					C.Inserta(Rep);
					Ele--;
				}
				System.out.println("reporte insertado");
				break;
			case 2: // Imprimir reporte desde el spool
				if(C.Vacia()) {
					i--;
					continue;
				}
				Total=0;
				while(C.Retira()) {
					Total+=C.Dr.Paginas;
					if(Total==C.Dr.TotalPaginas) {
						System.out.println("Impreso "+C.Dr.NoComp+"\t"+C.Dr.TotalPaginas+"\t"+Total);
						break;
					}
				}
				break;
			case 3: // estado actual del spool
				System.out.println("estado actual");
				Total=0;
				while (!C.Vacia()) {
					Total=0;
					while(C.Retira()) {
						CAux.Inserta(C.Dr);

						Total+=C.Dr.Paginas;
						if(Total==C.Dr.TotalPaginas) {
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
		System.out.println("estado actual final");
		ImprimeRecursiva(C);
		System.out.println("VACIA "+C.Vacia());
	}
	
	private int Imprimir(ColaCir<Reporte> C) {
		return 0;
	}
	
	private void ImprimeRecursiva(ColaCir<Reporte> C) {
		if(C.Vacia())
			return;
		C.Retira();
		Reporte DrAux=C.Dr;
		ImprimeRecursiva(C);
		System.out.println(DrAux.NoComp+"\t"+DrAux.TotalPaginas+"\t"+DrAux.Paginas);
	}
	
	public static void main(String[] args) {
		new AplColaCirSpool();
	}
}
