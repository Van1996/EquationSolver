/**
 * @author Van
 * @email van_L96@163.com
 * @time 2017年2月14日上午10:34:42
 * @see （盛金公式_Baidu）http://baike.baidu.com/link?url=AXVKxnQGjFarY481CweKPRWrLCMX6lor1vf_
 * 8abLZfBvha6BQMgd1CPt5jFK3z9h5099i9ez5zchvvDelHJnNM7Ufr6lQZF52Qn2KuJ7aBSj6WuW3d5kvUJYzMm4Y4gk
 * 
 * It's not excepted that u can understand the code,but just need to know what Test.java do(to test 
 * this class is perform correctly or not), and consider the margin of error is acceptable or not.
 * 并不指望你能看得懂下面的代码写的是什么，你只需要知道Test.java类是干什么的（测试这个类是否工作正常），并考虑误差值是否是可接受的。
 */
package van;

public class CubicEquation {
	
	/**
	 * Solve a cubic equation of the form ax^3+bx^2+cx+d=0.
	 * If a == 0,it will convert to quadratic equation and solve it.
	 * 
	 * @param a	coefficient of x^3
	 * @param b coefficient of x^2
	 * @param c coefficient of x^1
	 * @param d coefficient of x^0
	 * @return the root of the equation.Maybe contain NaN.
	 */
	
	public static double[] solve(double a, double b, double c, double d) {

		if (a == 0) {
			return QuadraticEquation.solve(b, c, d);
		}

		double A = b * b - 3 * a * c;
		double B = b * c - 9 * a * d;
		double C = c * c - 3 * b * d;
		double delta = B * B - 4 * A * C;

		if (A == B && B == 0) {
			System.out.println(-b / (3 * a));
			double[] solution = { -b / (3 * a), -b / (3 * a), -b / (3 * a) };
			return solution;
		} else if (delta > 0) {
			double y1 = (double) ((A * b + 1.5 * a * (-B + Math.sqrt(delta))));
			double y2 = (double) ((A * b + 1.5 * a * (-B - Math.sqrt(delta))));
			double x1 = (double) ((-b - Math.pow(y1, 1.0 / 3) - Math.pow(y2, 1.0 / 3)) / (3 * a));
			double[] solution = { x1 };
			return solution;
		} else if (delta == 0) {
			double x1 = -b / a + B / A;
			double x2 = -B / (A * 2);
			double[] solution = { x1, x2, x2 };
			return solution;
		} else {
			double T = (double) ((2 * A * b - 3 * a * B) / (2 * Math.pow(A, 1.5)));
			double theta = (double) Math.acos(T);
			double x1 = (double) ((-b - 2 * Math.sqrt(A) * Math.cos(theta / 3)) / (3 * a));
			double x2 = (double) ((-b + Math.sqrt(A) * (Math.cos(theta / 3) + Math.sqrt(3) * Math.sin(theta / 3)))
					/ (3 * a));
			double x3 = (double) ((-b + Math.sqrt(A) * (Math.cos(theta / 3) - Math.sqrt(3) * Math.sin(theta / 3)))
					/ (3 * a));
			double[] solution = { x1, x2, x3 };
			return solution;
		}
	}
}