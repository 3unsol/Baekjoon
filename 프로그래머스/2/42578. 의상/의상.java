import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // 옷 종류, 개수
        Map<String, Integer> map = new HashMap<>();
        
        // 옷 종류별로 몇 개 있는지 map에 저장
        for(int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        // 곱해야 해서 1로 초기 설정
        int answer = 1;
        
        // map의 values 하나씩 꺼내서 곱하기 (안 입는 경우도 포함)
        for(Integer cnt : map.values()) {
            answer *= cnt + 1;
        }
        
        // 아무것도 안 입는 경우 빼줘야 함!
        return answer - 1;
    }
}