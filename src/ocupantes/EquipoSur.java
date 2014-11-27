package ocupantes;

import tablero.Celda;
import tablero.Derecha;
import tablero.Tablero;

public class EquipoSur extends Equipo {

	/*
	@Override
	public int posEnXIzq(Celda celda) {
		return celda.getCoord().getX() - 1;
	}

	@Override
	public int posEnYIzq(Celda celda) {
		return celda.getCoord().getY();
	}

	@Override
	public int posEnYDer(Celda celda) {
		return celda.getCoord().getY();
	}

	@Override
	public int posEnXDer(Celda celda) {
		return celda.getCoord().getX() + 1;
	}

	@Override
	public int posEnXAdelante(Celda celda) {
		return celda.getCoord().getX();
	}
	
	@Override
	public int posEnYAdelante(Celda celda) {
		return celda.getCoord().getY() + 1;
	}
	
	*/
	
	@Override
	public Celda celdaAIzq(Tablero tablero, Celda celda) {
		return tablero.buscarCeldaEnPosicion(new Izquierda(), celda);
	}

	@Override
	public Celda celdaADer(Tablero tablero, Celda celda) {
		return tablero.buscarCeldaEnPosicion(new Derecha(), celda);
	}

	@Override
	public Celda celdaAdelante(Tablero tablero, Celda celda) {
		return tablero.buscarCeldaEnPosicion(new Adelante(), celda);
	}
	
}
