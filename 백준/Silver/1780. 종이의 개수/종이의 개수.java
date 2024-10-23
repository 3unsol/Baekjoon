import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        arr = new int[3];

        StringTokenizer st;
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == -1){
                    map[r][c] = 2;
                }
            }
        }

        check(0, 0, N);

        System.out.println(arr[2]);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    // 9분할
    static void check(int startR, int startC, int size) {

        if(count(startR, startC, size)) {
            arr[map[startR][startC]]++;
            return;
        }

        for(int i = startR; i < startR + size; i += (size / 3)) {
            for(int j = startC; j < startC + size; j += (size / 3)) {
                check(i, j, size / 3);
            }
        }
    }

    // 숫자 확인하기
    static boolean count(int startR, int startC, int size) {

        for(int r = startR; r < startR + size; r++) {
            for(int c = startC; c < startC + size; c++) {
                if(map[startR][startC] != map[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}