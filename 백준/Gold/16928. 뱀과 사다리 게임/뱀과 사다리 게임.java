import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int ladderCnt, snakeCnt, ans;
    static int[] board;


    public static void main(String[] args) throws IOException {
        input();
        bfs(1);
        System.out.println(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사다리 개수
        ladderCnt = Integer.parseInt(st.nextToken());
        // 뱀 개수
        snakeCnt = Integer.parseInt(st.nextToken());
        // 보드판 1-100까지
        board = new int[101];
        for(int i = 1; i < 101; i++){
            board[i] = i;
        }
        // 사다리 시작 칸에 도착값 입력
        for(int i = 0; i < ladderCnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }
        // 뱀 시작 칸에 도착값 입력
        for(int i = 0; i < snakeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

    }

    static void bfs(int startNode){
        // 깊이 저장
        int[] depth = new int[101];

        Queue<Integer> q = new LinkedList<>();
        // 1부터 넣기 시작
        q.offer(startNode);
        // 1은 시작 칸이라서 깊이 0
        depth[startNode] = 0;

        while(true){
            int node = q.poll();
            // 주사위 1-6 던지는 경우 모두 생각
            for(int i = 1; i < 7; i++){
                int newNode = node + i;
                // 100을 넘어가면 continue
                if(newNode > 100){
                    continue;
                }
                // 100보다 작고, 방문한 적이 없다면
                if(depth[board[newNode]] == 0){
                    // q에 넣기
                    q.offer(board[newNode]);
                    // 깊이 한 칸 늘려주기
                    depth[board[newNode]] = depth[node] + 1;
                }
                // 100에 도착했다면 그 값 저장
                if(board[newNode] == 100){
                    ans = depth[100];
                    return;
                }
            }
        }
    }
}