package consoleDemo;

public class Main {

	public static MethodPrinter methodPrinter = new MethodPrinter();
	
	public static void main(String[] args) {
		
		Barack barack = new Barack();
		Alma alma = new Alma();
		Citrom citrom = new Citrom();
		alma.SetBarack(barack);
		alma.SetCitrom(citrom);
		citrom.SetAlma(alma);
		
		alma.AlmaMethod1();
	}

}
