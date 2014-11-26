package ocupantes;

import java.util.List;

import movimientos.Movimiento;

import tablero.Celda;
import tablero.DimensionTablero;
import tablero.Tablero;

public class Participante extends Thread implements Ocupante {
	
	private Celda celdaActual;
	private Equipo equipo;
	private Tablero tablero;
	private List<Movimiento> movimientos;
	
	public Equipo getEquipo() {
		return this.equipo;
	}
	
	public Tablero getTablero() {
		return this.tablero;
	}
	
	public Celda getCeldaActual() {
		return this.celdaActual;
	}
	
	public void setCeldaActual(Celda celda) {
		this.celdaActual = celda;
	}
	
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
	
	public void run() {
		for(Movimiento movimiento : this.movimientos) {
			movimiento.mover();

//			double random = Math.random() * 2000;
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
