import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] map = new char[5][15];
		int max = 0;
		for (int r = 0; r < 5; r++) {
			String str = sc.next();
			max = Math.max(max, str.length());
			for (int c = 0; c < str.length(); c++) {
				map[r][c] = str.charAt(c);
			}
		}
		for (int c = 0; c < max; c++) {
			for (int r = 0; r < 5; r++) {
				if (map[r][c] == '\u0000')
					continue;
				System.out.print(map[r][c]);
			}
		}

	}
}
