package p6ej4;

import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class Test {
	public static void main(String[] args) {
		GrafoImplListAdy<String> grafo = new GrafoImplListAdy<String>(); 
		
		VerticeImplListAdy<String> vertA = new VerticeImplListAdy<String>("A");
		VerticeImplListAdy<String> vertB = new VerticeImplListAdy<String>("B");
		VerticeImplListAdy<String> vertC = new VerticeImplListAdy<String>("C");
		VerticeImplListAdy<String> vertD = new VerticeImplListAdy<String>("D");
		VerticeImplListAdy<String> vertE = new VerticeImplListAdy<String>("E");
		VerticeImplListAdy<String> vertF = new VerticeImplListAdy<String>("F");
		VerticeImplListAdy<String> vertG = new VerticeImplListAdy<String>("G");
		
		
		grafo.agregarVertice(vertA);
		grafo.agregarVertice(vertB);
		grafo.agregarVertice(vertC);
		grafo.agregarVertice(vertD);
		grafo.agregarVertice(vertE);
		grafo.agregarVertice(vertF);
		grafo.agregarVertice(vertG);
		
		grafo.conectar(vertF, vertA);
		grafo.conectar(vertF, vertB);
		grafo.conectar(vertF, vertC);
		grafo.conectar(vertA, vertD);
		grafo.conectar(vertB, vertD);
		grafo.conectar(vertC, vertD);
		grafo.conectar(vertC, vertB);
		grafo.conectar(vertC, vertE);
		grafo.conectar(vertD, vertG);
		grafo.conectar(vertE, vertG);
		
		Recorridos<String> b = new Recorridos<String>();
		ListaEnlazadaGenerica<Vertice<String>> dfs = b.dfs(grafo);
		System.out.println(dfs);
		ListaEnlazadaGenerica<Vertice<String>> bfs = b.bfs(grafo);
		System.out.println(bfs);
	}
}
