package tablero;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import ocupantes.Ocupante;

public class Celda {
	
	private Lock lock = new ReentrantLock();
	private Condition ocupado = lock.newCondition();
	private Condition puedeMoverAdelante = lock.newCondition();
	private Coordenada coord;
	private boolean estaLibre;
	private Ocupante ocupante;
	
	public Coordenada getCoord() {
		return coord;
	}
	
	@Override
	public String toString(){
		return this.coord.toString();
	}

	public void setCoord(Coordenada coord) {
		this.coord = coord;
	}

	public boolean isEstaLibre() {
		return estaLibre;
	}

	public void setEstaLibre(boolean estaLibre) {
		this.estaLibre = estaLibre;
	}

	public Celda(Coordenada coord) {
		this.setCoord(coord);
		this.setEstaLibre(true);
	}
	
	public boolean esBorde() {
		return this.coord.esBorde();
	}
	
	public void ocuparCasilleroAdelante(Ocupante ocupante) {
		lock.lock();
		
		while(!this.estaLibre && !hayParticipantesEnLindantes()) {
			try {
				this.puedeMoverAdelante.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				this.ocupado.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.ocupante = ocupante;
		
		lock.unlock();
	}

	public void ocuparCasilleroLateral(Ocupante ocupante){
		lock.lock();
		
		while(!this.estaLibre)
			try {
				this.ocupado.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		this.ocupante = ocupante;
		
		lock.unlock();
	}

	public void liberarCasillero(){
		this.estaLibre = true;
		this.ocupado.signal();		
		this.puedeMoverAdelante.signalAll();
	}
	
	public boolean hayParticipantesEnLindantes() {
		return false;
	}
}
