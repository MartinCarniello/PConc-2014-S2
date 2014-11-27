package tablero;

public class Derecha extends Posicion{

	@Override
	public Celda celdaProximaDe(Celda celda) {
		return new Celda(celda.getCoord().deLaDerecha());
	}
	
}
