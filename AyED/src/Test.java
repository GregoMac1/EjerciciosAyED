//import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;

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
		
		//System.out.println(ab.contarHojas()); //2a
		//ab.espejo().printPreorden(); //2b
		//ab.entreNiveles(1, 2); //2c
		/*ContadorArbol contador = new ContadorArbol(ab); //3
		ListaEnlazadaGenerica<Integer> lista = contador.numerosPares();
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}*/
	}
}
