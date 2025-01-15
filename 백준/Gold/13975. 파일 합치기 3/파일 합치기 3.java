import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {

            N = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;

            while(pq.size() > 1) {
                long val1 = pq.poll();
                long val2 = pq.poll();
                pq.offer(val1 + val2);
                sum += val1 + val2;
            }

            System.out.println(sum);
        }
    }
}