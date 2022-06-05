package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13_2661_RE {
	private static int N;
	private static boolean flag;

	public static void recur(String sequence) {
		if(sequence.length() == N) {
			System.out.println(sequence);
			flag = true;
			return;
		}

		for(int i = 1; i <= 3; i++) {
			if(isGoodSequence(sequence + i)) {
				recur(sequence + i);
				if(flag) {
					return;
				}
			}
		}
	}

	public static boolean isGoodSequence(String sequence) {
		String pattern, before;
		for(int i = 1; i <= sequence.length() / 2; i++) {
			pattern = sequence.substring(sequence.length() - i);
			before = sequence.substring(sequence.length() - (i*2), sequence.length() - i);
			if(pattern.equals(before)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		recur("");
	}
}
