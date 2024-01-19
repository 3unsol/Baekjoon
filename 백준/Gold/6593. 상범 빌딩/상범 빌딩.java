import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L, R, C;
    static int[][][] building;
    static boolean[][][] isVisited;
    static int[] dl = {-1, 0, 0, 1, 0, 0};
    static int[] dr = {0, 0, 0, 0, 1, -1};
    static int[] dc = {0, 1, -1, 0, 0, 0};
    static int startL, startR, startC;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            building = new int[L][R][C];
            isVisited = new boolean[L][R][C];

            for(int l = 0; l < L; l++){
                for(int r = 0; r < R; r++){
                    String line = br.readLine();
                    for(int c = 0; c < C; c++){

                        building[l][r][c] = line.charAt(c);

                        if(building[l][r][c] == 'S'){
                            startL = l;
                            startR = r;
                            startC = c;
                        }
                    }
                }
                br.readLine();
            }

            int x = findExit();

            if(x == -1){
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + x + " minute(s).");
            }

        }
    }

    static int findExit(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startL, startR, startC, 0));
        isVisited[startL][startR][startC] = true;

        while(!q.isEmpty()){

            Node now = q.poll();

            if(building[now.l][now.r][now.c] == 'E') return now.depth;

            for(int dir = 0; dir < 6; dir++){

                int nl = now.l + dl[dir];
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nl, nr, nc) && !isVisited[nl][nr][nc]) {
                    if(building[nl][nr][nc] == '.' || building[nl][nr][nc] == 'E'){
                        q.offer(new Node(nl, nr, nc, now.depth + 1));
                        isVisited[nl][nr][nc] = true;
                    }
                }
            }
        }

        return -1;
    }

    static boolean canMove(int l, int r, int c) {
        return l >= 0 && r >= 0 && c >= 0 && l < L && r < R && c < C;
    }

    static class Node {
        int l;
        int r;
        int c;
        int depth;
        Node(int l, int r, int c, int depth){
            this.l = l;
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}