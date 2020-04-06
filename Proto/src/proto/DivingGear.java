package proto;


/*
 * A játékos túlél a vízben is kör végén, ha van neki, illetve ki tud jutni a vízbõl.
 */
public class DivingGear extends Item {
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(DivingGear d) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(d) + ")");
		return true;
	}
	
	/*
	 * Ugyanazt csinálja, mint az Item, csak pluszba beállítja a
	 * játékoson a hasDivingGear-t.
	 */
	public boolean Equip(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Equip(" + Skeleton.GetName(p) + ")");
		boolean result;
		MethodPrinter.IncreaseIndentation();
		result =  p.AddItem(this);
		if(result)
			p.SetHasDivingGear();
		MethodPrinter.DecreaseIndentation();
		return result;
	}
}
