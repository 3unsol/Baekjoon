import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		input();
		LIS();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		max = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void LIS(){
		for(int i = 0; i < N; i++){ // dp 배열 채우기
			dp[i] = 1; // 가장 짧은 길이는 1
			for(int j = 0; j < i; j++){ // 나보다 앞에 있던 애들의 dp값이랑 비교할 것
				// arr[j]는 내 앞에 있는 애들 중 나랑 비교할 애
				// arr[i]는 현재 내 숫자
				// dp[i]는 지금 내가 가진 가장 긴 길이 (계속 변화하며 긴 값을 저장)
				// dp[j] 지금 비교하고 있는 애가 가진 가장 긴 길이
				// 내가 지금 비교하고 있는 애보다 크고
				// 내가 가진 길이보다 걔가 거쳐온 길이 + 1 (날 포함해야 하니까)이 더 크다면
				// 그 길이로 바꿔준다.
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
					dp[i] = dp[j] + 1;
				}
			}
		}
		for(int i = 0; i < N; i++){
			// dp 배열 돌면서
			// dp[i]가 max 보다 크면 dp[i], 아니면 max
			max = dp[i] > max ? dp[i] : max;
		}
		System.out.println(max);
	}
}