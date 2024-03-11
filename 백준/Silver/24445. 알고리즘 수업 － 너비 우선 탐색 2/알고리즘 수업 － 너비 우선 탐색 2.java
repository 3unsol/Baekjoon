import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[] isVisited;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 0; i <= N; i++) {
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        isVisited = new int[N + 1];

        bfs(R);

        for(int i = 1; i <= N; i++) {
            System.out.println(isVisited[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start] = 1;
        int rank = 1;

        while(!q.isEmpty()) {

            int now = q.poll();

            for(int next : list.get(now)) {
                if(isVisited[next] == 0) {
                    isVisited[next] = ++rank;
                    q.offer(next);
                }
            }
        }
    }
}
