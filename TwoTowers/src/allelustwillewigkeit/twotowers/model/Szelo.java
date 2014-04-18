package allelustwillewigkeit.twotowers.model;

public class Szelo extends Lovedek{
	
	public Szelo(){
		
	}
	
	/**
	 * void megLo Meglövi az ellenfelet.
	 * 
	 * @param Ellenseg
	 *            kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		kit.sebezSzelo();
	}
}
