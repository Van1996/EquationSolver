/**
 * @author Van
 * @email van_L96@163.com
 * @time 2017年2月13日下午11:40:04
 */
package van;

public class QuadraticEquation {
	
	/**
	 * Solve a Quadratic equation of the form ax^2+bx+c=0.
	 * If a == 0,return null
	 * @param a	coefficient of x^2
	 * @param b coefficient of x^1
	 * @param c coefficient of x^0
	 * @return the root of the equation
	 */
	public static double[] solve(double a, double b, double c) {
		if (a == 0 && b != 0) {
			double[] solution = {-c/b};
			return solution;
		}
		
		double delta = getDelta(a, b, c);
		if (delta < 0 || (a == 0 && b == 0)) {
			return null;
		} else {
			double[] f = { (-b + Math.sqrt(delta)) / (2 * a), (-b - Math.sqrt(delta)) / (2 * a) };
			return f;
		}
	}

	public static double getDelta(double b, double c, double d) {
		return c * c - 4 * b * d;
	}

}
