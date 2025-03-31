package _09_Greedy_Algorithms._02_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _07_N_meetings_in_one_room {
	public static void main(String args[]) {
		int n = 6;
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 5, 7, 9, 9 };
		maxMeetings(start, end, n);

	}

	static class Meeting {
		int start;
		int end;
		int pos;// position of index+1 in array

		public Meeting(int start, int end, int pos) {
			this.start = start;
			this.end = end;
			this.pos = pos;
		}
	}

	static class MeetingComparator implements Comparator<Meeting> {

		@Override
		public int compare(Meeting o1, Meeting o2) {

			if (o1.end < o2.end) {
				return -1;
			} else if (o1.end > o2.end) {
				return 1;
			} else if (o1.pos < o2.pos) {
				return -1;
			}

			return 1;
		}

	}

    //TC : O(2N + NlogN)
    //SC : O(3*N) + O(N)
	static void maxMeetings(int start[], int end[], int n) {
		ArrayList<Meeting> meet = new ArrayList<Meeting>();

		// put all data in meet list
		for (int i = 0; i < start.length; i++) {
			meet.add(new Meeting(start[i], end[i], i + 1));
		}

		// sort on the basis of end time
		MeetingComparator mc = new MeetingComparator();
		Collections.sort(meet, mc);

		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(meet.get(0).pos);

		int limit = meet.get(0).end;

		for (int i = 1; i < meet.size(); i++) {

			if (meet.get(i).start > limit) {
				ans.add(meet.get(i).pos);
				limit = meet.get(i).end;
			}
		}

		System.out.println("The order in which the meetings will be performed is ");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
