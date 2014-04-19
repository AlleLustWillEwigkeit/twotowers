package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Ut {
	protected Akadaly akadaly = null;
	protected List<Torony> beregisztraltak = new ArrayList<Torony>();
	protected List<Ut> szomszedok = new ArrayList<Ut>();

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
		for (Torony t : this.beregisztraltak) {
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
		if (torony == null)
			return;

		if (!this.beregisztraltak.contains(torony)) {
			this.beregisztraltak.add(torony);
			torony.utBeregisztralt(this);
		}
	}

	public void leiratkozik(Torony t) {
		if (t == null)
			return;

		if (this.beregisztraltak.contains(t))
			this.beregisztraltak.remove(t);
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
		return szomszedok;
	}

	/**
	 * Void beallitKovUt Hozzáadja a paraméterül kapott utat a listához, ha még
	 * nincs benne.
	 * 
	 * @param ut
	 */
	public void beallitKovUt(Ut ut) {
		if (ut == null)
			return;

		if (!this.szomszedok.contains(ut)) {
			this.szomszedok.add(ut);
		}
	}

	/**
	 * void akadalySebzes Sebzi a rajta lévő akadályt, ha van.
	 * 
	 * @param int mennyit
	 */
	public void akadalySebzes(float mennyit) {
		if (this.vanAkadalyRajta() && (mennyit > 0))
			this.akadaly.sebzodik(mennyit);
	}
}
