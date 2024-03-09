import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int ans;
    static boolean[] isVisited;
    static List<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }


        for(int i = 0; i < N; i++) {

            isVisited = new boolean[N];
            isVisited[i] = true;
            dfs(i, 0);
            isVisited[i] = false;
            if(ans == 1) {
                System.out.println(ans);
                return;
            }
        }

        if(ans != 1){
            System.out.println(0);
        }
    }

    static void dfs(int num, int dist) {


        if(dist == 4) {
            ans = 1;
            return;
        }

        for(int next : list.get(num)) {
            if(!isVisited[next]) {
                isVisited[next] = true;
                dfs(next, dist + 1);
                isVisited[next] = false;
            }
        }
    }
}