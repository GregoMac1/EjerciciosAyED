package p2ej2;

import java.util.Scanner;

import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;

public class TestListaEnlazadaGenerica { //bien

	public static void main(String[] args) {
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			Estudiante estudiante = new Estudiante();
			System.out.println("Ingrese el nombre: ");
			estudiante.setNombre(s.next());
			System.out.println("Ingrese el apellido: ");
			estudiante.setApellido(s.next());
			System.out.println("Ingrese el email: ");
			estudiante.setEmail(s.next());
			System.out.println("Ingrese la direccion: ");
			estudiante.setDireccion(s.next());
			System.out.println("Ingrese la comision: ");
			estudiante.setComision(s.nextInt());
			lista.agregarFinal(estudiante);
		}
		
		for (int i = 1; i < 5; i++) {
			System.out.println(lista.elemento(i).tusDatos());
		}
		
	}

}
