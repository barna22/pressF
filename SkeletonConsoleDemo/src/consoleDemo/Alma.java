package consoleDemo;

public class Alma {
	private Barack barack;
	private Citrom citrom;
	
	public void SetBarack(Barack barack) {
		this.barack = barack;
	}
	
	public void SetCitrom(Citrom citrom) {
		this.citrom = citrom;
	}
	
	public void AlmaMethod1() {
		Main.methodPrinter.Println("AlmaMethod1()");
		
		
		Main.methodPrinter.IncreaseIndentation();
		
		barack.BarackMethod();
		citrom.CitromMethod();
		
		Main.methodPrinter.DecreaseIndentation();
		
	}
	
	public void AlmaMethod2() {
		Main.methodPrinter.Println("AlmaMethod2()");
		
		
	}
}
