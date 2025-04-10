
public class AplRecursiva {
	public static void main(String [] args) {
		int [] V={100,200,300,400,500,600,700,800,900,1000};
		System.out.println("Inicia hilo del main");
	//	Recursividad.Directa(9);
		//Recursividad.InDirectaA(100);
		System.out.println("Finaliza main");
		for(int i=5;i<0 ; i++){
			System.out.println("Fact  "+i+"= "+Recursividad.Fact(i));
			System.out.println("Fact "+i+"= "+Recursividad.FactIte(i));
		}
		System.out.println("serie de fibonacci\nNoSerie\tValor");
		for(int i=40;i<0;i++)
			System.out.println(i+" \t"+Recursividad.Fibonacci(i));
		for(long i=0 ; i<0 ; i++)
		System.out.println("2 a la"+i+" =" +Recursividad.Eleva(2,i));
		
	//	Recursividad.Hanoi('A','B','C',21);
		
		System.out.println("el 1234554321, es palÌndromo ? "+Recursividad.Palindromo("1234554321"));
		System.out.println("el rotor, es palÌndromo ? "+Recursividad.Palindromo("rotor"));
		System.out.println("el rotar, es palÌndromo ? "+Recursividad.Palindromo("rotar"));
	}
}
