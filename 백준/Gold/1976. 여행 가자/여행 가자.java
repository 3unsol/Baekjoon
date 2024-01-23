import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] cities, parents;
    public static void main(String[] args) throws Exception {
        input();
        if(isPossible()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cities = new int[M];
        parents = new int[N + 1];

        StringTokenizer st;
        
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++){
                int val = Integer.parseInt(st.nextToken());

                if(val == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            cities[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void union(int i, int j){

        int p1 = find(i);
        int p2 = find(j);
        
        if(p1 == p2) return;
        
        if(p1 < p2){
            parents[p2] = p1;
        }else{
            parents[p1] = p2;
        }
    }

    static int find(int num){
        if(parents[num] == num) return num;
        return find(parents[num]);
    }

    static boolean isPossible(){

        int start = find(cities[0]);

        for(int i = 1; i < M; i++){
            if(start != find(cities[i])) return false;
        }

        return true;
    }
}