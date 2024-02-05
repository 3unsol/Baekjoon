import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L, R, ans;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] isVisited;
    static List<Node> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        move();
        System.out.println(ans);
    }

    // 인구이동 메서드
    static void move() {

        while(true) {

            // 반복문을 멈출 변수
            boolean isMove = false;
            // 인구이동마다 방문배열 새로 만들어주기
            isVisited = new boolean[N][N];

            // 모든 노드 방문
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    
                    // 이번 인구이동에서 방문 안 한 애들만
                    if(!isVisited[r][c]) {
                        
                        // 인구이동 후 이번 인구이동으로 합쳐진 애들의 인구수 갖고 오기
                        int sum = bfs(r, c);
                        
                        // 리스트 사이즈가 2 이상이면 두 나라 이상이 합쳐진 거
                        if(list.size() > 1) {
                            
                            // 인구이동이 일어났다고 알려주기
                            isMove = true;
                            
                            // 인구이동 일어난 애들 평균값으로 바꿔주기
                            int avg = sum / list.size();
                            for(Node n : list) {
                                map[n.r][n.c] = avg;
                            }
                        }
                    }
                }
            }
            
            // 모든 노드 방문했는데 인구이동이 일어나지 않았다면 그만
            if(!isMove) return;
            
            // 아니라면 인구이동 일수 늘려주기
            ans++;
        }
    }

    static int bfs(int r, int c) {
        
        // bfs 탐색할 큐
        Queue<Node> q = new LinkedList<>();
        // 인구이동이 일어난 도시 저장하는 리스트
        list = new ArrayList<>();

        // 시작 나라 큐, 리스트 넣어주고 방문처리
        q.offer(new Node(r, c));
        list.add(new Node(r, c));
        isVisited[r][c] = true;

        // 인구이동 일어난 나라의 인구수 합 저장하는 변수
        int sum = map[r][c];

        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && !isVisited[nr][nc]) {
                    if(Math.abs(map[now.r][now.c] - map[nr][nc]) >= L && Math.abs(map[now.r][now.c] - map[nr][nc]) <= R) {
                        q.offer(new Node(nr, nc));
                        list.add(new Node(nr, nc));
                        sum += map[nr][nc];
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }
        return sum;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c>= 0 && r < N && c < N;
    }

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}