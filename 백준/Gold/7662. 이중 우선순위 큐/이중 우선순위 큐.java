import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * deque로 삽입마다 정렬하면 시간초과
 * 우선순위 큐 2개 사용(min, max)
 * 뺐는지 아닌지 확인하기 위해 Map 사용
 */

public class Main {

    public static void main(String[] args) throws Exception {
        input();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++){
            
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minQue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if(str.equals("I")){
                    // number가 이미 들어있다면 그 값에 +1한 값 넣고
                    // number가 들어간 적 없다면 0에 +1한 값 넣어준다.
                    map.put(number, map.getOrDefault(number, 0) + 1);
                    minQue.add(number);
                    maxQue.add(number);
                }
                else{
                    if(map.size() == 0) continue;
                    
                    PriorityQueue<Integer> q = number == 1 ? maxQue : minQue;
                    removeMap(q, map);
                }
            }
            
            if(map.size() == 0){
                System.out.println("EMPTY");
            }else{
                int tmp = removeMap(maxQue, map);
                System.out.println(tmp + " " + (map.size() > 0 ? removeMap(minQue, map) : tmp));
            }
        }
    }
    
    static int removeMap(PriorityQueue<Integer> q, Map<Integer, Integer> map){
        int num;
        while(true){
            num = q.poll();
            int cnt = map.getOrDefault(num, 0);
            if(cnt == 0) continue; // 0이면 다른 큐에서 뽑힌 거니까 다시 뽑으러 감
            if(cnt == 1) map.remove(num); // 1이면 하나 남은 거니까 뽑아버림
            else map.put(num, cnt - 1); // 1보다 크면 아직 남은 거니까 -1해서 다시 넣어줌
            break;
        }
        return num;
    }
}