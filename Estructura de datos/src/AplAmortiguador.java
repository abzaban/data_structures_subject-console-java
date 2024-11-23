import java.util.*;
public class AplAmortiguador {
	private Scanner entrada;
	private Random R;
	private Pila<Disco> P;
	private Pila<Disco> PAux;
	static int Consecutivo = 0;
	
	class Disco {
		int VidaUtil;
		int NoDisco;
		
		public Disco(int VidaUtil) {
			this.VidaUtil = VidaUtil;
			Consecutivo++;
			NoDisco = Consecutivo;
		}
		
		public String toString() {
			return "Disco: "+NoDisco+"\tVida util: "+VidaUtil;
		}
	}
	
	private AplAmortiguador() {
		R = new Random();
		int N = R.nextInt(35) + 15;
		P = new Pila<Disco>(N);
		PAux = new Pila<Disco>(N);
		entrada = new Scanner(System.in);
		Procesa();
	}
	
	public void Procesa() {
		Disco ExtremoA, ExtremoB;
		int Contador, K = 0, Mitad;
		while(P.Inserta(new Disco(R.nextInt(5) + 95)));
		while(true) {
			Contador = 0;
			Mitad = 0;
			while(P.Retira() && PAux.Inserta(P.Dr))
				Mitad++;
			while(PAux.Retira() && P.Inserta(PAux.Dr));
			P.Retira();
			ExtremoA = P.Dr;
			while(P.Retira() && PAux.Inserta(P.Dr));
			ExtremoB = P.Dr;
			PAux.Retira();
			ExtremoA.VidaUtil = ExtremoA.VidaUtil - (R.nextInt(2) + 1);
			ExtremoB.VidaUtil = ExtremoB.VidaUtil - (R.nextInt(2) + 1);
			for(int i = 0 ; i < Mitad/2 ; PAux.Retira(), P.Inserta(PAux.Dr), i++);
			if(ExtremoB.VidaUtil >= 30)
				P.Inserta(ExtremoB);
			if(ExtremoA.VidaUtil >= 30)
				P.Inserta(ExtremoA);
			while(PAux.Retira() && P.Inserta(PAux.Dr));
			while(P.Retira() && PAux.Inserta(P.Dr))
				Contador++;
			while(PAux.Retira() && P.Inserta(PAux.Dr));
			K++;
			System.out.println("Bache "+K+"\tDisco usados "+ExtremoA.NoDisco+" "+ExtremoB.NoDisco+"\tVida Util Restante "+ExtremoA.VidaUtil+" "+ExtremoB.VidaUtil);
			if(Contador == 4) {
				while(P.Retira())
					System.out.println("Discos disponibles"+"\t"+P.Dr.toString());
				return;
			}
		}
	}
	
	public static void main(String [] a) {
		new AplAmortiguador();
	}
}
