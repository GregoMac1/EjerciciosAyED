package ParcialMaclenGregorio;

import Grafos.GrafoImplListAdy;
import Grafos.VerticeImplListAdy;
import ListasGenericas.ListaGenerica;

public class Test {
	public static void main(String[] args) {
		GrafoImplListAdy<Datos> grafo = new GrafoImplListAdy<Datos>(); 
		
		VerticeImplListAdy<Datos> vertA = new VerticeImplListAdy<Datos>(new Datos("Celeste", 0));
		VerticeImplListAdy<Datos> vertB = new VerticeImplListAdy<Datos>(new Datos("Rojo", 60));
		VerticeImplListAdy<Datos> vertC = new VerticeImplListAdy<Datos>(new Datos("Amarillo", 70));
		VerticeImplListAdy<Datos> vertD = new VerticeImplListAdy<Datos>(new Datos("Verde", 80));
		VerticeImplListAdy<Datos> vertE = new VerticeImplListAdy<Datos>(new Datos("Esmeraldas", 90));
		VerticeImplListAdy<Datos> vertF = new VerticeImplListAdy<Datos>(new Datos("Rubies", 45));
		VerticeImplListAdy<Datos> vertG = new VerticeImplListAdy<Datos>(new Datos("Diamantes", 80));		
		
		grafo.agregarVertice(vertA);
		grafo.agregarVertice(vertB);
		grafo.agregarVertice(vertC);
		grafo.agregarVertice(vertD);
		grafo.agregarVertice(vertE);
		grafo.agregarVertice(vertF);
		grafo.agregarVertice(vertG);
		
		grafo.conectar(vertA, vertB);
		grafo.conectar(vertA, vertC);
		grafo.conectar(vertA, vertD);
		grafo.conectar(vertB, vertC);
		grafo.conectar(vertB, vertE);
		grafo.conectar(vertC, vertF);
		grafo.conectar(vertD, vertG);
		
		Parcial buscar = new Parcial();
		ListaGenerica<String> mejorCamino = buscar.resolver(grafo);
		
		System.out.println(mejorCamino.toString());
	}
}
