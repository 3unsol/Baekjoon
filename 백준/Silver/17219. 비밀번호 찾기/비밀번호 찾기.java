import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			map.put(sc.next(), sc.next());
		}
		for (int i = 0; i < m; i++) {
			System.out.println(map.get(sc.next()));
		}
	}
}