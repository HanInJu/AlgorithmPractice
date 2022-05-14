package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q9_1145 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] numbers = new int[5];
		for(int i = 0; i<5; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		int lcd1 = (numbers[0]* numbers[1]) / gcd(numbers[0], numbers[1]);
		int answer = (lcd1 * numbers[2]) / gcd(lcd1, numbers[2]);
		int lcd;

		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				if(j != i) {
					lcd = (numbers[i]* numbers[j]) / gcd(numbers[i], numbers[j]);
					for(int k = 0; k<5; k++) {
						if((k != i) && (k != j)) {
							if(lcd % numbers[k] == 0) {
								answer = Math.min(answer, lcd);
							}
							else {
								answer = Math.min(answer, (lcd * numbers[k]) / gcd(lcd, numbers[k]));
							}
						}
					}
				}
			}
		}

		System.out.println(answer);
	}

	public static int gcd(int x, int y) {
		if(x % y == 0) {
			return y;
		}
		return gcd(y, x % y);
	}

}
