import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int returnDate, chapterCnt;
    static int[][] dp;
    static int[] day, page;
    public static void main(String[] args) throws Exception {
        input();
        findMaxPage();
        System.out.println(dp[chapterCnt][returnDate]);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        returnDate = Integer.parseInt(st.nextToken());
        chapterCnt = Integer.parseInt(st.nextToken());

        day = new int[chapterCnt + 1];
        page = new int[chapterCnt + 1];

        for(int i = 1; i <= chapterCnt; i++){
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            page[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[chapterCnt + 1][returnDate + 1];
    }

    static void findMaxPage() {

        for(int nowChapter = 1; nowChapter <= chapterCnt; nowChapter++){
            for(int nowDate = 1; nowDate <= returnDate; nowDate++){

                dp[nowChapter][nowDate] = dp[nowChapter - 1][nowDate];

                if(nowDate - day[nowChapter] >= 0){
                    dp[nowChapter][nowDate] = Math.max(dp[nowChapter][nowDate], dp[nowChapter - 1][nowDate - day[nowChapter]] + page[nowChapter]);
                }
            }
        }
    }
}