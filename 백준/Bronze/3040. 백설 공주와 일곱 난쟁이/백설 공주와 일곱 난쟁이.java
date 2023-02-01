import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 9명 숫자 받아보자
		// 모든 조합을 더해보자
		// 100이 나오면???
		// 7개..아니 7명...누군지 어케 알지?
		// 9개 다 더해
		// 다 더한 거에서 100을 빼
		// 2개 숫자 더한 값이 쟤 나오면
		// 걔네 빼고 출력....인데 그거 어케 하지
		Scanner sc = new Scanner(System.in);

		// 값을 입력 받을 배열을 만들자 
		int[] arr = new int[9];

		// 9개 값을 입력받자
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 9개 합을 구해보자
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += arr[i];
		}

		// 숫자 2개씩 다 더해보자
		int tmpsum = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				tmpsum = arr[i] + arr[j];
				// 만약 2개 더한 값이 전체 더한 값 - 100이라면?
				if (tmpsum == sum - 100) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j)
							// 나머지 숫자들 출력하기
							System.out.println(arr[k]);
					}
				}
			}
		}
	}
}