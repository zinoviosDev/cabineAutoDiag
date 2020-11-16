package diagauto.cabine.util.math;

public class Multiple {
	
	private Multiple() {}
	
	public static int generateMultipleOfThree() {
		return RandomIntegers.randomMultipleInRange(150, 3);
	}
	
	public static int generateMultipleOfFive() {
		return RandomIntegers.randomMultipleInRange(150, 5);
	}
	
	public static int generateMultipleOfThreeAndFive() {
		return RandomIntegers.randomMultipleInRange(150, 15);
	}
	
	public static boolean isMultipleOfThree(int number) {
		return (number % 3 == 0);
	}

	public static boolean isMultipleOfFive(int number) {
		return (number % 5 == 0);
	}
	
	public static boolean isMultipleOfThreeAndFive(int number) {
		return (number % 15 == 0);
	}
}
