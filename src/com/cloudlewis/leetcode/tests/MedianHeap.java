package com.cloudlewis.leetcode.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* idea is to keep two Heap structure, so that we could calculate runtime median value for a stream of data.
 * so we do not have to need to sort the array every time.
*/
public class MedianHeap {
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new maxComparator());
	PriorityQueue<Integer> minHeap = new PriorityQueue<>(new minComparator());
	
	public int getMedian() {
		if (maxHeap.size() >= minHeap.size())
			return maxHeap.peek();
		else
			return minHeap.peek();
	}
	
	public void insert(int num) {
		if (maxHeap.size() == 0 && minHeap.size() == 0 )
			maxHeap.add(num);
		if (num < maxHeap.peek())
			maxHeap.add(num);
		else
			minHeap.add(num);
		// balance to heap
		if (minHeap.size() - maxHeap.size() > 1)
			maxHeap.add(minHeap.remove());
		else if (maxHeap.size() - minHeap.size() > 1)
			minHeap.add(maxHeap.remove());
	}
	
	public List<Integer> readStream() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("median.txt").getFile());
		List<Integer> rs = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) 
				rs.add(Integer.parseInt(line));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void printStat() {
		System.out.println(minHeap.size());
		System.out.println(maxHeap.size());
	}
	
	public static void main(String [] args) {
		MedianHeap t = new MedianHeap();
		List<Integer> stream = t.readStream();
		int num=0;
		long total = 0;
		for (int i : stream){
			num++;
			t.insert(i);
			total += t.getMedian();
		}
		System.out.println(num);
		System.out.println(total);
		System.out.println(total % 10000);
		
		//Collections.sort(stream);
		//System.out.println(stream.get(stream.size()/2));
		//System.out.println(t.getMedian());
		//t.printStat();
		
	}
	
	class minComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o1, o2);
		}
		
	}
	
	class maxComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o2, o1);
		}
		
	}
}
