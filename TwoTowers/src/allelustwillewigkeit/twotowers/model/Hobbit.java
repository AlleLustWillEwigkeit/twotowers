package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Hobbit extends Ellenseg {
	public Hobbit() {
		super();
	}

	@Override
	public void sebezNyil() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Hobbit vagyok. Eltalalt egy Nyil. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezSzikla() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Hobbit vagyok. Eltalalt egy Szikla. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezTuzgolyo() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Hobbit vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezDarda() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Hobbit vagyok. Eltalalt egy Darda. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}
}
