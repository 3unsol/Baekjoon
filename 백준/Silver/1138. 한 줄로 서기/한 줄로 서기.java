import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr, tmp;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tmp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n; i >= 1; i--){
            result.add(arr[i], i);
        }
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }

}