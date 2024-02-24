import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[] isVisited;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        isVisited = new int[N + 1];

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

        for(int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }

        bfs(R);

        for(int i = 1; i <= N; i++) {
            sb.append(isVisited[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;
        q.offer(start);
        isVisited[start] = cnt++;

        while(!q.isEmpty()) {

            int now = q.poll();

            for(int num : list.get(now)) {
                if(isVisited[num] == 0) {
                    q.offer(num);
                    isVisited[num] = cnt++;
                }
            }
        }
    }
}