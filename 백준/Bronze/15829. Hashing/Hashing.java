import java.util.Scanner;

public class Main {

	static final int M = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String str = sc.next();
		long sum = 0;
		long pow = 1;
		char[] arr = str.toCharArray();
		for (int i = 0; i < L; i++) {
			sum += (arr[i] - 'a' + 1) * pow % M;
			pow = pow * 31 % M;
		}
		long hash = sum % M;
		System.out.println(hash);
	}
}
