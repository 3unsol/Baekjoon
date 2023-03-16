import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = sc.nextInt();
		}
		String ans = null;
		for (int i = 0; i < 7; i++) {
			if (arr[i] == arr[i + 1] - 1) {
				ans = "ascending";
			} else if (arr[i] == arr[i + 1] + 1) {
				ans = "descending";
			} else {
				ans = "mixed";
				break;
			}
		}
		System.out.println(ans);
	}

}
