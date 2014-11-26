package movimientos;

import ocupantes.Participante;
import tablero.Celda;

public abstract class Movimiento {
	private Participante participante;
	
	public Participante getParticipante() {
		return this.participante;
	}
	
	public Movimiento(Participante participante) {
		this.participante = participante;
	}
	
	public void mover() {
		Celda celdaAMoverse = this.celdaAMoverse();
		// Si hay tesoro propio => No me puedo mover
		// Si esta en el borde => No me puedo mover
		// Si termino el juego => No me puedo mover
		this.ocuparCasilleroCorrecto(celdaAMoverse);
		this.getParticipante().setCeldaActual(celdaAMoverse);
		// Chequear si hay tesoro enemigo => Agarrarlo
		// Chequear si termino el juego
	}
	
	public abstract Celda celdaAMoverse();
	
	public abstract void ocuparCasilleroCorrecto(Celda celda);
}
