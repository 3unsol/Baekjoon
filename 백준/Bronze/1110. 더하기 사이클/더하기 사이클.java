import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, cnt;
    public static void main(String[] args) throws IOException {
        input();
        calc(n);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = 1;
    }

    static void calc(int num){
        if(num < 10){
            num = (num * 10) + num;
        }else {
            int newNum = (num / 10) + (num % 10);
            num = ((num % 10) * 10) + (newNum % 10);
        }
        if(num == n){
            System.out.println(cnt);
            return;
        }else{
            cnt++;
            calc(num);
        }
    }
}