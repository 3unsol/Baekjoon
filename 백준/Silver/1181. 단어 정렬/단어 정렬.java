import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt(); // 단어 개수
	String[] StringArr = new String[n]; // 처음 단어를 입력 받을 배열
	for(int i = 0; i < n; i++) {
		StringArr[i] = sc.next(); // 입력 받는다
	}
	// 중복 제거를 위해 해쉬셋에 담아준다.
	HashSet<String> hashSet = new HashSet<>(Arrays.asList(StringArr));
	// 해쉬셋에 있는 걸 다시 배열에 담는다.
	String[] strArr = hashSet.toArray(new String[0]);
	// 정렬
	Arrays.sort(strArr, new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			// 두 문자열의 길이가 같으면
			if(o1.length() == o2.length()) {
				// 오름차순으로 정렬
				return o1.compareTo(o2);
			}
			// 아니라면 길이순으로 정렬
			return o1.length() - o2.length();
		}
	});
	// 출력
	for(int i = 0 ; i < strArr.length; i++) {
		System.out.println(strArr[i]);
	}
}
}
