import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] matches;
    static final int teamCnt = 6;
    static boolean isEndGame;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = 4;

        // 매칭 수 구하기
        int size = 0;
        for(int i = 1; i < teamCnt; i++) {
            size += i;
        }

        // 매치 배열
        matches = new int[size][2];

        int index = 0;

        // 같은 팀이랑 중복 매칭 안 됨, 매칭을 하나씩 채워준다.
        for(int i = 0; i < teamCnt - 1; i++) {
            for(int j = i + 1; j < teamCnt; j++) {
                matches[index][0] = i;
                matches[index][1] = j;
                index++;
            }
        }

        for(int tc = 1; tc <= testCase; tc++) {

            st = new StringTokenizer(br.readLine());
            int[][] worldCup = new int[teamCnt][3]; // 승무패를 팀별로 저장
            boolean isPossible = true;

            for(int i = 0; i < teamCnt; i++) {

                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());

                worldCup[i][0] = win;
                worldCup[i][1] = draw;
                worldCup[i][2] = lose;

                if(win + draw + lose != 5) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {

                backTracking(worldCup, 0, size);

                if(isEndGame) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else {
                sb.append(0);
            }

            sb.append(" ");
            isEndGame = false;

        }
        System.out.println(sb);
    }

    static void backTracking(int[][] worldCup, int matchCount, int size) {

        if(isEndGame) return;

        if(matchCount == size) {
            isEndGame = true;
            return;
        }

        int myTeam = matches[matchCount][0];
        int yourTeam = matches[matchCount][1];

        // 승
        if(worldCup[myTeam][0] > 0 && worldCup[yourTeam][2] > 0) {
            worldCup[myTeam][0]--;
            worldCup[yourTeam][2]--;
            backTracking(worldCup, matchCount + 1, size);
            worldCup[myTeam][0]++;
            worldCup[yourTeam][2]++;
        }

        // 무
        if(worldCup[myTeam][1] > 0 && worldCup[yourTeam][1] > 0) {
            worldCup[myTeam][1]--;
            worldCup[yourTeam][1]--;
            backTracking(worldCup, matchCount + 1, size);
            worldCup[myTeam][1]++;
            worldCup[yourTeam][1]++;
        }

        // 패
        if(worldCup[myTeam][2] > 0 && worldCup[yourTeam][0] > 0) {
            worldCup[myTeam][2]--;
            worldCup[yourTeam][0]--;
            backTracking(worldCup, matchCount + 1, size);
            worldCup[myTeam][2]++;
            worldCup[yourTeam][0]++;
        }
    }
}