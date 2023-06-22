import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		// 한 문장씩 받을 str
		String str;
		while (true) {
			str = sc.nextLine();
			// str이 "."이면 종료
			if (str.equals(".")) {
				break;
			}
			// 괄호를 담을 스택 생성
			Stack<Character> stack = new Stack<>();
			// 플래그
			boolean flag = true;
			// 문자열 돌면서 하나씩 확인
			for (int i = 0; i < str.length(); i++) {
				// char로 바꿔주고
				char c = str.charAt(i);
				// 여는 괄호면 스택에 넣어주기
				if (c == '(' || c == '[') {
					stack.push(c);
				}
				// 닫는 소괄호일 때
				else if (c == ')') {
					// 스택이 비었거나 스택 꼭대기에 있는 게 여는 소괄호가 아니라면
					if (stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					}
					// 스택이 비지 않았고 꼭대기에 있는 게 여는 소괄호라면 스택에서 뽑아내기
					else if (stack.peek() == '(') {
						stack.pop();
					}
				}
				// 닫는 대괄호일 때
				else if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					} else if (stack.peek() == '[') {
						stack.pop();
					}
				}
			}
			if (stack.isEmpty() && flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}