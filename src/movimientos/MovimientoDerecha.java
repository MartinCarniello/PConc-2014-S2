package movimientos;

import ocupantes.Participante;
import tablero.Celda;

public class MovimientoDerecha extends Movimiento {

	public MovimientoDerecha(Participante participante) {
		super(participante);
	}

	public Celda celdaAMoverse() {
		return this.getParticipante().getEquipo().celdaADer(
				this.getParticipante().getTablero(),
				this.getParticipante().getCeldaActual());
	}
	
	public void ocuparCasilleroCorrecto(Celda celda) {
		celda.ocuparCasilleroLateral(this.getParticipante());
	}

}
