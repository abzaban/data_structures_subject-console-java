
public class AplPila1 {
	public static void main(String [] a){
		Pila<Integer> P=new Pila<Integer>(10);
		Pila<Integer> PAux=new Pila<Integer>(10);
		Pila<Float>   PF=new Pila<Float>();
		Pila<Character> PC=new Pila<Character>(25);
		
//		System.out.println(P.Inserta(new Integer(56)));
//		System.out.println(P.Inserta(new Integer(560)));
//		System.out.println(P.Inserta(new Integer(5600)));
//		System.out.println(P.Inserta(new Integer(56000)));
//		System.out.println(P.Inserta(new Integer(560000)));
//		System.out.println(P.Inserta(new Integer(5600000)));
		int Valor=1;
		while (P.Inserta(new Integer(Valor*=10)));
		
		while (P.Retira() && PAux.Inserta(P.Dr))
		 System.out.println(P.Dr);
		 System.out.println("regresando a la original");
		 while(PAux.Retira() && P.Inserta(PAux.Dr))
			 System.out.println(PAux.Dr) ;
		
		 for(char i='@'; i<='Z' ; i++)
		    PC.Inserta(i);
		 while (PC.Retira())
			 System.out.println(PC.Dr);
	}
}
