package Ejercicio1;  //en el recursivo, falta opcion de si b>a

public class ClaseMetodos {
	public static void conFor(int a, int b) {
		if (a<b) {
			for (int i = a; i < b+1; i++) {
				System.out.println(i);
			}
		}
		else {
			for (int i = b; i < a+1; i++) {
				System.out.println(i);
			}
		}
	}
	public static void conWhile(int a, int b) {
		if (a<b) {
			int aux = a;
			while (aux<=b) {
				System.out.println(aux);
				aux++;
			}
		}
		else {
			int aux = b;
			while (aux<=a) {
				System.out.println(aux);
				aux++;
			}
		}
	}
	public static void sinEstruc(int a, int b) {
		if (a<=b) {
			System.out.println(a);
			a++;
			ClaseMetodos.sinEstruc(a, b);
		}
	}
}