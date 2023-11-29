import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, x, ans, count;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		input();
		slide();
		if(ans == 0){
			System.out.println("SAD");
		} else {
			System.out.println(ans);
			System.out.println(count);
		}

	}

	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		count = 1;
	}

	static void slide(){

		int start = 0;
		int sum = 0;

		while(start + x <= N){

			sum = arr[start + x] - arr[start];

			if(sum > ans){
				ans = sum;
				count = 1;
			} else if (sum == ans) {
				count++;
			}

			start++;

		}

	}
}