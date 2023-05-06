import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n + 1];
		dp[0] = 0;
		if (n == 0) {
			System.out.println(0);
		} else if (n == 1) {
			System.out.println(4);
		} else if (n == 2) {
			System.out.println(6);
		} else if (n > 2) {
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 2;
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			long ans = ((dp[n] * 2) + dp[n - 1]) * 2;
			System.out.println(ans);
		}
	}
}