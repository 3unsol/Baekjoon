import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		input();
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + M];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = N; i < N + M; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N + M; i++){
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb);

	}
}