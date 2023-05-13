import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// hashset
		HashSet<String> hashset = new HashSet<>();
		int n = sc.nextInt(); // 집합 문자열 개수
		int m = sc.nextInt(); // 검사할 문자열 개수
		for (int i = 0; i < n; i++) { // 해쉬셋에 문자열 넣어주기
			hashset.add(sc.next());
		}
		int cnt = 0; // 답
		for (int i = 0; i < m; i++) { // 해쉬셋에 있는지 확인
			String st = sc.next();
			if (hashset.contains(st)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
