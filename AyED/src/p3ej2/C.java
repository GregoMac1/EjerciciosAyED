package p3ej2;

import ArbolBinario.ArbolBinario;

public class C {
	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(1);
		
		ArbolBinario<Integer> izq2 = new ArbolBinario<Integer>(4);
		izq2.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));

		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(2);
		izq.agregarHijoIzquierdo(izq2);
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(5));
		


		ArbolBinario<Integer> der = new ArbolBinario<Integer>(3);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));

		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
			
		ab.entreNiveles(1, 2);
	}
}
