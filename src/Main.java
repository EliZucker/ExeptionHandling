
public class Main {
	
	/**
	 * Proof that the method works
	 * Use fileRead to get a list of 10 numbers, then print the object
	 * @param args
	 */
	public static void main(String[] args) {
		ListOfNumbers test = new ListOfNumbers();
		test.fileRead("test.txt");
		System.out.print(test);
	}
}
