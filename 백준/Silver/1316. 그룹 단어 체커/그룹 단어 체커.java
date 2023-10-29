import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int groupCnt = 0;
        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            boolean[] isChecked = new boolean[26];
            isChecked[word.charAt(0) - 'a'] = true;
            boolean flag = true;
            for (int j = 1; j < word.length(); j++) {
                char now = word.charAt(j);
                if(isChecked[now - 'a']){
                    if(now == word.charAt(j - 1)){
                        continue;
                    }else{
                        flag = false;
                        break;
                    }
                }else{
                    isChecked[now - 'a'] = true;
                }
            }
            if(flag){
                groupCnt++;
            }
        }
        System.out.println(groupCnt);
    }
}