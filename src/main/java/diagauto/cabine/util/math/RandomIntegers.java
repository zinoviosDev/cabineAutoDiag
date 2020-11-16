package diagauto.cabine.util.math;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIntegers {
	
	private RandomIntegers() {}

	public static int randomMultipleInRange(int max, int multiple) {
	    int value = -1;
		if(multiple == 0) {
			throw new ArithmeticException("multiple arg has to be > 0");
		}
		if(max < multiple) {
			throw new ArithmeticException("max arg has to be > multiple");
		}
		do {
		    value = new java.util.Random().nextInt(max / multiple) * multiple;
		}
		while (value == 0 || (value % multiple) != 0);
	    return value;
	}
	
	public static int getRandomIntBetween(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);

	}
}
