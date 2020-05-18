package graphic;

public class Tent extends Item implements Steppable {
	private IceField field;
	
	/*
	 * Felépíti a sátrat azon a jégtáblán, ahol a játékos áll.
	 */
	public boolean Use(Player p) {
		field = p.GetField();
		field.SetTent(this);
		p.RemoveItem(this);
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
		field.RemoveTent();
		field = null;
	}

}
