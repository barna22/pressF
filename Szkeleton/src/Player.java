//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Player.java
//  @ Date : 3/24/2020
//  @ Author : 
//
//




public abstract class Player {
	private int temperature;
	private boolean isInWater;
	private int remainingActions;
	private Object hasDivingGear;
	private Item items;
	private IceField field;
	private Game game;
	public void ChangeTemperature(int dif) {
	}
	
	public void GetSaved(IceField f) {
	}
	
	public abstract void UseAbility(Direction d);
	
	public void Move(Direction d) {
	}
	
	public void UseItem(Item i) {
	}
	
	public void PickUpItem() {
	}
	
	public void Dig() {
	}
	
	public boolean AddItem(Item i) {
	}
}
