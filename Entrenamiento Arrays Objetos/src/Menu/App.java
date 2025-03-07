package Menu;
import Utilerías.Leer;
public class App {
    static Pila<Character> a;
    public static void main(String[] args){
        
        System.out.print("INGRESA LA FUNCION:  ");
        String fun = Leer.dato().toUpperCase();
        a= new Pila<Character>(fun.length());
        System.out.println("TRASFORMAR A: ");
        System.out.println("1.-PREFIJA");
        System.out.println("2.-POSFIJA");
        
        int eleccion=Leer.datoInt();
        
        switch(eleccion){
            case 1:
                Prefija(fun);
                break;
            case 2: 
                PosFija(fun);
                break;
        }
        
    }
    
    private static void PosFija(String fun){
        String solucion="";
        for (int i = 0; i < fun.length(); i++) {
            char parte = fun.charAt(i);
            int aumento=0;
            if (parte=='('||parte==')'||parte=='+'||parte=='-'||parte=='/'||parte=='*'||parte=='^') {
                
                if(!a.PilaVacia()){
                    char ObservaTope=a.ObservarTope();
                    if (parte=='('||parte==')') {
 
                        if (parte=='(') {
                            a.Empujar(parte);
                        }
                        else if (parte==')' && a.Buscar('(')!=-1) {
                            solucion=(new StringBuilder()).append(solucion).append(VaciarPilaTotal(a)).toString();
                        }
                    }
                    if(parte=='+'||parte=='-'){
                        if (ObservaTope!='+' && ObservaTope!='-') {
                            solucion=(new StringBuilder()).append(solucion).append(VaciarPila(a)).toString();
                            a.Empujar(parte);
                        }
                        else if (ObservaTope=='+' || ObservaTope=='-') {
                            solucion+=a.RegresaUltimo();
                            a.Empujar(parte);
                        }
                    }
                    if (parte=='*'||parte=='/') {
                        if (ObservaTope=='^') {
                            solucion=(new StringBuilder()).append(solucion).append(VaciarPila(a)).toString();
                            a.Empujar(parte);
                        }
                        else if (ObservaTope=='*'||ObservaTope=='/') {
                            solucion+=a.RegresaUltimo();
                            a.Empujar(parte);
                        }
                        else if (ObservaTope=='-'||ObservaTope=='+') {
                            a.Empujar(parte);
                        }
                    }
                    if (parte=='^') {
                        if (ObservaTope=='^') {
                            solucion+=parte;
                        }
                        else if (ObservaTope!='^') {
                            a.Empujar(parte);
                        }
                    }
                }else{
                    a.Empujar(parte);
                }
            }else{
                solucion+= parte;
            } 
            
        }
        solucion=(new StringBuilder()).append(solucion).append(VaciarPila(a)).toString();
        System.out.println(solucion);
    }
    
    private static String VaciarPila(Pila<Character> a){
        String re="";
        String Olv="";
        int n= a.Buscar(a.ObservarTope());
        for (int i = 0; i<= n; i++) {
            if (a.ObservarTope()!='(') {
                char x= a.RegresaUltimo();
                re+=x;
            }else{
                continue;
            }
        }
        return re;
    }
    private static String VaciarPilaTotal(Pila<Character> a){
        String re="";
        String Olv="";
        int n= a.Buscar(a.ObservarTope());
        for (int i = 0; i<= n; i++) {
            if (a.ObservarTope()!='(' &&  a.ObservarTope()!=')') {
                char x= a.RegresaUltimo();
                re+=x;
            }else{
                Olv+=a.RegresaUltimo();
                continue;
            }
        }
        return re;
    }
    
    private static void Prefija(String fun){
        
        String Solucion="";
        String Solucion2="";
        
        for (int i = 0; i < fun.length(); i++) {
            char parte = fun.charAt(i);
            a.Empujar(parte);
        }
        for (int i = 0; i < fun.length(); i++) {
            Solucion+=a.RegresaUltimo();
        }
        
        for (int i = 0; i < fun.length(); i++) {
            char parte=Solucion.charAt(i);
            if (parte=='('||parte==')'||parte=='+'||parte=='-'||parte=='/'||parte=='*'||parte=='^') {
                
                if (!a.PilaVacia()) {
                    char ObservaTope=a.ObservarTope();
                    if (ObservaTope==')') {
                        a.Empujar(parte);
                    }
                    if (parte=='('||parte==')') {
                        if (parte==')') {
                            a.Empujar(parte);
                        }else if (parte=='(' && a.Buscar(')')!=-1) {
                            Solucion2=(new StringBuilder()).append(Solucion2).append(VaciarPilaTotal(a)).toString();
                        }
                    }
                    if (parte=='+'||parte=='-') {
                        if (ObservaTope!='+' && ObservaTope!='-' && ObservaTope!=')') {
                            Solucion2+=a.RegresaUltimo();
                            a.Empujar(parte);
                        }
                        else if (ObservaTope==parte) {
                            a.Empujar(parte);
                        }else if (ObservaTope!=parte && ObservaTope!=')') {
                            Solucion2+=a.RegresaUltimo();
                            a.Empujar(parte);
                        }
                    }
                    if (parte=='/'||parte=='*') {
                        if (ObservaTope=='^'&& ObservaTope!=')') {
                            Solucion2+=a.RegresaUltimo();
                            a.Empujar(parte);
                        }
                        else if (ObservaTope=='+'|| ObservaTope=='-') {
                            a.Empujar(parte);
                        }
                        else if (ObservaTope==parte) {
                            a.Empujar(parte);
                        }else if (ObservaTope!=parte&& ObservaTope!=')') {
                            Solucion2+=a.RegresaUltimo();
                            a.Empujar(parte);
                        }
                    }
                    if (parte=='^') {
                        a.Empujar(parte);
                    }
                }else{
                    a.Empujar(parte);
                }
                
            }else{
                Solucion2+=parte;
            }
        }
        while(!a.PilaVacia())
        	Solucion2+=a.RegresaUltimo();
        Solucion2=(new StringBuilder()).append(Solucion2).append(VaciarPilaTotal(a)).toString();
        char parte;
        System.out.println(Solucion2);
        for (int i = 0; i < Solucion2.length(); i++) {
            parte = Solucion2.charAt(i);
            a.Empujar(parte);
        }
        String Solucion3="";
        for (int i = 0; i < Solucion2.length(); i++) {
            Solucion3+=a.RegresaUltimo();
        }
        System.out.println(Solucion3);
    }
    
}
