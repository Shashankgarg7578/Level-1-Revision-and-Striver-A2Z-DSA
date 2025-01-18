package _05_Graph._02_DFS_BFS_Problems;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _11_Word_ladder_1 {
	public static void main(String[] args) throws IOException {
		String startWord = "der", targetWord = "dfs";
		String[] wordList = { "des", "der", "dfr", "dgt", "dfs" };

		int ans = wordLadderLength(startWord, targetWord, wordList);

		System.out.print(ans);

		System.out.println();
	}

	private static int wordLadderLength(String startWord, String targetWord, String[] wordList) {

		Set<String> st = new HashSet<String>();
		for (int i = 0; i < wordList.length; i++) {
			st.add(wordList[i]);
		}

		Queue<Pair02> q = new LinkedList<Pair02>();

		q.add(new Pair02(startWord, 1));

		// remove first word if it is in set.
		st.remove(startWord);

		while (!q.isEmpty()) {
			String word = q.peek().first;
			int steps = q.peek().second;

			q.remove();

			// if word is target word then we get the path.
			if (word.equals(targetWord) == true) {
				return steps;
			}

			// for every word every char check with a to z
			for (int i = 0; i < word.length(); i++) {
				for (char j = 'a'; j <= 'z'; j++) {

					char[] replacedCharArray = word.toCharArray();
					replacedCharArray[i] = j;
					String replacedString = new String(replacedCharArray);

					// every time check in Set if it there then remove it
					// so we don't need to visit again
					if (st.contains(replacedString) == true) {
						st.remove(replacedString);
						q.add(new Pair02(replacedString, steps + 1));
					}

				}
			}
		}

		return 0;
	}
}

class Pair02 {
	String first; // String
	int second; // Steps

	public Pair02(String first, int second) {
		this.first = first;
		this.second = second;
	}
}
