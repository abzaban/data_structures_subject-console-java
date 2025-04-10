import java.io.*;
import java.util.*;

public class ArchivoColor {
	/*
	 * Alumno: Berrelleza Beltrán Abraham
	 * Materia: Estructura de datos
	 * Hora: 12:00 - 13:00
	 */
	private File F;
	private RandomAccessFile Arch;
	private Scanner In;

	public ArchivoColor() {
		try {
			In = new Scanner(System.in);
			F = new File("colores.dat");
			Arch = new RandomAccessFile(F, "rw");
			if(F.length() == 0)
				Genera(500);
			int Length = (int)((Arch.length() - 1) / 42);
			Imprime();
			System.out.println();

			int Op;
			do {
				System.out.println("¿Qué desea hacer?");
				System.out.println("0. Salir");
				System.out.println("1. Ordenar el archivo "+F.getName()+" por el método Burbuja");
				System.out.println("2. Ordenar el archivo "+F.getName()+" por el método Quicksort");
				System.out.println("3. Borrar el archivo existente y generar uno nuevo (500 elementos)");
				System.out.println("4. Agregar N registros al archivo");
				System.out.println("5. Imprimir elementos del archivo");
				Op = In.nextInt();
				switch(Op) {
				case 0:
					break;
					
				case 1:
					OrdenaArchBurbuja();
					break;

				case 2:
					OrdenaArchQuicksort(0, Length);
					break;

				case 3:
					Arch.setLength(0);
			//		Arch = new RandomAccessFile(F, "rw");
					Genera(500);
					Length = (int)((Arch.length() - 1) / 42);
					break;
					
				case 4:
					System.out.println("Proporcione el número de registros a realizar:");
					int N = In.nextInt();
					Genera(N);
					Length = (int)((Arch.length() - 1) / 42);
					break;
					
				case 5:
					System.out.println("Elementos del archivo");
					Imprime();
					break;
					
				default:
					System.out.println("Ingrese una opción válida");
					break;
				}
				System.out.println();
			} while(Op != 0);

			Arch.close();
		} catch(IOException e) {
			System.out.println("Verifique su archivo, presentó problemas");
		}
	}
	
	public static void main(String [] a) {
		new ArchivoColor();
	}

	private void Genera(int N) throws IOException {
		String ColorGenerado;
		for(int i = 0 ; i < N ; i++) {
			ColorGenerado = Rutinas.nextColor();
			ColorGenerado = Rutinas.PonBlancos(ColorGenerado, 30);
			Arch.seek(Arch.length());
			Arch.writeUTF(ColorGenerado);
			Arch.writeFloat(0.0f);
			Arch.writeInt(0);
			Arch.writeChar('A');
		}
	}
	
	public void Imprime() throws IOException {
		Arch.seek(0);
		try {
			while(true) {
				System.out.println(Arch.readUTF()+"\t"+
						Arch.readFloat()+"\t"+
						Arch.readInt()+"\t"+
						Arch.readChar());
			}
		} catch(IOException e) {
			System.out.println("+++++++++++++++++");
		}
	}
	
	private void OrdenaArchBurbuja() throws IOException {
		String Color, ColorSig;
		boolean Band = true;
		int Reg = (int)(Arch.length() / 42);
		while(Band) {
			Band = false;
			Reg--;
			for(int i = 0 ; i < Reg ; i++) {
				Arch.seek(i * 42);
				Color = Arch.readUTF();
				Arch.seek((i + 1) * 42);
				ColorSig = Arch.readUTF();
				if(Color.compareTo(ColorSig) > 0) {
					Arch.seek((i + 1) * 42);
					Arch.writeUTF(Color);
					Arch.writeFloat(0.0f);
					Arch.writeInt(0);
					Arch.writeChar('A');
					
					Arch.seek(i * 42);
					Arch.writeUTF(ColorSig);
					Arch.writeFloat(0.0f);
					Arch.writeInt(0);
					Arch.writeChar('A');
					
					Band = true;
				}
			}
		}
	}
	
	private void OrdenaArchQuicksort(int Izq, int Der) throws IOException {
		int i, j;
		String Pivote, Auxi, Auxj;
		i = Izq;
		j = Der;
		Arch.seek(((Izq + Der) / 2) * 42);
		Pivote = Arch.readUTF();
		do {
			Arch.seek(i * 42);
			Auxi = Arch.readUTF();
			while(Auxi.compareToIgnoreCase(Pivote) < 0 && i < Der) {
				i++;
				Arch.seek(i * 42);
				Auxi = Arch.readUTF();
			}
			Arch.seek(j * 42);
			Auxj = Arch.readUTF();
			while(Pivote.compareToIgnoreCase(Auxj) < 0 && j > Izq) {
				j--;
				Arch.seek(j * 42);
				Auxj = Arch.readUTF();
			}
			if(i <= j) {
				Arch.seek(j * 42);
				Auxj = Arch.readUTF();
				
				Arch.seek(i * 42);
				Auxi = Arch.readUTF();
				
				Arch.seek(j * 42);
				Arch.writeUTF(Auxi);
				Arch.writeFloat(0.0f);
				Arch.writeInt(0);
				Arch.writeChar('A');
				
				Arch.seek(i * 42);
				Arch.writeUTF(Auxj);
				Arch.writeFloat(0.0f);
				Arch.writeInt(0);
				Arch.writeChar('A');
				
				i++;
				j--;
			}
		} while(i <= j);
		
		if(Izq < j)
			OrdenaArchQuicksort(Izq, j);
		if(i < Der)
			OrdenaArchQuicksort(i, Der);
	}
}
