package Ejercicio1;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int a;
		int b;
		
		Scanner consola = new Scanner(System.in);
		
		System.out.println("Ingrese el numero A: ");
		a = consola.nextInt();
		System.out.println("Ingrese el numero B: ");
		b = consola.nextInt();
		
		//ClaseMetodos.conFor(a, b);
		//ClaseMetodos.conWhile(a, b);
		ClaseMetodos.sinEstruc(a, b);
	}

}
