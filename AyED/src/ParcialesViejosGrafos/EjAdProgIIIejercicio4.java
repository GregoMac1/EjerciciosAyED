package ParcialesViejosGrafos;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ColaGenerica;
import ListasGenericas.ListaGenerica;

public class EjAdProgIIIejercicio4 { //la mejor en vez de las 5 mejores
	
	public String mejorEmpresa(Grafo<String> grafo) {
		String mejorEmpresa = "";
		int mejorCantidad = -1;
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		boolean[] marca = new boolean[vertices.tamanio() + 1];
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> v = vertices.proximo();
			marca = new boolean[vertices.tamanio() + 1]; //reseteo todo en falso
			int cantActual = mejorEmpresa(grafo, v, marca);
			if (cantActual > mejorCantidad) {
				mejorCantidad = cantActual;
				mejorEmpresa = v.dato();
			}
		}
		return mejorEmpresa;
	}
	
	private int mejorEmpresa(Grafo<String> grafo, Vertice<String> actual, 
			boolean[] marca) {
		marca[actual.getPosicion()] = true;
		ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
		cola.encolar(actual);
		cola.encolar(null);
		int cantidad = 0;
		while (!cola.esVacia()) {
			Vertice<String> v = cola.desencolar();
			if (v != null) {
				ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
				ady.comenzar();
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!marca[arista.getVerticeDestino().getPosicion()]) {
						marca[arista.getVerticeDestino().getPosicion()] = true;
						cola.encolar(arista.getVerticeDestino());
						cantidad++; //sumo la cantidad por cada adyacente
					}
				}
			} else if (!cola.esVacia()) {				
				cola.encolar(null);
			}
		}
		return cantidad;
	}
}
