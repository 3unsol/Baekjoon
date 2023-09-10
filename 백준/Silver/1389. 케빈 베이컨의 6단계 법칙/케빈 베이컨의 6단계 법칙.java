import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  BFS
 */

public class Main {

    static int n, m, ans;
    static int min = Integer.MAX_VALUE;
    static boolean[][] adjArr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjArr = new boolean[n + 1][n + 1];
        ans = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjArr[a][b] = adjArr[b][a] = true;
        }
        for(int i = 1; i <= n; i++){
            bfs(i);
        }
    }

    static void bfs(int a){
        isVisited = new boolean[n + 1];
        int tmp = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a, 0));
        isVisited[a] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            tmp += node.depth;
            for(int i = 1; i <= n; i++){
                if(!isVisited[i] && adjArr[node.friend][i]){
                    q.offer(new Node(i, node.depth + 1));
                    isVisited[i] = true;
                }
            }
        }
        if(min > tmp) {
            min = tmp;
            ans = a;
        }else if(min == tmp){
            if(ans > a){
                ans = a;
            }
        }
    }

    static class Node {
        int friend;
        int depth;
        Node(int friend, int depth){
            this.friend = friend;
            this.depth = depth;
        }
    }

}