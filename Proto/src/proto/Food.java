package proto;


/*
 * Fel lehet haszn�lni a j�t�kost testh�j�nek n�vel�s�re.
 */
public class Food extends Item {
	
	/*
	 * A j�t�kos testh�j�t n�veli. True-val t�r vissza
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(ConsoleApp.GetName(this) + ".Use(" + ConsoleApp.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		p.ChangeTemperature(1);
		MethodPrinter.DecreaseIndentation();
		return true;
	}
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Food f) {
		MethodPrinter.Println(ConsoleApp.GetName(this) + ".IsTheSame(" + ConsoleApp.GetName(f) + ")");
		return true;
	}
}
