import java.util.Scanner;

public class Main {

	static int[] p; // 부모를 담을 배열
	static int[] rank; // 랭크를 담을 배열

	// union : 두 집합을 합칠 메서드
	// x, y : 합칠 좌표
	static void union(int x, int y) {
		int px = find(x); // x의 부모
		int py = find(y); // y의 부모

		if (rank[px] > rank[py]) { // x 부모의 랭크가 y 부모의 랭크보다 크면
			p[py] = px; // y의 부모를 x의 부모로 바꿔준다.
		} else { // x부모의 랭크가 y부모의 랭크보다 작거나 같을 떄
			if (rank[px] == rank[py]) { // 랭크가 같다면
				rank[py]++; // y의 랭크를 높여주고
			}
			p[px] = py; // x의 부모를 y의 부모로 바꿔준다.
		}
	}

	// find : 좌표의 부모를 찾을 메서드
	// x : 부모를 찾을 좌표
	static int find(int x) {
		if (x != p[x]) { // 본인이 부모가 아니라면
			p[x] = find(p[x]); // 부모를 찾을 때까지 찾고 찾으면 부모에 넣어준다.
		}
		return p[x]; // 대빵부모가 담긴다.
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		p = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 0; i <= n; i++) { // 자기 자신을 대표로 설정한다.
			p[i] = i;
		}
		int[][] edges = new int[m][3]; // 연결된 정보를 저장한다.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				edges[i][j] = sc.nextInt();
			}
		}
		String ans = ""; // 답을 담을 변수
		for (int i = 0; i < m; i++) { // 간선을 돌면서
			if (edges[i][0] == 0) { // 0번째 인덱스가 0이면
				union(edges[i][1], edges[i][2]); // 두 좌표를 합쳐준다.
			} else if (edges[i][0] == 1) { // 0번째 인덱스가 1이면
				if (find(edges[i][1]) == find(edges[i][2])) { // 두 부모가 같은지 확인
					ans = "YES"; // 같으면 1로 바꿔주고
				} else {
					ans = "NO"; // 다르면 0으로 바꿔준다.
				}
				System.out.println(ans); // 답을 출력한다.
			}
		}
	}
}
