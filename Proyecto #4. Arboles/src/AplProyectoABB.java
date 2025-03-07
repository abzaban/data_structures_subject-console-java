import java.util.*;
public class AplProyectoABB {
	/*
	 * Alumno: Berrelleza Beltrán Abraham
	 * Materia: Estructura de datos
	 * Hora: 12:00 - 13:00
	 */
	
	private Scanner In;
	private ArbolBinarioBusqueda<Producto> Obj;
	
	class Producto {
		public int IdProducto;
		public int Existencia;
		
		public Producto(int IdProducto) {
			this.IdProducto = IdProducto;
		}
		
		public String toString () {
			return Rutinas.PonCeros(IdProducto, 5);
		}
	}
	
	public AplProyectoABB() {
		In = new Scanner(System.in);
		Obj = new ArbolBinarioBusqueda<Producto>();
		int Opcion = 0;
		while(Opcion != 11) {
			System.out.println();
			System.out.println("¿Qué desea hacer?");
			System.out.println(" 1. Inserta un producto con información aleatoria");
			System.out.println(" 2. Retirar un producto (la existencia debe ser igual a 0)");
			System.out.println(" 3. Registrar entrada a un producto por teclado");
			System.out.println(" 4. Registrar existencia a todos los productos con un ID mayor al que proporcione");
			System.out.println(" 5. Retirar existencia de un producto en específico");
			System.out.println(" 6. Retirar todos los productos con existencia igual a 100");
			System.out.println(" 7. Consulta: Porcentaje de productos registrados (con respecto al total productos)");
			System.out.println(" 8. Consulta: Productos registrados (en orden descendente)");
			System.out.println(" 9. Consulta: Proporcionado un id, mostrar la ubicación del producto en el árbol: nivel y secuencia de subárboles");
			System.out.println("10. Consulta: Niveles inferiores que tienen menos nodos que el nivel superior");
			System.out.println("11. Salir");
			Opcion = In.nextInt();
			
			switch(Opcion) {
			case 1:
				InsertaProductoAleatorio();
				break;
				
			case 2:
				RetiraProducto();
				break;
				
			case 3:
				InsertaProductoTeclado();
				break;
				
			case 4:
				IncrementaExistenciaProductosX();
				break;
				
			case 5:
				RetiraExistencia();
				break;
				
			case 6:
				RetiraProductosConExistenciaIgualCien();
				break;
				
			case 7:
				PorcentajeDeProductosConRespectoTotal();
				break;
				
			case 8:
				ConsultaProductosDescendente();
				break;
				
			case 9:
				ConsultaNivelYSecuenciaProducto();
				break;
				
			case 10:
				ConsultaNivelInferiorMenorQueS();
				break;
				
			case 11:
				break;
				
			default:
				System.out.println("Ingrese una opción válida ");
				break;
				
			}
		}
	}
	
	public void InsertaProductoAleatorio() {
		int IdProducto = Rutinas.nextInt(100, 5000);
		while(RepiteIdProducto(IdProducto, Obj.getRaiz()))
			IdProducto = Rutinas.nextInt(100, 5000);
		int Existencia = Rutinas.nextInt(100);
		Producto P = new Producto(IdProducto);
		System.out.println("El producto se creó con el ID "+IdProducto);
		P.Existencia = Existencia;
		Obj.Inserta(P);
	}
	
	public void RetiraProducto() {
		if(Obj.getRaiz() == null) {
			System.out.println("No se han insertado productos");
			return;
		}
		System.out.println("Productos disponibles");
		ConsultaProductosDescendente();
		System.out.println("Proporcione el ID del producto a eliminar:");
		Producto P = new Producto(In.nextInt());
		NodoABB<Producto> Aux = Obj.BuscaNodo(Obj.getRaiz(), P);
		if(Aux == null) {
			System.out.println("No se encontro el producto con ID "+P.IdProducto);
			return;
		}
		if(Aux.Info.Existencia != 0) {
			System.out.println("El producto que se proporciono cuenta con "+Aux.Info.Existencia+" existencias, por lo tanto no se puede eliminar");
			return;
		}
		Obj.Borrar(P);
	}
	
