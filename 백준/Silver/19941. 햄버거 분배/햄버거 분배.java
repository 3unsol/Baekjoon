import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, ans;
    static char[] table;
    static boolean[] eaten;

    public static void main(String[] args) throws Exception {
        input();
        eatHamburger();
        System.out.println(ans);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = new char[N];

        String str = br.readLine();

        for(int i = 0; i < N; i++){
            table[i] = str.charAt(i);
        }

        eaten = new boolean[N];
    }

    static void eatHamburger() {

        for(int i = 0; i < N; i++) {

            if(table[i] == 'P') {

                for(int j = i - K; j <= i + K; j++){

                    if(j >= 0 && j < N) {

                        if(table[j] == 'H' && !eaten[j]){
                            eaten[j] = true;
                            ans++;
                            break;
                        }
                    }
                }
            }
        }
    }
}