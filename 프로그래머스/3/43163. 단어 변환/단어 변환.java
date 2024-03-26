import java.util.*;

class Solution {
    
    static boolean[] isVisited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        // 방문 배열
        isVisited = new boolean[words.length];
        
        // 깊이우선탐색
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    // begin : 현재 단어, target : 목표 단어, words : 가능한 단어 목록, cnt : 몇 번 바꿨니?
    static void dfs(String begin, String target, String[] words, int cnt) {
        
        // 목표 단어가 되었다!
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        // 가능한 단어 목록을 돌아봅니다.
        for(int i = 0; i < words.length; i++) {
            
            // 이미 본 애면 지나칩니다.
            if(isVisited[i]) continue;
            
            // 현재 단어랑 words[i]랑 같은 철자 개수
            int sameCnt = 0;
            
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    sameCnt++;
                }
            }
            
            // 하나 빼고 같으면 dfs 돌리기 (한번에 하나만 바꿀 수 있음)
            if(sameCnt == begin.length() - 1) {
                isVisited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                isVisited[i] = false;
            }
        }
    }
}