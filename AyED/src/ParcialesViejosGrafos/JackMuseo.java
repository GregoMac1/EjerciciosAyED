package ParcialesViejosGrafos;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class JackMuseo {
	private Grafo<DatosDelVertice> grafo;
	private int pesoMax;
	
	public JackMuseo(Grafo<DatosDelVertice> grafo, int pesoMax) {
		this.grafo = grafo;
		this.pesoMax = pesoMax;
	}
	
	public ListaGenerica<String> mejorCamino() {
		Resultado res = new Resultado();
		res.setCaminoCumple(new ListaEnlazadaGenerica<String>());
		res.setMax(0);
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<DatosDelVertice>> vertices = grafo.listaDeVertices();
		boolean[] marca = new boolean [vertices.tamanio() + 1];
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<DatosDelVertice> v = vertices.proximo();
			if (v.dato().getNombre().equals("Entrada"))
				mejorCamino(v, camino, res, 0, 0, marca);
		}		
		return res.getCaminoCumple();
	}
	
	private void mejorCamino(Vertice<DatosDelVertice> actual, ListaGenerica<String> camino, 
			Resultado res, int peso, int cantVisitadas, boolean[] marca) {
		marca[actual.getPosicion()] = true;		
		camino.agregarFinal(actual.dato().getNombre());
		if (peso + actual.dato().getPeso() >= pesoMax) { //if si le sumo el actual me paso, me fijo si el camino actual es mejor
			if (cantVisitadas > res.getMax()) {
				res.setMax(cantVisitadas);
				res.setCaminoCumple(camino);
			}		
		} else {
			peso += actual.dato().getPeso();
			ListaGenerica<Arista<DatosDelVertice>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<DatosDelVertice> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()] && 
						peso + arista.peso() < pesoMax)
					mejorCamino(arista.getVerticeDestino(), camino, res, 
							peso + arista.peso(), ++cantVisitadas, marca);
			}
		}
		marca[actual.getPosicion()] = false;
		camino.eliminarEn(camino.tamanio());
	}
}
