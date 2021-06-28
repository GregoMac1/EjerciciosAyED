package p3ej5;

import ArbolBinario.ArbolBinario;

public class Test {
	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(30);

		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(25);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(110));
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(90));

		ArbolBinario<Integer> der = new ArbolBinario<Integer>(70);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(45));
		der.agregarHijoDerecho(new ArbolBinario<Integer>(65));

		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		ab.printPreorden();
		
		ProfundidadArbolBinario p = new ProfundidadArbolBinario(ab);
		int suma = p.sumaElementosProfundidad(2);
		System.out.println("Suma del nivel: "+Integer.toString(suma));
	}
}
