package graphic;

public class Tent extends Item implements Steppable {
	private IceField field;
	
	/*
	 * Fel�p�ti a s�trat azon a j�gt�bl�n, ahol a j�t�kos �ll.
	 */
	public boolean Use(Player p) {
		field = p.GetField();
		field.SetTent(this);
		p.RemoveItem(this);
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
		field = null;
	}

}
