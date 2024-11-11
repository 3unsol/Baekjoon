import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dq.offer(i);
        }

        while(!dq.isEmpty()) {
            int index = dq.pop();
            int val = arr[index];
            System.out.print(index + " ");
            if(dq.size() == 1) {
                System.out.println(dq.pop());
                return;
            }
            if(val < 0) {
                for(int i = 0; i < Math.abs(val); i++) {
                    dq.offerFirst(dq.removeLast());
                }
            } else {
                for(int i = 1; i < val; i++) {
                    dq.offerLast(dq.removeFirst());
                }
            }
        }
    }
}