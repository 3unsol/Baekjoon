import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[][] A, B;

    public static void main(String[] args) throws IOException {
        input();
        mulitple();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        for(int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++){
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        B = new int[m][k];
        for(int r = 0; r < m; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < k; c++){
                B[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void mulitple(){
        for(int a = 0; a < n; a++){
            for(int b = 0; b < k; b++){
                int sum = 0;
                for(int c = 0; c < m; c++){
                    sum += A[a][c] * B[c][b];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}