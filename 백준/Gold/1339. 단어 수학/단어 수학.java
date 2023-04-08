import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 문자열 개수
		String[] strArr = new String[n]; // 문자 배열에 하나씩 넣어준다.
		for (int i = 0; i < n; i++) {
			strArr[i] = sc.next();
		}
		int[] cntArr = new int[26]; // 알파벳 뭐 썼는지 담을 배열
		// 문자열 하나씩 돌면서
		// 자릿수마다 나눠서 값을 계산해준다.
		for (int i = 0; i < n; i++) {
			int tmp = (int) Math.pow(10, strArr[i].length() - 1); // 자릿수는 10의 배수
			for (int j = 0; j < strArr[i].length(); j++) { // 문자 하나씩 계산할 것
				cntArr[strArr[i].charAt(j) - 'A'] += tmp; // 알파벳을 정수로 바꿔서 인덱스로 쓴다. 각 자릿수만큼 더해줌.
				tmp /= 10; // 그 자릿수 끝났으면 10으로 나눠준다.
			}
		}
		Arrays.sort(cntArr); // 많이 나온 순서를 알아야 하니까 정렬
		int num = 9; // 9부터 넣어줄 것
		int sum = 0; // 합을 담을 변수
		for (int i = 25; i >= 0; i--) { // 알파벳 배열 돌면서
			if (cntArr[i] == 0) { // 0이면 끝
				break;
			}
			sum += cntArr[i] * num; // 해당 알파벳 값에 해당하는 숫자를 곱해서 더해준다.
			num--; // 숫자 줄여주기
		}
		System.out.println(sum);
	}
}
