
public class Busqueda {
	
	public int Binaria(int [] V, int Clave) {
		int Inf = 0, Mitad, Sup = V.length-1;
		while(Inf <= Sup) {
			Mitad = (Inf+Sup)/2;
			if(Clave == V[Mitad])
				return Mitad;
			else
				if(Clave > V[Mitad])
					Inf = Mitad+1;
				else
					Sup = Mitad - 1;
		}
		return -1;
	}
	
	public int Secuencial(int [] V, int Clave) {  
		int i = V.length - 1;
		while (i >= 0 && V[i] != Clave)
			i--;
		return i;
	}
}
