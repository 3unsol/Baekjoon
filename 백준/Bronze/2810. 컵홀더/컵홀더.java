import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		String str = sc.next();
		char[] arr = new char[n];
		for (int i = 0; i < n; i++) {
			arr[i] = str.charAt(i);
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'S') {
				cnt++;
			}
			if (arr[i] == 'L') {
				i++;
				cnt++;
			}
		}
		if (cnt >= n) {
			System.out.println(n);
		} else {
			System.out.println(cnt + 1);
		}
	}
}