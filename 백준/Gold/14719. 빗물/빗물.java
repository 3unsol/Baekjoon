import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int H, W, result;
    static int[] world;

    public static void main(String[] args) throws IOException {
        input();
        rain();
        System.out.println(result);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        world = new int[W];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < W; i++){
            world[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void rain() {

        // 빗물을 담는다기보다는 인덱스 마다 빗물이 담기는 정도를 확인하기
        // 양쪽 끝은 담길 수 없으니까 제외
        for(int i = 1; i < W - 1; i++) {

            // 현재 인덱스 기준으로 양쪽에서 가장 높은 블록 저장
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++){
                left = Math.max(left, world[j]);
            }

            for(int j = i + 1; j < W; j++) {
                right = Math.max(right, world[j]);
            }

            // 구한 최댓값들이 현재 인덱스 높이보다 높다면 그 중에서 낮은 높이와의 차만큼 담긴다
            if(left > world[i] && right > world[i]){
                result += Math.min(left, right) - world[i];
            }
        }
    }
}