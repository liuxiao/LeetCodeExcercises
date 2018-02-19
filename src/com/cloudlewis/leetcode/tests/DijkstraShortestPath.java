package com.cloudlewis.leetcode.tests;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

// https://www.coursera.org/learn/algorithms-graphs-data-structures/exam/Ij5au/programming-assignment-2

/*
 * There are only 200 vertices, so we could use an array
 * Dataset does not represent the reverse edge, so we need to populate both side
 *
 * MacBook-Air-de-Xiao:resources xiao$ python DijkstraShortestPath.py
 * 7,37,59,82,99,115,133,165,188,197
 * [2599, 2610, 2947, 2052, 2367, 2399, 2029, 2442, 2505, 3068]
 */
public class DijkstraShortestPath {
	private static final int NO_PATH = 1000000;
	private Set<Vertex> visited = new HashSet<>();

	public void shortestPath() {
		Graph g = loadData();
		Vertex start = g.getVertex(1);
		start.minDistance = 0;
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.add(start); // add first
		while (!q.isEmpty()) {
			Vertex u = q.poll();
			for (Edge e : u.neighbours) {
				int cost = u.minDistance + e.weight;
				if (e.target.minDistance > cost) {
					q.remove(e.target);
					e.target.minDistance = cost;

					// Take the path visited till now and add the new node.s
					e.target.path = new LinkedList<Vertex>(u.path);
					e.target.path.add(u);

					// Reenter the node with new distance.
					q.add(e.target);
				}
			}
		}

		System.out.println(g.getVertex(7).minDistance + "," + g.getVertex(37).minDistance + ","
				+ g.getVertex(59).minDistance + "," + g.getVertex(82).minDistance + "," + g.getVertex(99).minDistance
				+ "," + g.getVertex(115).minDistance + "," + g.getVertex(133).minDistance + ","
				+ g.getVertex(165).minDistance + "," + g.getVertex(188).minDistance + "," + g.getVertex(197).minDistance);

		// Print the minimum Distance.
		for (Vertex v : g.getVertices()) {
			System.out.print("Vertex - " + v + " , Dist - " + v.minDistance + " , Path - ");
			//for (Vertex pathvert : v.path) {
			//	System.out.print(pathvert + " ");
			//}
			System.out.println("" + v);
		}
	}

	private Graph loadData() {
		Graph g = new Graph(201);

		Scanner scanner = new Scanner(
				new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("dijkstra.txt")));
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			String num[] = s.split("\\t");
			Integer vert = Integer.parseInt(num[0]);

			for (int i = 1; i < num.length; i++) {
				String[] part = num[i].split(",");
				int node = Integer.parseInt(part[0]);
				int cost = Integer.parseInt(part[1]);
				g.addEdge(vert, node, cost);
				g.addEdge(node, vert, cost);
			}
		}
		scanner.close();
		return g;
	}

	public class Graph {
		private ArrayList<Vertex> vertices;

		public Graph(int numberVertices) {
			vertices = new ArrayList<Vertex>(numberVertices);
			for (int i = 0; i < numberVertices; i++) {
				vertices.add(new Vertex());
			}
		}

		public void addEdge(int src, int dest, int weight) {
			Vertex s = vertices.get(src);
			Edge new_edge = new Edge(vertices.get(dest), weight);
			s.neighbours.add(new_edge);
		}

		public ArrayList<Vertex> getVertices() {
			return vertices;
		}

		public Vertex getVertex(int vert) {
			return vertices.get(vert);
		}
	}

	class Vertex implements Comparable<Vertex> {
		public ArrayList<Edge> neighbours;
		public LinkedList<Vertex> path;
		public int minDistance = NO_PATH;
		public Vertex previous;

		public Vertex() {
			neighbours = new ArrayList<Edge>();
			path = new LinkedList<Vertex>();
		}

		@Override
		public int compareTo(Vertex other) {
			return Integer.compare(minDistance, other.minDistance);
		}
	}

	public class Edge {
		public Vertex target;
		public int weight;

		public Edge(Vertex target, int weight) {
			this.target = target;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		DijkstraShortestPath t = new DijkstraShortestPath();
		t.shortestPath();
	}

}
