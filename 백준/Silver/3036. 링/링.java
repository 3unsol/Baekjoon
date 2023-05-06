import java.util.Scanner;

public class Main {
	
	// 유클리드 호제법
	// 큰 수 % 작은 수 = 0 될 때까지 나누기
	// 0이 되면 그때 나눈 수가 최대공약수
	
	public static int GCD(int p, int q) {
		if(q == 0) {
			return p;
		}
		return GCD(q, p % q);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int firstRing = sc.nextInt();
		for(int i = 0; i < n - 1; i++) {
			int tempRing = sc.nextInt();
			int gcd = GCD(firstRing, tempRing);
			System.out.printf("%d/%d\n", firstRing/gcd, tempRing/gcd);
		}
	}
}
