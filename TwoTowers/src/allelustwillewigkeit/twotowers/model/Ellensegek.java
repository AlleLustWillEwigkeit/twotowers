package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Ellensegek {
	protected List<Ellenseg> ellensegek = new ArrayList<Ellenseg>();
	protected int osszLetszam = 0;
	protected JosagosSzaruman josagosSzaruman = null;
	protected Jatekmotor jatekMotor = null;
	protected Start kezdohely = null;

	/**
	 * Ez ellenségek konstruktora
	 * 
	 * @param Jatekmotor
	 *            _jatekmotor
	 * @param Start
	 *            _start
	 * @param int _osszletszam
	 */
	public Ellensegek(Jatekmotor _jatekmotor, Start _kezdohely, int _osszletszam) {
		this.kezdohely = _kezdohely;
		this.jatekMotor = _jatekmotor;
		this.osszLetszam = _osszletszam;
	}

	public Ellensegek(Jatekmotor jm, Start st) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * void inditEllenseg az adott ellenséget leteszi a kezdőhelyre
	 * 
	 * @param int mennyit
	 */
	public void inditEllenseg(Ellenseg e) {
		e.beallitUt(kezdohely);
	}

	/**
	 * void egyEllensegMeghalt Kiszedi a paraméterül kapott ellenséget a
	 * listájából. Ha elfogyott az összes, akkor szól a játékmotornak, hogy
	 * gőzelem van.
	 * 
	 * @param ellenseg
	 */
	public void egyEllensegMeghalt(Ellenseg ellenseg) {
		if (this.ellensegek.contains(ellenseg)) {
			this.ellensegek.remove(ellenseg);
			osszLetszam--;
		}

		if (osszLetszam == 0) {
			this.jatekMotor.gyozelem();
		}
	}

	/**
	 * void mindLep Minden ellenségnek szól, hogy lépjen.
	 */
	public void mindLep() {
		for (Ellenseg e : this.ellensegek) {
			e.lep();
		}
	}

	/**
	 * int lekerHanyEllensegVanMeg Megmondja hány ellenség spawnolható még
	 */
	public int lekerHanyEllensegVanMeg() {
		return osszLetszam;
	}

	/**
	 * void allitHanyEllensegVanMeg Beállítja hány ellenséget spawnoljon még a
	 * közeljövőben a játék.
	 * 
	 * @param: ertek amire állítjuk.
	 */
	public void allitHanyEllensegVanMeg(int ertek) {
		osszLetszam = ertek;
	}

	public void inditEllenseg(int i) {
		// TODO Auto-generated method stub
		
	}
}
