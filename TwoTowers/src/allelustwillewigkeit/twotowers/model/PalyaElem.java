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
	 * A palyaelem konstruktora
	 */
	public PalyaElem(int _palyaElemID) {
		this.palyaElemID = _palyaElemID;
	}

	/**
	 * EpitesiTerulet lekerEpitesiTerulet Visszater a rajta levo epitesi terulet
	 * referenciajaval
	 * 
	 * @return EpitesiTerulet
	 */
	public EpitesiTerulet lekerEpitesiTerulet() {

		return this.epitesiTerulet;
	}

	/**
	 * Ut lekerUt Visszater a rajta levo ut referenciajaval
	 * 
	 * @return Ut
	 */
	public Ut lekerUt() {

		return this.ut;
	}

	/**
	 * boolean vanUtja Igazzal ter vissza, ha van rajta ut, kulonben hamissal.
	 * 
	 * @return boolean
	 */
	public boolean vanUtja() {
		return (this.ut != null);
	}

	/**
	 * boolean vanEpitesiTerulete Igazzal ter vissza, ha van rajta epitesi
	 * terulet, kulonben hamissal.
	 * 
	 * @return boolean
	 */
	public boolean vanEpitesiTerulete() {
		return (this.epitesiTerulet != null);
	}

	/**
	 * void beregisztral Minden szomszedjanal rekurzivan beregisztralja a
	 * parameterul kapott tornyot, ha az adott szomszedon van ut. Mindezt a
	 * megadott hatotavig csinalja.
	 * 
	 * @param Torony
	 *            torony
	 * @param int tavolsag
	 */
	public void beregisztral(Torony torony, int tavolsag) {

		if (torony == null)
			return;

		if (tavolsag <= 0)
			return;
		
		if (this.beregisztralt)
			return;
		
		System.out.println("Pe: "+this.palyaElemID+", Tav: "+tavolsag);
		
		this.beregisztralt = true; // Ne kelljen meg egyszer foloslegesen
								   // figyelni ot.

		if (this.vanUtja())
			this.lekerUt().feliratkozik(torony);

		for (PalyaElem pe : szomszedok) {
			pe.beregisztral(torony, tavolsag-1);
		}

		this.beregisztralt = false; // Takaritas, hogy mas is fel tudjon
									// iratkozni hozza.

	}

	/**
	 * void legyelUt Letrehoz egy utat magara.
	 */
	public void legyelUt(int _id) {
		this.ut = new Ut(this, _id);
	}

	/**
	 * void legyelStart Letrehoz egy kezdohelyet magara.
	 */
	public void legyelStart(int _id) {
		this.ut = new Start(this, _id);
	}

	/**
	 * void legyelStart Letrehoz egy kezdohelyet magara.
	 */
	public void legyelVegzetHegye(Jatekmotor _jm, int _id) {
		this.ut = new VegzetHegye(_jm, this, _id);
	}

	/**
	 * void legyelEpitesiTerulet Letrehoz egy epitesi teruletet magara.
	 */
	public void legyelEpitesiTerulet(int _id) {
		this.epitesiTerulet = new EpitesiTerulet(this, _id);
	}

	/**
	 * void addSzomszed Hozzaadja a parameterul kapott szomszedot, ha meg nincs
	 * a listaban.
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
