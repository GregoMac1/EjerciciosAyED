package TareaGrafosCaperucita;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class BuscadorDeCaminos { //bien. corregido
	private Grafo<String> grafo;
	
	public BuscadorDeCaminos(Grafo<String> grafo) {
		this.grafo = grafo;
	}
	
	public ListaGenerica<String> recorridoMasCortoYSeguro() {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		Resultado res = new Resultado();
		ListaGenerica<Vertice<String>> vertices = this.grafo.listaDeVertices();
		Vertice<String> ini = null, fin = null;
		boolean[] marca = new boolean [vertices.tamanio() + 1];
		vertices.comenzar();
		while (!vertices.fin() && (ini == null || fin == null)) {
			Vertice<String> actual = vertices.proximo();
			if (actual.dato().equals("Casa Caperucita"))
				ini = actual;
			if (actual.dato().equals("Casa Abuelita"))
				fin = actual;
		}
		if (ini != null && fin != null)
			recorridoMasCortoYSeguro(ini, fin, 
					camino, res, 0, marca);
		return res.getCaminoMin();
	}
	
	private void recorridoMasCortoYSeguro(Vertice<String> actual, Vertice<String> fin, 
			ListaGenerica<String> camino, Resultado res, 
			int peso, boolean[] marca) {
		marca[actual.getPosicion()] = true;
		camino.agregarFinal(actual.dato());
		if (actual.equals(fin)) {
			if (peso < res.getMin())
				res.actualizarValor(peso, camino);
		} else {
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()] && 
						arista.peso() < 5)
					recorridoMasCortoYSeguro(arista.getVerticeDestino(), fin, 
							camino, res, peso + arista.peso(), marca);
			}
		}
		marca[actual.getPosicion()] = false;
		camino.eliminarEn(camino.tamanio());
	}
}
