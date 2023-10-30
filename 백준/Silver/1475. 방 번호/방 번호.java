import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        int[] count = new int[10];
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) - '0' == 9){
                count[6]++;
            }else{
                count[str.charAt(i) - '0']++;
            }
        }
        count[6] = count[6] / 2 + count[6] % 2;
        Arrays.sort(count);
        System.out.println(count[9]);
    }
}