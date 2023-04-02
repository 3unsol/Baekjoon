import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int n = sc.nextInt();
		int k = sc.nextInt();
        
		int a = factorial(n);
		int b = factorial(n - k);
		int c = factorial(k);
        
		System.out.println(a / (b * c));
	}

	static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
