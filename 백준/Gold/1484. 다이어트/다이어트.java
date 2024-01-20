import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 2;
        
        boolean flag = false;

        while(end <= 100000) {

            int num = end * end - start * start;

            if(num == G) {
                flag = true;
                System.out.println(end);
                start++;
            } else if (num < G) {
                end++;
            } else {
                start++;
            }
        }
        
        if(!flag) System.out.println(-1);
    }
}