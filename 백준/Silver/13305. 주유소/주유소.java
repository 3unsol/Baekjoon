import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] distance, cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        distance = new int[N - 1];
        cost = new int[N - 1];

        StringTokenizer distInfo = new StringTokenizer(br.readLine());
        StringTokenizer costInfo = new StringTokenizer(br.readLine());

        for(int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(distInfo.nextToken());
            cost[i] = Integer.parseInt(costInfo.nextToken());
        }

        long totalCost = 0;
        long minCost = cost[0];

        for(int i = 0; i < N - 1; i++) {
            if(minCost > cost[i]) {
                minCost = cost[i];
            }
            totalCost += (minCost * distance[i]);
        }

        System.out.println(totalCost);
    }
}