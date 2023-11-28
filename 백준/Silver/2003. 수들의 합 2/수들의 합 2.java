import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, count;
	static int[] sum;

	public static void main(String[] args) throws Exception {
		input();
		twoPointer();
		System.out.println(count);
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for(int i = 1; i <= N; i++){
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
	}

	static void twoPointer(){

		int start = 0;
		int end = 0;

		while(start != N + 1){

			if(sum[start] - sum[end] == M){
				count++;
				start++;
			}
			else if(sum[start] - sum[end] > M){
				end++;
			}
			else {
				start++;
			}

		}
	}
}