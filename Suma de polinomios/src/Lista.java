
public class Lista<T> {
	private Nodo<T> Frente;
	private Nodo<T> Fin;
	public T Dr;
	
	public Lista() {
		Frente = Fin = null;
		Dr = null;
	}
	
	public boolean InsertaFrente(T Dato) {
		if(Dato == null)
			return false;
		Nodo<T> Nuevo;
		try {
			Nuevo = new Nodo<T>(Dato);
		} catch(Exception e){return false;}
		if(Frente == null)
			Frente = Fin = Nuevo;
		else {
			Nuevo.setSig(Frente);
			Frente = Nuevo;
		}
		return true;
	}
	
	public boolean InsertaFin(T Dato) {
		if(Dato == null)
			return false;
		Nodo<T> Nuevo;
		try {
			Nuevo = new Nodo<T>(Dato);
		} catch(Exception e){return false;}
		if(Frente == null)
			Frente = Fin = Nuevo;
		else {
			Fin.setSig(Nuevo);
			Fin = Nuevo;
		}
		return true;
	}
	
	public boolean InsertaOrdenado(T Dato) {
		if(Dato == null)
			return false;
		Nodo<T> Nuevo;
		try {
			Nuevo = new Nodo<T>(Dato);
		} catch(Exception e){return false;}
		// Primer elemento
		if(Frente == null) {
			Frente = Fin = Nuevo;
			return true;
		}
		// Al inicio
		if(Nuevo.Info.toString().compareTo(Frente.Info.toString()) <= 0) {
			Nuevo.setSig(Frente);
			Frente = Nuevo;
			return true;
		}
		// Al final
		if(Nuevo.Info.toString().compareTo(Fin.Info.toString()) >= 0) {
			Fin.setSig(Nuevo);
			Fin = Nuevo;
			Fin.setSig(null);
			return true;
		}
		// Entre dos nodos
		Nodo<T> Aux = Frente;
		Nodo<T> Ant = null;
		while(Aux != null) {
			if(Nuevo.Info.toString().compareTo(Aux.Info.toString()) <= 0)
				break;
			Ant = Aux;
			Aux = Aux.getSig();
		}
		Nuevo.setSig(Aux);
		Ant.setSig(Nuevo);
		return true;
	}
	
	public int Length() {
		Nodo<T> Aux = Frente;
		int Cont = 0;
		while(Aux != null) {
			Cont++;
			Aux = Aux.getSig();
		}
		return Cont;
	}
	
	public boolean Retira(int Posicion) {
		if(Posicion > Length())
			return false;
		Nodo<T> Aux = Frente;
		Nodo<T> Ant = null;
		for(int i = 1 ; i < Posicion ; i++) {
			Ant = Aux;
			Aux = Aux.getSig();
		}
		EliminaNodo(Aux, Ant);
		return true;
	}
	
	public boolean Retira(T Dato) {
		Nodo<T> Aux = Frente;
		Nodo<T> Ant = null;
		String IdActual;
		while(Aux != null) {
			IdActual = Aux.Info.toString();
			if(IdActual.compareTo(Dato.toString()) == 0)
				break;
			Ant = Aux;
			Aux = Aux.getSig();
		}
		if(Aux == null)
			return false;
		EliminaNodo(Aux, Ant);
		return true;
	}
	
	private void EliminaNodo(Nodo<T> Aux, Nodo<T> Ant) {
		Dr = Aux.Info;
		// Único nodo de la lista
		if(Frente == Fin) {
			Frente = Fin = null;
			return;
		}
		// Primero de la lista
		if(Aux == Frente) {
			Frente = Frente.getSig();
			return;
		}
		// Último de la lista
		if(Aux == Fin) {
			Ant.setSig(null);
			Fin = Ant;
			return;
		}
		// Entre dos nodos
		Ant.setSig(Aux.getSig());
	}
	
	public void setFrente(Nodo<T> Ap) {
		Frente = Ap;
	}
	
	public void setFin(Nodo<T> Ap) {
		Fin = Ap;
	}
	
	public Nodo<T> getFrente() {
		return Frente;
	}
	
	public Nodo<T> getFin() {
		return Fin;
	}
}
