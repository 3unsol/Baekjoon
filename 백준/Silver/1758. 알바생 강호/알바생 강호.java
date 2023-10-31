import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Comparator.reverseOrder());
		long sum = 0;
		int idx = 0;
		for(int i = 0; i < n; i++){
			int num = arr[i] - idx;
			if(num <= 0){
				break;
			}else{
				sum += num;
			}
			idx++;
		}
		System.out.println(sum);
	}
}