package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14_9663 {
	//N개에서 N개 뽑기!
	private static int N, answer;
	private static int[] arr;

	public static void recur(int cur) {
		if(cur == N) {
			answer++;
			return;
		}

		for(int i = 0; i<N; i++) {
			arr[cur] = i;
			if(isPossible(cur)) {
				recur(cur+1);
			}
		}
	}

	private static boolean isPossible(int col) {
		for(int i = 0; i < col; i++) {
			if(arr[col] == arr[i]) { // idx가 열, 값이 행! 즉 놓으려는 곳과 같은 행에 다른 값이 있는 경우
				return false;
			}

			if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) { // 대각선에 있는 경우
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		recur(0);
		System.out.println(answer);
	}

}
