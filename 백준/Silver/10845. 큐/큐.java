import java.util.Scanner;

public class Main {

	static int[] queue = new int[10000];
	static int front = 0;
	static int rear = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			switch (sc.next()) {
			case "push":
				offer(sc.nextInt());
				break;
			case "pop":
				sb.append(poll()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(isEmpty()).append("\n");
				break;
			case "front":
				sb.append(peek()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	static void offer(int x) {
		queue[++rear] = x;
	}

	static int poll() {
		if (isEmpty() == 1) {
			return -1;
		}
		return queue[front++];
	}

	static int size() {
		return rear - front + 1;
	}

	static int isEmpty() {
		if (rear == front - 1) {
			return 1;
		}
		return 0;
	}

	static int peek() {
		if (isEmpty() == 1) {
			return -1;
		}
		return queue[front];
	}

	static int back() {
		if (isEmpty() == 1) {
			return -1;
		}
		return queue[rear];
	}

	static boolean isFull() {
		return rear == queue.length - 1;
	}
}
