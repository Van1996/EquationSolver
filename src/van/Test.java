/**
 * @author Van
 * @email van_L96@163.com
 * @time 2017年2月14日下午4:42:11
 */
package van;

import java.util.Random;


public class Test {

	private final static int TEST_TIMES = 10000;
	private final static double ERROR_MARGIN = 1E-4;

	public static void main(String[] args) {
		test(3);
		test(4);
	}

	static void test(int power) {
		int i = 0;
		int failed = 0;

		if (power == 3) {
			while (i < TEST_TIMES) {
				double a = getRandom();
				double b = getRandom();
				double c = getRandom();
				double d = getRandom();
				if (!testSolver(a, b, c, d)) {
					failed++;
				}
				i++;
			}
		} else if (power == 4) {
			while (i < TEST_TIMES) {
				double a = getRandom();
				double b = getRandom();
				double c = getRandom();
				double d = getRandom();
				double e = getRandom();
				if (!testSolver(a, b, c, d, e)) {
					failed++;
				}
				i++;
			}
		}
		System.out.println("Success:" + (i - failed) + ",Failed:" + failed);

	}

	static boolean testSolver(double... ds) {
		int power = ds.length - 1;
		double[] solution = null;
		if (power == 3) { // Cubic
			solution = CubicEquation.solve(ds[0], ds[1], ds[2], ds[3]);
		} else if (power == 4) {
			solution = QuarticEquation.solve(ds[0], ds[1], ds[2], ds[3], ds[4]);
		}

		if (solution == null) {
			return true;
		}
		for (double s : solution) {
			double check = 0;
			for (int i = 0; i <= power; i++) {
				check += ds[i] * Math.pow(s, power - i);
			}
			if (Math.abs(check) >= ERROR_MARGIN) {
				System.out.println("When the power is " + power + " ,TEST FAILED:");
				System.out.println("The error range:"+check);
				for (double d : ds) {
					System.out.println(d);
				}
				System.out.println("-------------------");
				return false;
			}
		}
		return true;
	}

	private static double getRandom() {
		Random r = new Random();
		double random = 0; // 这是生成的随机数
		if (r.nextBoolean()) {
			random = r.nextDouble();
		} else {
			random = -r.nextDouble();
		}
		return random * 100;
	}

}
