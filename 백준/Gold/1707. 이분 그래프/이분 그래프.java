import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static List<ArrayList<Integer>> adjList;
    static int[] colors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());

            // 정점 개수
            V = Integer.parseInt(st.nextToken());
            // 간선 개수
            E = Integer.parseInt(st.nextToken());
            // 인접 리스트
            adjList = new ArrayList<>();
            // 인접 리스트 빈 바구니 만들기
            for(int i = 0; i <= V; i++) {
                adjList.add(new ArrayList<>());
            }
            // 간선 정보 입력
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // 무방향 그래프
                adjList.get(a).add(b);
                adjList.get(b).add(a);
            }
            // 방문 배열
            colors = new int[V + 1];

            // 출력
            boolean flag = false;

            // bfs
            for(int i = 1; i <= V; i++) {
                if(colors[i] == 0) {
                    flag = bfs(i);
                }
                if(!flag) break;
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        colors[start] = 1;

        while(!q.isEmpty()) {

            int now = q.poll();
            int nowColor = colors[now] == 1 ? -1 : 1;

            for(int next : adjList.get(now)) {
                if(colors[next] == colors[now]) {
                    return false;
                }else if(colors[next] == 0) {
                    colors[next] = nowColor;
                    q.offer(next);
                }
            }
        }
        return true;
    }
}