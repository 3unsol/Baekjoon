import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1. 25C7 조합 만들기 -> 48만7백개
 * 2. 만든 조합들 bfs 돌면서 인접한가 확인
 * 3. S >= 4 인지 확인
 */
public class Main {

    static char[][] map = new char[5][5];
    static boolean[] isVisited;
    static int[] result = new int[7];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int r = 0; r < 5; r++) {
            String str = br.readLine();
            for(int c = 0; c < 5; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        comb(0, 0, 0);
        System.out.println(ans);
    }

    /**
     * comb() : 25명 중에 7명 조합 만들기
     * k : 넣을 자리, idx : 시작 위치, yCnt : 임도연파 수
     */
    static void comb(int k, int idx, int yCnt) {

        // 임도연파가 더 많으면 그만 보기
        if(yCnt >= 4) return;

        // 조합 완성!
        if(k == 7) {
            // 연결되어있는지 확인하러 ㄱㄱ
            if(bfs()) ans++;
            return;
        }

        // 조합 만들기
        for(int i = idx; i < 25; i++) {
            result[k] = i;
            // 임도연파 수 세어서 조합 만들러 ㄱㄱ
            if(map[i / 5][i % 5] == 'Y') {
                comb(k + 1, i + 1, yCnt + 1);
            } else {
                comb(k + 1, i + 1, yCnt);
            }
        }
    }

    /**
     * bfs() : 7명이 연결되어있는지 확인
     */
    static boolean bfs() {

        Queue<Node> q = new LinkedList<>();
        // 조합 만들어질 때마다 방문 배열 다시 만들기
        isVisited = new boolean[7];
        // result 배열의 첫 번째 숫자를 map[r][c]로 바꾼 걸 q에 넣기
        q.offer(new Node(result[0] / 5, result[0] % 5));
        // 첫 번째 숫자 방문처리
        isVisited[0] = true;
        // 연결된 개수
        int cnt = 1;

        while(!q.isEmpty()) {

            Node now = q.poll();

            // 지금 내 주변에
            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc)) {
                    // 선택 되었고 + 방문 아직 ㄴㄴ인 애가 있는지 확인
                    for(int i = 0; i < 7; i++) {
                        if(!isVisited[i] && result[i] == nr * 5 + nc) {
                            cnt++;
                            isVisited[i] = true;
                            q.offer(new Node(nr, nc));
                        }
                    }
                }
            }
        }

        if(cnt == 7) {
            return true;
        }
        return false;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < 5 && c < 5;
    }

    static class Node {
        int r, c;

        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}