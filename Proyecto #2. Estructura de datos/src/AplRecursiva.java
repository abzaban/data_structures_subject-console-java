import java.util.*;
public class AplRecursiva {
	public static void main(String [] args) {
		Scanner entrada = new Scanner(System.in);
		/*int [][] M = {{1,2,3,4,5,6,7,8,9,10}, {10,20,30}, {100,200}, {1000,2000,3000,4000,5000}, {5,10,15,20,25}};
		System.out.println("Proporcione el renglon del cual quiere obtener la suma de sus elementos: ");
		int R = entrada.nextInt();
		System.out.println("La suma del renglon "+R+" es = "+Recursividad.SumaRenglonMatriz(M, R, 0)+"\n");
		System.out.println("La suma total de los elementos de la matriz 7x3 es = "+Recursividad.SumaElementosMatriz(M, 0)+"\n");
		int [][] M2 = new int[5][5];
		System.out.println("La matriz 5x5 quedaria asi = ");
		System.out.println(Recursividad.AsignaValoresMatriz(M2, 0, 0)+"\n");*/
		System.out.println("Proporcione un numero: (maximo 12 cifras)");
		String N = entrada.next();
		System.out.println("El numero "+N+" de forma escrita quedaria asi = "+Recursividad.ConvertidorNumeroALetras(N));
	}
}
