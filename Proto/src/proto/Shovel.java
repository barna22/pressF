package proto;


/*
 * Havat lehet vele eltakar�tani a j�gmez�r�l.
 */
public class Shovel extends Item {
	
	/*
	 * K�t egys�gnyi h�r�teget takar�t el a j�gmez�r�l, ahol a
	 * haszn�l�ja �ll.
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(ConsoleApp.GetName(this) + ".Use(" + ConsoleApp.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		IceField f =  p.GetField();
		boolean result = MethodPrinter.AskQuestion("Van h� a mez�n?");
		if(result)
			f.RemoveSnow(2);
		MethodPrinter.DecreaseIndentation();
		return result;
	}
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Shovel s) {
		MethodPrinter.Println(ConsoleApp.GetName(this) + ".IsTheSame(" + ConsoleApp.GetName(s) + ")");
		return true;
	}
}
