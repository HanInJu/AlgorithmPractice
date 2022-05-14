package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1_17945 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		List<Integer> answer = new ArrayList<>();

		for(int x = -1000; x < 1001; x++) {
			if((x * x + 2 * a * x + b) == 0) {
				answer.add(x);
			}
		}

		if(answer.size() == 2) {
			Collections.sort(answer);
			System.out.println(answer.get(0) + " " + answer.get(1));
		}
		else {
			System.out.println(answer.get(0));
		}
	}
}
