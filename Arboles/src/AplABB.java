import java.util.Scanner;


public class AplABB {
	static class Dato{
		public int Edad;
		public Dato(int Edad){
			this.Edad=Edad;
		} 
		public String toString(){
			return Rutinas.PonCeros(Edad, 5);
		}
	}
	public static void main(String [] a){
		ArbolBinarioBusqueda<Dato> Obj=new ArbolBinarioBusqueda<Dato>();
		int Valor;
		int [] V={500,300,800,250,200,180,400,600,900,450,
				700,1000,430,850,830,840,835};
		for(int i=0 ; i<V.length ; i++){
			Valor=Rutinas.nextInt(100,120);
			System.out.println(Valor+" "+Obj.Inserta( new Dato(V[i])));
		}
		System.out.println("INORDEN");
		Obj.InOrden(Obj.getRaiz());
		System.out.println("____preorden");
		Obj.PreOrden(Obj.getRaiz());
		System.out.println("____PostoRDEN");
		Obj.PostOrden(Obj.getRaiz());
		System.out.println("____NO RECURSIVO");		
	//	RecorridoPila(Obj.getRaiz());
		System.out.println("Total nodos en el ·rbol "+Obj.Length());
		
//		Dato Info=new Dato(0);
//		while(true){
//			System.out.println("altura arbol "+Obj.Altura());
//			System.out.println("Edad a borrar ");
//			Info.Edad=new Scanner(System.in).nextInt();
//			if(Info.Edad==0)
//				break;
//			System.out.println(Obj.RetiraRecursivo(Info)?" ELIMINO"+Obj.Dr:" NO ELIMINO");
//			System.out.println("INORDEN");
//			Obj.InOrden(Obj.getRaiz());
//			
//		}
		
		
		Dato Hijo=new Dato(500);
		Dato Padre=new Dato(300);
		
		NodoABB<Dato> Ap1=Obj.BuscaNodo(Obj.getRaiz(), Hijo);
		NodoABB<Dato> Ap2=Obj.BuscaNodo(Obj.getRaiz(), Padre);
System.out.println(Ap1+"\t"+Ap2);		
		if(Ap1==null || Ap2==null){
			System.out.println("no encontrÛ al o los nodos");
			return;
		}
		if(Ap1.getSubIzq()==Ap2 || Ap1.getSubDer()==Ap2){
			System.out.println("DESCENDIENTES DIRECTOS "+Hijo+" es padre de " + Padre);
			return;
		}
		if(Ap2.getSubIzq()==Ap1 || Ap2.getSubDer()==Ap1){
			System.out.println("DESCENDIENTES DIRECTOS "+Padre+" es padre de " + Hijo);
			return;
		}
		
		
		
		
	}
/*	public static void RecorridoPila(NodoABB<Dato> Raiz){
		Pila<NodoABB<Dato>> P=new Pila<NodoABB<Dato>>(200);
		
		while(Raiz!=null){
			System.out.println(Raiz.Info.Edad);
			if(Raiz.getSubDer()!=null)
				P.Inserta(Raiz.getSubDer());
			Raiz=Raiz.getSubIzq();
			if(Raiz==null){
				if(P.Vacia())
					break;
				P.Retira();
				Raiz=P.Dr;
			}
			
		}
	}*/
}