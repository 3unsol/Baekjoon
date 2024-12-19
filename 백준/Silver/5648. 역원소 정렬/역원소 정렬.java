import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];

        for(int i = 0; i < N; i++) {
            String str = sc.next();
            String tmp = "";
            for(int j = str.length() - 1; j >= 0; j--) {
                tmp += str.charAt(j);
            }
            arr[i] = Long.parseLong(tmp);
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}