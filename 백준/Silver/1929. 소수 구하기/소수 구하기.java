import java.io.IOException;
import java.util.Scanner;

public class Main {

	static boolean[] checked;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		checked = new boolean[n + 1];
		check();
		for (int i = m; i <= n; i++) {
			if (!checked[i]) {
				System.out.println(i);
			}
		}
	}

	public static void check() {
		checked[0] = checked[1] = true;
		for (int i = 2; i <= Math.sqrt(checked.length); i++) {
			if (checked[i])
				continue;
			for (int j = i * i; j < checked.length; j += i) {
				checked[j] = true;
			}
		}
	}
}