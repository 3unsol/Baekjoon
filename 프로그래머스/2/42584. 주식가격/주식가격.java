import java.util.*;

/**
[4, 5, 1, 2, 6, 1, 1] 는 한 주식의 각각 1,2,3,4,5,6,7초일 때 가격이라고 생각하시면 됩니다.
1,2초일때보다 3초일때가 더 작으므로 리턴되는값의 0,1번째 원소는 각각 2,1 이어야합니다.
3초일때의 1보다 작은값은 없으므로 리턴되는값의 2번째 원소는 4이어야합니다.
4초일때보다 6초일때가 더 작으므로 리턴되는값의 3번째 원소는 2이어야합니다.
5초일때보다 6초일때가 더 작으므로 리턴되는값의 4번째 원소는 1이어야 합니다.
6초일때보다 더 작은값은 없으므로 리턴되는값의 5번째 원소는 1이어야 합니다.
7초가 마지막이므로 0을 리턴합니다.
따라서 [2,1,4,2,1,1,0]이 맞습니다.
**/

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            // 스택이 안 비었고 가격 내릴 때까지
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 감소 시점 - 들어간 시점
                answer[stack.peek()] = i - stack.pop();
            }
            // 스택이 비었거나 가격이 안 내렸다면
            stack.push(i);
        }
        
        // 스택에 아직 남아있다면
        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.pop() - 1;
        }
        return answer;
    }
}