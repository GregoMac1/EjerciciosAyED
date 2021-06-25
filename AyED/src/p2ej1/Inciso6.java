package p2ej1;

import java.util.Scanner;

import ListasDeEnteros.copy.ListaDeEnterosEnlazada;

public class Inciso6 { //bien
	
	public static ListaDeEnterosEnlazada calcularSucesion(Integer valor) {
		ListaDeEnterosEnlazada lista = null;
		if (valor == 1) { 
			lista = new ListaDeEnterosEnlazada();
			lista.agregarInicio(1);
		}
		else {	
			int valorInicial = valor;
			if (valor % 2 == 0) { 
				valor = valor/2;	
			}
			else {
				valor = (3*valor)+1;
			}
			lista = calcularSucesion(valor);
			lista.agregarInicio(valorInicial);
		}			
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
