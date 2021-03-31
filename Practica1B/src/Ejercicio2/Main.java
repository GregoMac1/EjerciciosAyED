package Ejercicio2;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num;
		
		Scanner consola = new Scanner(System.in);
		
		System.out.println("Ingrese el numero: ");
		num = consola.nextInt();
		
		Clase.getArreglo(num);

	}

}
