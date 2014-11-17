package ocupantes;

import tablero.Celda;
import tablero.Tablero;

public abstract class Equipo {

	public Celda celdaAIzq(Tablero tablero, Celda celda) {
		return tablero.buscarCelda(this.posEnXIzq(celda), this.posEnYIzq(celda));
	}

	public Celda celdaADer(Tablero tablero, Celda celda) {
		return tablero.buscarCelda(this.posEnXDer(celda), this.posEnYDer(celda));	
	}
	
	public Celda celdaAdelante(Tablero tablero, Celda celda) {
		return tablero.buscarCelda(this.posEnXAdelante(celda), this.posEnYAdelante(celda));
	}
	
	public abstract int posEnXIzq(Celda celda);
	
	public abstract int posEnYIzq(Celda celda);
	
	public abstract int posEnYDer(Celda celda);
	
	public abstract int posEnXDer(Celda celda);
	
	public abstract int posEnXAdelante(Celda celda);
	
	public abstract int posEnYAdelante(Celda celda);
}
