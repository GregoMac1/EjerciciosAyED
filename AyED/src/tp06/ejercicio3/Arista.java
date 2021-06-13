package tp06.ejercicio3;

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
