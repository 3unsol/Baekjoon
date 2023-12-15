import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = new int[M];
        recur(0, 0);
        System.out.println(sb.toString());
    }

    static void recur(int k, int idx) {

        if (k == M) {
            String tmp = "";
            for (int i = 0; i < M; i++) {
                tmp += result[i] + " ";
            }
            if(!set.contains(tmp)){
                sb.append(tmp).append("\n");
                set.add(tmp);
            }
            return;
        }
        for (int i = idx; i < N; i++) {
                result[k] = arr[i];
                recur(k + 1, i);
        }
    }
}