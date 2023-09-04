import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ROW, COL, DAY;
    static int[][] TOMATO;
    static int RIPE = 1;
    static int UNRIPE = 0;
    static int EMPTY = -1;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();
    // static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        input();
        if(complete()){
            System.out.println(0);
            return;
        }
        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(TOMATO[r][c] == RIPE){
                    q.offer(new Node(r, c, 0));
                }
            }
        }
        bfs();
        if(complete()){
            System.out.println(DAY);
        }else{
            System.out.println(-1);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        COL = Integer.parseInt(st.nextToken());
        ROW = Integer.parseInt(st.nextToken());
        TOMATO = new int[ROW][COL];
        for(int r = 0; r < ROW; r++){
            st = new StringTokenizer(br.readLine());
            // for(int c = 0; c < COL; c++){
            //     TOMATO[r][c] = Integer.parseInt(st.nextToken());
            // }
            int c = 0;
            while (st.hasMoreTokens()){
                TOMATO[r][c++] = Integer.parseInt(st.nextToken());
            }
        }
        DAY = 0;
    }

    static void bfs(){

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int dir = 0; dir < 4; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];
                if(!outOfRange(nr, nc) && TOMATO[nr][nc] == UNRIPE){
                    q.offer(new Node(nr, nc, node.day + 1));
                    DAY = node.day + 1;
                    TOMATO[nr][nc] = RIPE;
                }
            }
        }
    }

    static class Node {
        int r;
        int c;
        int day;

        Node(int r, int c, int day){
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    static boolean outOfRange(int nr, int nc){
        if(nr < 0 || nc < 0 || nr >= ROW || nc >= COL){
            return true;
        }
        return false;
    }

    static boolean complete(){
        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(TOMATO[r][c] == UNRIPE){
                    return false;
                }
            }
        }
        return true;
    }
}