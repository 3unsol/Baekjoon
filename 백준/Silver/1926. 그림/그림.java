import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, max, cnt;
    static int[][] map;
    static int[][] isVisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new int[n][m];
        max = 0;
        for(int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(map[r][c] == 1 && isVisited[r][c] == 0){
                    int tmp = bfs(r, c);
                    cnt++;
                    if(max < tmp){
                        max = tmp;
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    static int bfs(int r, int c){
        isVisited[r][c] = 1;
        int count = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(canMove(nr, nc) &&  map[nr][nc] == 1 && isVisited[nr][nc] == 0){
                    q.offer(new Node(nr, nc));
                    isVisited[nr][nc] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    static boolean canMove(int r, int c) {
        return !(r < 0 || c < 0 || r >= n || c >= m);
    }

    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}