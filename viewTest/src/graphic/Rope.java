package graphic;


/*
 * Ki lehet menteni a játékosokat a vízbõl a környezõ mezõkrõl.
 */
public class Rope extends Item {
	
	/*
	 * Kimenti a vízbeesett játékosokat a szomszédos mezõkrõl.
	 * True-val tér vissza, ha legalább egy játékost kimentett.
	 */
	public boolean Use(Player p1) {
		IceField f1 =  p1.GetField();
		boolean success = false;
		for (IceField f : f1.getNeighbours()) 
			if(f.Save(f1))
				success = true;
		return success;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Rope r) {
		return true;
	}
}
