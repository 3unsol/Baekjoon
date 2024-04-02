import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parents;
    static Set<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = 1;

        while(true){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) return;

            parents = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            set = new HashSet<>();

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            for(int i = 1; i <= N; i++) {
                int pi = find(i);
                if(pi > 0) {
                    set.add(pi);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case ").append(testCase).append(": ");

            if(set.isEmpty()) {
                sb.append("No trees.");
            } else if(set.size() == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(set.size()).append(" trees.");
            }
            
            System.out.println(sb);

            testCase++;
        }
    }

    static boolean union(int a, int b) {

        a = find(a);
        b = find(b);

        if(a == b) {
            parents[b] = a;
            parents[a] = 0;
            return false;
        }

        if(a > b) {
            parents[a] = b;
        } else {
            parents[b] = a;
        }
        return true;
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}