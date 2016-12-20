import util.MerchantsGuideSolver;

public class MerchantsGuideMain {
	
	public static void main(String[] args) {
		String fileName = null;
		
		if (args.length < 1) {
			fileName = "input.txt";
		} else {
			fileName = args[0];
		}
		
		String output = MerchantsGuideSolver.processInputFile(fileName);
		System.out.print(output);
	}
}