package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13_2661 {
	// 중복은 허용하지만 범위 중복은 안됨...!
	// 1,2,3 중에서 N개 뽑기, 중복순열, 범위 체크...? (일단 바로 직전 수는 또 쓰지 못하게 함으로써 한 자리 패턴의 반복 거름)
	// 문자열로 다루기
	// 최대 세 자리의 패턴이 반복될 수 있음
	private static int N;
	private static boolean flag;

	public static void recur(String sequence) {
		if(sequence.length() == N) {
			System.out.println(sequence);
			flag = true;
			return;
		}

		for(int i = 1; i<4; i++) {
			if(isGoodSequence(sequence + i)) {
				recur(sequence + i);
				if (flag) {
					return;
				}
			}
		}
	}

	public static boolean isGoodSequence(String string) {
		String sequence, pattern, next;

		for(int i = 0; i < string.length(); i++) { // 123213213 : 패턴 213 // 전체 문자열 돌면서
			sequence = string;
			for(int j = 1; j < string.length() / 2 - 1; j++) { // 패턴은 1부터 string 길이의 절반 크기까지
				pattern = sequence.substring(i, i+j); // 처음부터 패턴 2 길이 : (0,2) : 12
				next = sequence.substring(i+j, i+j+j);  // 바로 다음 2만큼 부분 : (2,4) : 12
				if(pattern.equals(next)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		recur("");
		// backtracking("");
	}
}
