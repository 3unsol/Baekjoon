import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, k;
    static int[] parents;
    static int[] cost;
    static List<ArrayList<Integer>> edges = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        findCost();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        cost = new int[N + 1];
        edges.add(new ArrayList<>());

        for(int i = 1; i <= N; i++){
            parents[i] = i;
            edges.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if(num == num2) continue;

            union(num, num2);
        }
    }

    static void union(int num, int num2){

        int p = findParents(num);
        int p2 = findParents(num2);

        if(cost[p] > cost[p2]) {
            parents[p] = parents[p2];
        } else {
            parents[p2] = parents[p];
        }
    }

    static int findParents(int num){

        if(parents[num] == num) return num;

        return findParents(parents[num]);
    }

    static void findCost(){

        int sum = 0;

        for(int i = 1; i <= N; i++){
            if(parents[i] == i) {
                sum += cost[i];
            }
        }

        if(sum > k){
            System.out.println("Oh no");
        }else{
            System.out.println(sum);
        }
    }
}