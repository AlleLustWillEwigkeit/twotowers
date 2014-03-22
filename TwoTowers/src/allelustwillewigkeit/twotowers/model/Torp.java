package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Torp extends Ellenseg {
	public Torp() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Torp");
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezTuzgolyo() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezSzikla() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezNyil() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezDarda() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}
}
