package p2ej1;

import java.util.Scanner;

import ListasDeEnteros.src.tp02.ejercicio1.copy.ListaDeEnterosEnlazada;

public class Inciso6 { //no se como resolver ese error
	
	public static ListaDeEnterosEnlazada calcularSucesion(Integer valor) {
		if (valor == 2) { 
			ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		}
		else {			
			calcularSucesion(valor);
		}
		if (valor % 2 == 0) { 
			valor = valor/2;	
		}
		else {
			valor = (3*valor)+1;
		}
		lista.agregarInicio(valor);
		return lista;
	}

	public static void main(String[] args) {
		Integer valor;
		Scanner s = new Scanner(System.in);

		System.out.println("Ingrese el valor: ");
		valor = s.nextInt();		
			
		int i = 1;
		while (calcularSucesion(valor).elemento(i) != null) {
			System.out.println("Elemento de la posicion " + i + ": " + calcularSucesion(valor).elemento(i));
			i++;
		}
		
	}

}
