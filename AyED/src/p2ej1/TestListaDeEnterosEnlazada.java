package p2ej1; // bien

import java.util.Scanner;

import ListasDeEnteros.copy.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {

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
		
		int i = 1;
		while (lista.elemento(i) != null) {
			System.out.println("Elemento de la posicion " + i + ": " + lista.elemento(i));
			i++;
		}

	}

}
