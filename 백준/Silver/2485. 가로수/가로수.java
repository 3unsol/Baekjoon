import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int gcd = 0;
        for(int i = 1; i < N; i++) {
            gcd = findGCD(arr[i] - arr[i - 1], gcd);
        }
        System.out.println((arr[N - 1] - arr[0]) / gcd + 1 - N);
    }

    static int findGCD(int p, int q) {
        if(q == 0) return p;
        else return findGCD(q, p % q);
    }
}