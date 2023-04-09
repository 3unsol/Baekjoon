import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[][] dp = new int[k + 1][n + 1];
			for (int c = 1; c <= n; c++) {
				dp[0][c] = c;
			}
			for (int r = 1; r <= k; r++) {
				for (int c = 1; c <= n; c++) {
					for (int i = 1; i <= c; i++) {
						dp[r][c] += dp[r - 1][i];
					}
				}
			}
			System.out.println(dp[k][n]);
		}
	}
}
