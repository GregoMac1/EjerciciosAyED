package Grafos;

/**
 * Representa una arista de un {@link Grafo} 
 * 
 * @author juan
 *
 */
public interface Arista<T> {
	
	public Vertice<T> getVerticeDestino();
	public int peso();

}
