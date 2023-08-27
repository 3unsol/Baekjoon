import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		int size = arr[0].length();
		boolean[] flag = new boolean[size];
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < size; j++) {
				if(arr[i].charAt(j) != arr[i + 1].charAt(j)) {
					flag[j] = true;
				}
			}
		}
		for(int i = 0; i < size; i++) {
			if(!flag[i]) {
				System.out.print(arr[0].charAt(i));
			}else {
				System.out.print("?");
			}
		}
	}
}