package com.cloudlewis.leetcode.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SCCKosaraju {
	
	public List<Set<Vertex<Integer>>> scc(Graph<Integer> graph) {

        //it holds vertices by finish time in reverse order.
        Deque<Vertex<Integer>> stack = new ArrayDeque<>();
        //holds visited vertices for DFS.
        Set<Vertex<Integer>> visited = new HashSet<>();

        //populate stack with vertices with vertex finishing last at the top.
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }
            DFSUtil(vertex, visited, stack);
        }

        //reverse the graph.
        Graph<Integer> reverseGraph = reverseGraph(graph);

        //Do a DFS based off vertex finish time in decreasing order on reverse graph..
        visited.clear();
        List<Set<Vertex<Integer>>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Vertex<Integer> vertex = reverseGraph.getVertex(stack.poll().getId());
            if(visited.contains(vertex)){
                continue;
            }
            Set<Vertex<Integer>> set = new HashSet<>();
            DFSUtilForReverseGraph(vertex, visited, set);
            result.add(set);
        }
        return result;
    }

    private Graph<Integer> reverseGraph(Graph<Integer> graph) {
        Graph<Integer> reverseGraph = new Graph<>(true);
        for (Edge<Integer> edge : graph.getAllEdges()) {
            reverseGraph.addEdge(edge.getVertex2().getId(), edge.getVertex1()
                    .getId(), edge.getWeight());
        }
        return reverseGraph;
    }

    private void DFSUtil(Vertex<Integer> vertex,
            Set<Vertex<Integer>> visited, Deque<Vertex<Integer>> stack) {
        visited.add(vertex);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
            if (visited.contains(v)) {
                continue;
            }
            DFSUtil(v, visited, stack);
        }
        stack.offerFirst(vertex);
    }

    private void DFSUtilForReverseGraph(Vertex<Integer> vertex,
                                        Set<Vertex<Integer>> visited, Set<Vertex<Integer>> set) {
        visited.add(vertex);
        set.add(vertex);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
            if (visited.contains(v)) {
                continue;
            }
            DFSUtilForReverseGraph(v, visited, set);
        }
    }

	public Graph<Integer> readGraph() {

		Graph<Integer> graph = new Graph<>(true);

		ClassLoader classLoader = getClass().getClassLoader();
		try {
			BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource("scc.txt").getFile()));
			String str = null;
			while ((str = br.readLine()) != null) {
				String[] parts = str.split(" ");
				graph.addEdge(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
				System.out.println(str);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return graph;
	}
	
	public static void main(String []args) {
		SCCKosaraju t = new SCCKosaraju();
		Graph<Integer> g = t.readGraph();
		System.out.println("read graph done");
		List<Set<Vertex<Integer>>> result = t.scc(g);
		
		List<Integer> list = new ArrayList<>();
		
		for (int i=0; i<result.size();i++) {
			list.add(result.get(i).size());
		}
		
		System.out.println("sorting size");
		Collections.sort(list);
		
		int len = list.size();
		System.out.println(list.get(len - 1));
		System.out.println(list.get(len - 2));
		System.out.println(list.get(len - 3));
		System.out.println(list.get(len - 4));
		System.out.println(list.get(len - 5));
		
	}

	public class Graph<T>{

	    private List<Edge<T>> allEdges;
	    private Map<Long,Vertex<T>> allVertex;
	    boolean isDirected = false;
	    
	    public Graph(boolean isDirected){
	        allEdges = new ArrayList<Edge<T>>();
	        allVertex = new HashMap<Long,Vertex<T>>();
	        this.isDirected = isDirected;
	    }
	    
	    public void addEdge(long id1, long id2){
	        addEdge(id1,id2,0);
	    }
	    
	    //This works only for directed graph because for undirected graph we can end up
	    //adding edges two times to allEdges
	    public void addVertex(Vertex<T> vertex){
	        if(allVertex.containsKey(vertex.getId())){
	            return;
	        }
	        allVertex.put(vertex.getId(), vertex);
	        for(Edge<T> edge : vertex.getEdges()){
	            allEdges.add(edge);
	        }
	    }
	    
	    public Vertex<T> addSingleVertex(long id){
	        if(allVertex.containsKey(id)){
	            return allVertex.get(id);
	        }
	        Vertex<T> v = new Vertex<T>(id);
	        allVertex.put(id, v);
	        return v;
	    }
	    
	    public Vertex<T> getVertex(long id){
	        return allVertex.get(id);
	    }
	    
	    public void addEdge(long id1,long id2, int weight){
	        Vertex<T> vertex1 = null;
	        if(allVertex.containsKey(id1)){
	            vertex1 = allVertex.get(id1);
	        }else{
	            vertex1 = new Vertex<T>(id1);
	            allVertex.put(id1, vertex1);
	        }
	        Vertex<T> vertex2 = null;
	        if(allVertex.containsKey(id2)){
	            vertex2 = allVertex.get(id2);
	        }else{
	            vertex2 = new Vertex<T>(id2);
	            allVertex.put(id2, vertex2);
	        }

	        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
	        allEdges.add(edge);
	        vertex1.addAdjacentVertex(edge, vertex2);
	        if(!isDirected){
	            vertex2.addAdjacentVertex(edge, vertex1);
	        }

	    }
	    
	    public List<Edge<T>> getAllEdges(){
	        return allEdges;
	    }
	    
	    public Collection<Vertex<T>> getAllVertex(){
	        return allVertex.values();
	    }
	    public void setDataForVertex(long id, T data){
	        if(allVertex.containsKey(id)){
	            Vertex<T> vertex = allVertex.get(id);
	            vertex.setData(data);
	        }
	    }

	    @Override
	    public String toString(){
	        StringBuffer buffer = new StringBuffer();
	        for(Edge<T> edge : getAllEdges()){
	            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
	            buffer.append("\n");
	        }
	        return buffer.toString();
	    }
	}


	class Vertex<T> {
	    long id;
	    private T data;
	    private List<Edge<T>> edges = new ArrayList<>();
	    private List<Vertex<T>> adjacentVertex = new ArrayList<>();
	    
	    Vertex(long id){
	        this.id = id;
	    }
	    
	    public long getId(){
	        return id;
	    }
	    
	    public void setData(T data){
	        this.data = data;
	    }
	    
	    public T getData(){
	        return data;
	    }
	    
	    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
	        edges.add(e);
	        adjacentVertex.add(v);
	    }
	    
	    public String toString(){
	        return String.valueOf(id);
	    }
	    
	    public List<Vertex<T>> getAdjacentVertexes(){
	        return adjacentVertex;
	    }
	    
	    public List<Edge<T>> getEdges(){
	        return edges;
	    }
	    
	    public int getDegree(){
	        return edges.size();
	    }
	    
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (id ^ (id >>> 32));
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Vertex other = (Vertex) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }
	}

	class Edge<T>{
	    private boolean isDirected = false;
	    private Vertex<T> vertex1;
	    private Vertex<T> vertex2;
	    private int weight;
	    
	    Edge(Vertex<T> vertex1, Vertex<T> vertex2){
	        this.vertex1 = vertex1;
	        this.vertex2 = vertex2;
	    }

	    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
	        this.vertex1 = vertex1;
	        this.vertex2 = vertex2;
	        this.weight = weight;
	        this.isDirected = isDirected;
	    }
	    
	    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected){
	        this.vertex1 = vertex1;
	        this.vertex2 = vertex2;
	        this.isDirected = isDirected;
	    }
	    
	    Vertex<T> getVertex1(){
	        return vertex1;
	    }
	    
	    Vertex<T> getVertex2(){
	        return vertex2;
	    }
	    
	    int getWeight(){
	        return weight;
	    }
	    
	    public boolean isDirected(){
	        return isDirected;
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
	        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Edge other = (Edge) obj;
	        if (vertex1 == null) {
	            if (other.vertex1 != null)
	                return false;
	        } else if (!vertex1.equals(other.vertex1))
	            return false;
	        if (vertex2 == null) {
	            if (other.vertex2 != null)
	                return false;
	        } else if (!vertex2.equals(other.vertex2))
	            return false;
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
	                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
	    }
	}
}
