package proto;

public class Tent extends Item implements Steppable {
	private IceField field;
	
	/*
	 * Felépíti a sátrat azon a jégtáblán, ahol a játékos áll.
	 */
	public boolean Use(Player p) {
		field = p.GetField();
		//SetTent függvény hiányzik vagy megváltozott a mûködés?
		field.SetTent(this);
		return true;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Tent t) {
		return true;
	}

	/*
	 * Lerombolja a sátrat, ha fel van építve egy IceField-en.
	 */
	@Override
	public void Step() {
		//RemoveTent függvény hiányzik vagy megváltozott a mûködés?
		field.RemoveTent();
		field = null;
	}

}
