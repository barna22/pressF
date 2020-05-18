package graphic;


/*
 * Havat lehet vele eltakarítani a jégmezõrõl.
 */
public class Shovel extends Item {
	
	/*
	 * Két egységnyi hóréteget takarít el a jégmezõrõl, ahol a
	 * használója áll.
	 */
	public boolean Use(Player p) {
		IceField f =  p.GetField();
		f.RemoveSnow(2);
		return true;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Shovel s) {
		return true;
	}
}
