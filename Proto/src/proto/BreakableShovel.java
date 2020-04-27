package proto;

/*
 * Havat lehet vele eltakar�tani a j�gmez�r�l. 
 * Minden haszn�lat cs�kkenti a durability-t, ha 0-ra cs�kken, akkor elt�rik.
 */
public class BreakableShovel extends Shovel {
	private int durability = 4;//Ennyi az alap�rtelmezett �rt�k?

	/*
	 * K�t egys�gnyi h�r�teget takar�t el a j�gmez�r�l, ahol a haszn�l�ja �ll. 
	 * Cs�kkenti eggyel a durability-t. Ha 0-ra cs�kkent a durability, akkor a p-n megh�vja a RemoveItem(bs)-t.
	 */
	public boolean Use(Player p) {
		IceField f = p.GetField();
		f.RemoveSnow(2);
		this.durability -= 1;
		if(this.durability == 0)
			p.RemoveItem(this);
		return true;
		
	}
	
	/*
	 *True-val t�r vissza. 
	 */
	public boolean IsTheSame(BreakableShovel bs) {
		return true;
	}
}
