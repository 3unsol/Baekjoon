import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, max;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        input();
        iCheck();
        oCheck();
        lCheck();
        sCheck();
        tCheck();
        System.out.println(max);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;

        map = new int[N][M];

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void iCheck(){

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M - 3; c++){
                int sum = map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r][c + 3];
                max = Math.max(sum, max);
            }
        }

        for(int r = 0; r < N - 3; r++){
            for(int c = 0; c < M; c++){
                int sum = map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 3][c];
                max = Math.max(sum, max);
            }
        }
    }

    static void oCheck(){
        for(int r = 0; r < N - 1; r++){
            for(int c = 0; c < M - 1; c++){
                int sum = map[r][c] + map[r + 1][c] + map[r][c + 1] + map[r + 1][c + 1];
                max = Math.max(sum, max);
            }
        }
    }

    static void lCheck(){

        for(int r = 0; r < N - 2; r++){
            for(int c = 0; c < M - 1; c++){

                int sum = map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 2][c + 1];
                int sum2 = map[r][c] + map[r][c + 1] + map[r + 1][c + 1] + map[r + 2][c + 1];
                int sum3 = map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r][c + 1];

                sum = Math.max(Math.max(sum, sum2), sum3);

                max = Math.max(max, sum);
            }
        }

        for(int r = 0; r < N - 1; r++){
            for(int c = 0; c < M - 2; c++){
                int sum = map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c];
                int sum2 = map[r][c] + map[r + 1][c] + map[r + 1][c + 1] + map[r + 1][c + 2];
                int sum3 = map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c + 2];

                sum = Math.max(Math.max(sum, sum2), sum3);

                max = Math.max(max, sum);
            }
        }

        for(int r = 1; r < N; r++){
            for(int c = 0; c < M - 2; c++){
                int sum = map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r - 1][c + 2];
                max = Math.max(max, sum);
            }
        }

        for(int r = 0; r < N - 2; r++){
            for(int c = 1; c < M; c++){
                int sum = map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 2][c - 1];
                max = Math.max(max, sum);
            }
        }
    }

    static void sCheck(){

        for(int r = 0; r < N - 2; r++){
            for(int c = 0; c < M - 1; c++){
                int sum = map[r][c] + map[r + 1][c] + map[r + 1][c + 1] + map[r + 2][c + 1];
                max = Math.max(max, sum);
            }
        }

        for(int r = 1; r < N; r++){
            for(int c = 0; c < M - 2; c++){
                int sum = map[r][c] + map[r][c + 1] + map[r - 1][c + 1] + map[r - 1][c + 2];
                max = Math.max(max, sum);
            }
        }

        for(int r = 1; r < N - 1; r++){
            for(int c = 0; c < M - 1; c++){
                int sum = map[r][c] + map[r][c + 1] + map[r + 1][c] + map[r - 1][c + 1];
                max = Math.max(max, sum);
            }
        }

        for(int r = 0; r < N - 1; r++){
            for(int c = 0; c < M - 2; c++){
                int sum = map[r][c] + map[r][c + 1] + map[r + 1][c + 1] + map[r + 1][c + 2];
                max = Math.max(max, sum);
            }
        }
    }

    static void tCheck(){

        for(int r = 0; r < N - 1; r++){
            for(int c = 1; c < M - 1; c++){
                int sum = map[r][c] + map[r][c - 1] + map[r][c + 1] + map[r + 1][c];
                int sum2 = map[r][c] + map[r + 1][c - 1] + map[r + 1][c] + map[r + 1][c + 1];
                max = Math.max(Math.max(sum, sum2), max);
            }
        }

        for(int r = 1; r < N - 1; r++){
            for(int c = 0; c < M - 1; c++){
                int sum = map[r][c] + map[r - 1][c + 1] + map[r][c + 1] + map[r + 1][c + 1];
                int sum2 = map[r][c] + map[r - 1][c] + map[r + 1][c] + map[r][c + 1];
                max = Math.max(Math.max(sum, sum2), max);
            }
        }
    }
}