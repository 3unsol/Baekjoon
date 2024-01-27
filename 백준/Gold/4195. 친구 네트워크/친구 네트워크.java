import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int F;
    static int[] parents;
    static int[] rank;
    static Map<String, Integer> index;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++){

            F = Integer.parseInt(br.readLine());

            parents = new int[F * 2];
            rank = new int[F * 2];
            index = new HashMap<>();

            for(int i = 0; i < F * 2; i++){
                parents[i] = i;
                rank[i] = 1;
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < F; i++){
                st = new StringTokenizer(br.readLine());

                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if(!index.containsKey(name1)){
                    index.put(name1, index.size());
                }

                if(!index.containsKey(name2)){
                    index.put(name2, index.size());
                }

                int index1 = index.get(name1);
                int index2 = index.get(name2);

                union(index1, index2);
                sb.append(rank[find(index1)]).append("\n");
            }
            System.out.print(sb);
        }
    }

    static void union(int x, int y){

        int px = find(x);
        int py = find(y);

        if(px == py) return;

        if(px < py){
            parents[py] = px;
            rank[px] += rank[py];
        }else{
            parents[px] = py;
            rank[py] += rank[px];
        }
    }

    static int find(int num){
        if(parents[num] == num) return num;
        return find(parents[num]);
    }

}