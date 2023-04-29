import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static char[] sign = new char[10]; // 부등호 배열
	static boolean[] isUsed = new boolean[10]; // 방문 처리
	static int k; // 부등호 개수
	static List<String> numList = new ArrayList<String>(); // 조합 리스트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		for (int i = 0; i < k; i++) { // 부등호 배열에 입력 받기
			sign[i] = sc.next().charAt(0);
		}
		comb(0, ""); // 시작 인덱스 0, String 바구니
		Collections.sort(numList);
		System.out.println(numList.get(numList.size() - 1));
		System.out.println(numList.get(0));
	}

	// 숫자 조합 메서드
	// idx : 조합 인덱스 (부등호 개수 + 1)
	// num : 완성된 수
	static void comb(int idx, String num) {
		if (idx == k + 1) { // 조합이 완성
			numList.add(num); // 조합 리스트에 추가한다.
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (isUsed[i]) { // 사용한 숫자라면 넘기기
				continue;
			}
			// 처음 넣거나 || 체크해봤더니 넣어도 된다면 조합에 넣는다.
			if (idx == 0 || check(num.charAt(idx - 1), (char) (i + '0'), sign[idx - 1])) {
				isUsed[i] = true;
				comb(idx + 1, num + i);
				isUsed[i] = false;
			}
		}
	}

	// 넣을 수 있는지 확인하는 메서드
	// a : 내 앞에 들어간 숫자
	// b : 나 (지금 넣을 숫자)
	// c : 현재 부등호
	static boolean check(char a, char b, char c) {
		if (c == '<') {
			if (a > b) {
				return false;
			}
		}
		if (c == '>') {
			if (a < b) {
				return false;
			}
		}
		return true;
	}
}