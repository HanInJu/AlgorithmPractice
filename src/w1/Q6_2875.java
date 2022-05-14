package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6_2875 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int answer = 0;

		if(n+m > k) {
			answer = Math.min(n / 2, m);
			k -= (n+m) - 3*answer;
			if(k>0) {
				answer -= (k%3 == 0) ? (k/3) : (k/3)+1;
			}
		}

		System.out.println(answer);

	}

}
