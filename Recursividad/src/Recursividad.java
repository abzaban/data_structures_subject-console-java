
public class Recursividad {
	static int Contador = 0;
	public static boolean Palindromo(String S) {
		if(S.length() <= 1)
			return true;
		if(S.charAt(0) != S.charAt(S.length() - 1))
			return false; 
		return Palindromo(S.substring(1, S.length() - 1));
	}
	
	public static void Hanoi(char Inicial,char Central,char Final,int N) { 
		if(N == 1) {
			Contador++;
			System.out.println(Contador + " Move disco "+N+" de la torre "+Inicial+" a la torre "+Final);
			return;
		}
		Hanoi(Inicial, Final, Central, N - 1);
		Contador++;
		System.out.println(Contador   +    " Move disco "+N+" de la torre "+Inicial+" a la torre "+Final);
		Hanoi(Central, Inicial, Final, N - 1);
	}
	
	public static void Directa(int N) {
		if(N < 1)
			return;
		System.out.println("N="+N);
		Directa(N - 1);
		System.out.println("...N= "+N );
	}
	
	public static void InDirectaA(int N) {
		System.out.println("N= DE LA A"+N);
		InDirectaB(N - 1);
		System.out.println("...N= "+N );
	}
	
	public static void InDirectaB(int N) {
		System.out.println("N DE LA B="+N);
		InDirectaA(N - 1);
		System.out.println("...N= "+N );
	}
	
	public static long Fact(int N) {
		if(N <= 0)
			return 1;
		return Fact(N - 1) * N;
	}
	
	public static long FactIte(int N) {
		long F=1;
		for(int i=1; i<=N;F*=i,i++);
		return F;
	}
	
	public static long Fibonacci(int N) {
		if(N<3)
			return 1;
		return Fibonacci(N-1)+Fibonacci(N-2);
	}
	
	public static double Eleva(int X, int Y){
		if(Y == 0)
			return 1;
		if(Y == 1)
			return X;
		return X * Eleva(X,Y-1);
	}
	
	public static double Eleva(long X, long Y) {
		if(Y == 0)
			return 1;
		if(Y == 1)
			return X;
		if(Y % 2 == 0)
			return Eleva(X * X, Y/2);
		return Eleva(X * X, Y/2) * X;
	}
	
	public static long SumaContenidoVector(int v[], int i) {		
		if(i == 0)
			return v[i];
		if(v.length == 0)
			return 0;
		return v[i] + SumaContenidoVector(v, i - 1);
	}
	
	public static int NumMayorVec(int [] v, int sub, int sub2, int mayor) {
		if(sub == v.length/2)
			return mayor;
		if(v[sub] >= v[sub2] && mayor == -1)
			mayor = v[sub];
		if(v[sub] < v[sub2] && mayor == -1)
			mayor = v[sub2];
		if(v[sub] > mayor)
			mayor = v[sub];
		if(v[sub2] > mayor)
			mayor = v[sub];
		return NumMayorVec(v, sub+1, sub2-1, mayor);
	}
		
	public static String ConvertidorBase(int N, int base) {
		if(N/base == 0)
			return String.valueOf(N%base);
		if(N % base > 9) {
			char a = 0;
			if (N%base == 10)
				a = 'A';
			if (N%base == 11)
				a = 'B';
			if (N%base == 12)
				a = 'C';
			if (N%base == 13)
				a = 'D';
			if (N%base == 14)
				a = 'E';
			if (N%base == 15)
				a = 'F';
			return ConvertidorBase(N/base, base)+""+a;
		}
		return ConvertidorBase(N/base, base)+""+N%base;
	}
	
	public static int SumaRenglonMatriz(int [][] m, int R, int Sub) {
		if(Sub == m[R].length - 1)
			return m[R][Sub];
		return m[R][Sub] + SumaRenglonMatriz(m, R, Sub+1);
	}
	
	public static long SumaElementosMatriz(int [][] m, int Sub) {
		if(Sub > m.length - 1)
			return 0;
		return SumaRenglonMatriz(m, Sub, 0) + SumaElementosMatriz(m, Sub+1);
	}
}
