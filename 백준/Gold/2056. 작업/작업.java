import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] time, inDegree, result;
    static List<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 작업 개수
        N = Integer.parseInt(br.readLine());
        
        // 해당 작업만 하는 데 걸리는 시간
        time = new int[N + 1];
        
        // 해당 작업을 하려면 앞에 몇 개의 작업을 해야 하는지 저장
        inDegree = new int[N + 1];
        
        // 해당 작업까지 걸리는 총 시간
        result = new int[N + 1];

        // 인접리스트 빈 바구니 만들기
        for(int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        // 시간, 순서, 인접 정보 등 입력
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            result[i] = time[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++) {
                int next = Integer.parseInt(st.nextToken());
                adjList.get(i).add(next);
                inDegree[next]++;
            }
        }

        // 작업 시간 구하기
        bfs();

        // 모든 작업을 완료해야 하니까 젤 오래걸리는 애 출력
        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, result[i]);
        }

        System.out.println(max);
    }

    static void bfs() {
        // 작업 순서 담을 큐
        Queue<Integer> q = new LinkedList<>();

        // 내 앞에 아무도 없는 애들은 시작해도 됨
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {

            // 현재 작업
            int now = q.poll();

            // 현재 작업이 끝나면 할 수 있는 애들
            for(int next : adjList.get(now)) {
                // 현재 작업 끝나면 순서 앞당기기
                inDegree[next]--;
                // 내 앞에 해야 할 작업들 중 가장 오래걸리는 애 + 내 작업 시간
                result[next] = Math.max(result[next], result[now] + time[next]);
                // 이제 내 앞에 아무도 없으면 작업ㄱㄱ
                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}