package CaminosGrafos;

import ListasGenericas.ListaGenerica;

public class Resultado<T> {
	private int min;
	private ListaGenerica<T> caminoMin;
	private ListaGenerica<ListaGenerica<T>> todosLosCaminos;
	
	public ListaGenerica<T> getCaminoMin() {
		return caminoMin;
	}
	
	public int getMin() {
		return min;
	}
	
	public ListaGenerica<ListaGenerica<T>> getTodosLosCaminos() {
		return todosLosCaminos;
	}
	
	public void setCaminoMin(ListaGenerica<T> caminoMin) {
		this.caminoMin = caminoMin.clonar();
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public void setTodosLosCaminos(ListaGenerica<ListaGenerica<T>> todosLosCaminos) {
		this.todosLosCaminos = todosLosCaminos.clonar();
	}
	
	public void agregarCamino(ListaGenerica<T> camino) {
		todosLosCaminos.agregarFinal(camino.clonar());
	}
	
	public void actualizarValorMin(int min, ListaGenerica<T> caminoMin) {
		this.min = min;
		this.caminoMin = caminoMin.clonar();
	}
}
