import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            StringTokenizer st;
            for(int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[b] = a;
            }
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(LCA(u, v));
        }
    }

    static int LCA(int u, int v) {
        int uDepth = findDepth(u);
        int vDepth = findDepth(v);
        if(uDepth > vDepth) {
            return findCommonParent(u, v, uDepth - vDepth);
        } else {
            return findCommonParent(v, u, vDepth - uDepth);
        }
    }

    static int findDepth(int x) {
        int depth = 0;
        while(parent[x] != 0) {
            x = parent[x];
            depth++;
        }
        return depth;
    }

    static int findCommonParent(int u, int v, int interval) {
        while(interval-- > 0) {
            u = parent[u];
        }
        while(u != v) {
            u = parent[u];
            v = parent[v];
        }
        return u;
    }
}