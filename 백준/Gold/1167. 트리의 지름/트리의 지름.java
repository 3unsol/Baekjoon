import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, max, findNode;
    static List<ArrayList<Node>> list = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            while(true) {

                int num2 = Integer.parseInt(st.nextToken());
                if(num2 == -1) break;
                int dist = Integer.parseInt(st.nextToken());

                list.get(num).add(new Node(num2, dist));
            }
        }

        isVisited = new boolean[N + 1];
        dfs(1, 0);

        max = 0;
        Arrays.fill(isVisited, false);
        dfs(findNode, 0);

        System.out.println(max);
    }

    static void dfs(int num, int cost) {

        isVisited[num] = true;
        if(cost > max) {
            max = cost;
            findNode = num;
        }

        for(Node next : list.get(num)) {
            if(!isVisited[next.num]) {
                dfs(next.num, cost + next.dist);
            }
        }
    }

    static class Node {
        int num, dist;

        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}