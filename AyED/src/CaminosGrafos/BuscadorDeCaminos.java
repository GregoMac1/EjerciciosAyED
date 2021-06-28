package CaminosGrafos;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.copy.ListaEnlazadaGenerica;
import ListasGenericas.copy.ListaGenerica;

public class BuscadorDeCaminos<T> {
	private Grafo<T> grafo;
	
	public BuscadorDeCaminos(Grafo<T> grafo) {
		this.grafo = grafo;
	}
	
	public ListaGenerica<T> caminoMinimo(T origen, T destino) {
		ListaGenerica<T> camino = new ListaEnlazadaGenerica<T>();
		Resultado<T> res = new Resultado<T>();
		res.setMin(Integer.MAX_VALUE); 
		res.setCaminoMin(new ListaEnlazadaGenerica<T>());
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		Vertice<T> ini = null, fin = null;
		boolean[] marca = new boolean [vertices.tamanio() + 1];
		vertices.comenzar();
		while (!vertices.fin() && (ini == null || fin == null)) {
			Vertice<T> actual = vertices.proximo();
			if (actual.dato().equals(origen))
				ini = actual;
			if (actual.dato().equals(destino))
				fin = actual;
		}
		if (ini != null && fin != null)
			caminoMinimo(ini, fin, camino, res, 0, marca);
		return res.getCaminoMin();
	}
	
	private void caminoMinimo(Vertice<T> actual, Vertice<T> fin, 
			ListaGenerica<T> camino, Resultado<T> res, int peso, boolean[] marca) {
		marca[actual.getPosicion()] = true;
		camino.agregarFinal(actual.dato());
		if (actual.equals(fin)) {
			if (peso < res.getMin()) {
				res.actualizarValorMin(peso, camino);
			}
		} else {
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()])
					caminoMinimo(arista.getVerticeDestino(), fin, 
							camino, res, peso + arista.peso(), marca);
			}
		}
		marca[actual.getPosicion()] = false;
		camino.eliminarEn(camino.tamanio());
	}
	
	public ListaGenerica<ListaGenerica<T>> todosLosCaminos(T origen, T destino) {
		ListaGenerica<T> camino = new ListaEnlazadaGenerica<T>();
		Resultado<T> res = new Resultado<>();
		res.setTodosLosCaminos(new ListaEnlazadaGenerica<ListaGenerica<T>>());
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		Vertice<T> ini = null, fin = null;
		boolean[] marca = new boolean [vertices.tamanio() + 1];
		vertices.comenzar();
		while (!vertices.fin() && (ini == null || fin == null)) {
			Vertice<T> actual = vertices.proximo();
			if (actual.dato().equals(origen))
				ini = actual;
			if (actual.dato().equals(destino))
				fin = actual;
		}
		if (ini != null && fin != null)
			todosLosCaminos(ini, fin, camino, res, marca);
		return res.getTodosLosCaminos();
	}
	
	private void todosLosCaminos(Vertice<T> actual, Vertice<T> fin, 
			ListaGenerica<T> camino, Resultado<T> res, boolean[] marca) {
		marca[actual.getPosicion()] = true;
		camino.agregarFinal(actual.dato());
		if (actual.equals(fin)) {
			res.agregarCamino(camino);
		} else {
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()])
					todosLosCaminos(arista.getVerticeDestino(), fin, 
							camino, res, marca);
			}
		}
		marca[actual.getPosicion()] = false;
		camino.eliminarEn(camino.tamanio());
	}
}
