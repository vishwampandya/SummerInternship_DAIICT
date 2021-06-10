/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class UsingDFS{
	
	

	public  void addEdgeUndirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
		graph.get(u).add(v);
	}
	
	public boolean isCycle(int s,ArrayList<ArrayList<Integer>> graph,boolean[] visited,int parent){
		visited[s] = true;
		for(int ele : graph.get(s)){
			if(!visited[ele]){
				if(isCycle(ele,graph,visited,s)) return true;
			}
			else if(parent!=ele) return true;
		}
		return false;
	}

	public  boolean detectCycle(ArrayList<ArrayList<Integer>> graph,int V){
		boolean[] visited = new boolean[V+1];
		for(int i=1;i<=V;i++){
			if(!visited[i]){
				if(isCycle(i,graph,visited,-1)) return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args){
		
		UsingDFS g = new UsingDFS();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Integer>());
		
		g.addEdgeUndirected(graph,1,2);
		g.addEdgeUndirected(graph,2,3);
		g.addEdgeUndirected(graph,2,7);
		g.addEdgeUndirected(graph,3,5);
		g.addEdgeUndirected(graph,7,5);
		
		g.addEdgeUndirected(graph,4,6);
		
		
		if(g.detectCycle(graph,V)) System.out.println("This graph has a cycle!");
		else System.out.println("This graph doesn't have any cycle!");
		
	}
}
