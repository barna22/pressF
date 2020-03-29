package szkeleton;


/*
 * Fel lehet használni a játékost testhõjének növelésére.
 */
public class Food extends Item {
	
	/*
	 * A játékos testhõjét növeli. True-val tér vissza
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Use(" + Skeleton.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		boolean result = MethodPrinter.AskQuestion("Tud enni a karakter?");
		if(result)
			p.ChangeTemperature(1);
		MethodPrinter.DecreaseIndentation();
		return result;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Food f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(f) + ")");
		return true;
	}
}
