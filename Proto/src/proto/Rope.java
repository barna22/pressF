package proto;


/*
 * Ki lehet menteni a játékosokat a vízbõl a környezõ mezõkrõl.
 */
public class Rope extends Item {
	
	/*
	 * Kimenti a vízbeesett játékosokat a szomszédos mezõkrõl.
	 * True-val tér vissza, ha legalább egy játékost kimentett.
	 */
	public boolean Use(Player p1) {
		MethodPrinter.Println(ConsoleApp.GetName(this) + ".Use(" + ConsoleApp.GetName(p1) + ")");
		MethodPrinter.IncreaseIndentation();
		IceField f1 =  p1.GetField();
		boolean success = false;
		for (Direction d : Direction.values()) {
			IceField f = f1.GetNeighbour(d);
			if(f.Save(f1))
				success = true;
		}
		MethodPrinter.DecreaseIndentation();
		return success;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Rope r) {
		MethodPrinter.Println(ConsoleApp.GetName(this) + ".IsTheSame(" + ConsoleApp.GetName(r) + ")");
		return true;
	}
}
