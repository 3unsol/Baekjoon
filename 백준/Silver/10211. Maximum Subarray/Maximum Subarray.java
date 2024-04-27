import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int tc = 1; tc <= testCase; tc++) {

            int N = sc.nextInt();

            int[] arr = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                arr[i] = arr[i - 1] + sc.nextInt();
            }

            int max = Integer.MIN_VALUE;

            for(int i = 1; i <= N; i++) {
                for(int j = i; j <= N; j++) {
                    max = Math.max(arr[j] - arr[i - 1], max);
                }
            }
            
            System.out.println(max);
        }
    }
}