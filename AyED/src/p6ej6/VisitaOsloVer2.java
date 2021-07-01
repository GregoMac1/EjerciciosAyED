package p6ej6;

import CaminosGrafos.Resultado;
import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class VisitaOsloVer2 {
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> grafo, String destino, 
			int maxTiempo, ListaGenerica<String> lugaresRestringidos) {
		Resultado<String> res = new Resultado<String>();
		res.setCaminoMin(new ListaEnlazadaGenerica<String>());		
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		boolean[] marca = new boolean[vertices.tamanio() + 1];
		vertices.comenzar();
		Vertice<String> ini = null, fin = null;
		while (!vertices.fin() && (ini == null || fin == null)) {
			Vertice<String> v = vertices.proximo();
			if (v.dato().equals("Ayuntamiento"))
				ini = v;
			if (v.dato().equals(destino))
				fin = v;
		}
		if (ini == null && fin == null)
			paseoEnBici(grafo, ini, destino, camino, res, 
					marca, 0, maxTiempo, lugaresRestringidos);
		return res.getCaminoMin();
	}
	
	private void paseoEnBici(Grafo<String> grafo, Vertice<String> actual, 
			String destino, ListaGenerica<String> camino, Resultado<String> res, 
			boolean[] marca, int peso, int pesoMax, ListaGenerica<String> lugaresRestringidos) {
		marca[actual.getPosicion()] = true;
		camino.agregarFinal(actual.dato());
		if (res.getCaminoMin().esVacia()) {//llamo recursivamente solo si no encontre un camino valido	
			if (actual.dato().equals(destino)) {
				res.setCaminoMin(camino);
			} else {
				ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
				ady.comenzar();
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!marca[arista.getVerticeDestino().getPosicion()] &&
							peso + arista.peso() <= pesoMax && 
							!lugaresRestringidos.incluye(arista.getVerticeDestino().dato()))
						paseoEnBici(grafo, arista.getVerticeDestino(), destino, 
								camino, res, marca, peso + arista.peso(), pesoMax, 
								lugaresRestringidos);
				}
			}
		}
		marca[actual.getPosicion()] = false;
		camino.eliminarEn(camino.tamanio());
	}
}
