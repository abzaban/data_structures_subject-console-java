
public class ColaCir <T> {
	
	private int Maximo,Frente,Fin;
	private T [] C;
	public T Dr;
	
	public ColaCir(){
		this(10);
	}
	
	public ColaCir(int TamaÒo){
		this.Maximo=TamaÒo;
		Frente=Fin=-1;
		C=(T[]) new Object[TamaÒo];
	}
	
	public boolean Inserta(T Dato){
		if(Llena())
			return false;
		if(Fin==Maximo-1)
			Fin=0;
		else
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
		C[Frente]=null;
		if(Frente==Fin){
			Frente=Fin=-1;
		}
		else {
			if(Frente==Maximo-1)
				Frente=0;
			else
				Frente++;
		}
		return true;
	}
	
	public boolean Llena(){
		return Frente==0 && Fin==Maximo-1 || Fin+1==Frente;
	}
	
	public boolean Vacia(){
		return Frente==-1;
	}
}