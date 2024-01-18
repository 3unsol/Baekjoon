import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int SNAKE = 2;
    static final int APPLE = 1;
    static final int BLANK = 0;
    static int mapSize, appleCnt, time;
    static int[][] map;
    static Map<Integer, Character> directions = new HashMap<>();
    static Queue<Node> snake = new LinkedList<>();

    // 우1 하2 좌3 상4
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        input();
        playDummy();
        System.out.println(time);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        mapSize = Integer.parseInt(br.readLine());
        appleCnt = Integer.parseInt(br.readLine());

        map = new int[mapSize + 1][mapSize + 1];

        for(int i = 0; i < appleCnt; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = APPLE;
        }

        int rotationCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < rotationCnt; i++){
            st = new StringTokenizer(br.readLine());
            directions.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
    }

    static void playDummy() {

        // 시작점을 뱀으로 설정
        Node now = new Node(1, 1);
        snake.offer(new Node(now.r, now.c));
        map[now.r][now.c] = SNAKE;

        // 시작 방향은 좌향
        int dir = 0;

        while(true){

            // turn 수 증가
            time++;

            // 앞으로 고고
            int nr = now.r + dr[dir];
            int nc = now.c + dc[dir];

            // 앞이 벽이거나 내 몸이면 그만
            if(isWall(nr, nc) || map[nr][nc] == SNAKE) break;

            // 빈 공간이면
            if(map[nr][nc] == BLANK){
                // 꼬리 안 길어짐
                Node tail = snake.poll();
                map[tail.r][tail.c] = BLANK;
            }

            // 새로운 자리에 머리 두기
            snake.offer(new Node(nr, nc));
            map[nr][nc] = SNAKE;
            now.r = nr;
            now.c = nc;

            // 방향 전환 타임인지 확인
            if(directions.containsKey(time)){
                if(directions.get(time) == 'D'){
                    dir++;
                    if(dir == 4) dir = 0;
                } else {
                    dir--;
                    if(dir == -1) dir = 3;
                }
            }
        }
    }

    static boolean isWall(int r, int c){
        return r < 1 || c < 1 || r > mapSize || c > mapSize;
    }
    static class Node {
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}