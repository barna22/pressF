package proto;

public class Tent extends Item implements Steppable {
	private IceField field;
	
	/*
	 * Fel�p�ti a s�trat azon a j�gt�bl�n, ahol a j�t�kos �ll.
	 */
	public boolean Use(Player p) {
		field = p.GetField();
		//SetTent f�ggv�ny hi�nyzik vagy megv�ltozott a m�k�d�s?
		field.SetTent(this);
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
		//RemoveTent f�ggv�ny hi�nyzik vagy megv�ltozott a m�k�d�s?
		field.RemoveTent();
		field = null;
	}

}
