import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); // a진법
		int b = sc.nextInt(); // b진법
		int m = sc.nextInt(); // 자리수 개수
		int[] arr = new int[m + 1]; // 자리수에 따른 숫자를 담을 배열
		for (int i = 1; i <= m; i++) {
			arr[i] = sc.nextInt(); // 자리수에 숫자 넣기
		}
		int tmp = 0; // 10진수로 바꿀 거
		for (int i = 1; i <= m; i++) { // 자리수 개수만큼
			tmp += arr[i] * Math.pow(a, m - i); // (자리에 해당하는 수 * a진법^자리수) 더하기
		}
		Stack<Integer> stack = new Stack<>(); // 거꾸로 뽑기 위해 스택 사용
		// 10진수로 바꾼 거 b진법으로 바꾸기
		while (tmp != 0) { // 수가 0이 될 때까지
			stack.push(tmp % b); // b로 나눈 나머지 넣기
			tmp /= b; // b로 나누기
		}
		while (!stack.isEmpty()) {
			if (stack.size() == 1) {
				System.out.print(stack.peek());
			} else {
				System.out.print(stack.peek() + " ");
			}
			stack.pop();
		}
	}
}