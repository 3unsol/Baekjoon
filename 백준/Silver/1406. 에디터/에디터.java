import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 스택
		Stack<Character> stack = new Stack<>();
		Stack<Character> tmpStack = new Stack<>();
		// 문자열
		String st = sc.next();
		// 문자 하나하나 스택에 넣기
		for (int i = 0; i < st.length(); i++) {
			stack.push(st.charAt(i));
		}
		// 명령 개수
		int num = sc.nextInt();
		// 명령 실행
		for (int i = 0; i < num; i++) {
			// 명령어
			char ch = sc.next().charAt(0);
			// L이면 커서 왼쪽
			if (ch == 'L') {
				if (!stack.isEmpty()) {
					char tmp = stack.pop();
					tmpStack.push(tmp);
				}
				// D면 커서 오른쪽
			} else if (ch == 'D') {
				if (!tmpStack.isEmpty()) {
					char tmp = tmpStack.pop();
					stack.push(tmp);
				}
				// B면 왼쪽 지우고
			} else if (ch == 'B') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
				// P면 다음 문자를 해당 위치에 추가
			} else if (ch == 'P') {
				char ch2 = sc.next().charAt(0);
				stack.push(ch2);
			}
		}
		while (!tmpStack.isEmpty()) {
			stack.push(tmpStack.pop());
		}
		// 뒤집어서 출력하기 위해 스트링빌더 사용
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.reverse());
	}
}
