import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, homeX, homeY, pentaX, pentaY;
    static Node[] combi;
    static boolean[] isVisited;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++){
            input();
            bfs();
            if(flag){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
    }

    static void input() throws Exception {

        N = Integer.parseInt(br.readLine());
        combi = new Node[N];
        isVisited = new boolean[N];
        flag = false;

        st = new StringTokenizer(br.readLine());
        homeX = Integer.parseInt(st.nextToken());
        homeY = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            combi[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        pentaX = Integer.parseInt(st.nextToken());
        pentaY = Integer.parseInt(st.nextToken());
    }

    static void bfs() {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(homeX, homeY));

        while(!q.isEmpty()){

            Node now = q.poll();

            if(Math.abs(now.x - pentaX) + Math.abs(now.y - pentaY) <= 1000){
                flag = true;
                return;
            }

            for(int i = 0; i < N; i++){
                if(!isVisited[i]){
                    if(Math.abs(now.x - combi[i].x) + Math.abs(now.y - combi[i].y) <= 1000){
                        isVisited[i] = true;
                        q.offer(combi[i]);
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}