import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] time, inDegree, result;
    static List<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        time = new int[N + 1];
        inDegree = new int[N + 1];
        result = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++) {

            result[i] = time[i] = sc.nextInt();

            while(sc.hasNext()) {

                int next = sc.nextInt();

                if(next == -1) break;

                adjList.get(next).add(i);
                inDegree[i]++;
            }
        }

        bfs();

        for(int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()){

            int now = q.poll();

            for(int next : adjList.get(now)) {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[now] + time[next]);
                if(inDegree[next] == 0) q.offer(next);
            }
        }
    }
}
