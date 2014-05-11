package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Ellensegek {
	protected List<Ellenseg> ellensegek = new ArrayList<Ellenseg>();
	protected List<Ellenseg> ujEllensegek = new ArrayList<Ellenseg>();
	protected List<Ellenseg> elmuloEllensegek = new ArrayList<Ellenseg>();
	protected int osszLetszam = 0;
	protected JosagosSzaruman josagosSzaruman = null;
	protected Jatekmotor jatekMotor = null;
	protected Start kezdohely = null;

	/**
	 * Ez ellensegek konstruktora
	 * 
	 * @param Jatekmotor
	 *            _jatekmotor
	 * @param Start
	 *            _start
	 * @param int _osszletszam
	 */
	public Ellensegek(Jatekmotor _jatekmotor, int _osszletszam,
			Start _kezdohely, JosagosSzaruman _szaruman) {
		this.jatekMotor = _jatekmotor;
		this.osszLetszam = _osszletszam;
		this.kezdohely = _kezdohely;
		this.josagosSzaruman = _szaruman;
	}

	/**
	 * void inditEllenseg az adott ellenseget leteszi a kezdohelyre
	 * 
	 * @param int mennyit
	 */
	public void inditEllenseg(Ellenseg e) {
		if (e == null)
			return;

		if (this.osszLetszam <= 0)
			return;

		if (!this.ellensegek.contains(e)) {
			e.beallitUt(kezdohely);
			this.ellensegek.add(e);
			this.osszLetszam--;
		}
	}

	/**
	 * void egyEllensegMeghalt Kiszedi a parameterul kapott ellenseget a
	 * listajabol. Ha elfogyott az osszes, akkor szol a jatekmotornak, hogy
	 * gozelem van.
	 * 
	 * @param ellenseg
	 */
	public void egyEllensegMeghalt(Ellenseg ellenseg) {
		if (ellenseg == null)
			return;

		if (this.ellensegek.contains(ellenseg)) {
			elmuloEllensegek.add(ellenseg);
			this.josagosSzaruman.varazseroNovel(ellenseg.varazseroNovel);
		}

		if ((osszLetszam <= 0)
				&& ((this.ellensegek.size() - elmuloEllensegek.size()) == 0)) {
			this.jatekMotor.gyozelem();
		}
	}

	/**
	 * void mindLep Minden ellensegnek szol, hogy lepjen.
	 */
	public void mindLep() {
		if (!ellensegek.isEmpty()) {
			for (Ellenseg e : this.ellensegek) {
				e.lep();
			}
		}
		ellensegek.addAll(ujEllensegek);
		ujEllensegek.clear();
		ellensegek.removeAll(elmuloEllensegek);
		elmuloEllensegek.clear();
	}

	/**
	 * int lekerHanyEllensegVanMeg Megmondja hany ellenseg spawnolhato meg
	 */
	public int lekerHanyEllensegVanMeg() {
		return osszLetszam;
	}

	/**
	 * void allitHanyEllensegVanMeg Beallitja hany ellenseget spawnoljon meg a
	 * kozeljovoben a jatek.
	 * 
	 * @param: ertek amire allitjuk.
	 */
	public void allitHanyEllensegVanMeg(int ertek) {
		if (ertek < 0)
			return;
		osszLetszam = ertek;
	}

	public void inditEllenseg(int i, int szint, int _id) {
		// TODO EZ KURVASZAR MERT SZeTRANDOMOZZA AMIKOR NEM IS KELLENE
		if (i <= 0)
			return;

		if (this.osszLetszam <= 0)
			return;

		if (this.osszLetszam <= i)
			i = this.osszLetszam;

		for (int x = 0; x < i; x++) {
			Ellenseg e = null;
			int raceRandom = (int) (Math.random() * 4);
			switch (raceRandom) {
			case 0:
				e = new Ember(kezdohely, this, szint, _id++);
				break;
			case 1:
				e = new Torp(kezdohely, this, szint, _id++);
				break;
			case 2:
				e = new Hobbit(kezdohely, this, szint, _id++);
				break;
			case 3:
				e = new Elf(kezdohely, this, szint, _id++);
				break;
			}

			this.ellensegek.add(e);
			this.osszLetszam--;
		}

	}

	public void egyEllensegSzetszakit(Ellenseg ellenseg) {
		if (this.osszLetszam <= 0)
			return;

		try {
			Ellenseg clone = ellenseg.Szetszakit();
			this.ujEllensegek.add(clone);
			this.osszLetszam--;// FIXME Miert?
		} catch (Exception e) {
		}
	}

	public void beallitKezdohely(Start _kezdohely) {
		this.kezdohely = _kezdohely;
	}

	public List<Ellenseg> lekerLista() {
		return ellensegek;
	}

	public int lekerspawnolt() {
		return ellensegek.size();
	}

	public void beallitmotor(Jatekmotor motor) {
		this.jatekMotor = motor;
	}

}
