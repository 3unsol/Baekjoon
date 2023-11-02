import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 최소 횟수를 담을 DP 배열
		int[] dp = new int[n + 1];
		dp[1] = 0;
		// 어떤 숫자에서 거쳐와서 +1을 한 건지 담을 list
		List<Integer> list = new ArrayList<>();
		// 0, 1 값 넣어주기
		list.add(0);
		list.add(0);
		// 2 ~ n까지
		for(int i = 2; i <= n; i++){
			dp[i] = dp[i - 1] + 1;
			int ans = i - 1;
			if(i % 2 == 0){
				if(dp[i] >= dp[i / 2] + 1){
					dp[i] = dp[i / 2] + 1;
					ans = i / 2;
				}
			}
			if(i % 3 == 0){
				if(dp[i] >= dp[i / 3] + 1){
					dp[i] = dp[i / 3] + 1;
					ans = i / 3;
				}
			}
			list.add(ans);
		}
		// 최소 횟수 출력
		System.out.println(dp[n]);
		// list.get(idx)에는 어떤 idx에서 왔는지가 담겨있다.
		int start = n;
		for(int i = 0; i <= dp[n]; i++){
			System.out.print(start + " ");
			start = list.get(start);
		}
	}
}