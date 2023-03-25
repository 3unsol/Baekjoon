import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int ans;
	static Queue<Integer> q;
	static Queue<Integer> idx;

	static void print() {
		int cnt = 1;
		while (!q.isEmpty()) {
			int max = Collections.max(q);
			int cur = q.poll();
			int curIdx = idx.poll();
			if (cur == max) {
				if (curIdx == m) {
					ans = cnt;
				}
				cnt++;
			} else {
				q.offer(cur);
				idx.offer(curIdx);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			q = new LinkedList<>();
			idx = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				q.offer(sc.nextInt());
				idx.offer(i);
			}
			ans = 0;
			print();
			System.out.println(ans);
		}
	}
}