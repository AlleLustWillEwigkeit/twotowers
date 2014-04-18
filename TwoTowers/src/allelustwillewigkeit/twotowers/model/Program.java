package allelustwillewigkeit.twotowers.model;

public class Program {
	protected Jatekmotor jatekmotor = null;

	/**
	 * A program konstruktora
	 */
	public Program() {
		jatekmotor = new Jatekmotor(new Ellensegek(jatekmotor, new Start(),
				1000), new JosagosSzaruman(1000), new Palya(), this);
	}

	/**
	 * void ujJatek Új játékot indít
	 */
	public void ujJatek() {
	}

	/**
	 * static void main Itt van a program induló pontja
	 */
	public static void main() {
	}
}
