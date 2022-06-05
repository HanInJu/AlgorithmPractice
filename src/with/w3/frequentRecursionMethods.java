package with.w3;

public class frequentRecursionMethods {
	static String st;
	static int n, m;
	static int[] arr = new int[110];
	static boolean[] visited = new boolean[110];

	public static void recur(int cur) {
		if(cur == 0) return;
		recur(cur/2);
		System.out.println(cur%2);
	}

	public static boolean recurPellindrome(int s, int e) { // s, e 범위까지 펠린드롬인지 아닌지 리턴
		if(s >= e) return true;
		else {
			return (st.charAt(s) == st.charAt(e) && recurPellindrome(s+1, e-1));
		}
		// 양 끝이 같으면 그 안이 펠린드롬이면 되니까 끝을 비교 - 재귀로 그 안쪽 비교
	}

	// 3^17을 구하고 싶다 - 3*3^16 - 3*(3^8)^2 이런 식으로 반씩 줄여가면 log 복잡도로 구할 수 있음
	// 보통 엄청 큰 수를 엄청 큰 수로 나눈 나머지를 구해라 이런 식으로 나옴
	// 경우의 수 구할 때 몇의 몇 제곱을 자주 구해야 하는 상황에서 자주 씀 예)10000제곱을 10000번 구해라 이런 문제들
	public static long recur(int x, int y) { // x^y 구하기!!!
		long result;
		if(y == 0) {
			return 1;
		}

		result = recur(x, y/2);
		result *= result;
		result %= 100000007;

		if(y%2 == 0) return result; //짝수제곱
		else return (x * result) % 100000007; // 홀수제곱이면 아직 2를 한번 더 곱해야 하니까. 곱할 때마다 모듈러 연산해주는 게 좋아.
	}

	// 이진수, 펠린드롬, 피보나치, 분할정복을 이용해서 거듭제곱하기 : 자주 사용되는 재귀

	/**
	 * 완탐에서 반복만으로는 해결이 안될 경우에 재귀로 쓰기 위해서 재귀를 공부하는 것!
	 *
	 * (설명)
	 * 일단 완탐을 하는 경우지. n중 포문이 필요하면 재귀 쓴다고 생각해!!!
	 * --- 어떤 배열에서 3개를 고르는 경우가 있따고 가정하자. (MBTI문제도 그랬지. 이걸 3중 포문으로 해결할 수도 있어)
	 * 중복 허용해서 고르는지 아닌지에 따라 for 시작조건이 달라지겠지만.
	 * 문제는 n개를 골라라! 그러면 for n번 써야 하는데 어떡할거야... --- n개를 골라서 더한 최대값을 구해라
	 * [목적] 이런 문제들을 위해서 재귀를 쓴다. "결국 n중 반복을 돌리기 위해서!"
	 *
	 * --- n자리 m진수 출력 예) 3자리 5진수 : 000 001 002 003 ... 444 <=> 배열에서 3개 고르는 것(인덱스0,0,0 || 0,0,1 ...)
	 * 따라서 n자리 m진수 출력을 먼저 할 수 있어야 겠지. 저 두 상황은 동치니까. 중복조합 O(m^n)
	 * m개에서 n개 고르기!
	 *
	 *
	 * --- 만약 인덱스 중복이 안되는 경우도 있을 수 있지. (012, 013, 021, ...) 순열 mPn
	 * 중복 제거 시에는 visited 배열 필요함
	 *
	 *
	 * --- 근데 012 021 동치지. 시간이득 보기 위해서 실질적으로 같은 케이스를 제거하고 싶은 경우가 있을 수 있어. 조합 mCn
	 * 실질적으로! 012 021 120 102 210 201 다 사실 같은 걸 선택하는 거잖아. 예를 들어 중복 케이스를 카운팅하면 안되는 경우.
	 * 오름차순만 남기면 해결됨!!! 즉 012만 남기기!
	 *
	 * 비오름차순 : 내림차순처럼 되는데 중복된 수가 있음
	 * 비내림차순 : 오름차순처럼 되는데 중복 수가 있음 - 중복조합
	 *
	 *
	 * */

	// 암기해야 하는 기본형 재귀함수!! - m개에서 n개 뽑기
	public static void recursion(int cur) {
		if(cur == n) { // n이면 배열에 있는 걸 출력
			for(int i = 0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i = 0; i<m; i++) {
			arr[cur] = i;
			recursion(cur+1); // 여기가 n중반복 구현하게 되는 거지
		}
	}

	public static void recursion2(int cur) { //순열
		if(cur == n) { // n이면 배열에 있는 걸 출력
			for(int i = 0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i = 0; i<m; i++) {
			if(visited[i]) continue;

			arr[cur] = i;
			visited[i] = true; // 들어가기 전에 방문처리
			recursion2(cur+1);
			visited[i] = false; // 나오면 다시 풀어주기
		}
	}

	public static void recursion3(int cur, int start) { //오름차순만 남기기
		if(cur == n) { // n이면 배열에 있는 걸 출력
			for(int i = 0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i = start; i<m; i++) {
			arr[cur] = i;
			recursion3(cur+1, i+1); // 비내림차순은 recur(cur+1, i) : 중복 허용 오름차순

		}
/**
		for(int i = m-1; i>=start; i--) { // 오름차순인데 큰 것부터 보고 싶은 경우
			arr[cur] = i;
			recursion3(cur+1, i+1);
		}

		for(int i = m-1; i>=start; i--) { // 여기 범위에서 내부 오름차순 내림차순이 정해지고
			arr[cur] = i;
			recursion3(cur+1, i-1); // i-1부터냐 i+1부터냐에 따라 전체의 오름차순, 내림차순이 정해진다.
		}
*/

	}


	public static void main(String[] args) {
		n = 3; // 자리수
		m = 5; // 개수 // m개에서 n개 뽑기
		recursion(0);
		System.out.println("===================");
	}
}
