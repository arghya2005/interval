package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoMain {

	public static void main(String[] args) {

		List<Interval> listinterval = new ArrayList<>();
		listinterval.add(new Interval(8, 10));
		listinterval.add(new Interval(1, 3));
		listinterval.add(new Interval(2, 4));
		
		listinterval.add(new Interval(8, 9));
		
		listinterval.add(new Interval(9, 11));
		listinterval.add(new Interval(15, 18));
		listinterval.add(new Interval(16, 17));
		listinterval.add(new Interval(2, 6));

		Collections.sort(listinterval, (a, b) -> Integer.compare(a.start, b.start));

		List<Interval> outputList = new ArrayList<>();

		for (int i = 0; i < listinterval.size(); i++) {
			Interval currentInterval = listinterval.get(i);
			if (!outputList.isEmpty()) {
				if (currentInterval.getStart() <= outputList.get(outputList.size() - 1).end) {
					continue;
				}
			}
			for (int j = i + 1; j < listinterval.size(); j++) {

				if (matchInterval(currentInterval, listinterval.get(j))) {
					currentInterval.setEnd(listinterval.get(j).getEnd());

				}

			}
			currentInterval.setEnd(Math.max(currentInterval.getEnd(), listinterval.get(i).end));

			outputList.add(currentInterval);

		}

		System.out.println(outputList);

	}

	private static boolean matchInterval(Interval interval1, Interval interval2) {

		return interval2.getEnd() >= interval1.getStart() && interval2.getStart() <= interval1.getEnd();
	}

}

class Interval {

	int start;
	int end;

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}

//output 1,6, 8,17
