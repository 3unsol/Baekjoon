import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> trucks = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int tmpWeight = 0;

        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        while(!bridge.isEmpty()) {
            time++;
            tmpWeight -= bridge.poll();

            if(!trucks.isEmpty()) {
                if(trucks.peek() + tmpWeight <= L) {
                    tmpWeight += trucks.peek();
                    bridge.offer(trucks.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }

        System.out.println(time);
    }
}