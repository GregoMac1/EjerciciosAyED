package ParcialesViejosGrafos;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class Parcial1 {
	
	public ListaGenerica<String> resolver(Grafo<DatosDelVertice> ciudades, String origen,
			String destino, ListaGenerica<String> pasandoPor) {
		Resultado res = new Resultado();
		res.setCaminoCumple(new ListaEnlazadaGenerica<String>());
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<DatosDelVertice>> vertices = ciudades.listaDeVertices();		
		boolean[] marca = new boolean[vertices.tamanio() + 1];
		Vertice<DatosDelVertice> ini = null, fin = null;
		vertices.comenzar();
		while (!vertices.fin() && (ini != null || fin != null)) {
			Vertice<DatosDelVertice> v = vertices.proximo();
			if (origen == v.dato().getNombre())
				ini = v;
			if (destino == v.dato().getNombre())
				fin = v;
		}
		if (ini != null && fin != null)
			resolver(ciudades, ini, fin, res, camino, pasandoPor, marca);
		return res.getCaminoCumple();
	}
	
	private void resolver(Grafo<DatosDelVertice> grafo, Vertice<DatosDelVertice> actual, 
			Vertice<DatosDelVertice> destino, Resultado res, ListaGenerica<String> camino, 
			ListaGenerica<String> pasandoPor, boolean[] marca) {
		marca[actual.getPosicion()] = true;
		camino.agregarFinal(actual.dato().getNombre());
		if (actual.dato().getNombre().equals(destino.dato().getNombre())) {
			boolean ok = true;
			for (int i = 0; i < pasandoPor.tamanio(); i++) {
				if (!camino.incluye(pasandoPor.elemento(i)))
					ok = false;
			if (ok)
				res.setCaminoCumple(camino);
			}
		} else {
			ListaGenerica<Arista<DatosDelVertice>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<DatosDelVertice> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()] && 
						arista.peso() >= 0) //si es un valor negativo, significa que la ruta no esta habilitada
					resolver(grafo, arista.getVerticeDestino(), destino, 
							res, camino, pasandoPor, marca);
			}
		}
		marca[actual.getPosicion()] = false;
		camino.eliminarEn(camino.tamanio());
	}	
}
