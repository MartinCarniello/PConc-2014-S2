package tablero;

import java.util.Hashtable;

import ocupantes.Participante;

public class Tablero {

	private int dimension = DimensionTablero.TAMANIO;
	private Hashtable<String, Celda> tablero;
	private int tesorosNorte;
	private int tesorosSur;
	
	public Tablero(int cantParticipantes, int cantTesoros) {
		this.tablero = new Hashtable<String, Celda>();
		
		for(int x = 0; x < this.dimension; x++) {
			for(int y = 0; y < this.dimension; y++) {
				Coordenada coord = new Coordenada(x, y);
				String clave = this.convertirCoordenada(x, y);
				this.tablero.put(clave,	new Celda(coord));
			}
		}
		
		this.tesorosNorte = cantTesoros;
		this.tesorosSur = cantTesoros;
		this.generarParticipantes(cantParticipantes);
	}
	
	public String convertirCoordenada(int x, int y) {
		return Integer.toString(x).concat(".").concat(Integer.toString(y));
	}
	
	public Celda buscarCelda(int x, int y) {
		return this.tablero.get(this.convertirCoordenada(x, y));
	}
	
	public void generarParticipantes(int cantParticipantes) {
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < cantParticipantes; i++) {
			Celda celda = new Celda(new Coordenada(x, y));
			new Participante(celda).start();
			x++;
		}
		
		x = 0;
		y = this.dimension - 1;
		
		for(int i = 0; i < cantParticipantes; i++) {
			Celda celda = new Celda(new Coordenada(x, y));
			new Participante(celda).start();
			x++;
		}
	}

	public Celda buscarCeldaEnPosicion(Posicion unaPosicion, Celda celda) {
		return this.tablero.get(unaPosicion.celdaProximaDe(celda).toString());
	}
}
