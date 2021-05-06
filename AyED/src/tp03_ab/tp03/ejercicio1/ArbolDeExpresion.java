package tp03_ab.tp03.ejercicio1;

import ListasGenericas.src.tp02.ejercicio2.copy.PilaGenerica;

public class ArbolDeExpresion {
	public void printPreorden(ArbolBinario<Character> arbol) {
		if (arbol != null && !arbol.esVacio()) {
			System.out.println(arbol.getDato());		
			if (arbol.tieneHijoIzquierdo()) {
				arbol.getHijoIzquierdo().printPreorden();
			}
			if (arbol.tieneHijoDerecho()) {
				arbol.getHijoDerecho().printPreorden();
			}
		}
	}
	
	public void printEnOrden(ArbolBinario<Character> arbol) {	
		if (arbol != null && !arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				arbol.getHijoIzquierdo().printEnOrden();
			}
			System.out.println(arbol.getDato());
			if (arbol.tieneHijoDerecho()) {
				arbol.getHijoDerecho().printEnOrden();
			}
		}
	}

	// imprime el �rbol en postorden
	public void printPostorden(ArbolBinario<Character> arbol) {		
		if (arbol != null && !arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				arbol.getHijoIzquierdo().printPreorden();
			}
			if (arbol.tieneHijoDerecho()) {
				arbol.getHijoDerecho().printPreorden();
			}
			System.out.println(arbol.getDato());
		}
	}	
	public ArbolBinario<Character> convertirPostfija(String exp) {
		 char c;
		 ArbolBinario<Character> result;
		 PilaGenerica<ArbolBinario<Character>> p = new PilaGenerica<ArbolBinario<Character>>();
		 for (int i = 0; i < exp.length(); i++) {
		     c = exp.charAt(i);
		     result = new ArbolBinario<Character>(c);
		     if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) { // Es operador
		         result.agregarHijoDerecho(p.desapilar());
		         result.agregarHijoIzquierdo(p.desapilar ());
		     }
		     p.apilar(result);
		 }
		 return (p.desapilar());
	}

	public ArbolBinario<Character> convertirPrefija(StringBuffer exp) {
		 char c = exp.charAt(0);
		 ArbolBinario<Character> result = new ArbolBinario<Character>(c);
		 if ((c == '+') || (c == '-') || (c == '/') || c == '*') { // es operador
		     result.agregarHijoIzquierdo(this.convertirPrefija(exp.delete(0,1)));
		     result.agregarHijoDerecho(this.convertirPrefija(exp.delete(0,1)));
		 }
		 // es operando
		 return result;
		}

	public Integer evaluar(ArbolBinario<Character> arbol) {    //fijate que si no lo ingresas bien al arbol te salta error
		 Character c = arbol.getDato();
		 // es operador
		 if ((c == '+') || (c == '-') || (c == '/') || c == '*') {
		     int operador_1 = evaluar(arbol.getHijoIzquierdo());
		     int operador_2 = evaluar(arbol.getHijoDerecho());
		     switch (c) {
		         case '+':
		             return operador_1 + operador_2;
		         case '-':
		             return operador_1 - operador_2;
		         case '*':
		             return operador_1 * operador_2;
		         case '/':
		             return operador_1 / operador_2;
		     }
		 }
		 // es operando
		 return Integer.parseInt(c.toString());
		}

}
