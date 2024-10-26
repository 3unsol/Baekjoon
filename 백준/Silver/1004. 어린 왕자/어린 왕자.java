import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그림 그려보면 이해 가능
 */
public class Main {

    static int startX, startY, endX, endY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {

            st = new StringTokenizer(br.readLine());

            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            int cnt = 0;
            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                // 시작점, 끝점이 모두 원 안에 있는지 확인
                boolean startIn = false;
                boolean endIn = false;

                // 출발지, 도착지가 원 안에 있는지 확인
                // (x - a) ^ 2 + (y - b) ^ 2 <= r ^ 2 (이걸 어케 앎? ㅠㅠ)
                if(Math.pow(startX - x, 2) + Math.pow(startY - y, 2) <= Math.pow(r, 2)) {
                    startIn = true;
                    cnt++;
                }
                if(Math.pow(endX - x, 2) + Math.pow(endY - y, 2) <= Math.pow(r, 2)) {
                    endIn = true;
                    cnt++;
                }

                // 출발지, 도착지가 모두 원 안에 있으면 진입/이탈 없으므로 숫자 빼주기
                if(startIn && endIn) cnt -= 2;
            }

            System.out.println(cnt);
        }
    }
}