	public void InsertaProductoTeclado() {
		int IdProducto = Rutinas.nextInt(100, 5000);
		while(RepiteIdProducto(IdProducto, Obj.getRaiz()))
			IdProducto = Rutinas.nextInt(100, 5000);
		System.out.println("El ID del nuevo producto es "+IdProducto);
		System.out.println("Proporcione el número de existencias que tiene el producto:");
		int Existencia = In.nextInt();
		Producto P = new Producto(IdProducto);
		P.Existencia = Existencia;
		Obj.Inserta(P);
	}
	
	public void IncrementaExistenciaProductosX() {
		if(Obj.getRaiz() == null) {
			System.out.println("No se han insertado productos");
			return;
		}
		int IdProducto = Rutinas.nextInt(100, 5000);
		System.out.println("Se incrementará la existencia a todos los productos con un ID mayor a "+IdProducto);
		System.out.println("Proporcione la cantidad que se le incrementará a estos productos:");
		int IncreExis = In.nextInt();
		Producto P = new Producto(IdProducto);
		P.Existencia = IncreExis;
		IncrementaExistenciaProductosX(P, Obj.getRaiz());
	}
	
	public void IncrementaExistenciaProductosX(Producto P, NodoABB<Producto> Raiz) {
		if(Raiz == null)
			return;
		IncrementaExistenciaProductosX(P, Raiz.getSubIzq());
		if(Raiz.Info.IdProducto >= P.IdProducto) {
			System.out.println("Producto "+Raiz.Info.IdProducto+"\tAntigüas existencias "+Raiz.Info.Existencia+"\tNuevas existencias "+(Raiz.Info.Existencia + P.Existencia));
			Raiz.Info.Existencia += P.Existencia;
		}
		IncrementaExistenciaProductosX(P, Raiz.getSubDer());
	}
	
	public void RetiraExistencia() {
		if(Obj.getRaiz() == null) {
			System.out.println("No se han insertado productos");
			return;
		}
		System.out.println("Productos disponibles");
		ConsultaProductosDescendente();
		System.out.println("Proporcione el ID del producto al cual desea retirarle existencia:");
		int IdProducto = In.nextInt();
		Producto P = new Producto(IdProducto);
		NodoABB<Producto> Aux = Obj.BuscaNodo(Obj.getRaiz(), P);
		if(Aux == null) {
			System.out.println("No se encontro el producto "+IdProducto);
			return;
		}
		System.out.println("Las existencias del producto "+IdProducto+" son "+Aux.Info.Existencia);
		System.out.println("¿Cuánto será lo que se le disminuirá las existencias?");
		int Existencias = In.nextInt();
		while(Existencias > Aux.Info.Existencia) {
			System.out.println("Ingrese una cantidad valida (MENOR o IGUAL a "+Aux.Info.Existencia+"):");
			Existencias = In.nextInt();
		}
		Aux.Info.Existencia -= Existencias;
	}
	
	boolean Band;
	public void RetiraProductosConExistenciaIgualCien() {
		if(Obj.getRaiz() == null) {
			System.out.println("No se han insertado productos");
			return;
		}
		Band = false;
		RetiraProductosConExistenciaIgualCien(Obj.getRaiz());
		if(!Band)
			System.out.println("No se encontró ningún producto con existencia igual a 100");
	}
	
	public void RetiraProductosConExistenciaIgualCien(NodoABB<Producto> Raiz) {
		if(Raiz == null)
			return;
		RetiraProductosConExistenciaIgualCien(Raiz.getSubIzq());
		RetiraProductosConExistenciaIgualCien(Raiz.getSubDer());
		if(Raiz.Info.Existencia == 100) {
			Obj.Borrar(Raiz.Info);
			System.out.println("Se borró "+Raiz.Info.IdProducto);
			Band = true;
		}
	}
	
