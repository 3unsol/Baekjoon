import java.util.*;

/**
1. board의 빈칸 list에 넣기
2. 퍼즐 조각 list에 넣기
3. 빈칸이랑 퍼즐 조각 맞는지 비교하기
3-1. 비교하기 위해서 정규화 (0,0)에서 시작하는 걸로
**/

class Solution {
    
    static List<List<Node>> tableList = new ArrayList<>();
    static List<List<Node>> boardList = new ArrayList<>();
    static int length;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        length = table.length;
        boolean[][] visitedTable = new boolean[length][length];
        boolean[][] visitedBoard = new boolean[length][length];
        
        // 빈칸 0 <-> 1 바꾸기
        for(int r = 0; r < length; r++) {
            for(int c = 0; c < length; c++) {
                if(game_board[r][c] == 1) {
                    game_board[r][c] = 0;
                } else {
                    game_board[r][c] = 1;
                }
            }
        }
        
        // 빈칸 or 조각 찾기
        for(int r = 0; r < length; r++) {
            for(int c = 0; c < length; c++) {
                // 조각 찾기
                if(table[r][c] == 1 && !visitedTable[r][c]) {
                    bfs(r, c, table, visitedTable, tableList);
                }
                
                // 빈칸 찾기
                if(game_board[r][c] == 1 && !visitedBoard[r][c]) {
                    bfs(r, c, game_board, visitedBoard, boardList);
                }
            }
        }
        
        // 조각과 빈칸 회전하면서 비교
        answer = compareBlock(tableList, boardList, answer);
        
        return answer;
    }
    
    static int compareBlock(List<List<Node>> table, List<List<Node>> board, int answer) {
        int tableSize = table.size();
        int boardSize = board.size();
        
        // 해당 빈칸이 채워졌는지 확인하는 방문 배열
        boolean[] visited = new boolean[boardSize];
        
        for(int i = 0; i < tableSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                // 이미 찾았거나 개수가 안 맞으면 패스
                if(visited[j] || table.get(i).size() != board.get(j).size()) {
                    continue;
                }
                // 회전해서 찾았다면 방문 처리 + 개수 늘리기
             if(isRotate(table.get(i), board.get(j))) {
                 visited[j] = true;
                 answer += board.get(j).size();
                 break;
             }   
            }
        }
        return answer;
    }
    
    static boolean isRotate(List<Node> table, List<Node> board) {
        // 오름차순 정렬
        Collections.sort(board);
        
        // 90도씩 회전
        for(int i = 0; i < 4; i++) {
            // 회전할 때마다 table 오름차순 정렬
            Collections.sort(table);
            
            int nowR = table.get(0).r;
            int nowC = table.get(0).c;
            
            // 회전해서 바뀐 좌표를 다시 (0, 0) 기준으로
            for(int j = 0; j < table.size(); j++) {
                table.get(j).r -= nowR;
                table.get(j).c -= nowC;
            }
            
            boolean flag = true;
            
            // 좌표 비교했을 때 일치하지 않으면 false
            for(int j = 0; j < board.size(); j++) {
                if(board.get(j).r != table.get(j).r || board.get(j).c != table.get(j).c) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                return true;
            } else {
                // 90도 회전 r, c -> c, -r
                for(int j = 0; j < table.size(); j++) {
                    int tmp = table.get(j).r;
                    table.get(j).r = table.get(j).c;
                    table.get(j).c = -tmp;
                }
            }
        }
        return false;
    }
    
    // BFS (좌표, 판, 방문, 리스트)
    static void bfs(int r, int c, int[][] board, boolean[][] visited, List<List<Node>> list) {
        
        visited[r][c] = true;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));
        
        List<Node> subList = new ArrayList<>(); // 조각(빈칸) 뭉치
        subList.add(new Node(0, 0)); // (0, 0)을 기준으로
        
        while(!q.isEmpty()){
            
            Node now = q.poll();
            
            for(int dir = 0; dir < 4; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(canMove(nr, nc) && board[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                    subList.add(new Node(nr - r, nc - c)); // (0, 0)을 기준으로
                }
            }
        }
        list.add(subList); // 리스트에 조각(빈칸) 뭉치 추가
    }
    
    // 범위
    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < length && c < length;
    }
    
    // Node 클래스
    static class Node implements Comparable<Node> {
        
        int r, c;
        
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        // r 기준 오름차순 정렬 (블록과 빈칸의 좌표를 같은 위치에서 비교)
        public int compareTo(Node o) {
            if(this.r == o.r) {
                return this.c - o.c;
            }
            return this.r - o.r;
        }
    }
}