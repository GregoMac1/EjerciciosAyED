package CaminoMinimoGrafos;

import Grafos.GrafoImplListAdy;
import Grafos.VerticeImplListAdy;
import ListasGenericas.copy.ListaGenerica;

public class Test { //bien. funciona y esta corregido
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
		
		grafo.conectar(vertF, vertA, 5);
		grafo.conectar(vertF, vertB, 13);
		grafo.conectar(vertF, vertC, 3);
		grafo.conectar(vertA, vertD, 20);
		grafo.conectar(vertB, vertD, 16);
		grafo.conectar(vertC, vertD, 1);
		grafo.conectar(vertC, vertB, 9);
		grafo.conectar(vertC, vertE, 11);
		grafo.conectar(vertD, vertG, 18);
		grafo.conectar(vertE, vertD, 12);
		
		BuscadorCaminoMinimo<String> buscador = new BuscadorCaminoMinimo<String>(grafo);
		
		ListaGenerica<String> caminoMin = buscador.caminoMinimo("F", "D");
		
		System.out.println(caminoMin.toString());
	}
}
