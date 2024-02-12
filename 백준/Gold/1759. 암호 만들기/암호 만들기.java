import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static char[] alphabets;
    static char[] password;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = new char[C];
        password = new char[C];
        isUsed = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);

        comb(0, 0);
    }

    static void comb(int index, int length) {

        // 패스워드 완성
        if (length == L) {
            if(isValid(password)){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < L; i++) {
                    sb.append(password[i]);
                }
                System.out.println(sb);
            }
            return;
        }

        // 현재 index보다 큰 애들만 뒤에 올 수 있다.
        for(int i = index; i < C; i++) {
            password[length] = alphabets[i];
            comb(i + 1, length + 1);
        }
    }

    static boolean isValid(char[] password){

        int vowel = 0;
        int consonant = 0;

        for(int i = 0; i < L; i++) {
            if(password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u'){
                vowel++;
            } else {
                consonant++;
            }
        }

        if(vowel >= 1 && consonant >= 2) {
            return true;
        }

        return false;
    }
}