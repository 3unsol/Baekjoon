import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 42 크기의 배열을 생성한다.
		int[] arr = new int[42];
		// 입력값을 42로 나눈 나머지 값의 인덱스의 숫자를 늘려준다.
		for (int i = 0; i < 10; i++) {
			arr[sc.nextInt() % 42]++;
		}
		
		// 나머지 숫자가 몇 개인지 셀 변수
		int cnt = 0;
		
		// 배열을 돌면서 0이 아닌 개수를 세어준다.
		for (int i = 0; i < 42; i++) {
			if (arr[i] != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
