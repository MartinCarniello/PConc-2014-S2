package ocupantes;

import tablero.Celda;
import tablero.Posicion;

public class Adelante extends Posicion {

	@Override
	public Celda celdaProximaDe(Celda celda) {
		return new Celda(celda.getCoord().deAdelante());
	}

}
