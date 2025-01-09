package Graph._02_DFS_BFS_Problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class comp implements Comparator<ArrayList<String>> {

	@Override
	public int compare(ArrayList<String> a, ArrayList<String> b) {

		String x = "";
		String y = "";

		for (String temp : a) {
			x += temp;
		}

		for (String temp : b) {
			y += temp;
		}

		return x.compareTo(y);
	}

}

public class _12_Word_ladder_2 {
	public static void main(String[] args) throws IOException {
		String startWord = "der", targetWord = "dfs";
		String[] wordList = { "des", "der", "dfr", "dgt", "dfs" };

		ArrayList<ArrayList<String>> ans = findSequences(startWord, targetWord, wordList);

		// If no transformation sequence is possible.
		if (ans.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(ans, new comp());
			for (int i = 0; i < ans.size(); i++) {
				for (int j = 0; j < ans.get(i).size(); j++) {
					System.out.print(ans.get(i).get(j) + " ");
				}
				System.out.println();
			}
		}

	}

	private static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {

		Set<String> st = new HashSet<String>();
		for (String temp : wordList) {
			st.add(temp);
		}

		Queue<ArrayList<String>> q = new LinkedList<ArrayList<String>>();

		ArrayList<String> ls = new ArrayList<String>();
		ls.add(startWord);

		q.add(ls);

		ArrayList<String> usedOnLevels = new ArrayList<String>();
		usedOnLevels.add(startWord);

		int level = 0;

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			ArrayList<String> vec = q.peek();
			q.remove();

			//after every level remove last used last elements of list
			if (vec.size() > level) {
				level++;
				for (String it : usedOnLevels) {
					st.remove(it);
				}
			}

			//take last word of list
			String word = vec.get(vec.size() - 1);

			// store the answers if the end word matches with targetWord.
			if (word.equals(targetWord)) {
				if (ans.size() == 0) {
					ans.add(vec);
				} else if (ans.get(0).size() == vec.size()) {
					ans.add(vec);
				}
			}

			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {

					char[] replacedCharArr = word.toCharArray();
					replacedCharArr[i] = ch;
					String replacedString = new String(replacedCharArr);

					// in this we don't remove from set
					// we removed after all this
					if (st.contains(replacedString)) {
						vec.add(replacedString);

						// Java works by reference, so enter the copy of vec
						// otherwise if you remove word from vec in next lines, it will
						// remove from everywhere
						ArrayList<String> temp = new ArrayList<String>(vec);
						q.add(temp);

						usedOnLevels.add(replacedString);
						vec.remove(vec.size() - 1);
					}

				}
			}

		}

		return ans;
	}

}
