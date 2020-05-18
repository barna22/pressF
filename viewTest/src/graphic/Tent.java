package graphic;

public class Tent extends Item implements Steppable {
	private IceField field;
	private Game game;
	
	/*
	 * Felépíti a sátrat azon a jégtáblán, ahol a játékos áll.
	 */
	public boolean Use(Player p) {
		field = p.GetField();
		field.SetTent(this);
		p.GetGame().AddSteppable(this);
		p.RemoveItem(this);
		game = p.GetGame();
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
		game.RemoveSteppable(this);
		game = null;
		field = null;
	}

}
