import java.util.*;
public class Actividad05{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = generador();
		int num2 = generador();
		String [] eje01 = new String[num1];
		String [] eje02 = new String[num2];
		datos(eje01);
		datos(eje02);
		mensaje("Ejercito 01 : " );
		imprimir(eje01);
		mensaje("Ejercito 02 : " );
		imprimir(eje02);
		ganador(eje01,eje02);
	}
	public static int generador(){
	    int a = (int)(Math.random()*5 + 1);
	    return a;
	}
	public static void datos(String []a){
	    for(int i = 0 ; i<a.length ; i++){
	        a[i] = "Soldado" + i + "\nVida: 100 \nFuerza: 100 \nVelocidad: 100" ;
	    }
	}
	public static void ganador(String[]a,String[]b){
	    int c= a.length;
	    int d= b.length;
	    if(c == d){
	        mensaje("La guerra es un empate");
	    }
	    if(c>d){
	        mensaje("El ejercito 01 a ganado");
	    }else{
	        mensaje("El ejercito 02 a ganado");
	    }
	}
	public static void imprimir(String[]a){
	    for(int i = 0; i<a.length; i++){
	        mensaje(a[i]);
	    }
	}
	public static void mensaje(String a){
	    System.out.println(a);
	}
}
