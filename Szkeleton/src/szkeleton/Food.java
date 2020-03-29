package szkeleton;


/*
 * Fel lehet haszn�lni a j�t�kost testh�j�nek n�vel�s�re.
 */
public class Food extends Item {
	
	/*
	 * A j�t�kos testh�j�t n�veli. True-val t�r vissza
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
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Food f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(f) + ")");
		return true;
	}
}
