package _02_Recursion._1_Basic;

public class _10_x_power_n_logarithmic {
	public static void main(String[] args) {

		double x = 0.44528;
		int pow = 0;
		System.out.println(power2(x, pow));
	}

	// easy and better approach, use this only
	private static double power2(double x, int n) {
		double ans = 1.0;
		long nn = n; // for last checking value

		if (nn < 0) {
			nn = -1 * nn;
		}

		while (nn > 0) {
			if (nn % 2 == 1) {
				ans = ans * x;
				nn = nn - 1;
			} else {
				x = x * x;
				nn = nn / 2;
			}
		}

		// check with original power.
		if (n < 0) {
			ans = (double) 1.0 / (double) ans;
		}

		return ans;

	}

	// recursive
	@SuppressWarnings("unused")
	private static double power(double x, int pow) {

		// Handle the case of pow being zero
		if (pow == 0) {
			// If x is 0 and pow is 0, return NaN (Not a Number), as 0^0 is undefined
			if (x == 0) {
				return Double.NaN; // Or handle it based on your needs
			}
			return 1; // Any non-zero number to the power of 0 is 1
		}

		// If the power is negative, calculate the positive power and take the
		// reciprocal
		if (pow < 0) {
			return 1 / power(x, -pow);
		}

		if (pow == 1) {
			return x;
		}

		double xpn2 = power(x, pow / 2);

		double xn = xpn2 * xpn2;

		if (pow % 2 == 1) {
			xn *= x;
		}

		return xn;
	}
}
