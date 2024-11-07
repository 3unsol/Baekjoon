import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] result;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        isUsed = new boolean[N + 1];
        perm(0);
        System.out.print(sb);
    }

    static void perm(int k) {

        if(k == N) {
            for(int i = 0; i < N; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(isUsed[i]) continue;
            result[k] = i;
            isUsed[i] = true;
            perm(k + 1);
            isUsed[i] = false;
        }
    }
}