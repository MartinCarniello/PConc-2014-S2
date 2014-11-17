package tablero;

import java.util.Hashtable;

public class Tablero {

	private int dimension = DimensionTablero.TAMANIO;
	private Hashtable<String, Celda> tablero;
	
	public Tablero() {
		this.tablero = new Hashtable<String, Celda>();
		
		for(int x = 0; x < this.dimension; x++) {
			for(int y = 0; y < this.dimension; y++) {
				Coordenada coord = new Coordenada(x, y);
				String clave = this.convertirCoordenada(x, y);
				this.tablero.put(clave,	new Celda(coord));
			}
		}
	}
	
	public String convertirCoordenada(int x, int y) {
		return Integer.toString(x).concat(".").concat(Integer.toString(y));
	}
	
	public Celda buscarCelda(int x, int y) {
		return this.tablero.get(this.convertirCoordenada(x, y));
	}
}
