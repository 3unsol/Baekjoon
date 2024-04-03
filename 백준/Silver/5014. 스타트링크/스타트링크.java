import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F, S, G, U, D;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        isVisited = new boolean[F + 1];

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(S, 0));
        isVisited[S] = true;

        while(!q.isEmpty()){

            Node now = q.poll();
            if(now.num == G) {
                System.out.println(now.dist);
                return;
            }

            int up = now.num + U;
            if(up <= F && !isVisited[up]) {
                q.offer(new Node(up, now.dist + 1));
                isVisited[up] = true;
            }

            int down = now.num - D;
            if(down > 0 && !isVisited[down]) {
                q.offer(new Node(down, now.dist + 1));
                isVisited[down] = true;
            }
        }

        System.out.println("use the stairs");
    }

    static class Node {
        int num, dist;
        Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }
}