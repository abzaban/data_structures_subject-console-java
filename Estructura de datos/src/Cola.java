
public class  Cola<T> {
	private int Maximo,Frente,Fin;
	private T [] C;
	public T Dr;
	
	public Cola(){
		this(10);
	}
	
	public Cola(int Maximo){
		this.Maximo=Maximo;
		Frente=Fin=-1;
		Dr=null;
		C= (T[]) new Object[Maximo];
	}
	
	public boolean Inserta(T Dato){
		if(Llena())
			return false;
		Fin++;
		C[Fin]=Dato;
		if(Frente==-1)
			Frente=0;
		return true;
	}
	
	public boolean Retira(){
		if(Vacia())
			return false;
		Dr=C[Frente];
		if(Frente==Fin)
			Frente=Fin=-1;
		else
			Frente++;
		
		return true;
	}
	
	public boolean Llena(){
		return Fin==Maximo-1;
	}
	
	public boolean Vacia(){
		return Frente==-1;
	}
}
