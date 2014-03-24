package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ut {
	public Akadaly akadaly = null;
	public List<Torony> torony = new ArrayList<Torony>();
	public List<Ut> ut = new ArrayList<Ut>();

	/**
	 * Az ut konstruktora
	 */
	public Ut() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Ut");
		SkeletonController.tabCsokken();
	}

	/** Void raLep
	 * Minden tonyanak szol, hogy tuzeljen a celpontra
	 * @param Ellenseg ellenseg
	 */
	public void raLep(Ellenseg ellenseg) {
		SkeletonController.tabNo();
		for (Torony t : this.torony) {
			t.tuzel(ellenseg);
		}
		SkeletonController.tabCsokken();
	}

	/** Void feliratkozik
	 * Ha a torony meg nincs alistaban, akkor felveszi oda
	 * @param Torony torony
	 */
	public void feliratkozik(Torony torony) {
		SkeletonController.tabNo();
		if( !this.torony.contains(torony)){
			this.torony.add(torony);
		}
		SkeletonController.tabCsokken();
	}

	/** Void akadalyomLebomlott
	 *  Az akadalyat torli.
	 */
	public void akadalyomLebomlott() {
		SkeletonController.tabNo();
		this.akadaly = null;
		SkeletonController.tabCsokken();
	}

	/** Void lerakAkadaly
	 * Letrehoz egy uj akadalyt, es felveszi a referenciajat.
	 */
	public void lerakAkadaly() {
		SkeletonController.tabNo();
		this.akadaly = new Akadaly(this);
		SkeletonController.tabCsokken();
	}

	/** boolean vanAkadalyRajta
	 * Igazzal ter vissza, ha van akadaly rajta, maskulonben hamissal
	 * @return boolean
	 */
	public boolean vanAkadalyRajta() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return (this.akadaly != null);
	}

	/** Akadaly lekerAkadaly
	 * Az akadaly referenciajaval ter vissza, vagy nullal, ha nincs rajta akadaly.
	 * @return Akadaly
	 */
	public Akadaly lekerAkadaly() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.akadaly; 
	}

	/** Ut lekerKovUt
	 * Az elso nala ismert uttal ter vissza, vagy ha a tarolo ures, akkor nullal.
	 * @return Ut
	 */
	public Ut lekerKovUt() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		if(this.ut.isEmpty())
			return null;
		else
			return this.ut.get(0);
	}

	/** Void beallitKovUt
	 * Hozzaadja a parameterul kapott utat a listahoz, ha meg nincs benne.
	 * @param ut
	 */
	public void beallitKovUt(Ut ut) {
		SkeletonController.tabNo();
		if( !this.ut.contains(ut)){
			this.ut.add(ut);
		}
		SkeletonController.tabCsokken();
	}

	/** void akadalySebzes
	 * Sebzi a rajta levo akadalyt, ha van.
	 * @param int mennyit
	 */
	public void akadalySebzes(int mennyit) {
		SkeletonController.tabNo();
		if (this.vanAkadalyRajta()) 
			this.lekerAkadaly().sebzodik(mennyit);
		SkeletonController.tabCsokken();
	}
}
