package p6ej5;

import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;

public class MapaCiudades<T> {
	private GrafoImplListAdy<String> grafo;
	
	public MapaCiudades(GrafoImplListAdy<String> grafo) {
		this.grafo = grafo;
	}
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){ //consultar si esta bien
		boolean[] marca = new boolean[this.grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
		for (int i = 0; i < this.grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i] && this.grafo.listaDeVertices().elemento(i).dato().equals(ciudad1))
				this.devolverCamino(ciudad2, i, this.grafo, lista, marca);
		}
		return lista;
	}
	
	private boolean devolverCamino (String ciudad2, int i, Grafo<String> grafo, ListaGenerica<String> lista, boolean[] marca){
		marca[i] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()){
			int j = ady.proximo().getVerticeDestino().getPosicion();
			if (!marca[j]) {
				if (v.dato().equals(ciudad2) || this.devolverCamino(ciudad2, j, grafo, lista, marca)){
					lista.agregarInicio(v.dato());
					return true;
				}
			}
		}
		return false;
	}
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades){ //consultar si esta bien
		boolean[] marca = new boolean[this.grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
		for (int i = 0; i < this.grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i] && this.grafo.listaDeVertices().elemento(i).dato().equals(ciudad1))
				this.devolverCaminoExceptuando(ciudad2, ciudades, i, this.grafo, lista, marca);
		}
		return lista;
	}
	
	private boolean devolverCaminoExceptuando (String ciudad2, ListaGenerica<String> ciudades, int i, Grafo<String> grafo, ListaGenerica<String> lista, boolean[] marca){
		marca[i] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		for (int j = 0; j < ciudades.tamanio(); j++) {
			if (v.dato().equals(ciudades.elemento(j)))
				return false;
		}
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()){
			int j = ady.proximo().getVerticeDestino().getPosicion();
			if (!marca[j]) {
				if (v.dato().equals(ciudad2) || this.devolverCaminoExceptuando(ciudad2, ciudades, j, grafo, lista, marca)){
					lista.agregarInicio(v.dato());
					return true;
				}
			}
		}
		return false;
	}

	/*public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		boolean[] marca = new boolean[this.grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<String> camino;
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
		int max = -1;
		for (int i = 0; i < this.grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i] && this.grafo.listaDeVertices().elemento(i).dato().equals(ciudad1))
				this.caminoMasCorto(max, ciudad2, i, this.grafo, lista, marca);
		}
		return camino;
	}
	
	private boolean caminoMasCorto(int max, String ciudad2, int i, Grafo<String> grafo, ListaGenerica<String> camino, boolean[] marca) {
		marca[i] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()){
			int j = ady.proximo().getVerticeDestino().getPosicion();
			if (!marca[j]) {
				if (v.dato().equals(ciudad2) || this.caminoMasCorto(max, ciudad2, j, grafo, camino, marca)){
					camino.agregarInicio(v.dato());
					return true;
				}
			}
		}
		return false;
	}	*/
}






















