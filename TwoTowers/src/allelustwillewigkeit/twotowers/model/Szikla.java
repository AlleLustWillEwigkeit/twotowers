package allelustwillewigkeit.twotowers.model;

public class Szikla extends Lovedek {
	public Szikla() {
		super();
	}

	@Override
	public void megLo(Ellenseg kit) {
		kit.sebezSzikla();
	}
}
