
public class Recursividad {
	// Método que suma los valores de un renglón de una matriz en específico
	public static int SumaRenglonMatriz(int [][] m, int R, int Sub) {
		if(Sub == m[R].length - 1)
			return m[R][Sub];
		return m[R][Sub] + SumaRenglonMatriz(m, R, Sub+1);
	}
	
	// Método que suma todos los elementos de una matriz
	public static long SumaElementosMatriz(int [][] m, int Sub) {
		if(Sub > m.length - 1)
			return 0;
		return SumaRenglonMatriz(m, Sub, 0) + SumaElementosMatriz(m, Sub+1);
	}
	
	// Método que imprime una matriz con números específicos
	public static int AsignaValoresMatriz(int [][] m, int SubR, int SubC) {
		if(SubR == m.length) {
			SubR = 0;
			SubC++;
		}
		if(SubC == m.length) {
			for(int i = 0 ; i < m.length ; i++) {
				for(int j = 0 ; j < m.length ; j++)
					System.out.print(m[i][j]+" ");
				System.out.println();
			}
			System.out.println();
			return 1;
		}
		if(SubR == SubC)
			m[SubC][SubR] = 1;
		if(SubR + SubC == m.length - 1 && (SubR - SubC < 0 || SubR - SubC > 0))
			m[SubC][SubR] = 2;
		if(SubC + SubR < m.length - 1 && SubC - SubR > 0)
			m[SubC][SubR] = 3;
		if(SubC + SubR < m.length - 1 && SubC - SubR < 0)
			m[SubC][SubR] = 4;
		if(SubC + SubR > m.length - 1 && SubC - SubR < 0)
			m[SubC][SubR] = 5;
		if(SubC + SubR > m.length - 1 && SubC - SubR > 0)
			m[SubC][SubR] = 6;
		return AsignaValoresMatriz(m, SubR+1, SubC);
	}
	
	static String [] U = {"Uno","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez", "Once","Doce","Trece","Catorce","Quince","Dieciseis","Diecisiete","Dieciocho","Diecinueve","Veinte", "Veintiuno","Veintidos","Veintitres","Veinticuatro","Veinticinco","Veintiseis","Ventisiete","Veintiocho","Veintinueve"};
	static String [] D = {"Treinta","Cuarenta","Cincuenta","Sesenta","Setenta","Ochenta","Noventa"};
	static String [] C = {"Cien","Doscientos","Trescientos","Cuatrocientos","Quinientos","Seiscientos","Setecientos","Ochocientos","Novecientos"};
	
	// Método que regresa un número convertido en su forma textual
	public static String ConvertidorNumeroALetras(String N) {
		String UnidadCompleta = "";
		int Num;
		if(N.length() == 0)
			return "";
		if(N.length() % 3 != 0) {
			N = "0"+N;
			return ConvertidorNumeroALetras(N);
		}
		Num = Integer.parseInt(N.substring(0, 1));
		if(Num > 0)
			UnidadCompleta = C[Num - 1];
		Num = Integer.parseInt(N.substring(0, 3));
		if(Num > 100 && Num <= 199)
			UnidadCompleta = UnidadCompleta+"to";
		Num = Integer.parseInt(N.substring(1, 3));
		if(Num <= 29 && Num > 0)
			UnidadCompleta = UnidadCompleta+" "+U[Num - 1];
		else {
			Num = Integer.parseInt(N.substring(1, 2));
			if(Num > 0)
				UnidadCompleta = UnidadCompleta+" "+D[Num - 3];
			Num = Integer.parseInt((N.substring(2, 3)));
			if(Num > 0)
				UnidadCompleta = UnidadCompleta+" y "+U[Num - 1];
		}
		Num = Integer.parseInt(N.substring(0, 3));
		if(N.length() / 3 == 2 && Num > 0 || N.length() / 3 == 4 && Num > 0) {
			if(Num == 1) {
				UnidadCompleta = "Mil ";
				return UnidadCompleta+""+ConvertidorNumeroALetras(N.substring(3, N.length()));
			}
			UnidadCompleta = UnidadCompleta+" Mil ";
		}
		if(N.length() / 3 == 3 && Num > 0) {
			if(Num == 1) {
				UnidadCompleta = "Un Millon ";
				return UnidadCompleta+""+ConvertidorNumeroALetras(N.substring(3, N.length()));
			}
			UnidadCompleta = UnidadCompleta+" Millones ";
		}
		return UnidadCompleta+""+ConvertidorNumeroALetras(N.substring(3, N.length()));
	}	
}
