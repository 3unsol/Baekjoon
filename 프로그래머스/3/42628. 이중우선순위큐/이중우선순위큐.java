import java.util.*;
/**
asc : -642 -45 45 97
desc : 97 45 -45 -642
**/
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            
            String order = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            
            if(order.equals("I")) {
                asc.offer(number);
                desc.offer(number);
            } else {
                if(asc.isEmpty()) continue;
                if(number == 1) {
                    asc.remove(desc.poll());
                } else {
                    desc.remove(asc.poll());
                }
            }
        }
        
        if(!asc.isEmpty()) {
            answer[0] = desc.poll();
            answer[1] = asc.poll();
        }
        return answer;
    }
}