import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 숫자 10개 받고
		// 순서대로 더하는데
		// 더한값과 100의 차이가 가장 작은 거
		// 근데 작을 수도 클 수도 있으니까 절대값으로 비교
		// 차이가 같으면 더 큰 수를 출력

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		int iSum = 0;
		int tmpSum = 0;
		int result = 0;
		for (int i = 0; i < 10; i++) {
			tmpSum = arr[i] + iSum;
			if (Math.abs(iSum - 100) >= Math.abs(tmpSum - 100)) {
				result = tmpSum;
			}
			iSum = tmpSum;
		}
		System.out.println(result);
	}
}