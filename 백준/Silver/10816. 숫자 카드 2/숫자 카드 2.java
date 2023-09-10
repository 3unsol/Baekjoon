import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        input();
        print();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(!map.containsKey(tmp)){
                map.put(tmp, 1);
            }else{
                map.put(tmp, map.get(tmp) + 1);
            }
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        numbers = new int[m];
        for(int i = 0; i < m; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            if(map.containsKey(numbers[i])){
                sb.append(map.get(numbers[i])).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}