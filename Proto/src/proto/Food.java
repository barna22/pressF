package proto;


/*
 * Fel lehet használni a játékost testhõjének növelésére.
 */
public class Food extends Item {
	
	/*
	 * A játékos testhõjét növeli. True-val tér vissza
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(ConsoleApp.GetName(this) + ".Use(" + ConsoleApp.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		p.ChangeTemperature(1);
		MethodPrinter.DecreaseIndentation();
		return true;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Food f) {
		MethodPrinter.Println(ConsoleApp.GetName(this) + ".IsTheSame(" + ConsoleApp.GetName(f) + ")");
		return true;
	}
}
