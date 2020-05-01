package proto;

/*
 * Havat lehet vele eltakarítani a jégmezõrõl. 
 * Minden használat csökkenti a durability-t, ha 0-ra csökken, akkor eltörik.
 */
public class BreakableShovel extends Shovel {
	private int durability = 4;//Ennyi az alapértelmezett érték?

	/*
	 * Két egységnyi hóréteget takarít el a jégmezõrõl, ahol a használója áll. 
	 * Csökkenti eggyel a durability-t. Ha 0-ra csökkent a durability, akkor a p-n meghívja a RemoveItem(bs)-t.
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
	 *True-val tér vissza. 
	 */
	public boolean IsTheSame(BreakableShovel bs) {
		return true;
	}
}
