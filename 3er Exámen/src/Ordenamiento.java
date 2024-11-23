
public class Ordenamiento {
	
	public void OrdenInsercion( int [] V, int n) {
		int i, j, aux;
		for(i = 1; i < n ; i++) { //inicia considerando el elemento 0 ordenado
			j = i;  //para explorar los elementos v[j-1]..v[0] buscando la
			      //posición correcta del dato v[i]
			aux = V[i];
			while(j > 0 && aux < V[j-1]) { //desplaza el elemento hacia arriba una posición
				V[j] = V[j-1];
				j--;
			}
			V[j] = aux;
		}
	}
	
	public void Burbuja(int [] V) {
		int Sup, Temp, i; 
		boolean Band = true;
	    Sup = V.length;
	    while(Band) {
	    	Band = false;
	    	Sup--;
	    	for(i = 0 ; i < Sup ; i++) {
	    		if(V[i] > V[i+1]) {
	    			Temp = V[i];
	    			V[i] = V[i+1];
	    			V[i+1] = Temp;
	    			Band = true;
	    		}
	    	}
	    }
	}
}
