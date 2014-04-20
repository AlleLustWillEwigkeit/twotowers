package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class PalyaElem {
	protected EpitesiTerulet epitesiTerulet = null;
	protected List<PalyaElem> szomszedok = new ArrayList<PalyaElem>();
	protected boolean beregisztralt = false;
	protected Ut ut = null;
	protected int palyaElemID;

	/**
	 * A pályaelem konstruktora
	 */
	public PalyaElem(int _palyaElemID) {
		this.palyaElemID = _palyaElemID;
	}

	/**
	 * EpitesiTerulet lekerEpitesiTerulet Visszatér a rajta lévő építési terület
	 * referenciájával
	 * 
	 * @return EpitesiTerulet
	 */
	public EpitesiTerulet lekerEpitesiTerulet() throws NullPointerException {
		if (epitesiTerulet != null)
			return this.epitesiTerulet;
		else
			throw new NullPointerException(
					"Nincs építési terület a pályaelemen! ID:" + palyaElemID);
	}

	/**
	 * Ut lekerUt Visszatér a rajta lévő út referenciájával
	 * 
	 * @return Ut
	 */
	public Ut lekerUt() throws NullPointerException {
		if (ut != null)
			return this.ut;
		else
			throw new NullPointerException("Nincs út a pályaelemen! ID:"
					+ palyaElemID);
	}

	/**
	 * boolean vanUtja Igazzal tér vissza, ha van rajta út, különben hamissal.
	 * 
	 * @return boolean
	 */
	public boolean vanUtja() {
		return (this.ut != null);
	}

	/**
	 * boolean vanEpitesiTerulete Igazzal tér vissza, ha van rajta építési
	 * terület, különben hamissal.
	 * 
	 * @return boolean
	 */
	public boolean vanEpitesiTerulete() {
		return (this.epitesiTerulet != null);
	}

	/**
	 * void beregisztral Minden szomszédjánál rekurzívan beregisztrálja a
	 * paraméterül kapott tornyot, ha az adott szomszédon van út. Mindezt a
	 * megadott hatótávig csinálja.
	 * 
	 * @param Torony
	 *            torony
	 * @param int tavolsag
	 */
	public void beregisztral(Torony torony, int tavolsag) {

		if (torony == null)
			return;

		if (this.beregisztralt)
			return;

		if (tavolsag == 0)
			return;

		if (this.vanUtja() == true)
			this.lekerUt().feliratkozik(torony);

		this.beregisztralt = true; // Ne kelljen még egyszer fölöslegesen
									// figyelni őt.

		for (PalyaElem pe : szomszedok) {
			pe.beregisztral(torony, tavolsag--);
		}

		this.beregisztralt = false; // Takarítás, hogy más is fel tudjon
									// iratkozni hozzá.

	}

	/**
	 * void legyelUt Létrehoz egy utat magára.
	 */
	public void legyelUt() {
		this.ut = new Ut(this);
	}

	/**
	 * void legyelStart Létrehoz egy kezdőhelyet magára.
	 */
	public void legyelStart() {
		this.ut = new Start(this);
	}

	/**
	 * void legyelStart Létrehoz egy kezdőhelyet magára.
	 */
	public void legyelVegzetHegye(Jatekmotor _jm) {
		this.ut = new VegzetHegye(_jm, this);
	}

	/**
	 * void legyelEpitesiTerulet Létrehoz egy építési területet magára.
	 */
	public void legyelEpitesiTerulet() {
		this.epitesiTerulet = new EpitesiTerulet(this);
	}

	/**
	 * void addSzomszed Hozzáadja a paraméterül kapott szomszédot, ha még nincs
	 * a listában.
	 * 
	 * @param PalyaElem
	 *            sz
	 */
	public void addSzomszed(PalyaElem sz) {
		if (!this.szomszedok.contains(sz)) {
			this.szomszedok.add(sz);
			sz.addSzomszed(this);
		}
	}

	public List<PalyaElem> lekerSzomszedok() {
		return szomszedok;
	}

	public void tick() {
		if (this.vanEpitesiTerulete()) {
			EpitesiTerulet e = this.lekerEpitesiTerulet();
			if (e.vanToronyRajta()) {
				Torony t = e.lekerTorony();
				t.tick();
			}
		}

		if (this.vanUtja()) {
			Ut u = this.lekerUt();
			if (u.vanAkadalyRajta()) {
				Akadaly a = u.lekerAkadaly();
				a.tick();
			}
		}
	}

	public int lekerID() {
		return palyaElemID;
	}
}
