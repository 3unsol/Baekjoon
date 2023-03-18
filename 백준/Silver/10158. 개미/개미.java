import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		int x = (p + t) % (w * 2);
		int y = (q + t) % (h * 2);
		x = w - Math.abs(w - x);
		y = h - Math.abs(h - y);
		System.out.println(x + " " + y);
	}
}
