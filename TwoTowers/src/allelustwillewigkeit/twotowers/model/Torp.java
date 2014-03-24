package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Torp extends Ellenseg {
	/** A torp konstruktora
	 * @param start
	 * @param ellens
	 */
	public Torp(Ut start, Ellensegek ellens) {
		super(start,ellens);
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Torp");
		SkeletonController.tabCsokken();
	}

	/** void sebezTuzgolyo
	 * Sebzi magat a megfelelo metrekben
	 */
	@Override
	public void sebezTuzgolyo() {
		SkeletonController.tabNo();
		if(this.ellensegek != null){
			if (SkeletonController
					.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
				this.ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Torp vagyok. Eltalalt egy Tuzgolyo.");
		}
		SkeletonController.tabCsokken();
	}

	/** void sebezSzikla
	 * Sebzi magat a megfelelo metrekben
	 */
	@Override
	public void sebezSzikla() {
		SkeletonController.tabNo();
		if(this.ellensegek != null){
			if (SkeletonController
					.kerdezIH("Torp vagyok. Eltalalt egy Szikla. Meghaltam?")) {
				this.ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Torp vagyok. Eltalalt egy Szikla.");
		}
		SkeletonController.tabCsokken();
	}

	/** void sebezNyil
	 * Sebzi magat a megfelelo metrekben
	 */
	@Override
	public void sebezNyil() {
		SkeletonController.tabNo();
		if(this.ellensegek != null){
			if (SkeletonController
					.kerdezIH("Torp vagyok. Eltalalt egy Nyil. Meghaltam?")) {
				this.ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Torp vagyok. Eltalalt egy Nyil.");
		}
		SkeletonController.tabCsokken();
	}

	/** void sebezDarda
	 * Sebzi magat a megfelelo metrekben
	 */
	@Override
	public void sebezDarda() {
		SkeletonController.tabNo();
		if(this.ellensegek != null){
			if (SkeletonController
					.kerdezIH("Torp vagyok. Eltalalt egy Darda. Meghaltam?")) {
				this.ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Torp vagyok. Eltalalt egy Darda.");
		}
		SkeletonController.tabCsokken();
	}
}
