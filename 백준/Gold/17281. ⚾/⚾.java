import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int inning, ans;
    static final int HIT = 1;
    static final int DOUBLE = 2;
    static final int TRIPLE = 3;
    static final int HOMERUN = 4;
    static final int OUT = 0;
    static int[][] players;
    static boolean[] select;
    static int[] lineUp;

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inning = Integer.parseInt(br.readLine());
        players = new int[inning + 1][10];
        for(int r = 1; r <= inning; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= 9; c++){
                players[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 선수 선발 유무
        select = new boolean[10];
        // 만들어진 선수 라인업
        lineUp = new int[10];
        // 4번 선수 무조건 1번 타석
        select[4] = true;
        lineUp[4] = 1;

        ans = 0;

        selectPlayer(2);

        System.out.println(ans);
    }

    static void selectPlayer(int num){
        // 순열이 완성되면 경기 시작
        if(num == 10){
            play();
            return;
        }
        // 라인업 만들기
        for(int i = 1; i <= 9; i++){
            // 이미 선택한 선수라면 넘어가기
            if(select[i]){
                continue;
            }
            // 아직 선택 안 한 선수라면 넣어주기
            lineUp[i] = num;
            // 선택했다고 표시
            select[i] = true;
            // 다음 선수 확인
            selectPlayer(num + 1);
            select[i] = false;
        }
    }

    static void play(){
        int score = 0;
        int startPlayer = 1;
        boolean[] base;

        for(int i = 1; i <= inning; i++){
            // 이닝이 새로 시작할 때마다 아웃카운트, base 초기화
            int outCnt = 0;
            base = new boolean[4];
            outer: while(true){
                for(int p = startPlayer; p <= 9; p++){
                    // p번째 선수의 i이닝 때의 점수
                    int hitter = players[i][lineUp[p]];
                    switch(hitter){
                        // OUT일 때
                        case OUT:
                            outCnt++;
                            break;
                        // 1루타
                        case HIT:
                            // 앞에서부터 비우고 채워야 하니까 for문 거꾸로 실행
                            for(int k = 3; k >= 1; k--){
                                // base에 선수가 있을 때
                                if(base[k]){
                                    // 3루석 홈인
                                    if(k == 3){
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    // 1-2루 선수들 진루
                                    base[k] = false;
                                    base[k + 1] = true;
                                }
                            }
                            // 타자 진루
                            base[1] = true;
                            break;
                        // 2루타
                        case DOUBLE:
                            for(int k = 3; k >= 1; k--){
                                // base에 선수가 있다면
                                if(base[k]){
                                    // 3루, 2루 선수 홈인
                                    if(k == 3 || k == 2){
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    // 1루 선수 2루 진루
                                    base[k] = false;
                                    base[k + 2] = true;
                                }
                            }
                            // 타자 2루 진루
                            base[2] = true;
                            break;
                        // 3루타
                        case TRIPLE:
                            for(int k = 3; k >= 1; k--){
                                // base에 있는 선수 모두 홈인
                                if(base[k]){
                                    score++;
                                    base[k] = false;
                                }
                            }
                            // 타자 3루 진루
                            base[3] = true;
                            break;
                        case HOMERUN:
                            for(int k = 1; k <= 3; k++){
                                // base 모든 선수 홈인
                                if(base[k]){
                                    score++;
                                    base[k] = false;
                                }
                            }
                            // 타자 홈인
                            score++;
                            break;
                    }
                    // 쓰리아웃일 때
                    if(outCnt == 3){
                        // 다음 선수부터 이닝 시작
                        startPlayer = p + 1;
                        // 9번 선수를 넘어가면 1번부터 시작
                        if(startPlayer == 10){
                            startPlayer = 1;
                        }
                        break outer;
                    }
                }
                // 이닝이 끝나지 않았다면 1번 선수부터 다시 시작
                startPlayer = 1;
            }
        }
        ans = Math.max(ans, score);
    }
}