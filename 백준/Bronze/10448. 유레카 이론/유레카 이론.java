import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[101];
        for(int i = 1; i <= 100; i++){
            arr[i] = i * (i + 1) / 2;
        }
        int t = Integer.parseInt(br.readLine());
        for(int idx = 0; idx < t; idx++){
            int n = Integer.parseInt(br.readLine());
            int flag = 0;
            for(int i = 1; i <= 100; i++){
                for(int j = 1; j <= 100; j++){
                    for(int k = 1; k <= 100; k++){
                        if(arr[i] + arr[j] + arr[k] == n){
                            flag = 1;
                        }
                    }
                }
            }
            System.out.println(flag);
        }
    }
}