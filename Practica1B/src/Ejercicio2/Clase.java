package Ejercicio2;

public class Clase {
		
	public static int[] getArreglo (int num) {
		int[] arreglo = new int[num];
		for (int i = 1; i <= num; i++) {
			arreglo[i-1] = num*i;
		}
		for (int i = 0; i < num; i++) {
			System.out.println(arreglo[i]);
		}
		return arreglo;
	}
}
