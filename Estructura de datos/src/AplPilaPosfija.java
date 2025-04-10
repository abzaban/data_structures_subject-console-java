import java.util.*;
public class AplPilaPosfija {
	private Pila<Integer> P;
	private Pila<Integer> PAux;
	String Expresion;
	private AplPilaPosfija(){
		P=new Pila<Integer>(20);
		PAux=new Pila<Integer>(20);
		Captura();
		Procesa();
	}
	private void Captura(){
		System.out.println("Proporciona expresiÛn aritmÈtica posfija");
		Expresion=new Scanner(System.in).nextLine();
	}
	private void Procesa(){
		char C;
		for(int i=0 ; i< Expresion.length(); i++){
			C=Expresion.charAt(i);
			if(C>='0' && C<='9'){
				if(P.Inserta(C-48 )){
					continue;
				}
				System.out.println("la expresiÛn no puede evaluarese, PILA LLENA");
				return;
			}
			
			int Base = 10;
			int Suma = 0;
			if(C == ' ' && P.Retira()) {
				Suma = P.Dr;
				while(P.Retira()) {
					Suma += P.Dr*Base;
					Base *= 10;
				}
				PAux.Inserta(Suma);
				continue;
			}
			
			if(C=='+' || C=='-' || C=='*' || C=='/'){
				if(!PAux.Retira()){
					System.out.println("LA EXPRESI”N ESTA INCORRECTA");
					return;
				}
				int D2=PAux.Dr;
				if(!PAux.Retira()){
					System.out.println("LA EXPRESION ESTA INCORRECTA");
					return;
				}
				int D1=PAux.Dr;
				int Res=0;
				switch (C){
				   case '+': Res=D1+D2;break;
				   case '-': Res=D1-D2;break;
				   case '*': Res=D1*D2;break;
				   case '/': Res=D1/D2;break;
				}
				PAux.Inserta(Res);
			}
		}
		PAux.Retira();
		if(!PAux.Vacia()){
			System.out.println("expresionn incorrecta");
			return;
		}
		System.out.println("Resultado = "+PAux.Dr);
	}
	public static void main(String[] args) {
		new AplPilaPosfija();
	}

}
