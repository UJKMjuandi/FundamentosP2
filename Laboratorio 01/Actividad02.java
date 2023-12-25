import java.util.*;

public class Actividad02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sol1,sol2,sol3,sol4,sol5;
		System.out.println("Escribe 5 nombres de soldados y su vida");
		sol1 = sc.nextLine();
		int vida1 = sc.nextInt();
		sc.nextLine();
		sol2 = sc.nextLine();
		int vida2 = sc.nextInt();
		sc.nextLine();
		sol3 = sc.nextLine();
		int vida3 = sc.nextInt();
		sc.nextLine();
		sol4 = sc.nextLine();
		int vida4 = sc.nextInt();
		sc.nextLine();
		sol5 = sc.nextLine();
		int vida5 = sc.nextInt();
		sc.nextLine();
		System.out.println("Soldado 01: "+ sol1 + "Ysu vida es: "+ vida1);
		System.out.println("Soldado 02: "+ sol2 + "Ysu vida es: "+ vida2);
		System.out.println("Soldado 03: "+ sol3 + "Ysu vida es: "+ vida3);
		System.out.println("Soldado 04: "+ sol4 + "Ysu vida es: "+ vida4);
		System.out.println("Soldado 05: "+ sol5 + "Ysu vida es: "+ vida5);

	}

}
