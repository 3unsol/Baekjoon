import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int h, w;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    static class Node{
        int r;
        int c;

        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(h == 0 && w == 0){
                break;
            }
            visited = new boolean[h][w];
            map = new int[h][w];
            for(int r = 0; r < h; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < w; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for(int r = 0; r < h; r++){
                for(int c = 0; c < w; c++){
                    if(!visited[r][c] && map[r][c] == 1){
                        bfs(r, c);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int r, int c){
        Queue<Node> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Node(r, c));
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int dir = 0; dir < 8; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];
                if(nr >= 0 && nc >= 0 && nr < h && nc < w && !visited[nr][nc] && map[nr][nc] == 1){
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
    }
}