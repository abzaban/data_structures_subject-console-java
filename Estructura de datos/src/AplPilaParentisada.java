import java.util.*;
public class AplPilaParentisada {
	String Texto;
	public AplPilaParentisada(){
		Leer();
		if(Procesa())
			System.out.println("EXPRESION CORRECTAMENTE PARENTISADA");
		else
			System.out.println("expresion incorrectamente parentisada");
	}
	public void Leer(){
		Scanner In=new Scanner(System.in);
		System.out.println("Proporcione expresiÛn parentisada ");
		Texto=In.nextLine();
	}
	public boolean Procesa(){
		Pila<Character> P=new Pila<Character>(20);
		char C;
		for(int i=0 ; i<Texto.length() ; i++){
			C=Texto.charAt(i);
			if(  C=='(' || C=='[' || C=='{' || C=='<' ){
				if(P.Inserta(C))
					continue;
				System.out.println("la expresiÛn o puede ser evaluada, tamaÒo pila insuficiente");
				return false;
			}
			if(  C==')' || C==']' || C=='}' || C=='>' ){
				if( ! P.Retira()){
					System.out.println("Existe un "+C+" SIN QUE HAYA PARESTESIS ABIERTO");
					return false;
				}
				if(C==')' && P.Dr =='('  ||
				   C=='}' && P.Dr =='{'  ||
				   C==']' && P.Dr =='['  ||
				   C=='>' && P.Dr =='<'     ){
					continue;
				}
				System.out.println(P.Dr+" se esta cerrando con parentesis incorrecto "+C);
				return false;
			}
		}
		if(!P.Vacia()){
			System.out.println("parentÈsis pendiente de cerrar");
			return false;
		}
		return true;
	}
	public static void main(String [] a){
		new AplPilaParentisada();
	}
}
