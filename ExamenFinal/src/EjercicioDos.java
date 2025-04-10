
public class EjercicioDos {
	/*
	 * Alumno: Berrelleza Beltrán Abraham
	 * Materia: Estructura de datos
	 * Hora: 12:00 - 13:00
	 */
	private ArbolBinarioBusqueda<Integer> Obj;
	
	public EjercicioDos() {
		Obj = new ArbolBinarioBusqueda<Integer>();
		int Num;
		for(int i = 0 ; i < 5 ; i++) {
			Num = Rutinas.nextInt(1,100);
			System.out.println(Num);
			Obj.Inserta(Num);
		}
		AlturaLado();
		System.out.println(AltoDer+" "+AltoIzq+" "+Alto);
		if(AltoDer == AltoIzq)
			System.out.println("Ambos subarboles tienen la altura");
		if(AltoDer > AltoIzq)
			System.out.println("La altura está del lado derecho");
		if(AltoIzq > AltoDer)
			System.out.println("La altura está del lado izquierdo");
	}
	
	int Alto, AltoDer, AltoIzq;
	public void AlturaLado() {
		if(Obj.getRaiz() == null)
			return;
		Alto = AltoDer = AltoIzq = 0;
		AlturaLado(Obj.getRaiz(), 1);
	}
	
	private void AlturaLado(NodoABB<Integer> Raiz, int Nivel) {
		if(Raiz == null)
			return;
		AlturaLado(Raiz.getSubIzq(), Nivel+1);
		if(Nivel >= Alto && Raiz.Info > Obj.getRaiz().Info)
			AltoDer = Nivel;
		if(Nivel >= Alto && Raiz.Info < Obj.getRaiz().Info)
			AltoIzq = Nivel;
		if(Nivel > Alto)
			Alto = Nivel;
		AlturaLado(Raiz.getSubDer(), Nivel+1);
	}
	
	public static void main(String [] a) {
		new EjercicioDos();
	}
}
