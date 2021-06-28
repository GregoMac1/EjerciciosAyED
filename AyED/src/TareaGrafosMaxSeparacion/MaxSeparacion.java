package TareaGrafosMaxSeparacion;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ColaGenerica;
import ListasGenericas.ListaGenerica;

public class MaxSeparacion {
	private Grafo<String> grafo;
	
	public MaxSeparacion(Grafo<String> grafo) {
		this.grafo = grafo;
	}
	
	public int maxGradoDeSeparacion() {
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		boolean[] marca = new boolean[vertices.tamanio() + 1];
		int max = 0;
		vertices.comenzar();
		boolean seguir = false;
		while (!vertices.fin() && seguir) {
			Vertice<String> v = vertices.proximo();
			int actual = gradoDeSeparacion(v, marca);
			if (actual == 0) {
				seguir = false;
				max = 0;
			} else if (actual > max)
				max = actual;
		}
		return max;
	}
	
	private int gradoDeSeparacion(Vertice<String> origen, boolean[] marca) {
		int cantVisitados = 0;
		ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
		for (int i = 0; i < marca.length; i++)			
			marca[i] = false;
		cola.encolar(origen);
		cola.encolar(null);
		marca[origen.getPosicion()] = true;
		cantVisitados++;
		int grado = 0;
		while (!cola.esVacia()) {
			Vertice<String> actual = cola.desencolar();
			if (actual != null) {
				ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
				ady.comenzar();
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!marca[arista.getVerticeDestino().getPosicion()]) {
						marca[arista.getVerticeDestino().getPosicion()] = true;
						cantVisitados++;
						cola.encolar(arista.getVerticeDestino());
					}
				}
			} else {
				grado++;
				if (!cola.esVacia())
					cola.encolar(null);
			}
		}
		if (cantVisitados < grafo.listaDeVertices().tamanio())
			return 0;
		else
			return grado;
	}
}
