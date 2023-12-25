import java.util.*;

public class Actividad04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] nombres = new String[5];
		int [] vida = new int[5];
		System.out.println("Coloque 5 nombres de soldados y su respectiva vida");
		for(int i = 0 ; i < nombres.length ; i++) {
			nombres[i]= sc.nextLine();
			vida [i] = sc.nextInt();
			sc.nextLine();
		}
		for(int i = 0 ; i < nombres.length ; i++) {
			System.out.println("Nombre del soldado: "+ nombres[i] + " y su vida es: " + vida[i]);
		}
	}

}
