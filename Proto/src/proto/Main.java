package proto;

import java.util.Scanner;

public class Main
{
	//Main: egyszer� sz�veges men� a tesztesetekre
	public static void main(String[] args)
	{
		String parancs;
		ConsoleApp skeleton = new ConsoleApp();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("A help paranccsal tudok megtekinteni a teszparancsok listajat!"); 
		
		for(;;) {
 		System.out.println("Kerem a kovetkezo parancsot"); 
 		parancs = sc.nextLine();
 		
 		try {
 	 		switch(parancs) {
 	 		case "1":
 	 		    skeleton.Dig();
 	 		    break;
 	 		case "2":
 	  		    skeleton.TakeItem();
 	  		    break;
 	 		case "3":
 	 		    skeleton.FlareGunSuccess();
 	 		    break;
 	 		case "4":
 	 		    skeleton.FlareGunFail();
 	 		    break;
 	 		case "5":
 	 		    skeleton.UseFood();
 	 		    break;
 	 		case "6":
 	 		    skeleton.UseRopeFail();
 	 		    break;
 	 		case "7":
 	 		    skeleton.UseRopeSuccess();
 	 		    break;
 	 		case "8":
 	 		    skeleton.UseShovel();
 	 		    break;
 	 		case "9":
 	 		    skeleton.MoveWithSuit();
 	 		    break;
 	 		case "10":
 	 		    skeleton.MoveWithoutSuit();
 	 		    break;
 	 		case "11":
 	 		    skeleton.MoveOnStable();
 	 		    break;
 	 		case "12":
 	 		    skeleton.MoveToFinishRound();
 	 		    break;
 	 		case "13":
 	 		    skeleton.MoveToFinishTurn();
 	 		    break;
 	 		case "14":
 	 		    skeleton.NextTurn();
 	 		    break;
 	 		case "15":
 	 		    skeleton.NextRound();
 	 		    break;
 	 		case "16":
 	 		    skeleton.LethalStorm();
 	 		    break;
 	 		case "17":
 	 		    skeleton.IglooStorm();
 	 		    break;
 	 		case "18":
 	 		    skeleton.HitStorm();
 	 		    break;
 	 		case "19":
 	 		    skeleton.Igloo();
 	 		    break;
 	 		case "20":
 	 		    skeleton.Reveal();
 	 		    break;
 	 		case "ChangeObjectFormat":
 	 			System.out.println("1: Megjelen�t�s n�vvel �s t�pussal");
 	 			System.out.println("2: Megjelen�t�s csak t�pussal");
 	 			System.out.println("3: Megjelen�t�s csak n�vvel");
 	 			System.out.println("\nAdd meg a k�v�nt form�tum sz�m�t: ");
 	 			switch (sc.nextLine()) {
 	 			case "1":
 	 				skeleton.SetNameFormat(ConsoleApp.NameFormat.NAMEANDTYPE);
 	 				break;
 	 			case "2":
 	 				skeleton.SetNameFormat(ConsoleApp.NameFormat.TYPEONLY);
 	 				break;
 	 			case "3":
 	 				skeleton.SetNameFormat(ConsoleApp.NameFormat.NAMEONLY);
 	 				break;
 	 			default:
 	 				System.out.println("Hib�s bemenet");
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
 	 			System.out.println("Az alabbi parancsokokkal lehet fuggvenyeket tesztelni: (A sz�mot kell kiadni parancsk�nt)");
 	 			System.out.println("1: Dig");
 	 			System.out.println("2: TakeItem");
 	 			System.out.println("3: FlareGunSuccess");
 	 			System.out.println("4: FlareGunFail");
 	 			System.out.println("5: UseFood");
 	 			System.out.println("6: UseRopeFail");
 	 			System.out.println("7: UseRopeSuccess");
 	 			System.out.println("8: UseShovel");
 	 			System.out.println("9: MoveWithSuit");
 	 			System.out.println("10: MoveWithoutSuit");
 	 			System.out.println("11: MoveOnStable");
 	 			System.out.println("12: MoveToFinishRound");
 	 			System.out.println("13: MoveToFinishTurn");
 	 			System.out.println("14: NextTurn");
 	 			System.out.println("15: NextRound");
 	 			System.out.println("16: LethalStorm");
 	 			System.out.println("17: IglooStorm");
 	 			System.out.println("18: HitStorm");
 	 			System.out.println("19: Igloo");
 	 			System.out.println("20: Reveal");
 	 			System.out.println("A ChangeObjectFormat paranccsal lehet �ll�tani a ki�rt objektumok form�tum�t");
 	 			System.out.println("Az Exit paranccsal pedig kil�pni lehet");
 	 			break;
 	 		default:
 	 		    System.out.println("Hibas input");
 	 		}
 		} catch (NullPointerException e) {
 			System.out.println("Nem a tesztesetnek megfelel� v�lasz");
 		}finally {
 			
 		}
 		

 		}		
	}
}