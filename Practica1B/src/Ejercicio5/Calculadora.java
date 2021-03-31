package Ejercicio5;

public class Calculadora {
	public static int[] puntoA (int[] arreglo) {
		int [] arregloDatos = new int[3];
		int max = -1;
		int min = 9999;
		int prom = 0;
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] > max)
				max = arreglo[i];
			if (arreglo[i] < min)
				min = arreglo[i];
			prom += arreglo[i];
		}
		arregloDatos[0] = max;
		arregloDatos[1] = min;
		arregloDatos[2] = prom / arreglo.length;
		return arregloDatos;
	}
	public static Datos puntoB (?) {
		Datos datos = new Datos();
		
		return datos;
	}
}
