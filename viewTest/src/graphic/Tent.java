package graphic;

public class Tent extends Item implements Steppable {
	private IceField field;
	private Game game;
	
	/*
	 * Fel�p�ti a s�trat azon a j�gt�bl�n, ahol a j�t�kos �ll.
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
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Tent t) {
		return true;
	}

	/*
	 * Lerombolja a s�trat, ha fel van �p�tve egy IceField-en.
	 */
	@Override
	public void Step() {
		field.RemoveTent();
		game.RemoveSteppable(this);
		game = null;
		field = null;
	}

}
