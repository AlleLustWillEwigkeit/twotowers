package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Tunde extends Ellenseg {
	/** A tünde konstruktora
	 * @param start
	 * @param ellens
	 */
	public Tunde(Ut start, Ellensegek ellens) {
		super(start,ellens);
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Elf");
		SkeletonController.tabCsokken();
	}

	/** void sebezNyil
	 * Sebzi magát a megfelelő métrékben
	 */
	@Override
	public void sebezNyil() {
		SkeletonController.tabNo();
		if(this.ellensegek != null){
			if (SkeletonController
					.kerdezIH("Tunde vagyok. Eltalalt egy Nyil. Meghaltam?")) {
				this.ellensegek.egyEllensegMeghalt(this);
			}
		}
		else{
			SkeletonController.println("Tunde vagyok. Eltalalt egy Nyil.");
		}

		SkeletonController.tabCsokken();
	}

	/** void sebezTuzgolyo
	 * Sebzi magát a megfelelő métrékben
	 */
	@Override
	public void sebezTuzgolyo() {
		SkeletonController.tabNo();
		if(this.ellensegek != null){
			if (SkeletonController
					.kerdezIH("Tunde vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
				this.ellensegek.egyEllensegMeghalt(this);
			}
		}
		else{
			SkeletonController.println("Tunde vagyok. Eltalalt egy Tuzgolyo.");
		}
		SkeletonController.tabCsokken();
	}

	/** void sebezDarda
	 * Sebzi magát a megfelelő métrékben
	 */
	@Override
	public void sebezDarda() {
		SkeletonController.tabNo();
		if(this.ellensegek != null){
			if (SkeletonController
					.kerdezIH("Tunde vagyok. Eltalalt egy Darda. Meghaltam?")) {
				this.ellensegek.egyEllensegMeghalt(this);
			}
		}
		else{
			SkeletonController.println("Tunde vagyok. Eltalalt egy Darda.");
		}
		
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezSzikla() {
		SkeletonController.tabNo();
		if(this.ellensegek != null){
			if (SkeletonController
					.kerdezIH("Tunde vagyok. Eltalalt egy Szikla. Meghaltam?")) {
				this.ellensegek.egyEllensegMeghalt(this);
			}
		}
		else{
			SkeletonController.println("Tunde vagyok. Eltalalt egy Szikla.");
		}
		SkeletonController.tabCsokken();
	}
}
