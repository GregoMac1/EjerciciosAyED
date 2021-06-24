package TareaGrafos;

import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

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
			if (peso < res.getMin()) {
				res.setMin(peso);
				res.setCaminoMin(camino);
			}
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

	/*private void copiarLista(ListaGenerica<String> origen, ListaGenerica<String> destino) {        
        while (!destino.esVacia()) {
        	destino.eliminarEn(1);
        }        
        origen.comenzar();
        while (!origen.fin()) {
            destino.agregarFinal(origen.proximo());
        }
	}*/
}
