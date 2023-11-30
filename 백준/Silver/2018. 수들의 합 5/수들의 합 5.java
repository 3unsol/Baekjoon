import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, count;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		input();
		twoPointer();
		System.out.println(count);
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++){
			arr[i] = arr[i - 1] + i;
		}
		count = 1;
	}

	static void twoPointer() {

		int start = 0;
		int end = 0;

		while(start != N){

			if(arr[start] - arr[end] == N){
				count++;
				start++;
			}else if(arr[start] - arr[end] > N){
				end++;
			}else{
				start++;
			}
		}
	}
}