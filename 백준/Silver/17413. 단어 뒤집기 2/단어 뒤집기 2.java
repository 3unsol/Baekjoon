import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // 한 줄 다 갖고 와야 해서 nextLine
		String str = sc.nextLine();
        // 스택...뭔데..
		Stack<Character> stk = new Stack<>();
        // <> 안인지 밖인지 확인할 플래그
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
            // < 이거 만나면 그 전에 있던 것들 거꾸로 프린트
			if (str.charAt(i) == '<') {
                // 안에 있다고 알려줌
				flag = true;
				while (!stk.isEmpty()) {
					System.out.print(stk.pop());
				}
                // < 프린트
				System.out.print(str.charAt(i));
                // > 이거 만나면
			} else if (str.charAt(i) == '>') {
                // 벗어난 거 알려주고 > 프린트
				flag = false;
				System.out.print(str.charAt(i));
                // <> 안에 있으면 제대로 프린트
			} else if (flag) {
				System.out.print(str.charAt(i));
                // <> 여기 안이 아니면
			} else if (!flag) {
                // 공백 만나면 그 전까지 있던 거 프린트
				if (str.charAt(i) == ' ') {
					while (!stk.isEmpty()) {
						System.out.print(stk.pop());
					}
                    // 공백 프린트
					System.out.print(str.charAt(i));
                    // 스택에 넣어두기
				} else {
					stk.push(str.charAt(i));
				}
			}
		} // 남은 거 프린트
		while (!stk.isEmpty()) {
			System.out.print(stk.pop());
		}
	}
}
