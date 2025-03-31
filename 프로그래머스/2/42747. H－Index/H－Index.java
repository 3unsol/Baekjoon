import java.util.*;
/**
3 0 6 1 5 / 3
인덱스 : 0 1 2 3 4
정렬   : 0 1 3 5 6
0번 이상 인용 : 5
1번 이상 인용 : 4
3번 이상 인용 : 3
5번 이상 인용 : 2
6번 이상 인용 : 1

0 0 0 0 0

**/
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(citations);
        
        // 뒤에서부터 보기
        for(int i = 0; i < citations.length; i++) {
            
            int h = citations.length - i;
            
            if(citations[i] >= h) {
                return h;
            }
        }
        return answer;
    }
}