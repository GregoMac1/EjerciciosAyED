package p3ej3;

import ArbolBinario.ArbolBinario;
import ListasGenericas.ListaEnlazadaGenerica;

public class Test {
	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(5);

		ArbolBinario<Integer> izq = new ArbolBinario<Integer>(3);
		izq.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		izq.agregarHijoDerecho(new ArbolBinario<Integer>(4));

		ArbolBinario<Integer> der = new ArbolBinario<Integer>(8);
		der.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		der.agregarHijoDerecho(new ArbolBinario<Integer>(10));

		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		ContadorArbol contador = new ContadorArbol(ab);
		
		ListaEnlazadaGenerica<Integer> lista = contador.numerosParesInOrden();

		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}
}
