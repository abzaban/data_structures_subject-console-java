
public class AplSerpYEsc {
	ListaDBL<Casilla> LC;
	ListaDBL<Jugador> LJ;
	
	class Jugador {
		public int NoJugador;
		public NodoDBL<Casilla> Casilla;
		
		public Jugador(int NoJugador) {
			this.NoJugador = NoJugador;
			Casilla = null;
		}
	}
	
	class Casilla {
		public int NoCasilla;
		public char TipoCasilla;
		public int Posiciones;
		
		public Casilla(int NoCasilla) {
			this.NoCasilla = NoCasilla;
			TipoCasilla = 'N';
			Posiciones = 0;
		}
	}
	
	public AplSerpYEsc() {
		LC = new ListaDBL<Casilla>();
		LJ = new ListaDBL<Jugador>();
		LlenaCasillas();
		CreaEsc();
		CreaSerp();
		NodoDBL<Casilla> AuxC = LC.getFrente();
		System.out.println("\tTABLERO");
		while(AuxC != null) {
			System.out.println(AuxC.Info.NoCasilla+"\t"+AuxC.Info.TipoCasilla+"\t"+AuxC.Info.Posiciones);
			AuxC = AuxC.getSig();
		}
		System.out.println();
		Jugadores();
		Juega();
	}
	
	public void LlenaCasillas() {
		Casilla C;
		for(int i = 1 ; i <= 100 ; i++) {
			C = new Casilla(i);
			LC.InsertaFin(C);
		}
	}
	
	public void CreaEsc() {
		int NvoNodoE, Posicion = 0, Contador = 0;
		while(Contador < 5) {
			NvoNodoE = Rutinas.nextInt(15, 70);
			NodoDBL<Casilla> Aux = LC.getFrente();
			while(Aux != null) {
				if(Aux.Info.NoCasilla == NvoNodoE)
					break;
				Aux = Aux.getSig();
			}
			if(Aux.Info.TipoCasilla != 'N')
				continue;
			Posicion = Rutinas.nextInt(5, 20);
			while(!NodoValidoEsc(Posicion, Aux))
				Posicion = Rutinas.nextInt(5, 20);
			Aux.Info.TipoCasilla = 'E';
			Aux.Info.Posiciones = Posicion;
			Contador++;
		}
	}
	
	public void CreaSerp() {
		int NvoNodoE, Posicion = 0, Contador = 0;
		while(Contador < 5) {
			NvoNodoE = Rutinas.nextInt(30, 95);
			NodoDBL<Casilla> Aux = LC.getFrente();
			while(Aux != null) {
				if(Aux.Info.NoCasilla == NvoNodoE)
					break;
				Aux = Aux.getSig();
			}
			if(Aux.Info.TipoCasilla != 'N')
				continue;
			Posicion = Rutinas.nextInt(5, 20);
			while(!NodoValidoSerp(Posicion, Aux))
				Posicion = Rutinas.nextInt(5, 20);
			Aux.Info.TipoCasilla = 'S';
			Aux.Info.Posiciones = Posicion;
			Contador++;
		}
	}
	
	public void Jugadores() {
		int CantJug = Rutinas.nextInt(2, 10);
		Jugador J;
		for(int i = 1 ; i <= CantJug ; i++) {
			J = new Jugador(i);
			LJ.InsertaFin(J);
		}
	}
	
	public void Juega() {
		NodoDBL<Jugador> AuxJ = LJ.getFrente();
		NodoDBL<Casilla> AuxC, CasillaInicial, CasillaDado;
		int Dados, Extra, ContadorPasa100, DadosReal;
		while(true) {
			CasillaInicial = AuxC = AuxJ.Info.Casilla;
			DadosReal = ContadorPasa100 = Dados = Rutinas.nextInt(2, 12);
			if(CasillaInicial == null) {
				CasillaInicial = new NodoDBL<Casilla>(new Casilla(0));
				AuxC = LC.getFrente();
				Dados--;
			}
			for(int i = 0 ; i < Dados ; i++) {
				if(AuxC == null)
					break;
				ContadorPasa100--;
				AuxC = AuxC.getSig();
			}
			if(AuxC == null) {
				ContadorPasa100++;
				AuxC = LC.getFin();
				for(int i = 0 ; i < ContadorPasa100 ; i++)
					AuxC = AuxC.getAnt();
			}
			CasillaDado = AuxC;
			if(AuxC.Info.TipoCasilla == 'E') {
				Extra = AuxC.Info.Posiciones;
				for(int i = 0 ; i < Extra ; i++)
					AuxC = AuxC.getSig();
			}
			if(AuxC.Info.TipoCasilla == 'S') {
				Extra = AuxC.Info.Posiciones;
				for(int i = 0 ; i < Extra ; i++)
					AuxC = AuxC.getAnt();
			}
			AuxJ.Info.Casilla = AuxC;
			System.out.println("Jugador No. "+AuxJ.Info.NoJugador+"\tSacó "+DadosReal+" puntos"+"\tInició en "+CasillaInicial.Info.NoCasilla+"\tCayó en "+CasillaDado.Info.TipoCasilla+"\tFinalizó en "+AuxJ.Info.Casilla.Info.NoCasilla+(CasillaDado.Info.TipoCasilla == 'S' ? "\tRetrocedió "+CasillaDado.Info.Posiciones+" puntos extra" : CasillaDado.Info.TipoCasilla == 'E' ? "\tAvanzó "+CasillaDado.Info.Posiciones+" puntos extra" : ""));
			if(AuxJ.Info.Casilla == LC.getFin())
				break;
			AuxJ = AuxJ.getSig();
			if(AuxJ == null)
				AuxJ = LJ.getFrente();
		}
		System.out.println("El jugador ganador es el No. "+AuxJ.Info.NoJugador);
	}

	private boolean NodoValidoEsc(int Posicion, NodoDBL<Casilla> Aux) {
		for(int i = 0 ; i < Posicion ; Aux = Aux.getSig(), i++);
		if(Aux.Info.TipoCasilla != 'N')
			return false;
		Aux.Info.TipoCasilla = 'T';
		return true;
	}
	
	private boolean NodoValidoSerp(int Posicion, NodoDBL<Casilla> Aux) {
		for(int i = 0 ; i < Posicion ; Aux = Aux.getAnt(), i++);
		if(Aux.Info.TipoCasilla != 'N')
			return false;
		Aux.Info.TipoCasilla = 'T';
		return true;
	}
	
	public static void main(String [] a) {
		new AplSerpYEsc();
	}
}
