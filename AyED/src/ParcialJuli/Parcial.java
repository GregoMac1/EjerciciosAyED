package ParcialJuli;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class Parcial {
	
	public ListaGenerica<String> resolver(Grafo<String> ciudades, String origen, String destino, int montoMaximo) {

		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
		Resultado resultado = new Resultado();

		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
		Vertice<String> vOrigen = null, vDestino = null;

		boolean[] visitados = new boolean [vertices.tamanio() + 1];

		vertices.comenzar();
		while (!vertices.fin() && (vOrigen == null || vDestino == null)) {
			Vertice<String> actual = vertices.proximo();
			if (actual.dato().equals(origen))
				vOrigen = actual;
			if (actual.dato().equals(destino))
				vDestino = actual;
		}

		if (vOrigen != null && vDestino != null)
			resolver(ciudades, vOrigen, vDestino, caminoActual, resultado, 0, montoMaximo, visitados);

		return resultado.getCamino();
	}
	
	private void resolver(Grafo<String> ciudades, Vertice<String> actual, Vertice<String> fin, ListaGenerica<String> caminoActual, Resultado resultado, int peso, int pesoMax, boolean[] visitados) {

		visitados[actual.getPosicion()] = true;
		caminoActual.agregarFinal(actual.dato());

		if (resultado.getCamino().esVacia()) { //si no es vacia es porque ya encontre un camino valido

			if (actual.equals(fin)) {
				resultado.setCamino(caminoActual);
			} else {

				ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(actual);
				ady.comenzar();
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!visitados[arista.getVerticeDestino().getPosicion()] && peso + arista.peso() <= pesoMax)
						resolver(ciudades, arista.getVerticeDestino(), fin, caminoActual, resultado, peso + arista.peso(), pesoMax, visitados);
				}
			}
		}

		visitados[actual.getPosicion()] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}
}
