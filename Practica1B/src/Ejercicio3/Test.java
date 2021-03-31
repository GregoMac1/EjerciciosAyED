package Ejercicio3;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Estudiante estudiantes[] = new Estudiante[2];
		Profesor profesores[] = new Profesor[3];
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Estudiantes: ");
		for (int i = 0; i < 2; i++) {
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
			estudiantes[i] = estudiante;
		}
		
		System.out.println("Profesores: ");
		for (int i = 0; i < 3; i++) {
			Profesor profesor = new Profesor();
			System.out.println("Ingrese el nombre: ");
			profesor.setNombre(s.next());
			System.out.println("Ingrese el apellido: ");
			profesor.setApellido(s.next());
			System.out.println("Ingrese el email: ");
			profesor.setEmail(s.next());
			System.out.println("Ingrese la facultad: ");
			profesor.setFacultad(s.next());
			System.out.println("Ingrese la catedra: ");
			profesor.setCatedra(s.next());
			profesores[i] = profesor;
		}
		
		System.out.println("Estudiantes: ");
		for (int i = 0; i < 2; i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
		
		System.out.println("Profesores: ");
		for (int i = 0; i < 3; i++) {
			System.out.println(profesores[i].tusDatos());
		}

	}

}
