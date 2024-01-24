import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, M;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= testCase; tc++){

            sb.append("Scenario " + tc + ":").append("\n");

            N = Integer.parseInt(br.readLine());
            parents = new int[N + 1];
            for(int i = 1; i <= N; i++){
                parents[i] = i;
            }

            K = Integer.parseInt(br.readLine());
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                union(num, num2);
            }

            M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if (find(num) == find(num2)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void union(int num, int num2){

        int p1 = find(num);
        int p2 = find(num2);

        if(p1 == p2) return;

        if(p1 < p2){
            parents[p2] = p1;
        }else{
            parents[p1] = p2;
        }
    }

    static int find(int num) {
        if (parents[num] == num) return num;
        return find(parents[num]);
    }
}