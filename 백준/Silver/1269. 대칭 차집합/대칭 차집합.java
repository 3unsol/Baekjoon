import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		HashSet<Integer> aSet = new HashSet<>();
		HashSet<Integer> bSet = new HashSet<>();
		for (int i = 0; i < a; i++) {
			aSet.add(sc.nextInt());
		}
		for (int i = 0; i < b; i++) {
			bSet.add(sc.nextInt());
		}
		int ans = 0;
		// 해쉬셋은... 원소 하나를 못 꺼내온다..헉
		// 걍 포이치로 확인..
		for (int num : bSet) {
			if (!aSet.contains(num)) {
				ans += 1;
			}
		}
		for (int num : aSet) {
			if (!bSet.contains(num)) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}