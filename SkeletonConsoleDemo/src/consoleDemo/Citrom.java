package consoleDemo;

public class Citrom {
	private Alma alma;
	
	public void SetAlma(Alma alma) {
		this.alma = alma;
	}
	
	public void CitromMethod() {
		Main.methodPrinter.Println("CitromMethod()");
		
		Main.methodPrinter.IncreaseIndentation();
		
		if(Main.methodPrinter.AskQuestion("Hívja meg a citrom az alma második metódusát?"))
			alma.AlmaMethod2();
		
		Main.methodPrinter.DecreaseIndentation();
	}
}
