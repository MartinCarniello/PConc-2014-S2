package ocupantes;

import tablero.Celda;
import tablero.Posicion;

public class Izquierda extends Posicion {

	@Override
	public Celda celdaProximaDe(Celda celda) {
		return new Celda(celda.getCoord().deLaIzquierda());
	}

}
