import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long B;
    static int[][] A;
    static final int MOD = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                // B == 1 일 때 pow 과정에서 바로 A가 반환될 수 있기 때문에
                // 초기 배열부터 MOD로 나눈 값 저장하기
                A[r][c] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(A, B);

        // 출력
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                System.out.print(result[r][c] + " ");
            }
            System.out.println();
        }
    }

    // 분할 정복
    static int[][] pow(int[][] map, long exp) {

        // 지수가 1일 때 A 리턴
        if(exp == 1l) {
            return map;
        }

        // 지수를 절반으로 분할
        int[][] ret = pow(map, exp / 2);

        // 하위 재귀에서 얻은 행렬 제곱
        ret = multiply(ret, ret);

        // 지수가 홀수 일 때 A(origin) 곱해줌
        if(exp % 2 == 1l) {
            ret = multiply(ret, A);
        }

        return ret;
    }

    // 행렬 곱 공식
    static int[][] multiply(int[][] map1, int[][] map2) {

        int[][] res = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++) {

                    res[i][j] += map1[i][k] * map2[k][j];
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}