import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int findNum, ans;
    static boolean[] buttons = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        findNum = Integer.parseInt(N);
        int breakCnt = Integer.parseInt(br.readLine());
        if(breakCnt > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < breakCnt; i++) {
                buttons[Integer.parseInt(st.nextToken())] = true;
            }
        }
        ans = Math.abs(findNum - 100);
        for(int i = 0; i <= 999999; i++){
            String str = String.valueOf(i);
            int len = str.length();
            boolean isBreak = false;
            for(int j = 0; j < len; j++){
                if(buttons[str.charAt(j) - '0']){
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak){
                int min = Math.abs(findNum - i) + len;
                ans = Math.min(min, ans);
            }
        }
        System.out.println(ans);
    }
}