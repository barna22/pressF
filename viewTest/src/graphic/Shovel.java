package graphic;


/*
 * Havat lehet vele eltakar�tani a j�gmez�r�l.
 */
public class Shovel extends Item {
	
	/*
	 * K�t egys�gnyi h�r�teget takar�t el a j�gmez�r�l, ahol a
	 * haszn�l�ja �ll.
	 */
	public boolean Use(Player p) {
		IceField f =  p.GetField();
		f.RemoveSnow(2);
		return true;
	}
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Shovel s) {
		return true;
	}
}