	public void PorcentajeDeProductosConRespectoTotal() {
		if(Obj.getRaiz() == null) {
			System.out.println("No se han insertado productos");
			return;
		}
		double CantProd = Obj.Length();
		double Porcentaje = (CantProd * 100) / 4900;
		System.out.println("El porcentaje de productos con respecto al total de los mismos es = "+Porcentaje+" %");
	}
	
	public void ConsultaProductosDescendente() {
		if(Obj.getRaiz() == null) {
			System.out.println("No se han insertado productos");
			return;
		}
		ConsultaProductosDescendente(Obj.getRaiz());
	}
	
	public void ConsultaProductosDescendente(NodoABB<Producto> Raiz) {
		if(Raiz == null)
			return;
		ConsultaProductosDescendente(Raiz.getSubDer());
		System.out.println("ID del producto: "+Raiz.Info.IdProducto+"\tExistencias: "+Raiz.Info.Existencia);
		ConsultaProductosDescendente(Raiz.getSubIzq());
	}
	
	public void ConsultaNivelYSecuenciaProducto() {
		NodoABB<Producto> Raiz = Obj.getRaiz();
		if(Raiz == null) {
			System.out.println("No se han insertado productos");
			return;
		}
		System.out.println("Proporcione el producto el cual desea consultar:");
		Producto P = new Producto(In.nextInt());
		NodoABB<Producto> ProductoSolicitado = Obj.BuscaNodo(Raiz, P);
		if(ProductoSolicitado == null) {
			System.out.println("No se encontró el producto "+P.IdProducto);
			return;
		}
		int Nivel = 0;
		System.out.println("Para llegar al producto "+ProductoSolicitado.Info.IdProducto+" se requiere bajar en el siguiente orden:");
		while(Raiz != null) {
			Nivel++;
			if(Obj.getRaiz() == ProductoSolicitado) {
				System.out.println("El producto "+Raiz.Info.IdProducto+" se encuentra en la raíz");
				break;
			}
			if(Raiz == ProductoSolicitado) {
				System.out.println("Llegaste");
				break;
			}
			if(ProductoSolicitado.Info.IdProducto < Raiz.Info.IdProducto) {
				System.out.println("Izquierda");
				Raiz = Raiz.getSubIzq();
				continue;
			}
			System.out.println("Derecha");
			Raiz = Raiz.getSubDer();
		}
		System.out.println("El nivel en el que se encuentra es "+Nivel);
	}
	
	public void ConsultaNivelInferiorMenorQueS() {
		if(Obj.getRaiz() == null) {
			System.out.println("No se han insertado productos");
			return;
		}
		boolean Band = false;
		int [] V = new int [Obj.Altura() + 1];
		ConsultaNivelInferiorMenorQueS(Obj.getRaiz(), 1, V);
		for(int i = 1 ; i < V.length - 1; i++)
			if(V[i] > V[i+1]) {
				System.out.println("El nivel "+(i+1)+" ("+V[(i+1)]+") tiene menos nodos que el nivel "+i+" ("+V[i]+")");
				Band = true;
			}
		if(!Band)
			System.out.println("No se encontró ningun nivel con menos nodos que su nivel superior");
	}
	
	public void ConsultaNivelInferiorMenorQueS(NodoABB<Producto> Raiz, int Nivel, int [] V) {
		if(Raiz == null)
			return;
		V[Nivel] += 1;
		ConsultaNivelInferiorMenorQueS(Raiz.getSubIzq(), Nivel+1, V);
		ConsultaNivelInferiorMenorQueS(Raiz.getSubDer(), Nivel+1, V);
	}
	
	public boolean RepiteIdProducto(int IdProducto, NodoABB<Producto> Raiz) {
		boolean Band = false;
		if(Raiz == null)
			return Band;
		while(Raiz != null) {
			if(Raiz.Info.IdProducto == IdProducto) {
				Band = true;
				break;
			}
			if(IdProducto < Raiz.Info.IdProducto) {
				Raiz = Raiz.getSubIzq();
				continue;
			}
			Raiz = Raiz.getSubDer();
		}
		return Band;
	}
	
	public static void main(String [] a) {
		new AplProyectoABB();
	}
}
