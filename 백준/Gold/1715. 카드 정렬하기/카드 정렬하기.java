import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 카드 묶음 개수
		int n = sc.nextInt();
		// 작은 수부터 더해야 좋기 때문에 우선순위 큐에 넣어준다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.offer(sc.nextInt());
		}
		// sum : 최종 비교 횟수
		int sum = 0;
		// 카드 묶음이 1개 일 때는 그냥 뽑아냄
//		if (n == 1) {
//			sum = pq.poll();
//			// 2개 이상이라면
//			// 두 묶음 더한 값이 최솟값이 아닐 수 있기 떄문에
//			// 더한 값을 큐에 넣어준다.
//		} else {
		// tmp : 두 묶음 더한 값
		int tmp = 0;
		while (pq.size() > 1) {
			tmp = pq.poll() + pq.poll();
			sum += (tmp);
			pq.offer(tmp);
		}
//		}
		System.out.println(sum);
	}
}
