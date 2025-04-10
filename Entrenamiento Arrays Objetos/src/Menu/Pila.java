package Menu;

public class Pila<T>{
    
    private T IPila[];
    private int Cima=-1,Tamaño;
    
    public Pila(int t){
        IPila = (T[])(new Object[t]);
        this.Tamaño=t;
    }
    
    public boolean PilaVacia(){
        return this.Cima==-1;
    }
    
    public boolean PilaLlena(){
        return Tamaño > 0 && Cima==Tamaño-1;
    }
    
    public void Empujar(T datos){
        if (!PilaLlena()) {
            Cima++;
            IPila[Cima] = datos;
            return;
        }
    }
    
    public T ObservarTope(){
        if (!PilaVacia()) {
            return IPila[Cima];
        }
        return null;
    }
    
    public T RegresaUltimo(){
        T Regreso;
        if (!PilaVacia()) {
            Regreso=IPila[Cima];
            Cima--;
            return Regreso;
        }
        return null;
    }
    
    public int Buscar(T d){
        if (!PilaVacia()) {
            for (int i = 0; i <=Cima; i++) {
                if (IPila[i]== d) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public int getCima(){
        return Cima;
    }
    public void setCima(int c){
        Cima=c;
    }
    
}
