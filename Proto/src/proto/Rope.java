package proto;


/*
 * Ki lehet menteni a j�t�kosokat a v�zb�l a k�rnyez� mez�kr�l.
 */
public class Rope extends Item {
	
	/*
	 * Kimenti a v�zbeesett j�t�kosokat a szomsz�dos mez�kr�l.
	 * True-val t�r vissza, ha legal�bb egy j�t�kost kimentett.
	 */
	public boolean Use(Player p1) {
		IceField f1 =  p1.GetField();
		boolean success = false;
		for (Direction d : Direction.values()) {
			//Akkor direction helyett sz�mok 0-3-ig?
			IceField f = f1.GetNeighbour(d);
			if(f.Save(f1))
				success = true;
		}
		return success;
	}
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Rope r) {
		return true;
	}
}
