import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 홍수를 일으킨다
 * 1-0. 모든 물을 큐에 넣기
 * 1-1. water배열에 홍수가 일어나는 시간 저장
 * 1-2. 0보다 크면 이미 홍수 일어난 것
 * 1-3. -1이면 홍수 일으킬 수 있음
 *
 * 2. 고슴도치의 이동
 * 2-1. 고슴도치 큐에 넣기
 * 2-2. 내 depth가 water[][]보다 작음 && map[][] != -2면 이동 가능
 * 2-3. 비버 만나면 return depth
 */

public class Main {

    static int R, C;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Node> q = new LinkedList<>();
    static Queue<Node> water = new LinkedList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static Node D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        isVisited = new boolean[R][C];

        for(int r = 0; r < R; r++) {
            String str = br.readLine();
            for(int c = 0; c < C; c++) {

                char sign = str.charAt(c);

                if(sign == 'X') { // 돌
                    map[r][c] = -2;
                } else if(sign == 'S') { // 고슴도치
                    q.offer(new Node(r, c, 0));
                    isVisited[r][c] = true;
                    map[r][c] = -1;
                } else if(sign == 'D') { // 비버
                    D = new Node(r, c, 0);
                    map[r][c] = -3;
                }else if(sign == '*') { // 물
                    water.offer(new Node(r, c, 0));
                    map[r][c] = 0;
                }else { // 길
                    map[r][c] = -1;
                }
            }
        }

        flood();

        int result = bfs();

        if(result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    static void flood(){

        while(!water.isEmpty()){

            Node now = water.poll();

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(!canMove(nr, nc)) continue; // 범위 ㄴㄴ
                if(map[nr][nc] >= 0) continue; // 이미 간 곳
                if(map[nr][nc] == -2 || map[nr][nc] == -3) continue; // 돌 or 비버

                water.offer(new Node(nr, nc, now.depth + 1));
                map[nr][nc] = now.depth + 1;
            }
        }
    }

    static int bfs() {

        while(!q.isEmpty()) {

            Node now = q.poll();

            if(now.r == D.r && now.c == D.c) {
                return now.depth;
            }

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(!canMove(nr, nc)) continue; // 범위 ㄴㄴ
                if(isVisited[nr][nc]) continue; // 이미 방문
                if(map[nr][nc] == -2) continue; // 돌
                if(map[nr][nc] != -1 && map[nr][nc] != -3 && map[nr][nc] <= now.depth + 1) continue; // 물이 먼저 번짐

                isVisited[nr][nc] = true;
                q.offer(new Node(nr, nc, now.depth + 1));
            }
        }

        return -1;
    }
    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    static class Node {
        int r, c, depth;
        Node(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}