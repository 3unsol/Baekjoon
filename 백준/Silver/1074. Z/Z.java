import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

static int[][] map;
static int n, r, c, cnt;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        map = new int[n][n];
        cnt = 0;
        int size = (int) Math.pow(2, n);
        recur(r, c, size);
        System.out.println(cnt);
    }

    public static void recur(int r, int c, int size){
        if(size == 1){
            return;
        }
        if(r < size / 2 && c < size / 2){
            recur(r, c, size / 2);
        }
        else if(r < size / 2 && c >= size / 2){
            cnt += (size *  size / 4);
            recur(r, c - size / 2, size / 2);
        }
        else if(r >= size / 2 && c < size / 2){
            cnt += (size *  size / 4) * 2;
            recur(r - size / 2, c, size / 2);
        }
        else{
            cnt += (size *  size / 4) * 3;
            recur(r - size / 2, c - size / 2, size / 2);
        }
    }
}