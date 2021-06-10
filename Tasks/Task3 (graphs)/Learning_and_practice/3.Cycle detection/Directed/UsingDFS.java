/*UnDirected Graph*/

import java.util.*;
import java.io.*;



public class UsingDFS{
	
	

	public void addEdgeDirected(ArrayList<ArrayList<Integer>> graph,int v,int u){
		graph.get(v).add(u);
	}
	
	public boolean isCycle(int s,ArrayList<ArrayList<Integer>> graph,boolean[] visited,boolean[] innerVisited){
		visited[s] = true;
		innerVisited[s] = true;
		for(Integer ele : graph.get(s)){
			if(!visited[ele]) {
				if(isCycle(ele,graph,visited,innerVisited)) return true;
			}
			else if(visited[ele]&&innerVisited[ele]) return true;			
		}
		innerVisited[s] = false;
		return false;
	}

	public boolean detectCycle(ArrayList<ArrayList<Integer>> graph,int V){
		boolean[] visited = new boolean[V+1];
		boolean[] innerVisited = new boolean[V+1];
		for(int i=1;i<=V;i++){
			if(!visited[i]){
				if(isCycle(i,graph,visited,innerVisited)) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		
		UsingDFS g = new UsingDFS();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int V=7;
		for(int i=0;i<=V;i++) graph.add(new ArrayList<Integer>());
		
		g.addEdgeDirected(graph,1,2);
		g.addEdgeDirected(graph,2,3);
		g.addEdgeDirected(graph,2,7);
		g.addEdgeDirected(graph,3,5);
		g.addEdgeDirected(graph,7,5);
		
		g.addEdgeDirected(graph,4,6);
		g.addEdgeDirected(graph,6,7);
		g.addEdgeDirected(graph,7,4);
		
		
		if(g.detectCycle(graph,V)) System.out.println("This graph has a cycle!");
		else System.out.println("This graph doesn't have any cycle!");
		
	}
}
