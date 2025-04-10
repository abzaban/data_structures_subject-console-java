
public class ListaCircularDBL <T> {
	private NodoDBL<T> Frente;
	private NodoDBL<T> Fin;
	public  T          Dr;
	
	public ListaCircularDBL(){
		Frente=Fin=null;
		Dr=null;
	}
	public boolean InsertaFrente(T Dato){
		if(Dato==null)
			return false;
		NodoDBL<T> Nuevo;
		try {
		  Nuevo=new NodoDBL<T>(Dato);
		} catch(Exception e){return false;}
		if(Frente==null){
			Frente=Fin=Nuevo;
			Frente.setAnt(Fin);
			Fin.setSig(Frente);
			return true;
		}
		Nuevo.setSig(Frente);
		Frente.setAnt(Nuevo);
		Frente=Nuevo;
		Frente.setAnt(Fin);
		Fin.setSig(Frente);
		return true;
	}
	public boolean Retira(int Posicion){
		if(Posicion<1 || Posicion>Length())
			return false;
		NodoDBL<T> Aux=Frente;
		for(int i=1 ; i<Posicion ; i++)
			Aux=Aux.getSig();
		EliminaNodo(Aux);
		return true;
	}
	private void EliminaNodo(NodoDBL<T> Aux){
		Dr=Aux.Info;
		//˙nico nodo de la lista
		if(Frente==Fin){
			Frente=Fin=null;
			return;
		}
		// Primero de la lista
		if(Aux==Frente){
			Fin.setSig(Aux.getSig());
			Aux.getSig().setAnt(Fin);
			Frente=Frente.getSig();
			return;
		}
		// ˙ltimo de la lista
		if(Aux==Fin){
			Fin=Fin.getAnt();
			Fin.setSig(Frente);
			Frente.setAnt(Fin);
			return;
		}
		// entre dos nodos
		Aux.getAnt().setSig(Aux.getSig());
		Aux.getSig().setAnt(Aux.getAnt());
		
	}
	public int Length(){
		NodoDBL<T> Aux=Frente;
		int Cont=0;
		while(Aux!=null){
			Cont++;
			if(Aux.getSig()==Frente)
				break;
			Aux=Aux.getSig();
		}
		return Cont;
	}

}
