
public class AplDBL1 {
	static class Dato{
		public String Nombre;
		public int Edad;
		public Dato(String Nombre,int Edad){
			this.Nombre=Nombre;
			this.Edad=Edad;
		}
		public String toString(){
			return Rutinas.PonCeros(Edad, 3)+Rutinas.PonBlancos(Nombre, 50);
		}
	}
	public static void main(String [] a){
		ListaDBL<Dato> L=new ListaDBL<Dato>();
		Dato Persona;
		String Nombre;
		int Edad;
		for(int i=0 ; i<10 ; i++){
			Nombre=Rutinas.nextNombre(1, Rutinas.nextInt(1, 2));
			Edad=Rutinas.nextInt(1, 2);
			Persona=new Dato( Nombre,Edad   );
			L.InsertaFin(Persona);
		}
		Imprime(L,1);
		System.out.println("______________________");
		Imprime(L,2);
		
	}
	public static void Imprime(ListaDBL<Dato> L,int Sentido){
		NodoDBL<Dato> Aux=Sentido==1?L.getFrente():L.getFin();
		while(Aux != null){
			System.out.println(Aux.Info);
			Aux=Sentido==1?Aux.getSig():Aux.getAnt();
		}
	}
}
