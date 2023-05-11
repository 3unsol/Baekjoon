import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] card = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			card[i] = sc.nextInt();
			dp[i] = card[i]; // 개수 맞춰서 샀을 때 값을 넣어주기
		}
		for (int i = 1; i <= n; i++) { // dp 배열 채우기
			for (int j = 1; j <= i; j++) { // 1개짜리 + i-1개짜리 샀을 때 ~ i개짜리 샀을 때 쭉 돌면서 비교
				dp[i] = Math.min(dp[i], dp[i - j] + card[j]); // 최솟값 담아준다
			}
		}
		System.out.println(dp[n]);
	}
}