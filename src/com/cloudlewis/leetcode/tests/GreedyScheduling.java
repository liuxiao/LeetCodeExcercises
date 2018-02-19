package com.cloudlewis.leetcode.tests;

import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class GreedyScheduling {

	private int total = 0;
	private Queue<Job> heap;

	private void loadData() {
		Scanner scanner = new Scanner(
				new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("scheduling.txt")));
		total = Integer.parseInt(scanner.nextLine());
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			String num[] = s.split(" ");
			heap.add(new Job(Integer.parseInt(num[0]), Integer.parseInt(num[1])));
		}
		scanner.close();
	}
	
	public void computeQuestion1() {
		heap = new PriorityQueue<Job>(new diffJobComparator());
		loadData();
		long sum = 0;
		long length = 0;
		while(!heap.isEmpty()) {
			Job j = heap.remove();
			sum+= j.weight * (j.length + length);
			length += j.length;
		}
		System.out.println(sum);
	}
	
	public void computeQuestion2() {
		heap = new PriorityQueue<Job>(new ratioJobComparator());
		loadData();
		long sum = 0;
		long length = 0;
		while(!heap.isEmpty()) {
			Job j = heap.remove();
			sum+= j.weight * (j.length + length);
			length += j.length;
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		GreedyScheduling t = new GreedyScheduling();
		t.computeQuestion1();
		t.computeQuestion2();
	}
	
	class Job {
		public int weight;
		public int length;
		public Job(int w, int l) {
			weight = w;
			length = l;
		}
	}
	
	class diffJobComparator implements Comparator<Job> {

		@Override
		public int compare(Job o1, Job o2) {
			if (o1.weight - o1.length == o2.weight - o2.length)
				return Integer.compare(o2.weight, o1.weight);
			else
				return Integer.compare(o2.weight - o2.length, o1.weight - o1.length);
		}
	}
	
	class ratioJobComparator implements Comparator<Job> {

		@Override
		public int compare(Job o1, Job o2) {
			return Double.compare((double)o2.weight/o2.length, (double)o1.weight/o1.length);
		}
	}
}
