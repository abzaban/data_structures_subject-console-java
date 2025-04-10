
public class AplSegundoPunto {
	/*
	Alumno: Berrelleza Beltrán Abraham
	Materia: Estructura de Datos
	Hora: 12:00 - 13:00
	 */
	class Int {
		public int Numero;
		
		public Int(int N) {
			Numero = N;
		}
		
		public String toString() {
			return Rutinas.PonCeros(Numero, 3);
		}
	}
	
	private ArbolBinarioBusqueda<Int> Obj;
	
	public AplSegundoPunto() {
		Obj = new ArbolBinarioBusqueda<Int>();
		int TamA = Rutinas.nextInt(1, 50);
		for(int i = 0 ; i < TamA ; i++)
			Obj.Inserta(new Int(Rutinas.nextInt(100)));
		if(ValidaArbolBusqueda())
			System.out.println("SI es árbol de búsqueda");
		else
			System.out.println("NO es árbol de búsqueda");
		
		NodoABB<Int> Raiz = Obj.getRaiz();
		Raiz = Raiz.getSubIzq();
		while(Raiz != null) {
			if(Raiz.getSubDer() == null)
				break;
			Raiz = Raiz.getSubDer();
		}
		Raiz.Info.Numero = Obj.getRaiz().Info.Numero + 2;
		
		if(ValidaArbolBusqueda())
			System.out.println("SI es árbol de búsqueda");
		else
			System.out.println("NO es árbol de búsqueda");
	}
	
	public static void main(String [] a) {
		new AplSegundoPunto();
	}
	
	int i;
	public boolean ValidaArbolBusqueda() {
		if(Obj.getRaiz() == null)
			return false;
		Int [] V = new Int[Obj.Length()];
		i = 0;
		ValidaArbolBusqueda(Obj.getRaiz(), V);
		for(int i = 0 ; i < V.length ; i++) {
			if((i+1) < Obj.Length() && V[i].toString().compareTo(V[i+1].toString()) > 0)
				return false;
		}
		return true;
	}
	
	public void ValidaArbolBusqueda(NodoABB<Int> Raiz, Int [] V) {
		if(Raiz == null)
			return;
		ValidaArbolBusqueda(Raiz.getSubIzq(), V);
		V[i] = Raiz.Info;
		i++;
		ValidaArbolBusqueda(Raiz.getSubDer(), V);
	}
}
