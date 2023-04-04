import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		int[] inDegree = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		int a = 0;
		int b = 0;
		for (int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			adjList.get(a).add(b);
			inDegree[b]++;
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp + " ");
			for (int i = 0; i < adjList.get(tmp).size(); i++) {
				inDegree[adjList.get(tmp).get(i)]--;
				if (inDegree[adjList.get(tmp).get(i)] == 0) {
					q.offer(adjList.get(tmp).get(i));
				}
			}
		}
	}
}
