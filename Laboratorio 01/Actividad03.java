import java.util.*;
public class Actividad03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] nombres = new String[5];
		System.out.println("Coloque 5 nombres de soldados");
		for(int i = 0 ; i < nombres.length ; i++) {
			nombres[i]= sc.nextLine();
		}
		for(int i = 0 ; i < nombres.length ; i++) {
			System.out.println("Nombre del soldado: "+ nombres[i]);
		}
	}
}
