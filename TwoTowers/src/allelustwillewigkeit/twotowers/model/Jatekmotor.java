package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Jatekmotor {
	public Ellensegek ellensegek = null;
	public Program progrgam = null;
	public Palya palya = null;
	public JosagosSzaruman josagosSzaruman = null;
	public HashSet<Varazsko> kavicsok = new HashSet<Varazsko>();

	/** A játékmotor konstruktora
	 * @param JosagosSzaruman jsz
	 */
	public Jatekmotor(JosagosSzaruman jsz) {
		super();
		SkeletonController.tabNo();
		this.josagosSzaruman = jsz;
		SkeletonController.println("<<create>> JatekMotor");
		SkeletonController.tabCsokken();
	}

	/** void tick
	 * Szimulál egy időegységet.
	 */
	public void tick() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}

	/** void lerakTornyot
	 * Lerak egy tornyot egy adott pályaelemre.
	 * @param PalyaElem hova
	 */
	public void lerakTornyot(PalyaElem hova) {
		SkeletonController.tabNo();
		hova.lekerEpitesiTerulet().lerakTornyot();
		SkeletonController.tabCsokken();
	}

	/** void lerakAkadaly
	 * Lerak egy akadályt egy adott pályaelemre.
	 * @param PalyaElem hova
	 */
	public void lerakAkadaly(PalyaElem hova) {
		SkeletonController.tabNo();
		hova.lekerUt().lerakAkadaly();
		SkeletonController.tabCsokken();
	}

	/** void felkovez
	 * Az adott pályaelem-nek szól, hogy kövezze fel a rajta lévő tornyot, vagy akadályt.
	 * @param PalyaElem mit
	 */
	public void felkovez(PalyaElem mit) {
		SkeletonController.tabNo();
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
		SkeletonController.tabCsokken();
	}

	/** void ujJatek
	 * Új játékot indít
	 */
	public void ujJatek() {
		SkeletonController.tabNo();
		/*this.palya = new Palya();
		this.palya.ujPalya();
		this.josagosSzaruman = new JosagosSzaruman();
		Start st = new Start();
		Ellensegek e = new Ellensegek(this,st);
		int i = 3;
		while (i-- != 0) {
			tick();
		}*/
		SkeletonController.tabCsokken();
	}

	/** void vereseg
	 * Vereség történt.
	 */
	public void vereseg() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}

	/** void gyozelem
	 * Győzelem történt.
	 */
	public void gyozelem() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}
}
