import java.util.*;

import javax.management.StringValueExp;
public class AplPilaInfijaAPosfija {
	private Pila<Character> P;
	private Scanner entrada;
	private String Infija;

	private AplPilaInfijaAPosfija() {
		entrada = new Scanner(System.in);
		P = new Pila<Character>(20);
		Lectura();
		Procesa();
	}

	private void Lectura() {
		System.out.println("Proporciona una expresión infija:");
		Infija = entrada.next();
	}

	private void Procesa() {
		char Simbolo;
		String ExpPos = "";
		while(Infija.length() != 0) {
			Simbolo = Infija.charAt(0);
			if(Simbolo == '(')
				P.Inserta(Simbolo);
			else
				if(Simbolo == ')')
					while(P.Retira() && P.Dr != '(')
						ExpPos += String.valueOf(P.Dr);
				else
					if(Simbolo > '0' && Simbolo < '9')
						ExpPos += String.valueOf(Simbolo);
					else {
						while(P.Retira() && P.Dr != '(') {
							if(P.Dr == '*' && Simbolo == '/' || P.Dr == '/' && Simbolo == '*' ||
							   P.Dr == '*' && Simbolo == '+' || P.Dr == '*' && Simbolo == '-' ||
							   P.Dr == '/' && Simbolo == '+' || P.Dr == '/' && Simbolo == '-' ||
							   P.Dr == '+' && Simbolo == '-' || P.Dr == '-' && Simbolo == '+' || 
							   P.Dr == Simbolo)
								ExpPos += P.Dr;
						}
						P.Inserta(Simbolo);
					}
			Infija = Infija.substring(1, Infija.length());
		}
		while(P.Retira())
			ExpPos += P.Dr;
		System.out.println(ExpPos);
	}

	public static void main(String [] args) {
		new AplPilaInfijaAPosfija();
	}
}
