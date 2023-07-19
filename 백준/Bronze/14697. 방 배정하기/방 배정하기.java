import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int flag = 0;
        for(int i = 0; i <= 300; i++){
            for(int j = 0; j <= 300; j++){
                for(int k = 0; k <= 300; k++){
                    if((a * i) + (b * j) + (c * k) == n){
                        flag = 1;
                    }
                }
            }
        }
        System.out.println(flag);
    }
}