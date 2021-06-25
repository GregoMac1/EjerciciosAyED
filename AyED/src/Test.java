import ListasGenericas.copy.ListaEnlazadaGenerica;

//import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;

public class Test {
	public static void main(String[] args) {
		ArbolBinario<String> ab = new ArbolBinario<String>("C");

		ArbolBinario<String> izq = new ArbolBinario<String>("A");
		izq.agregarHijoIzquierdo(new ArbolBinario<String>("L"));
		izq.agregarHijoDerecho(new ArbolBinario<String>("D"));

		ArbolBinario<String> der = new ArbolBinario<String>("E");
		der.agregarHijoIzquierdo(new ArbolBinario<String>("S"));
		der.agregarHijoDerecho(new ArbolBinario<String>("F"));

		ab.agregarHijoIzquierdo(izq);
		ab.agregarHijoDerecho(der);
		
		ListaEnlazadaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
		lista.agregarFinal("C");
		lista.agregarFinal("E");
		lista.agregarFinal("F");
		Parcial parcial = new Parcial();
		System.out.println(parcial.resolver(ab, lista));
		
		//System.out.println(ab.contarHojas()); //2a
		//ab.espejo().printPreorden(); //2b
		//ab.entreNiveles(1, 2); //2c
		/*ContadorArbol contador = new ContadorArbol(ab); //3
		ListaEnlazadaGenerica<Integer> lista = contador.numerosPares();
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}*/
		/*ListaEnlazadaGenerica<String> lista = new ListaEnlazadaGenerica<String>(); //parcialesViejos1
		lista.agregarFinal("00");
		lista.agregarFinal("0");
		lista.agregarFinal("10");
		lista.agregarFinal("11");
		ParcialesViejos parcial = new ParcialesViejos();
		ListaEnlazadaGenerica<Integer> listaNueva = parcial.codigoZigZag(ab,lista);
		System.out.println(listaNueva.toString());*/
		//ParcialesViejos parcial = new ParcialesViejos();
		//System.out.println(parcial.resolverJuli(ab));
		//System.out.println(parcial.buscarPrimerElementoUltimoNivel());		
	}
}
