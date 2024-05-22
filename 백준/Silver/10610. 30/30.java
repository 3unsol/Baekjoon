import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int sum = 0;

        char[] arr = N.toCharArray();
        Arrays.sort(arr);
        int len = N.length();

        StringBuilder sb = new StringBuilder();

        for(int i = len - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if(arr[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }

}