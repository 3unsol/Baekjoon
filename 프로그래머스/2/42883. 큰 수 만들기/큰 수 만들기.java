import java.util.*;

class Solution {
    public String solution(String number, int k) {
       StringBuilder sb = new StringBuilder(); // StringBuilder 사용으로 문자열 처리 개선

        for (int i = 0; i < number.length(); i++) {
            char now = number.charAt(i);

            // 스택처럼 작동: 뒤에서부터 제거
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < now) {
                sb.deleteCharAt(sb.length() - 1); // 마지막 문자 제거
                k--;
            }

            sb.append(now); // 현재 문자 추가
        }

        // k개의 문자를 더 제거해야 하는 경우 처리
        if (k > 0) {
            sb.setLength(sb.length() - k); // 뒤에서 k개 문자 제거
        }
        
        return sb.toString();
    }
}