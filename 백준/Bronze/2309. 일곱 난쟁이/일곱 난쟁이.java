import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 입력값 받기
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			// 숫자 총합 구하기
			sum += arr[i];
		}
		// 순서대로 정렬하기
		Arrays.sort(arr);

		// 2개씩 더해보기
		int tmpsum = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				tmpsum = arr[i] + arr[j];
				// 합이 총합-100과 같으면
				if (tmpsum == (sum - 100)) {
					for (int k = 0; k < 9; k++) {
						// 두 인덱스 빼고 출력하기
						if (k != i && k != j) {
							System.out.println(arr[k]);
						}
					}
					return;

				}
			}
		}
	}
}
