import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int fruitCnt = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[] fruits = new int[fruitCnt];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < fruitCnt; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fruits);

        for(int i = 0; i < fruitCnt; i++) {

            if(fruits[i] > length) {
                System.out.println(length);
                return;
            } else {
                length++;
            }
        }

        System.out.println(length);
    }
}