import java.util.Scanner;

public class Main {

    static final int MAX = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        int Z = getPercent(X, Y);

        int left = 0;
        int right = MAX;
        int ans = -1;

        // 이분탐색
        while(left <= right) {

            int mid = (left + right) / 2;

            if(getPercent(X + mid, Y + mid) != Z) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    // 부동소수점....ㅂㄷㅂㄷ
    // 변수에 실수형을 저장하면 오차가 발생
    // 실수형은 소수가 2진수로 저장되기 때문에 가장 근사한 값을 저장
    // 0.58 * 100을 하면 0.5799999로 저장해서 57이 반환됨... 세상에
    static int getPercent(int x, int y) {
        return (int)((long)y * 100 / x);
    }
}