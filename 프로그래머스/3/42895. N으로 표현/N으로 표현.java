import java.util.*;

/**
DP : 숫자를 i개 사용해서 만들 수 있는 모든 숫자들
따라서 배열이 아닌 Set, List 등으로 만듦
ex) List<Set<Integer>> list / list.get(1).add(N)
list.get(2)에는
list.get(1) +-/* list.get(1) 결과값 다 넣기
이런 식으로 list.get(8)까지...
시간초과가 걱정되지만 어쩔 수 없다
!! 결과값 말고도 N, NN, NNN 이런 애들도 넣어줘야 함
**/

class Solution {
    public int solution(int N, int number) {
        
        // N == number일 때
        if(N == number) {
            return 1;
        }
        
        // DP 리스트
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        // 1개로 만들 수 있는 수는 N
        dp.get(1).add(N);
        
        for(int i = 2; i <= 8; i++) {
            
            // N, NN, NNN 숫자 만들어서 넣기
            StringBuilder sb = new StringBuilder().append(N);
            for(int j = 1; j < i; j++) {
                sb.append(N);
            }
            dp.get(i).add(Integer.parseInt(sb.toString()));
            
            // 사칙연산으로 숫자 만들기
            // j개 리스트 + i - j개 리스트 조합(BF)
            for(int j = 1; j < i; j++) {
                for(int num1 : dp.get(j)) {
                    for(int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if(num2 != 0) { // 나누기 오류 방지
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            
            // dp에 number가 있으면 return
            if(dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}