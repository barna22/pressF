package szkeleton;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FlareGunPart.java
//  @ Date : 3/24/2020
//  @ Author : 
//
//




public class FlareGunPart extends Item {
	private Game game;
	public boolean Use(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Use(" + Skeleton.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		IceField f = p.GetField();
		boolean result = false;
		if(game.IsEveryoneHere(f))
			result = f.CountGunParts(this);
		MethodPrinter.DecreaseIndentation();
		return result;
	}
	
	public boolean IsTheSame(FlareGunPart f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(f) + ")");
		return true;
	}
}
