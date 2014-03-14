package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Elf extends Ellenseg {
	public Elf() {
		super();
	}

	@Override
	public void sebezNyil() {
		if (SkeletonController
				.kerdezIH("Tunde vagyok. Eltalalt egy Nyil. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezTuzgolyo() {
		if (SkeletonController
				.kerdezIH("Tunde vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezDarda() {
		if (SkeletonController
				.kerdezIH("Tunde vagyok. Eltalalt egy Darda. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezSzikla() {
		if (SkeletonController
				.kerdezIH("Tunde vagyok. Eltalalt egy Szikla. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}
}
