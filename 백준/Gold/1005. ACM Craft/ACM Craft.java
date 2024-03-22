import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, W, ans;
    static int[] time;
    static int[] stackTime;
    static int[] inDegree;
    static List<ArrayList<Integer>> adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {

            st = new StringTokenizer(br.readLine());

            // 건물 번호
            N = Integer.parseInt(st.nextToken());

            // 건물 관계 개수
            K = Integer.parseInt(st.nextToken());

            // 해당 건물만 짓는 데 걸리는 시간
            time = new int[N + 1];

            // 해당 건물을 다 지으려면 걸리는 시간
            stackTime = new int[N + 1];

            // 인접리스트
            adjList = new ArrayList<>();
            adjList.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= N; i++) {
                int val = Integer.parseInt(st.nextToken());
                time[i] = stackTime[i] = val;
                // 인접 리스트에 빈 바구니 만들어주기
                adjList.add(new ArrayList<>());
            }

            // 내 앞에 몇 개 있는지 저장하는 배열
            inDegree = new int[N + 1];

            // 건물 관계 입력
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // b를 지으려면 a 먼저 지어야 함
                adjList.get(a).add(b);
                inDegree[b]++;
            }

            // 마지막 건물
            W = Integer.parseInt(br.readLine());

            // 총 시간
            ans = 0;

            // 너비우선탐색
            bfs();

            System.out.println(ans);
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        // 내 앞에 아무도 없으면 q에 넣기
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {

            int now = q.poll();

            if(now == W) {
                ans = stackTime[now];
            }

            // 내 뒤에 있는 애들
            for(int next : adjList.get(now)) {
                // 나 갔으니까 순서 줄여주기
                inDegree[next]--;
                // 지금 뽑힌 now에서 오는게 더 크면 갱신해주기
                stackTime[next] = Math.max(stackTime[next], stackTime[now] + time[next]);
                // 이제 앞에 아무도 없다
                if(inDegree[next] == 0) {
                    // 들어가거라
                    q.offer(next);
                }
            }
        }
    }
}