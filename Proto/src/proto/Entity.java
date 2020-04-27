package proto;

/**
 * Jégtáblák közötti mozgásra képes entitás
 */
public abstract class Entity implements Printable{
	
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
	public void Meet(Entity other) {
	}
	
	/**
	 * Az entitás átlép egy másik mezõre.
	 * Ha kimenne a pályáról, a program jelzi, hogy ezt nem teheti.
	 */
	public void Move(int d) {
		IceField newfield = field.GetNeighbour(d);
		if(newfield == null) {
			System.out.println("Can't go outside the map");
			return;
		}
		field.Remove(this);
		field = newfield;
		field.Accept(this);
	}
	public void SetField(IceField f) {
		field = f;
	}
}
