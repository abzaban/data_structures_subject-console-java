
public class ExamenPunto2 {
	ArbolBinarioBusqueda<Integer> A;
	
	public static void main(String[] args) {
		new ExamenPunto2();
	}
	
	public ExamenPunto2() {
		A=new ArbolBinarioBusqueda<Integer>();
		for (int i = 0; i < 20; i++) {
			A.Inserta(Rutinas.nextInt(1, 50));
		}
		System.out.println(Comprobar(A.getRaiz()));
		NodoABB<Integer> Aux = A.getRaiz().getSubIzq();
		Aux.Info += A.getRaiz().Info;
		System.out.println(Comprobar(A.getRaiz()));
	}
	
	public boolean Comprobar(NodoABB<Integer> R) {
		if(R == null)
			return false;
		return Comprobar(R.getSubIzq(),R,true) && Comprobar(R.getSubDer(),R,false);
	}
	
	public boolean Comprobar(NodoABB<Integer> R,NodoABB<Integer>Padre,boolean Izquierda) {
		if(R == null)
			return true;
		String IdActual=R.Info.toString();
		String IdPadre=Padre.Info.toString();
		if(IdActual.compareTo(IdPadre) > 0 && Izquierda)//compara en la izquierda si los numeros actuales son mayores
			return false;
		if(IdActual.compareToIgnoreCase(IdPadre) < 0 && !Izquierda)//compara en la derecha si los numeros actuales son menores
			return false;
		return Comprobar(R.getSubIzq(),R,true) && Comprobar(R.getSubDer(),R,false);
	}
}
