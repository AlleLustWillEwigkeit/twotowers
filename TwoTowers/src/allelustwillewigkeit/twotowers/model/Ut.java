package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Ut {
	protected Akadaly akadaly = null;
	protected List<Torony> beregisztraltak = new ArrayList<Torony>();
	protected List<Ut> szomszedok = new ArrayList<Ut>();
	protected PalyaElem palyaElem = null;
	protected int id;

	/**
	 * Az ut konstruktora
	 */
	public Ut(PalyaElem _palyaelem, int _id) {
		this.palyaElem = _palyaelem;
		this.id = _id;
	}

	/**
	 * Void raLep Minden tonyanak szol, hogy tuzeljen a celpontra
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
	 * Void feliratkozik Ha a torony meg nincs alistaban, akkor felveszi oda
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
	 * Void akadalyomLebomlott Az akadalyat torli.
	 */
	public void akadalyomLebomlott() {
		this.akadaly = null;
	}

	/**
	 * Void lerakAkadaly Letrehoz egy uj akadalyt, es felveszi a referenciajat.
	 */
	public void lerakAkadaly(int _id) {
		this.akadaly = new Akadaly(this, _id);
	}

	/**
	 * boolean vanAkadalyRajta Igazzal ter vissza, ha van akadaly rajta,
	 * maskulonben hamissal
	 * 
	 * @return boolean
	 */
	public boolean vanAkadalyRajta() {
		return (this.akadaly != null);
	}

	/**
	 * Akadaly lekerAkadaly Az akadaly referenciajaval ter vissza, vagy nullal,
	 * ha nincs rajta akadaly.
	 * 
	 * @return Akadaly
	 */
	public Akadaly lekerAkadaly() throws NullPointerException {
		if (akadaly != null)
			return this.akadaly;
		else
			throw new NullPointerException("Nincs akadaly az uton! ID:"
					+ palyaElem.lekerID());
	}

	/**
	 * Ut lekerKovUt Az elso nala ismert uttal ter vissza, vagy ha a tarolo
	 * ures, akkor nullal.
	 * 
	 * @return Ut
	 */
	public List<Ut> lekerKovUtak() {
		return szomszedok;
	}

	/**
	 * Void beallitKovUt Hozzaadja a parameterul kapott utat a listahoz, ha meg
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
	 * void akadalySebzes Sebzi a rajta levo akadalyt, ha van.
	 * 
	 * @param int mennyit
	 */
	public void akadalySebzes(float mennyit) {
		if (this.vanAkadalyRajta() && (mennyit > 0))
			this.akadaly.sebzodik(mennyit);
	}

	public PalyaElem lekerPalyaelem() throws NullPointerException {
		if (palyaElem != null)
			return palyaElem;
		throw new NullPointerException(
				"Kellemetlen, de az uthoz nem tartozik palyaelem...ez nem kene tortenjen...");
	}

	public int lekerID() {
		return id;
	}
}
