import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		for (int i = 3; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		for (int tc = 0; tc < testCase; tc++) {
			int n = sc.nextInt();
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
	}
}