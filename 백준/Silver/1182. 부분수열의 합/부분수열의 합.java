import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        subs(0, 0);

        System.out.println(S == 0 ? --ans : ans);
    }

    static void subs(int index, int sum) {

        if(index == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        subs(index + 1, sum + arr[index]);
        subs(index + 1, sum);

    }
}