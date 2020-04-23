package proto;

/**
 * J�gt�bl�k k�z�tti mozg�sra k�pes entit�s
 */
public abstract class Entity {
	
	protected IceField field;

	/**
	 * Az entit�st vihar �ri.
	 */
	public abstract void CaughtByStorm();
	
	
	/**
	 * Az entit�s v�zbe esik.
	 * @param field TODO
	 */
	public abstract void FallInWater(IceField field);
	
	
	/**
	 * Az entit�s m�sik entit�ssal tal�lkozik.
	 */
	public void Meet(Entity entity) {
			
	}
	
	

	/**
	 * Az entit�s �tl�p egy m�sik mez�re.
	 * Ha kimenne a p�ly�r�l, a program jelzi, hogy ezt nem teheti.
	 */
	public void Move(Direction d) {
		IceField newfield = field.GetNeighbour(d);
		if(newfield == null) {
			//System.out.println("Nem lehet kimenni a p�ly�r�l!");
			return;
		}
		field.Remove(this);
		field = newfield;
		field.Accept(this);
	}
}
