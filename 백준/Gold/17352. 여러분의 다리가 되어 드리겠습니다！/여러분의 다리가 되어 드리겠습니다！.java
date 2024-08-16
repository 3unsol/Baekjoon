import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] parents;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for(int i = 1; i <= N; i++) {
            if(parents[find(i)] != 1) {
                System.out.println(1 + " " + i);
                return;
            }
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(parents[x] > parents[y]) parents[x] = parents[y];
        else parents[y] = parents[x];
    }

    static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}