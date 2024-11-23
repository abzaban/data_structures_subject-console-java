import java.util.*;
public class AplSumaPolinomio {
	private Scanner Entrada;
	private Lista<Polinomio> LPol1;
	private Lista<Polinomio> LPol2;
	private Lista<Polinomio> LSuma;
	
	class Polinomio {
		int Exponente;
		int Cociente;
		
		public Polinomio(int Cociente, int Exponente) {
			this.Cociente = Cociente;
			this.Exponente = Exponente;
		}
		
		public String toString() {
			return Rutinas.PonCeros(Exponente, 10);
		}
	}
	
	public AplSumaPolinomio() {
		Entrada = new Scanner(System.in);
		LPol1 = new Lista<Polinomio>();
		LPol2 = new Lista<Polinomio>();
		LSuma = new Lista<Polinomio>();
		Lectura(LPol1);
		Lectura(LPol2);
		Procesa();
	}
	
	public void Procesa() {
		Nodo<Polinomio> Aux = LPol1.getFrente();
	}
	
	public void Lectura(Lista<Polinomio> L) {
		int Cociente, Exponente;
		System.out.println("1er Polinomio");
		while(true) {
			System.out.println("Ingresa el cociente: (0 para terminar)");
			Cociente = Entrada.nextInt();
			if(Cociente == 0)
				break;
			System.out.println("Ingresa el exponente:");
			Exponente = Entrada.nextInt();
			L.InsertaOrdenado(new Polinomio(Cociente, Exponente));
		}
	}
	
	public void SumaPolinomios(Lista<Polinomio> L) {
		Lista<Polinomio> LAux = new Lista<Polinomio>();
		for(Nodo<Polinomio> Aux = L.getFrente() ; Aux != null ; Aux = Aux.getSig()) {
			Nodo<Polinomio> AuxNuevo = LAux.getFrente();
			while(AuxNuevo != null) {
				if(AuxNuevo.Info.Exponente == Aux.Info.Exponente) {
					AuxNuevo.Info.Cociente += Aux.Info.Cociente;
					break;
				}
				AuxNuevo = AuxNuevo.getSig();
			}
			if(AuxNuevo == null)
				LAux.InsertaOrdenado(new Polinomio(Aux.Info.Cociente, Aux.Info.Exponente));
		}
	}
	
	public void ImprimePolinomio(Lista<Polinomio> L) {
		
	}
	
	public static void main(String [] a) {
		new AplSumaPolinomio();
	}
}
