import java.util.Scanner;

public class Main {

	static int[] stack = new int[10000];
	static int top = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			switch (sc.next()) {
			case "push":
				push(sc.nextInt());
				break;
			case "top":
				sb.append(peek()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "empty":
				sb.append(isEmpty()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	static void push(int x) {
		stack[++top] = x;
	}

	static int pop() {
		if (isEmpty() == 1) {
			return -1;
		}
		return stack[top--];
	}

	static int size() {
		return top + 1;
	}

	static int isEmpty() {
		if (top == -1) {
			return 1;
		} else
			return 0;
	}

	static int peek() {
		if (isEmpty() == 1) {
			return -1;
		}
		return stack[top];
	}
}
