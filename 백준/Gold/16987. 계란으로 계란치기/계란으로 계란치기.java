import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int eggCnt;
    static int[][] eggs;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        eggCnt = Integer.parseInt(br.readLine());
        eggs = new int[eggCnt][2];
        max = 0;

        for(int r = 0; r < eggCnt; r++){
            st = new StringTokenizer(br.readLine());
            eggs[r][0] = Integer.parseInt(st.nextToken());
            eggs[r][1] = Integer.parseInt(st.nextToken());
        }

        breakTheEgg(0, 0);
        System.out.println(max);
    }

    // 0: 내구도, 1: 무게
    static void breakTheEgg(int index, int cnt) {

        // 끝까지 다 봤으면 최댓값 갱신
        if(index == eggCnt){
            max = Math.max(max, cnt);
            return;
        }

        // 현재 계란 깨졌거나 계란판 다 깨졌으면 다음
        if(eggs[index][0] <= 0 || cnt == eggCnt - 1) {
            breakTheEgg(index + 1, cnt);
            return;
        }

        // 재귀 돌려줄 때 쓰려고 저장한 개수
        int nowCnt = cnt;

        // 계란판 돌면서 깰 수 있는 거 확인
        for(int i = 0; i < eggCnt; i++){

            // 본인 제외
            if(i == index) continue;

            // 이미 깨진 거 제외
            if(eggs[i][0] <= 0) continue;

            // 깰 수 있으면 깨본다
            eggs[index][0] -= eggs[i][1];
            eggs[i][0] -= eggs[index][1];

            // 현재 계란 깨졌으면 개수 늘려주기
            if(eggs[index][0] <= 0){
                cnt++;
            }

            // 상대 계란 깨졌으면 개수 늘려주기
            if(eggs[i][0] <= 0){
                cnt++;
            }

            // 다음
            breakTheEgg(index + 1, cnt);

            // 돌아왔을 때를 위해 다시 돌려놓기
            eggs[index][0] += eggs[i][1];
            eggs[i][0] += eggs[index][1];
            cnt = nowCnt;
        }
    }
}