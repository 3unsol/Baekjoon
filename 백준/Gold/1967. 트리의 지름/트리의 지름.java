import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static boolean[] isVisited;
    static List<ArrayList<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 양방향 간선 정보 저장
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, cost));
            list.get(b).add(new Node(a, cost));
        }

        // 각 노드마다 연결된 모든 노드 들르면서 최대값 갱신
        for(int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            isVisited[i] = true;
            dfs(i, 0);
        }

        // 최대값 출력
        System.out.println(max);
    }

    // num : 노드 번호, cost : 현재 노드까지 오는 데 들인 비용
    static void dfs(int num, int cost) {

        // 해당 노드와 연결된 모든 노드 탐색
        for(Node next : list.get(num)){
            // 그 중 방문하지 않은 노드에 방문하기
            if(!isVisited[next.num]) {
                isVisited[next.num] = true;
                // 그 노드에서 갈 수 있는 길 탐색하러 ㄱㄱ
                dfs(next.num, cost + next.cost);
            }
        }
        // 갔다왔으면 최대값 갱신
        max = Math.max(max, cost);
    }

    static class Node {
        int num, cost;
        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}