import java.util.*;

/**
1. target이 words[] 안에 없으면 0 return
2. 한 번에 한 개만 + words에 포함되어야 함
2-1. begin과 words[i] 다른 철자 개수 비교
2-2. cnt == 1 단어 dfs
3. dfs(깊이, 현재 단어 인덱스) + 방문 배열, words 배열
4. target 일 때 return 깊이
**/

class Solution {
    
    static boolean[] isVisited;
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        
        // words 배열에 target이 있는지 확인
        if(!isContains(target, words)) {
            return 0;
        }
        
        // 방문 배열
        isVisited = new boolean[words.length];
        
        // dfs
        dfs(0, begin, target, words);
        
        return answer;
    }
    
    // dfs(깊이, 현재 단어, 타겟 단어, 단어 배열)
    public void dfs(int depth, String now, String target, String[] words) {
        
        // 타겟 단어면 깊이 반환
        if(now.equals(target)) {
            answer = depth;
            return;
        }
        
        // 단어 배열 돌면서 차이가 1이고 방문하지 않은 단어 탐색
        for(int i = 0; i < words.length; i++) {
            if(findDiff(now, words[i], words) && !isVisited[i]) {
                isVisited[i] = true;
                dfs(depth + 1, words[i], target, words);
                isVisited[i] = false;
            }
        }
    }
    
    // 차이가 1인지 확인하는 메서드
    public boolean findDiff(String begin, String target, String[] words) {
        
        int cnt = 0;
        
        for(int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != target.charAt(i)) {
                cnt++;
            }
        }
        
        if(cnt == 1) {
            return true;
        }
        return false;
    }
    
    // 단어 배열 안에 타겟 단어가 있는지 확인하는 메서드
    public boolean isContains(String target, String[] words) {
        for(int i = 0; i < words.length; i++) {
            if(target.equals(words[i])) return true;
        }
        return false;
    }
}