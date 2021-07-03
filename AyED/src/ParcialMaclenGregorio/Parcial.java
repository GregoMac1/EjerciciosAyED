package ParcialMaclenGregorio;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class Parcial {
	
	public ListaGenerica<String> resolver(Grafo<Datos> mapa) {
		Resultado res = new Resultado();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>(); //camino auxiliar
		
		ListaGenerica<Vertice<Datos>> vertices = mapa.listaDeVertices();
		boolean[] marca = new boolean[vertices.tamanio() + 1]; //arreglo de visitados
				
		Vertice<Datos> ini = null;
		vertices.comenzar();
		while (!vertices.fin() && ini == null) {
			Vertice<Datos> actual = vertices.proximo();
			if (actual.dato().getProfundidad() == 0) //busco el origen
				ini = actual;
		}
		
		if (ini != null) //si encontre el origen, largo el recorrido
			resolver(mapa, ini, camino, res, 0, 1, marca);
		
		return res.getMejorCamino(); //si no encontre ninguno, devuelve la lista vacia
	}
	
	private void resolver(Grafo<Datos> grafo, Vertice<Datos> actual, 
			ListaGenerica<String> camino, Resultado res, int prof, 
			int cant, boolean[] marca) {
		
		marca[actual.getPosicion()] = true;
		camino.agregarFinal(actual.dato().getNombre());
		
		if (grafo.listaDeAdyacentes(actual).esVacia()) { //si el actual no tiene ady, llegue a un destino
			
			prof += actual.dato().getProfundidad();
			int promedio = prof / cant; //calculo el promedio actual
			
			if (promedio > res.getMejorPromedio()) { //si el promedio actual es mejor que el almacenado en res, actualizo
				res.setMejorCamino(camino);
				res.setMejorPromedio(promedio);
			}
		} else {
			ListaGenerica<Arista<Datos>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			cant++;
			while (!ady.fin()) {
				Arista<Datos> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()])
					resolver(grafo, arista.getVerticeDestino(), camino, 
							res, prof + actual.dato().getProfundidad(), 
							cant, marca);
			}
		}
		
		marca[actual.getPosicion()] = false;
		camino.eliminarEn(camino.tamanio());
	}	
}
