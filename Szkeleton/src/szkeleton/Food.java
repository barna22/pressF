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
		p.ChangeTemperature(1);
		MethodPrinter.DecreaseIndentation();
		return true;
	}
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Food f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(f) + ")");
		return true;
	}
}
