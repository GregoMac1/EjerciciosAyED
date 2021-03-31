package p2ej1; //bien

import java.util.Scanner;

import ListasDeEnteros.src.tp02.ejercicio1.copy.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglos {

	public static void main(String[] args) {
		Integer valor;
		Scanner s = new Scanner(System.in);
		
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		
		System.out.println("Ingrese el valor (0 para finalizar): ");
		valor = s.nextInt();
		while (valor != 0) {
			lista.agregarFinal(valor);
			System.out.println("Ingrese el valor (0 para finalizar): ");
			valor = s.nextInt();
		}
		
		int i = 1;
		while (lista.proximo() != null) {
			System.out.println("Elemento de la posicion " + i + ": " + lista.elemento(i));
			i++;
		}

	}

}
