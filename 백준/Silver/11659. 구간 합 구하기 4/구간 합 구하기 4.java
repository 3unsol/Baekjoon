import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] prefix = new int[n + 1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + sc.nextInt();
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(prefix[b] - prefix[a - 1]);
        }
    }
}