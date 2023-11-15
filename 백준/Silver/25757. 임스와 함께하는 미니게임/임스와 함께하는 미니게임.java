import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N, game;
    static HashSet<String> player = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();
        switch (gameType) {
            case "Y":
                game = 1;
                break;
            case "F":
                game = 2;
                break;
            case "O":
                game = 3;
        }
        for(int i = 0; i < N; i++){
            player.add(br.readLine());
        }
        System.out.println(player.size() / game);
    }
}