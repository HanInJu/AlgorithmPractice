package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer, continueCount, startNumber;
		String number;

		answer = 0;
		startNumber = 666;
		while(answer != n) {
			number = String.valueOf(startNumber);

			continueCount = 0;
			for(int i = 0; i<number.length() - 1; i++) {
				if(number.charAt(i) == '6') {
					if(number.charAt(i) == number.charAt(i+1)) {
						continueCount++;
					}
					else {
						continueCount = 0;
					}
					if(continueCount++ >= 3) {
						answer++;
						break;
					}
				}
			}

			startNumber++;
		}

		System.out.println(startNumber - 1);
	}

}
