import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 큐의 크기
		m = sc.nextInt(); // 뽑아낼 수의 개수
		LinkedList<Integer> dq = new LinkedList<>(); // 덱
		for (int i = 1; i <= n; i++) { // 1~N까지 넣기
			dq.offer(i);
		}
		int[] num = new int[m]; // 뽑아낼 수의 배열
		for (int i = 0; i < m; i++) { // 배열에 숫자 입력
			num[i] = sc.nextInt();
		}
		int cnt = 0; // 답
		for (int i = 0; i < m; i++) {
			// deque에는 인덱스 찾아내는 메서드가 없다!
			// linkedList.indexOf를 쓰면 해당 숫자의 인덱스를 찾을 수 있다.
			// 근데 숫자가 중복되면 어케 찾음?..
			// -> 제일 처음 발견한 인덱스를 찾아준다고 한다 (오...)
			int idx = dq.indexOf(num[i]); // 해당 숫자의 현재 위치를 저장
			if (idx <= dq.size() / 2) { // 앞이랑 더 가까우면 앞으로 빼내기
				for (int j = 0; j < idx; j++) {
					int tmp = dq.pollFirst(); // 앞에서 빼고
					dq.offerLast(tmp); // 뒤에 넣는다
					cnt++;
				}
			} else { // 뒤랑 더 가까우면 (전체 크기 - 현재 idx)만큼 뒤에서 뺀다
				for (int j = 0; j < dq.size() - idx; j++) {
					int tmp = dq.pollLast();
					dq.offerFirst(tmp); // 앞에 넣기
					cnt++;
				}
			}
			dq.pollFirst(); // 해당 인덱스가 맨 앞에 왔으니 빼낸다
		}
		System.out.println(cnt);
	}
}