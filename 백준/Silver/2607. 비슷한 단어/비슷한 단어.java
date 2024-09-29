import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String word = br.readLine();
        int[] alpha = new int[26];
        for(int i = 0; i < word.length(); i++) {
            alpha[word.charAt(i) - 'A']++;
        }

        int ans = 0;

        for(int i = 1; i < N; i++) {
            int[] check = alpha.clone();
            String now = br.readLine();

            if(Math.abs(now.length() - word.length()) > 1) continue;

            int cnt = 0; // word랑 같은 알파벳 개수

            for(int j = 0; j < now.length(); j++) {
                if(check[now.charAt(j) - 'A'] > 0) {
                    cnt++;
                    check[now.charAt(j) - 'A']--;
                }
            }

            // 길이가 1 작은 경우
            if(word.length() - 1 == now.length()) {
                // now가 word에 없는 알파벳 가지면 ㄴㄴ
                if(cnt == now.length()) ans++;
            } else if (word.length() + 1 == now.length()){ // 길이가 1 큰 경우
                // 값을 하나 빼도 word와 구성이 같아야 함
                if(cnt == word.length()) ans++;
            } else if (word.length() == now.length()) { // 같은 경우
                if(cnt == word.length()) ans++;
                else if(cnt == word.length() - 1) ans++;
            }
        }

        System.out.println(ans);
    }
}