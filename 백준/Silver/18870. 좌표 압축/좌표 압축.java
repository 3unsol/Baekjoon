import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            sorted[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 0;

        for(int i = 0; i < N; i++) {
            if(!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}