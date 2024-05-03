import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> hashSet = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                hashSet.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                if(hashSet.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                if(i < M- 1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }
    }
}