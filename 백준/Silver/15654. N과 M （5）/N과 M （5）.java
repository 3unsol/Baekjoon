import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr, result;
	static boolean[] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		result = new int[M];
		isVisited = new boolean[N];
		recur(0);
	}

	static void recur(int k){

		if(k == M){
			for(int i = 0; i < M; i++){
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++){
			if(!isVisited[i]){
				isVisited[i] = true;
				result[k] = arr[i];
				recur(k + 1);
				isVisited[i] = false;
			}
		}
	}
}