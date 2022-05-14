package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_6131 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int a = 1, b = 1;
		int answer = 0;

		for(b = 1; b < 500; b++) {
			for(a = 1; a < 500; a++) {
				if(a*a == b*b + n) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

}
