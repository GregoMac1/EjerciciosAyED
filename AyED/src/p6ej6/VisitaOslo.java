package p6ej6;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.copy.ListaEnlazadaGenerica;
import ListasGenericas.copy.ListaGenerica;
import MutableObjects.MutableBoolean;

public class VisitaOslo {
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, 
			int maxTiempo, ListaEnlazadaGenerica<String> lugaresRestringidos) { //consultar si esta bien
		ListaGenerica<String> caminoOk = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		MutableBoolean encontre = new MutableBoolean(false);		
		ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
		boolean[] marca = new boolean [vertices.tamanio()];
		Vertice<String> ini = null, fin = null;
		while (!vertices.fin() && (ini == null || fin == null)) {
			Vertice<String> actual = vertices.proximo();
			if (actual.dato().equals("Ayuntamiento"))
				ini = actual;
			if (actual.dato().equals(destino))
				fin = actual;
		}
		if (ini != null && fin != null)
			paseoEnBici(lugares, ini.getPosicion(), destino, 0, maxTiempo,  
					camino, caminoOk, encontre, marca, lugaresRestringidos);
		return caminoOk;
	}
	
	private void paseoEnBici(Grafo<String> lugares, int i, String destino, 
			int tiempo, int maxTiempo, ListaGenerica<String> camino, 
			ListaGenerica<String> caminoOk, MutableBoolean encontre, boolean[] marca, 
			ListaEnlazadaGenerica<String> lugaresRestringidos) {
		marca[i] = true;
		Vertice<String> actual = lugares.vetice(i);
		if (!lugaresRestringidos.incluye(actual.dato())) //chequeo que solo sirve la primera vez
			camino.agregarFinal(actual.dato());
		if (actual.dato().equals(destino)) {
			if (tiempo <= maxTiempo) {
				encontre.setDato(true);
				caminoOk = camino;
			}
		} else if (!encontre.getDato()){ //si ya encontre, dejo de llamar
			ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(actual);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()] && 
						(tiempo - arista.peso() >= 0) && 
						!lugaresRestringidos.incluye(arista.getVerticeDestino().dato()))
					paseoEnBici(lugares, arista.getVerticeDestino().getPosicion(),
							destino, tiempo, maxTiempo, camino, caminoOk, 
							encontre, marca, lugaresRestringidos);
			}
		}
		marca[i] = false;
		camino.eliminarEn(camino.tamanio());
	}	
}
