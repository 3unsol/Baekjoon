import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            cnt = 0;
            String str = br.readLine();
            int isPalindrome = recur(str, 0, str.length() - 1);
            System.out.println(isPalindrome + " " + cnt);
        }
    }

    public static int recur(String str, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return recur(str, l + 1, r - 1);
    }


}