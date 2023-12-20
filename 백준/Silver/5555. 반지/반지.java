import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            str += str;
            if(str.contains(key)){
                ans++;
            }
        }
        System.out.println(ans);
    }
}