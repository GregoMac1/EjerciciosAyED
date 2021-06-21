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
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, 
			String ciudad2) { //creo que bien. consultar
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoMin = new ListaEnlazadaGenerica<String>();
		Integer min = Integer.MAX_VALUE;
		ListaGenerica<Vertice<String>> vertices = this.grafo.listaDeVertices();
		Vertice<String> ini = null, fin = null;
		boolean[] marca = new boolean [vertices.tamanio()];
		while (!vertices.fin() && (ini == null || fin == null)) { //chequeo que ambas existan
			Vertice<String> actual = vertices.proximo();
			if (actual.dato().equals(ciudad1))
				ini = actual;
			if (actual.dato().equals(ciudad2))
				fin = actual;
		}
		if (ini != null && fin != null)
			caminoMasCorto(this.grafo, ini.getPosicion(), fin.dato(), 
					camino, caminoMin, 0, min, marca);
		return caminoMin;
	}
	
	private void caminoMasCorto(Grafo<String> grafo, int i, String fin, 
			ListaGenerica<String> camino, ListaGenerica<String> caminoMin, 
			int peso, Integer min, boolean[] marca) {
		marca[i] = true;
		Vertice<String> actual = grafo.vetice(i);
		camino.agregarFinal(actual.dato());
		if (actual.dato().equals(fin)) { //caso base
			if (peso < min) {
				min = peso; //corregir. el valor tiene que ser devuelto
				caminoMin = camino;
			}
		} else {
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()])
					caminoMasCorto(grafo, arista.getVerticeDestino().getPosicion(), fin, 
							camino, caminoMin, peso + arista.peso(), min, marca);
			}
		}		
		marca[i] = false;
		camino.eliminarEn(camino.tamanio()); //no entendi para que
	}

	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, 
			String ciudad2, int tanqueAuto){ //creo que bien. consultar
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoOk = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> vertices = this.grafo.listaDeVertices();
		Vertice<String> ini = null, fin = null;
		boolean[] marca = new boolean [vertices.tamanio()];
		while (!vertices.fin() && (ini == null || fin == null)) {
			Vertice<String> actual = vertices.proximo();
			if (actual.dato().equals(ciudad1))
				ini = actual;
			if (actual.dato().equals(ciudad2))
				fin = actual;
		}
		if (ini != null && fin != null)
			caminoSinCargarCombustible(this.grafo, ini.getPosicion(), fin.dato(), 
					camino, caminoOk, tanqueAuto, marca);
		return caminoOk;
	}
	
	private void caminoSinCargarCombustible(Grafo<String> grafo, int i, String fin, 
			ListaGenerica<String> camino, ListaGenerica<String> caminoOk, int tanqueAuto, 
			boolean[] marca) {
		marca[i] = true;
		Vertice<String> actual = grafo.vetice(i);
		camino.agregarFinal(actual.dato());
		if (actual.dato().equals(fin)) 
			caminoOk = camino;
		else {
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				if (!marca[arista.getVerticeDestino().getPosicion()] && 
						(tanqueAuto - arista.peso() >= 0))
					caminoSinCargarCombustible(grafo, arista.getVerticeDestino().getPosicion(), 
							fin, camino, caminoOk, tanqueAuto - arista.peso(), marca);
			}
		}
		marca[i] = false;
		camino.eliminarEn(camino.tamanio());
	}	
}