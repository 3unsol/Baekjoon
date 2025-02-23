import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //1 5 9 13
        char[][] pan = new char[4 * (N - 1) + 1][4 * (N - 1) + 1];
        for (int i = 0; i < 4 * (N - 1) + 1; i++) {//빈칸으로 초기화
            for (int j = 0; j < 4 * (N - 1) + 1; j++) {
                pan[i][j] = ' ';
            }
        }
        drawStart(0, pan, N);//재귀함수 호출
        for (int i = 0; i < 4 * (N - 1) + 1; i++) {//출력단
            for (int j = 0; j < 4 * (N - 1) + 1; j++) {
                System.out.print(pan[i][j]);
            }
            System.out.println();
        }
    }

    public static void drawStart(int start, char[][] array, int n) {
        if (n <= 0) {//종료 조건
            return;
        }
        int cnt = 4 * (n - 1) + 1;
        for (int i = start; i < start+4 * (n - 1) + 1; i++) {
            array[start][i] = '*';
            array[i][start] = '*';
            array[start+4 * (n - 1)][i] = '*';
            array[i][start+4 * (n - 1)] = '*';

        }
        drawStart(start+2, array, n-1);
    }
}