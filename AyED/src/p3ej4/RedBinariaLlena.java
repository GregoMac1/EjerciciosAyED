package p3ej4;

import ArbolBinario.ArbolBinario;

public class RedBinariaLlena {
	ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio() { //bien
		int retardoHI = 0;
		int retardoHD = 0;
		if (arbol.tieneHijoIzquierdo()) {
			RedBinariaLlena redHijoIzquierdo = new RedBinariaLlena(arbol.getHijoIzquierdo());
			retardoHI = redHijoIzquierdo.retardoReenvio();
		}
		if (arbol.tieneHijoDerecho()) {
			RedBinariaLlena redHijoDerecho = new RedBinariaLlena(arbol.getHijoDerecho());
			retardoHD = redHijoDerecho.retardoReenvio();
		}
		int max = Math.max(retardoHI, retardoHD);
		return arbol.getDato() + max;		
	}
}
