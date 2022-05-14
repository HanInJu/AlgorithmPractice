package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7_2851 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] mushrooms = new int[10];
		for(int i = 0; i<10; i++) {
			mushrooms[i] = Integer.parseInt(br.readLine());
		}

		int i, sum = 0;
		for(i = 0; i<10; i++) {
			sum += mushrooms[i];
			if(sum >= 100) {
				break;
			}
		}

		if(sum > 100) {
			int candidate = sum - mushrooms[i];
			if((sum - 100) > (100 - candidate)) {
				sum = candidate;
			}
		}
		System.out.println(sum);
	}

}
