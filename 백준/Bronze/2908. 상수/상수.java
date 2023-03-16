import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		StringBuilder sba = new StringBuilder();
		StringBuilder sbb = new StringBuilder();
		a = Integer.parseInt(sba.append(a).reverse().toString());
		b = Integer.parseInt(sbb.append(b).reverse().toString());
		System.out.println(a > b ? a : b);
	}
}
