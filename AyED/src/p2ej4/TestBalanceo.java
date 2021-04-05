package p2ej4;

import ListasGenericas.src.tp02.ejercicio2.copy.PilaGenerica;

public class TestBalanceo {// esta encaminado, pero falta corregir si el string tiene mas de apertura que de cierre, y falta verificar que la pila no este vacia antes de preguntar el tope
	
	public static void main(String[] args) {
		PilaGenerica<Character> pila = new PilaGenerica<>();
		
		boolean estaBalanceado = true;
		Character car;
		Character verificador = ' ';
		for (int i = 0; i < args[0].length(); i++) {
			car = args[0].charAt(i);
			if (car == '{' || car == '[' || car == '('){
				pila.apilar(car);
			}
			else {
				switch(car) {
					case '}':
						verificador = '{';
						break;
					case ']':
						verificador = '[';
						break;
					case ')':
						verificador = '(';
						break;
				}
				if (verificador == pila.tope()) {
					pila.desapilar();
				}
				else {
					estaBalanceado = false;
					break;
				}
			}
		}
		
		if (estaBalanceado) {
			System.out.println("El string esta balanceado.");
		}
		else {
			System.out.println("El string NO esta balanceado.");
		}
		
	}

}
