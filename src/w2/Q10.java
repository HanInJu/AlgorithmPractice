package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q10 {
	static Deque<Integer> deque = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int N = Integer.parseInt(br.readLine());
			if (isRightNumber(N)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

	private static boolean isRightNumber(int n) {
		for (int i = 2; i <= 64; i++) {
			int num = n;
			deque.clear();
			while (num != 0) {
				deque.addFirst(num % i);
				num /= i;
			}

			while (deque.size() > 1 && (deque.peekFirst()).equals(deque.peekLast())) {
				deque.pollLast();
				deque.pollFirst();
			}

			if (deque.size() == 0 || deque.size() == 1) {
				return true;
			}

		}

		return false;
	}
}
