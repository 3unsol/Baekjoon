import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int[] stones = new int[M];
        int N = 0; // 총 조약돌 개수

        for(int i = 0; i < M; i++) {
            stones[i] = sc.nextInt();
            N += stones[i];
        }

        int K = sc.nextInt();

        // 가능한 모든 경우의 수
        double total = 1;
        for(int i = 0; i < K; i++) {
            total *= (N - i);
        }

        // 같은 색상이 나오는 경우의 수
        double sum = 0;
        for(int i = 0; i < M; i++) {
            // 목표한 돌의 개수보다 작으면 continue
            if(stones[i] < K) continue;

            double tmp = 1;
            for(int j = 0; j < K; j++) {
                tmp *= (stones[i] - j);
            }
            sum += tmp;
        }

        System.out.println(sum / total);
    }
}