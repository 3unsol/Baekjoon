import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int row, col, height, day;
    static int[][][] tomato;
    static final int RIPE = 1;
    static final int UNRIPE = 0;
    static final int EMPTY = -1;
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static Queue<Node> q = new LinkedList<>();
    // static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        input();
        if(complete()){
            System.out.println(UNRIPE);
            return;
        }
        for(int h = 0; h < height; h++) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (tomato[h][r][c] == RIPE) {
                        q.offer(new Node(r, c, h, 0));
                    }
                }
            }
        }
        bfs();
        if(complete()){
            System.out.println(day);
        }else{
            System.out.println(EMPTY);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        tomato = new int[height][row][col];
        for(int h = 0; h < height; h++) {
            for (int r = 0; r < row; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < col; c++) {
                    tomato[h][r][c] = Integer.parseInt(st.nextToken());
                }
            }
        }
        day = 0;
    }

    static void bfs(){

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int dir = 0; dir < 6; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];
                int nh = node.h + dh[dir];
                if(!outOfRange(nr, nc, nh) && tomato[nh][nr][nc] == UNRIPE){
                    q.offer(new Node(nr, nc, nh, node.day + 1));
                    day = node.day + 1;
                    tomato[nh][nr][nc] = RIPE;
                }
            }
        }
    }

    static class Node {
        int r;
        int c;
        int h;
        int day;

        Node(int r, int c, int h, int day){
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }
    }

    static boolean outOfRange(int nr, int nc, int nh){
        if(nr < 0 || nc < 0 || nr >= row || nc >= col || nh < 0 || nh >= height){
            return true;
        }
        return false;
    }

    static boolean complete(){
        for(int h = 0; h < height; h++) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (tomato[h][r][c] == UNRIPE) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}