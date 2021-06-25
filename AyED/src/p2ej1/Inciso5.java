package p2ej1;

import java.util.Scanner;

import ListasDeEnteros.copy.ListaDeEnterosEnlazada;
import ListasDeEnteros.copy.NodoEntero;

public class Inciso5 { //creo que bien
	
	public static void imprimirListaInverso(NodoEntero nodo) {
		if (nodo.getSiguiente() != null) {
			imprimirListaInverso(nodo.getSiguiente());
		}
		System.out.println(nodo.getDato());
	}

	public static void main(String[] args) {
		Integer valor;
		Scanner s = new Scanner(System.in);
		
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		
		System.out.println("Ingrese el valor (0 para finalizar): ");
		valor = s.nextInt();
		while (valor != 0) {
			if (lista.agregarFinal(valor)) {
				System.out.println("Ingrese el valor (0 para finalizar): ");
				valor = s.nextInt();
			}
		}
		imprimirListaInverso(lista.getInicio());

	}

}
