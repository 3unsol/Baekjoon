import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] adjList;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        isVisited = new boolean[N + 1];
        isVisited[1] = true;

        dfs(1, 0);

        int cnt = 0;
        for(int i = 2; i <= N; i++) {
            if(isVisited[i]) cnt++;
        }

        System.out.println(cnt);
    }

    static void dfs(int num, int depth) {

        if(depth == 2) {
            return;
        }
        for(int next : adjList[num]) {
                isVisited[next] = true;
                dfs(next, depth + 1);
        }
    }
}