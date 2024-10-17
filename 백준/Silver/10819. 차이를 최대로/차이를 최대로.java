import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, ans;
    static int[] arr, result;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        isVisited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(ans);
    }

    static void perm(int idx) {

        if(idx == N) {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(result[i] - result[i + 1]);
            }
            ans = Math.max(ans, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                result[idx] = arr[i];
                perm(idx + 1);
                isVisited[i] = false;
            }
        }
    }
}