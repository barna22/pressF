package szkeleton;


/*
 * Havat lehet vele eltakarítani a jégmezõrõl.
 */
public class Shovel extends Item {
	
	/*
	 * Két egységnyi hóréteget takarít el a jégmezõrõl, ahol a
	 * használója áll.
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Use(" + Skeleton.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		IceField f =  p.GetField();
		boolean result = MethodPrinter.AskQuestion("Van hó a mezõn?");
		if(result)
			f.RemoveSnow(2);
		MethodPrinter.DecreaseIndentation();
		return result;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Shovel s) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(s) + ")");
		return true;
	}
}
