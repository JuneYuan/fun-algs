package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Didi2_dinnerTables {

	private static class Guest {
		int idx;
		int hc;
		int spend;
		boolean settled = false;
		
		Guest(int idx, int hc, int spend) {
			this.idx = idx;
			this.hc = hc;
			this.spend = spend;
		}
	}

	private  class DeskGuest implements Comparator {
		int deskSize;
		PriorityQueue<Guest> possibleGuests;
		
		public DeskGuest(int deskSize, PriorityQueue<Guest> possibleGuests) {
			this.deskSize = deskSize;
			this.possibleGuests = possibleGuests;
		}

		@Override
		public int compare(Object o1, Object o2) {
			o1 = (DeskGuest) o1;
			o2 = (DeskGuest) o2;
			return o1.deskSize < o2.deskSize;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<DeskGuest> deskGuests = new ArrayList<>();
		Guest[] guests = new Guest[M];
		
		for (int i = 0; i < N; i++) {
			int size = sc.nextInt();
			DeskGuest dg = new DeskGuest(size, null);
			deskGuests.add(dg);
		}
		
		Arrays.sort(deskGuests);
		
		for (int i = 0; i < M; i++) {
			int hc = sc.nextInt();
			int spend = sc.nextInt();
			guests[i] = new Guest(i, hc, spend);
		}
		
		
		System.out.println();
		sc.close();
	}
}
