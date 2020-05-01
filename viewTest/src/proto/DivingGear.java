package proto;


/*
 * A játékos túlél a vízben is kör végén, ha van neki, illetve ki tud jutni a vízbõl.
 */
public class DivingGear extends Item {
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(DivingGear d) {
		return true;
	}
	
	/*
	 * Ugyanazt csinálja, mint az Item, csak pluszba beállítja a
	 * játékoson a hasDivingGear-t.
	 */
	public boolean Equip(Player p) {
		boolean success;
		 success = p.AddItem(this);
		if(success)
			p.SetHasDivingGear(true);
		return success;
	}
}
