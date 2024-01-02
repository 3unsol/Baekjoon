import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, storeCnt, ans;
    static Node[] result;
    static List<Node> storeList = new ArrayList<>();
    static List<Node> houseList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        close(0, 0);
        System.out.println(ans);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < N; c++){

                int value = Integer.parseInt(st.nextToken());

                if(value == 2){
                    Node node = new Node(r, c);
                    storeList.add(node);
                }else if(value == 1){
                    Node node = new Node(r, c);
                    houseList.add(node);
                }
            }
        }

        result = new Node[M];
        ans = Integer.MAX_VALUE;
    }

    static void close(int index, int k){

        if(k == M){
            ans = Math.min(calc(result), ans);
            return;
        }

        for(int i = index; i < storeList.size(); i++){
            result[k] = storeList.get(i);
            close(i + 1, k + 1);
        }
    }

    static int calc(Node[] list){

        int sum = 0;

        for(Node house : houseList){

            int minDistance = Integer.MAX_VALUE;

            for(Node store : result){
                int distance = Math.abs(store.r - house.r) + Math.abs(store.c - house.c);
                minDistance = Math.min(minDistance, distance);
            }

            sum += minDistance;
        }

        return sum;
    }

    static class Node {
        int r;
        int c;

        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
