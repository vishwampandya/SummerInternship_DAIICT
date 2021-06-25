/*UnDirected Graph*/

/*Or in simple words , a graph with odd cycle is not an bipatre graph , rest all graphs are bipatre graphs*/

import java.util.*;
import java.io.*;



public class UsingBFS{
	
	

	public  void addEdgeUndirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
		graph.get(u).add(v);
	}
	
	public int[] getMinimumDistance(int source,int V,ArrayList<ArrayList<Integer>> graph){
		int[] distance = new int[V+1];
		for(int i=1;i<=V;i++) distance[i] = Integer.MAX_VALUE;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		distance[source] = 0;
		
		while(!q.isEmpty()){
			int node = q.poll();
			for(Integer ele : graph.get(node)){
				if(distance[node]+1<distance[ele]){
					distance[ele] = distance[node]+1;
					q.add(ele);
				}
			}
		}
		
		return distance;
		
	}
	
	
	public static void main(String[] args){
		
		UsingBFS g = new UsingBFS();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Integer>());
		
		g.addEdgeUndirected(graph,1,2);
		g.addEdgeUndirected(graph,2,3);
		g.addEdgeUndirected(graph,2,7);
		g.addEdgeUndirected(graph,3,5);
		g.addEdgeUndirected(graph,7,5);
		
		g.addEdgeUndirected(graph,4,6);
		
		int source = 1;
		int[] distance = g.getMinimumDistance(source,V,graph);
		System.out.println("From source "+source);
		for(int i=1;i<=V;i++) System.out.print(i+": "+distance[i]+" |");
		System.out.println();
		
	}
}
