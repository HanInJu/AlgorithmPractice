package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_14568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = 1, c = 1;
		int answer = 0;

		for(int i = 1; i <= n-3; i++) {
			if(i%2 != 0) {
				c += i;
				for(int x = 1; x <= n-3-i; x++) {
					a += x;
					int b = n - a - c;
					if(a >= b+2) {
						answer++;
					}
					a = 1;
				}
				c = 1;
			}
		}

		System.out.println(answer);

	}


}
