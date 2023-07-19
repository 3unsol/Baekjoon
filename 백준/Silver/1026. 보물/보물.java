import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        List<Integer> arrB = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arrB.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arrA);
        Collections.sort(arrB);
        Collections.reverse(arrB);
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arrA[i] * arrB.get(i);
        }
        System.out.println(sum);
    }
}