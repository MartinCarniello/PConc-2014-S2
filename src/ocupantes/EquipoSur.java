package ocupantes;

import tablero.Celda;

public class EquipoSur extends Equipo {

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
}
