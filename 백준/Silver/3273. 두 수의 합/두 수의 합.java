import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, x, count;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		input();
		twoPointer();
		System.out.println(count);
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		count = 0;
		Arrays.sort(arr);
	}

	static void twoPointer(){

		int start = 0;
		int end = N - 1;

		while(start < end){
			if(arr[start] + arr[end] == x){
				count++;
				start++;
				end--;
			} else if (arr[start] + arr[end] > x){
				end--;
			} else {
				start++;
			}
		}
	}
}