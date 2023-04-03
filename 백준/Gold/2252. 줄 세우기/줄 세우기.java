import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 학생 수
		int m = sc.nextInt(); // 비교 횟수
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(); // 인접리스트 (배열로 하면 메모리초과)
		int[] inDegree = new int[n + 1]; // 진입 차수 저장 배열
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>()); // 리스트에 빈 바구니 만들어준다.
		}
		int a = 0;
		int b = 0;
		for (int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			adjList.get(a).add(b); // 인접리스트 입력
			inDegree[b]++; // 진입 차수 입력
		}
		Queue<Integer> q = new LinkedList<>(); // 큐 생성
		for (int i = 1; i <= n; i++) { // 1부터
			if (inDegree[i] == 0) { // 진입 차수가 0인 애들
				q.offer(i); // 큐에 넣어준다.
			}
		}
		while (!q.isEmpty()) { // 큐가 빌 때까지
			int tmp = q.poll(); // 하나 꺼내서
			System.out.print(tmp + " "); // 꺼낸 순서가 정렬 순서
			for (int i = 0; i < adjList.get(tmp).size(); i++) { // tmp와 인접한 애들 전부 확인
				inDegree[adjList.get(tmp).get(i)]--; // 인접한 애들 진입 차수 줄여주고
				if (inDegree[adjList.get(tmp).get(i)] == 0) { // 진입 차수가 0이라면
					q.offer(adjList.get(tmp).get(i)); // 큐에 넣어준다.
				}
			}
		}
	}
}
