package consoleDemo;

public class Citrom {
	private Alma alma;
	
	public void SetAlma(Alma alma) {
		this.alma = alma;
	}
	
	public void CitromMethod() {
		Main.methodPrinter.Println("CitromMethod()");
		
		Main.methodPrinter.IncreaseIndentation();
		
		if(Main.methodPrinter.AskQuestion("H�vja meg a citrom az alma m�sodik met�dus�t?"))
			alma.AlmaMethod2();
		
		Main.methodPrinter.DecreaseIndentation();
	}
}
