package szkeleton;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		String parancs;
		Skeleton skeleton = new Skeleton();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("A help paranccsal tudok megtekinteni a teszparancsok listajat!"); 
		
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
 		case "ChangeObjectFormat":
 			System.out.println("1: Megjelenítés névvel és típussal");
 			System.out.println("2: Megjelenítés csak típussal");
 			System.out.println("3: Megjelenítés csak névvel");
 			System.out.println("\nAdd meg a kívánt formátum számát: ");
 			switch (sc.nextLine()) {
 			case "1":
 				skeleton.SetNameFormat(Skeleton.NameFormat.NAMEANDTYPE);
 				break;
 			case "2":
 				skeleton.SetNameFormat(Skeleton.NameFormat.TYPEONLY);
 				break;
 			case "3":
 				skeleton.SetNameFormat(Skeleton.NameFormat.NAMEONLY);
 				break;
 			default:
 				System.out.println("Hibás bemenet");
 			}
 			break;
 		case "Exit":
 			sc.close();
 			System.exit(0);
 		    break;
 		case "e":
 			sc.close();
 			System.exit(0);
 		    break;
 		case "help":
 			System.out.println("Az alabbi parancsokokkal lehet fuggvenyeket tesztelni:");
 			System.out.println("Dig");
 			System.out.println("TakeItem");
 			System.out.println("FlareGunSuccess");
 			System.out.println("FlareGunFail");
 			System.out.println("UseFood");
 			System.out.println("UseRopeFail");
 			System.out.println("UseRopeSuccess");
 			System.out.println("UseShovel");
 			System.out.println("MoveWithSuit");
 			System.out.println("MoveWithoutSuit");
 			System.out.println("MoveOnStable");
 			System.out.println("MoveToFinishRound");
 			System.out.println("MoveToFinishTurn");
 			System.out.println("NextTurn");
 			System.out.println("NextRound");
 			System.out.println("LethalStorm");
 			System.out.println("IglooStorm");
 			System.out.println("HitStorm");
 			System.out.println("Igloo");
 			System.out.println("Reveal");
 			System.out.println("A ChangeObjectFormat paranccsal lehet állítani a kiírt objektumok formátumát");
 			System.out.println("Az Exit paranccsal pedig kilepni lehet");
 			break;
 		default:
 		    System.out.println("Hibas input");
 		}
 		}		
	}
}