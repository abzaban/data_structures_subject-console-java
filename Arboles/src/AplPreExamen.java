import java.util.*;

public class AplPreExamen {
	
	class Dato {
		int Edad;
		
		public Dato(int Edad) {
			this.Edad = Edad;
		}
		
		public String toString() {
			return Rutinas.PonCeros(Edad, 3);
		}
	}
	
	private ArbolBinarioBusqueda<Dato> Obj;
	private Scanner In;
	
	public AplPreExamen() {
		Obj = new ArbolBinarioBusqueda<Dato>();
		In = new Scanner(System.in);
		int Op;
		do {
			System.out.println("¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Ingresar personas");
			System.out.println("2. Imprime");
			System.out.println("3. Localiza primos");
			Op = In.nextInt();
			
			switch(Op) {
			case 0:
				break;
				
			case 1:
				InsertaPersona();
				break;
				
			case 2:
				Imprime();
				break;
				
			case 3:
				ImprimePrimos();
				break;
			}
			System.out.println();
		} while(Op != 0);
	}
	
	public void InsertaPersona() {
		int Edad = Rutinas.nextInt(1, 100);
		NodoABB<Dato> NR = Obj.BuscaNodo(Obj.getRaiz(), new Dato(Edad));
		while(NR != null) {
			Edad = Rutinas.nextInt(1, 100);
			NR = Obj.BuscaNodo(Obj.getRaiz(), new Dato(Edad));
		}
		Dato D = new Dato(Edad);
		Obj.Inserta(D);
	}
	
	public void Imprime() {
		if(Obj.getRaiz() == null) {
			System.out.println("No se han insertado personas");
			return;
		}
		Imprime(Obj.getRaiz());
	}
	
	public void Imprime(NodoABB<Dato> Raiz) {
		if(Raiz == null)
			return;
		Imprime(Raiz.getSubIzq());
		System.out.println("Edad: "+Raiz.Info.Edad);
		Imprime(Raiz.getSubDer());
	}
	
	int Nivel;
	NodoABB<Dato> Padre;
	boolean Band;
	public boolean ImprimePrimos() {
		System.out.println("Proporciona la edad de la persona:");
		int Edad = In.nextInt();
		Dato D = new Dato(Edad);
		NodoABB<Dato> N = Obj.BuscaNodo(Obj.getRaiz(), D);
		if(N == null) {
			System.out.println("No se encontró la persona");
			return false;
		}
		Nivel = 1;
		BuscaNivel(Obj.getRaiz(), N, Nivel);
		Padre = null;
		BuscaPadre(Obj.getRaiz(), N);
		if(Padre == null)
			return false;
		System.out.println(Nivel+" "+Padre.Info.Edad);
		Band = false;
		ImprimePrimos(Obj.getRaiz(), 1);
		if(!Band) {
			System.out.println(N.Info.Edad+" no tiene primos");
			return false;
		}
		return true;
	}
	
	public void ImprimePrimos(NodoABB<Dato> Raiz, int Nivel) {
		if(Raiz == null)
			return;
		ImprimePrimos(Raiz.getSubIzq(), Nivel+1);
		if(this.Nivel == Nivel && Padre.getSubDer() != Raiz && Padre.getSubIzq() != Raiz) {
			System.out.println("Primo: "+Raiz.Info.Edad);
			Band = true;
		}
		ImprimePrimos(Raiz.getSubDer(), Nivel+1);
	}
	
	public void BuscaPadre(NodoABB<Dato> Raiz, NodoABB<Dato> Hijo) {
		if(Raiz == null)
			return;
		BuscaPadre(Raiz.getSubIzq(), Hijo);
		if(Raiz.getSubDer() == Hijo || Raiz.getSubIzq() == Hijo) {
			Padre = Raiz;
			return;
		}
		BuscaPadre(Raiz.getSubDer(), Hijo);
	}
	
	public void BuscaNivel(NodoABB<Dato> Raiz, NodoABB<Dato> Hijo, int Nivel) {
		if(Raiz == null)
			return;
		BuscaNivel(Raiz.getSubIzq(), Hijo, Nivel+1);
		if(Raiz.Info.toString().compareTo(Hijo.Info.toString()) == 0) {
			this.Nivel = Nivel;
			return;
		}
		BuscaNivel(Raiz.getSubDer(), Hijo, Nivel+1);
	}
	
	public static void main(String [] a) {
		new AplPreExamen();
	}
}
