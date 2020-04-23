package proto;

/**
 * Jégtáblák közötti mozgásra képes entitás
 */
public abstract class Entity {
	
	protected IceField field;

	/**
	 * Az entitást vihar éri.
	 */
	public abstract void CaughtByStorm();
	
	
	/**
	 * Az entitás vízbe esik.
	 * @param field TODO
	 */
	public abstract void FallInWater(IceField field);
	
	
	/**
	 * Az entitás másik entitással találkozik.
	 */
	public void Meet(Entity entity) {
			
	}
	
	

	/**
	 * Az entitás átlép egy másik mezõre.
	 * Ha kimenne a pályáról, a program jelzi, hogy ezt nem teheti.
	 */
	public void Move(Direction d) {
		IceField newfield = field.GetNeighbour(d);
		if(newfield == null) {
			//System.out.println("Nem lehet kimenni a pályáról!");
			return;
		}
		field.Remove(this);
		field = newfield;
		field.Accept(this);
	}
}
