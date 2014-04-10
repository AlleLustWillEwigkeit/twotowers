package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Ut {
	protected Akadaly akadaly = null;
	protected List<Torony> torony = new ArrayList<Torony>();
	protected List<Ut> ut = new ArrayList<Ut>();

	/**
	 * Az út konstruktora
	 */
	public Ut() {
	}

	/**
	 * Void raLep Minden tonyának szól, hogy tüzeljen a célpontra
	 * 
	 * @param Ellenseg
	 *            ellenseg
	 */
	public void raLep(Ellenseg ellenseg) {
		for (Torony t : this.torony) {
			t.tuzel(ellenseg);
		}
	}

	/**
	 * Void feliratkozik Ha a torony még nincs alistában, akkor felveszi oda
	 * 
	 * @param Torony
	 *            torony
	 */
	public void feliratkozik(Torony torony) {
		if (!this.torony.contains(torony)) {
			this.torony.add(torony);
		}
	}

	public void leiratkozik(Torony t) {
		this.torony.remove(torony);
	}

	/**
	 * Void akadalyomLebomlott Az akadályát törli.
	 */
	public void akadalyomLebomlott() {
		this.akadaly = null;
	}

	/**
	 * Void lerakAkadaly Létrehoz egy új akadályt, és felveszi a referenciáját.
	 */
	public void lerakAkadaly() {
		this.akadaly = new Akadaly(this);
	}

	/**
	 * boolean vanAkadalyRajta Igazzal tér vissza, ha van akadály rajta,
	 * máskülönben hamissal
	 * 
	 * @return boolean
	 */
	public boolean vanAkadalyRajta() {
		return (this.akadaly != null);
	}

	/**
	 * Akadaly lekerAkadaly Az akadály referenciájával tér vissza, vagy nullal,
	 * ha nincs rajta akadály.
	 * 
	 * @return Akadaly
	 */
	public Akadaly lekerAkadaly() {
		return this.akadaly;
	}

	/**
	 * Ut lekerKovUt Az első nála ismert úttal tér vissza, vagy ha a tároló
	 * üres, akkor nullal.
	 * 
	 * @return Ut
	 */
	public List<Ut> lekerKovUtak() {
		return ut;
	}

	/**
	 * Void beallitKovUt Hozzáadja a paraméterül kapott utat a listához, ha még
	 * nincs benne.
	 * 
	 * @param ut
	 */
	public void beallitKovUt(Ut ut) {
		if (!this.ut.contains(ut)) {
			this.ut.add(ut);
		}
	}

	/**
	 * void akadalySebzes Sebzi a rajta lévő akadályt, ha van.
	 * 
	 * @param int mennyit
	 */
	public void akadalySebzes(int mennyit) {
		this.akadaly.sebzodik(mennyit);
	}
}
