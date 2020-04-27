package proto;


/*
 * A j�t�kos t�l�l a v�zben is k�r v�g�n, ha van neki, illetve ki tud jutni a v�zb�l.
 */
public class DivingGear extends Item {
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(DivingGear d) {
		return true;
	}
	
	/*
	 * Ugyanazt csin�lja, mint az Item, csak pluszba be�ll�tja a
	 * j�t�koson a hasDivingGear-t.
	 */
	public boolean Equip(Player p) {
		boolean success;
		 success = p.AddItem(this);
		if(success)
			p.SetHasDivingGear(true);
		return success;
	}
}
