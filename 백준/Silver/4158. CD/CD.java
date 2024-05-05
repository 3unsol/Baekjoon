import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arrN, arrM;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            arrN = new int[N];
            arrM = new int[M];

            for(int i = 0; i < N; i++) {
                arrN[i] = Integer.parseInt(br.readLine());
            }

            for(int i = 0; i < M; i++) {
                arrM[i] = Integer.parseInt(br.readLine());
            }

            int pointN = 0;
            int pointM = 0;
            int cnt = 0;

            while(true) {

                if(pointN == N || pointM == M) break;

                if(arrN[pointN] == arrM[pointM]) {
                    cnt++;
                    pointN++;
                    pointM++;
                } else if(arrN[pointN] > arrM[pointM]) {
                    pointM++;
                } else {
                    pointN++;
                }
            }

            System.out.println(cnt);
        }
    }
}