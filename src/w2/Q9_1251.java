package w2; // 여기부터..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q9_1251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String[] str = new String[3];
		StringBuilder sb = new StringBuilder();
		List<String> strings = new ArrayList<>();

		for(int i = 1; i < word.length() - 1; i++) {
			for(int j = i+1; j < word.length(); j++) {
				str[0] = sb.append(word, 0, i).reverse().toString();
				sb.setLength(0);
				str[1] = sb.append(word, i, j).reverse().toString();
				sb.setLength(0);
				str[2] = sb.append(word, j, word.length()).reverse().toString();
				sb.setLength(0);
			}
			strings.add(str[0] + str[1] + str[2]);
		}

		Collections.sort(strings);
		System.out.println(strings.get(0));
	}
}
