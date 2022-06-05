package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, base, count, answer;

		n = Integer.parseInt(br.readLine());
		base = 99;

		if(100 <= n) {
			count = countHanSu(n);
			answer = base + count;
		}
		else {
			answer = n;
		}

		System.out.println(answer);
	}

	public static int countHanSu(int n) {
		int one, tenth, hundredth, count;

		count = 0;
		for(int i = 110; i <= n; i++) {
			one = i%10;
			tenth = (i/10)%10;
			hundredth = i/100;
			if((hundredth - tenth) == (tenth - one)) {
				count++;
			}
		}

		return count;
	}
}
