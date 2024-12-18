import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int cheese;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 1) cheese++;
            }
        }

        int prevCheese = 0;
        int time = 0;

        while(cheese != 0) {
            // 이전 치즈 개수 저장
            prevCheese = cheese;
            // 시간
            time++;
            // 방문배열 초기화
            isVisited = new boolean[N][M];
            bfs();
        }

        System.out.println(time);
        System.out.println(prevCheese);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        isVisited[0][0] = true;

        while(!q.isEmpty()) {

            Node now = q.poll();

            for(int dir = 0; dir < 4; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(canMove(nr, nc) && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    if(map[nr][nc] == 0) {
                        // 빈칸이면 q에 넣기
                        q.offer(new Node(nr, nc));
                    } else {
                        // 치즈면 빈칸으로 바꿔주고 치즈 개수 줄이기
                        map[nr][nc] = 0;
                        cheese--;
                    }
                }
            }

        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}