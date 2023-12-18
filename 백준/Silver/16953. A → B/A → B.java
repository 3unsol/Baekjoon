import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long A, B;
    static int cnt;
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(bfs());
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        cnt = 1;
    }

    static int bfs() {
        Queue<Long> q = new LinkedList<>();

        q.offer(A * 2);
        q.offer(A * 10 + 1);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                long now = q.poll();

                if(now == B) return cnt + 1;

                if(now * 2 <= B) q.offer(now * 2);
                if(now * 10 + 1 <= B) q.offer(now * 10 + 1);
            }
            cnt++;
        }
        return -1;
    }
}