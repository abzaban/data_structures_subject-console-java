import java.util.*;

public class EjercicioUno {
	/*
	 * Alumno: Berrelleza Beltrán Abraham
	 * Materia: Estructura de datos
	 * Hora: 12:00 - 13:00
	 */
	class Dato {
		int Codigo;
		int CapacidadL;
		int LContiene;
		
		public Dato(int Codigo) {
			this.Codigo = Codigo;
		}
		
		public String toString() {
			return Rutinas.PonCeros(Codigo, 5);
		}
	}
	
	private ArbolBinarioBusqueda<Dato> Obj;
	private Scanner In;
	private int X;
	
	public EjercicioUno() {
		Obj = new ArbolBinarioBusqueda<Dato>();
		In = new Scanner(System.in);
		int Codigo;
		Dato D;
		for(int i = 0 ; i < 10 ; i++) {
			Codigo = Rutinas.nextInt(1, 1000);
			D = new Dato(Codigo);
			D.CapacidadL = Rutinas.nextInt(1, 100);
			D.LContiene = Rutinas.nextInt(1, D.CapacidadL);
			if(!Obj.Inserta(D))
				i--;
		}
		int N = 2;
		ImprimeTinaco(Obj.getRaiz(), 1, N);
		PasaLitros();
		N = X;
		ImprimeTinaco(Obj.getRaiz(), 1, N);
	}
	
	int NodosNivelX, i;
	public void PasaLitros() {
		System.out.println("Proporcione el nivel del cual desea pasar el agua al nivel 2:");
		X = In.nextInt();
		while(X <= 2) {
			System.out.println("Ingrese un nivel válido");
			X = In.nextInt();
		}
		NodosNivelX = 0;
		CuentaNodos(X, 1, Obj.getRaiz());
		if(NodosNivelX == 0) {
			System.out.println("No hay contenedores de agua en ese nivel");
			return;
		}
		int [] V = new int[NodosNivelX];
		System.out.println(V.length);
		i = 0;
		AlmacenaAgua(V, X, 1, Obj.getRaiz());
		i = 0;
		while(AunQuedaAgua(V)) {
			if(i == V.length)
				return;
			PasaLitros(Obj.getRaiz(), 1, V);
		}
	}
	
	public boolean AunQuedaAgua(int [] V) {
		int Suma = 0;
		for(int i = 0 ; i < V.length ; i++)
			Suma += V[i];
		if(Suma > 0)
			return true;
		return false;
	}
	
	public void PasaLitros(NodoABB<Dato> Raiz, int Nivel, int [] V) {
		if(Raiz == null)
			return;
		if(Nivel == 2) {
			if(i > V.length - 1)
				return;
			Raiz.Info.LContiene = Raiz.Info.LContiene + V[i];
			i++;
		}
		PasaLitros(Raiz.getSubIzq(), Nivel+1, V);
		PasaLitros(Raiz.getSubDer(), Nivel+1, V);
		
	}
	
	public void CuentaNodos(int X, int Nivel, NodoABB<Dato> Raiz) {
		if(Raiz == null)
			return;
		CuentaNodos(X, Nivel+1, Raiz.getSubIzq());
		if(X == Nivel)
			NodosNivelX++;
		CuentaNodos(X, Nivel+1, Raiz.getSubDer());
	}
	
	public void AlmacenaAgua(int [] V, int X, int Nivel, NodoABB<Dato> Raiz) {
		if(Raiz == null)
			return;
		AlmacenaAgua(V, X, Nivel+1, Raiz.getSubIzq());
		if(X == Nivel) {
			V[i] = Raiz.Info.LContiene;
			Raiz.Info.LContiene = 0;
			i++;
		}
		AlmacenaAgua(V, X, Nivel+1, Raiz.getSubDer());
	}
	
	public void ImprimeTinaco(NodoABB<Dato> Raiz, int Nivel, int X) {
		if(Raiz == null)
			return;
		ImprimeTinaco(Raiz.getSubIzq(), Nivel+1, X);
		if(Nivel == X)
			System.out.println("NIVEL "+X+" ----> Código: "+Raiz.Info.Codigo+"\tCapacidad: "+Raiz.Info.CapacidadL+"\tLitros que contiene: "+Raiz.Info.LContiene);
		else
			System.out.println("Código: "+Raiz.Info.Codigo+"\tCapacidad: "+Raiz.Info.CapacidadL+"\tLitros que contiene: "+Raiz.Info.LContiene);
		ImprimeTinaco(Raiz.getSubDer(), Nivel+1, X);
	}
	
	public static void main(String [] a) {
		new EjercicioUno();
	}
}
