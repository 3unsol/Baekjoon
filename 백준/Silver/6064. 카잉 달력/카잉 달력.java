import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testCase; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean check = false;
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for(int i = x; i < (n * m); i += m){
                if(i % n == y){
                    System.out.println(i + 1);
                    check = true;
                    break;
                }
            }
            if(!check){
                System.out.println(-1);
            }
        }
    }
}