package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Elf extends Ellenseg {
	public Elf() {
		super();
	}

	@Override
	public void sebezNyil() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Tunde vagyok. Eltalalt egy Nyil. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}

		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezTuzgolyo() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Tunde vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezDarda() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Tunde vagyok. Eltalalt egy Darda. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezSzikla() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Tunde vagyok. Eltalalt egy Szikla. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}
}
