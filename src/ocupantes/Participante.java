package ocupantes;

import tablero.Celda;
import tablero.DimensionTablero;
import tablero.Tablero;

public class Participante implements Ocupante {
	
	private Celda celdaActual;
	private Equipo equipo;
	private Tablero tablero;
	
	public void setEquipo(Celda celda) {
		if(celda.getCoord().getY() <= (DimensionTablero.TAMANIO / 2)) {
			this.equipo = new EquipoSur();
		} else {
			this.equipo = new EquipoNorte();
		}
	}

	public Participante(Celda celda) {
		this.celdaActual = celda;
		this.setEquipo(celda);
	}

	public void moverseIzq() {
		Celda celdaAMoverse = equipo.celdaAIzq(this.tablero, this.celdaActual); 
		celdaAMoverse.ocuparCasillero(this);
		this.celdaActual = celdaAMoverse;
	}

	public void moverseDer() {
		Celda celdaAMoverse = equipo.celdaADer(this.tablero, this.celdaActual); 
		celdaAMoverse.ocuparCasillero(this);
		this.celdaActual = celdaAMoverse;
	}
	
	public void moverseAdelante() {
		Celda celdaAMoverse = equipo.celdaAdelante(this.tablero, this.celdaActual); 
		celdaAMoverse.ocuparCasillero(this);
		this.celdaActual = celdaAMoverse;
	}
	
}
