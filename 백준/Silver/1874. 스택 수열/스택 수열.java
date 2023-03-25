
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>(); // 스택 생성
		ArrayList<Character> ans = new ArrayList<Character>(); // 답 출력할 리스트
		int n = sc.nextInt(); // 스택에 쌓을 숫자 개수
		int start = 0; // 인덱스 역할을 할 변수
		while (n-- > 0) { // while문 n번 반복하고 싶을 때 이렇게 쓰는구나
			int cur = sc.nextInt(); // 현재 입력받은 값
			if (cur > start) { // 현재 값이 전에 넣은 값보다 크다면
				for (int i = start + 1; i <= cur; i++) { // 인덱스 다음 숫자부터 입력받은 값까지
					stack.push(i); // 스택에 차곡차곡 쌓는다.
					ans.add('+'); // 스택에 넣어줄 때는 + 출력해야 하므로 답 리스트에 넣어준다.
				}
				start = cur; // 다음 입력값을 확인할 때 쓰기위해 인덱스에 현재 값을 넣어준다.
			} else if (stack.peek() != cur) { // 이 부분이 이해가 안 감... 스택 맨 위에 값이랑 현재 입력값이랑 다르다면?
				System.out.println("NO"); // 안 된다고 출력
				return; // 끝낸다.
			}
			stack.pop(); // 현재 입력값이 전값보다 작은데 맨 위에 있는 값과 현재 값이 같다면 스택에서 맨 위에 값을 제거한다.
			ans.add('-'); // 답 리스트에는 - 넣어줌
		}
		for (int i = 0; i < ans.size(); i++) { // 답 리스트를 출력한다.
			System.out.println(ans.get(i));
		}
	}
}