import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
//		Arrays.sort(arr);
//		int start = (int) Math.round(n * 0.15);
//		int end = n - start;
//		double sum = 0;
//		for (int i = start; i < end; i++) {
//			sum += arr[i];
//		}
//		double ans = sum / (n - (start + start));
//		System.out.println(Math.round(ans));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int start = (int) Math.round(n * 0.15);
		int end = n - start;
		double sum = 0;
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}
		System.out.println((int) Math.round(sum / (n - (start * 2))));
		br.close();
	}
}