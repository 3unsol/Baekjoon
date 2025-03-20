import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // set에 전화번호 모두 넣기
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }
        
        // 전화번호 하나씩 꺼내서 0~길이까지 문자열 잘라서 확인
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                String now = phone_book[i].substring(0, j);
                // 자른 문자열이 set에 있다면 false
                if(set.contains(now)) {
                    return false;
                }
            }
        }
        return answer;
    }
}