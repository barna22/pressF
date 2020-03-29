package szkeleton;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		String parancs;
		Skeleton skeleton = new Skeleton();
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
 		System.out.println("Kerem a kovetkezo parancsot"); 
 		parancs = sc.nextLine();
 		
 		switch(parancs) {
 		case "Dig":
 		    skeleton.Dig();
 		    break;
 		case "TakeItem":
  		    skeleton.TakeItem();
  		    break;
 		case "FlareGunSuccess":
 		    skeleton.FlareGunSuccess();
 		    break;
 		case "FlareGunFail":
 		    skeleton.FlareGunFail();
 		    break;
 		case "UseFood":
 		    skeleton.UseFood();
 		    break;
 		case "UseRopeFail":
 		    skeleton.UseRopeFail();
 		    break;
 		case "UseRopeSuccess":
 		    skeleton.UseRopeSuccess();
 		    break;
 		case "UseShovel":
 		    skeleton.UseShovel();
 		    break;
 		case "MoveWithSuit":
 		    skeleton.MoveWithSuit();
 		    break;
 		case "MoveWithoutSuit":
 		    skeleton.MoveWithoutSuit();
 		    break;
 		case "MoveOnStable":
 		    skeleton.MoveOnStable();
 		    break;
 		case "MoveToFinishRound":
 		    skeleton.MoveToFinishRound();
 		    break;
 		case "MoveToFinishTurn":
 		    skeleton.MoveToFinishTurn();
 		    break;
 		case "NextTurn":
 		    skeleton.NextTurn();
 		    break;
 		case "NextRound":
 		    skeleton.NextRound();
 		    break;
 		case "LethalStorm":
 		    skeleton.LethalStorm();
 		    break;
 		case "IglooStorm":
 		    skeleton.IglooStorm();
 		    break;
 		case "HitStorm":
 		    skeleton.HitStorm();
 		    break;
 		case "Igloo":
 		    skeleton.Igloo();
 		    break;
 		case "Reveal":
 		    skeleton.Reveal();
 		    break;
 		case "Exit":
 			sc.close();
 			System.exit(0);
 		    break;
 		case "e":
 			sc.close();
 			System.exit(0);
 		    break;
 		default:
 		    System.out.println("Hibas input");
 		}
 		}		
	}
}