package szkeleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MethodPrinter {
	private static int indentation = 0;

	public static boolean AskQuestion(String question) {
		Print(question + " (I/N) ");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		boolean answer = false;
		try {
			boolean answeredCorrectly = false;
			while (!answeredCorrectly) {
				String line = bf.readLine();
				if (line.startsWith("I") || line.startsWith("i")) {
					answer = true;
					answeredCorrectly = true;
				}
				
				else if (line.startsWith("N") || line.startsWith("n")) {
					answer = false;
					answeredCorrectly = true;
				}
				else {
					Println("Hibás válasz");
					Print(question + " (I/N) ");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answer;
	}

	public static void IncreaseIndentation() {
		indentation++;
	}

	public static void DecreaseIndentation() {
		indentation--;
	}

	public static void Print(String s) {
		Indent();
		System.out.print(s);
	}

	public static void Println(String s) {
		Indent();
		System.out.println(s);
	}

	private static void Indent() {
		for (int i = 0; i < indentation; i++)
			System.out.print("    ");
	}
}
