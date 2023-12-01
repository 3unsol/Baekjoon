import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, k;
	static int ans = Integer.MIN_VALUE;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		input();
		slidingWindow();
		System.out.println(ans);
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
	}

	static void slidingWindow(){

		int start = k;

		while(start != N + 1){
			if(arr[start] - arr[start - k] > ans){
				ans = arr[start] - arr[start - k];
			}
			start++;
		}
	}
}