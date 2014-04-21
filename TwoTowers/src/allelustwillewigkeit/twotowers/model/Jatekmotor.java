package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Jatekmotor {
	protected Ellensegek ellensegek = null;
	protected Program program = null;
	protected Palya palya = null;
	protected JosagosSzaruman josagosSzaruman = null;
	protected List<Varazsko> kavicsok = new ArrayList<Varazsko>();
	// TODO: ez itt minek? Neki kell tudnia a lehetséges kő összeállításokról?
	// Nem a JSZ-nek?
	protected int jatekallas = 0;

	/**
	 * A játékmotor konstruktora
	 * 
	 * @param JosagosSzaruman
	 *            jsz
	 */
	public Jatekmotor(Ellensegek _ellensegek, JosagosSzaruman _josagosSzaruman,
			Palya _palya, Program _program) {
		this.josagosSzaruman = _josagosSzaruman;
		this.palya = _palya;
		this.program = _program;
		this.ellensegek = _ellensegek;
		this.jatekallas = 0;
	}

	/**
	 * void tick Szimulál egy időegységet.
	 */
	public void tick() {
		this.ellensegek.mindLep();
		this.palya.tick();
	}

	/**
	 * void lerakTornyot Lerak egy tornyot egy adott pályaelemre.
	 * 
	 * @param PalyaElem
	 *            hova
	 */
	public void lerakTornyot(PalyaElem hova, int _id) {
		hova.lekerEpitesiTerulet().lerakTornyot(_id);
	}

	/**
	 * void lerakAkadaly Lerak egy akadályt egy adott pályaelemre.
	 * 
	 * @param PalyaElem
	 *            hova
	 */
	public void lerakAkadaly(PalyaElem hova, int _id) {
		hova.lekerUt().lerakAkadaly(_id);
	}

	/**
	 * void felkovez Az adott pályaelem-nek szól, hogy kövezze fel a rajta lévő
	 * tornyot, vagy akadályt.
	 * 
	 * @param PalyaElem
	 *            mit
	 */
	public void felkovez(PalyaElem mit) {
		Varazsko v = josagosSzaruman.lekerKivalasztottVarazsko();
		if (mit.vanEpitesiTerulete()) {
			EpitesiTerulet et = mit.lekerEpitesiTerulet();
			if (et.vanToronyRajta()) {
				Torony t = et.lekerTorony();
				t.felkovez(v);
			}
		}
		if (mit.vanUtja()) {
			Ut u = mit.lekerUt();
			if (u.vanAkadalyRajta()) {
				Akadaly a = u.lekerAkadaly();
				a.felkovez(v);
			}
		}
	}

	/**
	 * void ujJatek Új játékot indít
	 */
	public void ujJatek() { // TODO: ez valószínűleg nem jó implementáció...
							// While ciklus a modelben????
		// this.palya = new Palya();
		// this.palya.ujPalya();
		// this.josagosSzaruman = new JosagosSzaruman(1000);
		// Start st = new Start();
		// this.ellensegek = new Ellensegek(this, st, 1000);
		// while (jatekallas == 0) {
		// tick();
		// }
		// if (jatekallas < 0) {
		// System.out.println("Vereség!");
		// System.exit(0);
		// } else if (jatekallas > 0) {
		// System.out.println("Győzelem!");
		// System.exit(0);
		// }
	}

	/**
	 * void vereseg Vereség történt.
	 */
	public void vereseg() {
		jatekallas = -666;
	}

	/**
	 * void gyozelem Győzelem történt.
	 */
	public void gyozelem() {
		jatekallas = 1337;
	}

	/** int lekerallapot: visszatér a játék állapotával **/
	public int lekerallapot() {
		return jatekallas;
	}

	public void beallitellen(Ellensegek ellen) {
		this.ellensegek = ellen;
	}

}
