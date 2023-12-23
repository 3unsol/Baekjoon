import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                dq.offer(num);
            }else if(order.equals("pop")){
                if(dq.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(dq.pollFirst()).append("\n");
                }
            }else if(order.equals("size")){
                sb.append(dq.size()).append("\n");
            }else if(order.equals("empty")){
                if(dq.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(order.equals("front")){
                if(dq.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(dq.peekFirst()).append("\n");
                }
            }else if(order.equals("back")){
                if(dq.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(dq.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}