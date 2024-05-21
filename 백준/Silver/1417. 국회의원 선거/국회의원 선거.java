import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int N, dasom;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        while(!pq.isEmpty() && pq.peek() >= dasom) {

            int now = pq.poll();

            now--;
            dasom++;
            cnt++;
            pq.offer(now);
        }

        System.out.println(cnt);
    }

}